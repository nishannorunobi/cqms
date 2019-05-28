package com.consumers.qms.dao.repositories;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import com.consumers.qms.model.User;
import com.consumers.qms.utils.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class FirestoreUserDao implements UserDao {
    private static final String TAG = FirebaseFirestore.class.getName();
    private Activity context = null;
    private static FirestoreUserDao userDao;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new FirestoreUserDao();
        }
        return userDao;
    }

    @Override
    public void setContext(Activity context) {
        this.context = context;
    }

    @Override
    public void save(final User userObj) {
        final Map<String, Object> user = new HashMap<>();
        user.put("mobileNumber", userObj.getMobileNumber());
        user.put("password", userObj.getPassword());

        db.collection(Constants.FirestoreCollections.USERS)
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        SharedPreferences.Editor sharedPreferencesEdit = context.getApplicationContext().getSharedPreferences(Constants.SettingsKeys.PREF_NAME, MODE_PRIVATE).edit();
                        sharedPreferencesEdit.putString(Constants.SettingsKeys.USER_MOBILE_NO, userObj.getMobileNumber());
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
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
    public void update(User user) {

    }

    @Override
    public User getByMobileNo(String mobileNumber) {
        return new User();
    }

    @Override
    public User getById(String id) {
        return new User();
    }
}
