package com.consumers.qms.dao.repositories;

import android.support.annotation.NonNull;
import android.util.Log;
import com.consumers.qms.model.User;
import com.consumers.qms.services.OnEventListener;
import com.consumers.qms.utils.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;

import java.util.HashMap;
import java.util.Map;

public class FirestoreUserDao implements UserDao {
    private static final String TAG = FirebaseFirestore.class.getName();
    private static FirestoreUserDao userDao;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference users = db.collection(Constants.FirestoreCollections.USERS);

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new FirestoreUserDao();
        }
        return userDao;
    }

    @Override
    public void save(User userObj, final OnEventListener onEventListener) {
        final Map<String, Object> user = new HashMap<>();
        user.put("mobileNumber", userObj.getMobileNumber());
        user.put("password", userObj.getPassword());

        users.add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        onEventListener.fire(documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    @Override
    public void update(final User userObj, final OnEventListener onEventListener) {
        final Map<String, Object> user = new HashMap<>();
        user.put("password", userObj.getPassword());
        users.document(userObj.getId())
                .update(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        onEventListener.fire(userObj.getId());
                    }
                });
    }

    @Override
    public void getByMobileNo(final String mobileNumber, final OnEventListener onEventListener) {
        Query query = users.whereEqualTo("mobileNumber", mobileNumber);
        query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String userId = null;
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    Log.w(TAG, "onSuccess: no user documents found by mobile number {}" + mobileNumber);
                } else {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots.getDocuments()) {
                        if (userId == null) {
                            userId = documentSnapshot.getId();
                        } else {
                            users.document(documentSnapshot.getId()).delete();
                        }
                    }
                }
                onEventListener.fire(userId);
            }
        });
    }

    @Override
    public User getById(String id, OnEventListener onEventListener) {
        return new User();
    }
}
