package com.consumers.qms.features.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.consumers.qms.R;

public class LoginActivity
        extends AppCompatActivity
        implements View.OnClickListener{
    LoginActivityPresenter loginActivityPresenter = LoginActivityPresenterImpl.getInstance();

    private EditText etMobile;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnForgetPass;
    private Button btnRegister;

    String TAG = "LoginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);
        findViews();
        loginActivityPresenter.setContext(this);
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
            loginActivityPresenter.login(
                    etMobile.getText().toString().trim(),
                    etPassword.getText().toString().trim());

        } else if (v == btnForgetPass) {
            // Handle clicks for button2
        } else if (v == btnRegister) {
            loginActivityPresenter.register(
                    etMobile.getText().toString().trim(),
                    etPassword.getText().toString().trim()
            );
        }
    }
}
