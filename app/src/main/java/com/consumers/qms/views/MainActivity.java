package com.consumers.qms.views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.consumers.qms.R;
import com.google.firebase.firestore.FirebaseFirestore;

class MainActivity extends AppCompatActivity{
    String TAG = "MainActivity";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private int PRIVATE_MODE = 0;
    private String PREF_NAME = "LOGGED-IN";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, PRIVATE_MODE);


    }

}
