package com.consumers.qms.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.consumers.qms.features.appointment.AppointmentActivity;
import com.consumers.qms.features.dashboard.DashboardActivity;
import com.consumers.qms.features.login.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class ApplicationUtil {
    public static Intent getIntentForDefaultScreen(Activity activity) {
        SharedPreferences sharedPreferences = activity.getApplicationContext()
                .getSharedPreferences(Constants.Preferences.PREF_NAME, MODE_PRIVATE);
        String applicationData = sharedPreferences.getString(Constants.Preferences.USER_ID, null);
        Intent intent = null;
        if (applicationData == null) {
            intent = new Intent(activity, LoginActivity.class);
        } else {
            int appointmentCount = sharedPreferences.getInt(Constants.Preferences.APT_CNT, 0);
            if (appointmentCount > 0) {
                intent = new Intent(activity, DashboardActivity.class);
            } else {
                intent = new Intent(activity, AppointmentActivity.class);
            }
        }
        return intent;
    }
}
