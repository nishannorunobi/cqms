package com.consumers.qms.features.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.consumers.qms.asyntask.DbActionSuccessCallback;
import com.consumers.qms.model.User;
import com.consumers.qms.services.OnEventListener;
import com.consumers.qms.services.UserService;
import com.consumers.qms.services.UserServiceImpl;
import com.consumers.qms.utils.ApplicationUtil;
import com.consumers.qms.utils.Constants;

import static android.content.Context.MODE_PRIVATE;
import static android.support.constraint.Constraints.TAG;

public class LoginActivityPresenterImpl implements LoginActivityPresenter {
    private UserService userService = UserServiceImpl.getInstance();
    private static LoginActivityPresenter loginActivityPresenter = null;

    public static LoginActivityPresenter getInstance() {
        if (loginActivityPresenter == null) {
            loginActivityPresenter = new LoginActivityPresenterImpl();
        }
        return loginActivityPresenter;
    }


    @Override
    public void login(
            String mobileNumber,
            String password,
            Activity activity) {

    }

    @Override
    public void register(
            final String mobileNumber,
            final String password,
            final Activity activity) {


        userService.getUserByMobileNumber(mobileNumber, new OnEventListener() {

            @Override
            public void fire(Object[] t) {
                Log.w(TAG, "fire: "+t[0]);
                if (t[0] == null) {
                    User user = new User();
                    user.setMobileNumber(mobileNumber);
                    user.setPassword(password);
                    userService.storeUser(user, new OnEventListener() {
                        @Override
                        public void fire(Object[] t) {
                            String userId = (String) t[0];
                            SharedPreferences.Editor sharedPreferencesEdit = activity.getApplicationContext().getSharedPreferences(Constants.Preferences.PREF_NAME, MODE_PRIVATE).edit();
                            sharedPreferencesEdit.putString(Constants.Preferences.USER_ID, userId);
                            sharedPreferencesEdit.apply();

                            Intent intent = ApplicationUtil.getIntentForDefaultScreen(activity);

                            activity.startActivity(intent);
                            activity.finish();
                        }
                    });
                } else {
                    String userId = (String) t[0];
                    User user = new User();
                    user.setId(userId);
                    user.setMobileNumber(mobileNumber);
                    user.setPassword(password);
                    userService.updateUser(user, new OnEventListener<String>() {

                        @Override
                        public void fire(String... t) {
                            SharedPreferences.Editor sharedPreferencesEdit = activity.getApplicationContext().getSharedPreferences(Constants.Preferences.PREF_NAME, MODE_PRIVATE).edit();
                            sharedPreferencesEdit.putString(Constants.Preferences.USER_ID, t[0]);
                            sharedPreferencesEdit.apply();

                            Intent intent = ApplicationUtil.getIntentForDefaultScreen(activity);

                            activity.startActivity(intent);
                            activity.finish();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void forgetPassword(String mobileNumber) {

    }

}
