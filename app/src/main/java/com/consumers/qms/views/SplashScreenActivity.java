package com.consumers.qms.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.consumers.qms.R;
import com.consumers.qms.login.LoginActivity;
import com.consumers.qms.utils.Constants;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        SharedPreferences sharedPreferences = this.getApplicationContext().getSharedPreferences(Constants.SettingsKeys.PREF_NAME, MODE_PRIVATE);
        String applicationData = sharedPreferences.getString(Constants.SettingsKeys.USER_MOBILE_NO, null);
        Intent intent = null;
        if (applicationData == null) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, DashboardActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
