package com.consumers.qms.features.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.consumers.qms.R;
import com.consumers.qms.utils.ApplicationUtil;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        startActivity(ApplicationUtil.getIntentForDefaultScreen(this));
        finish();
    }
}
