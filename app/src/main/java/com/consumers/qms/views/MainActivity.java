package com.consumers.qms.views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.consumers.qms.R;
import com.consumers.qms.presenter.MainActivityPresenter;
import com.consumers.qms.presenter.MainActivityPresenterImpl;
import com.google.firebase.firestore.FirebaseFirestore;

class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MainActivityPresenter mainActivityPresenter = MainActivityPresenterImpl.getInstance();

    private EditText etMobile;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnForgetPass;
    private Button btnRegister;

    String TAG = "MainActivity";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private static String PREF_NAME = "PREF_NAME";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        if (sharedPreferences.getString(PREF_NAME, null) == null) {
            setContentView(R.layout.user_register);
        } else {
            setContentView(R.layout.activity_main);
        }
        findViews();
        mainActivityPresenter.setContext(this);
    }


    private void findViews() {
        etMobile = (EditText) findViewById(R.id.etMobile);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnForgetPass = (Button) findViewById(R.id.btnForgetPass);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(this);
        btnForgetPass.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            mainActivityPresenter.login(
                    etMobile.getText().toString().trim(),
                    etPassword.getText().toString().trim());

        } else if (v == btnForgetPass) {
            // Handle clicks for button2
        } else if (v == btnRegister) {
            mainActivityPresenter.register(
                    etMobile.getText().toString().trim(),
                    etPassword.getText().toString().trim()
            );
        }
    }

}
