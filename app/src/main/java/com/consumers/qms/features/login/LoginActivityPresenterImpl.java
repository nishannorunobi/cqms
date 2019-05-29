package com.consumers.qms.features.login;

import android.app.Activity;
import android.content.Intent;
import com.consumers.qms.asyntask.DbActionSuccessCallback;
import com.consumers.qms.model.User;
import com.consumers.qms.services.UserService;
import com.consumers.qms.services.UserServiceImpl;

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
    public void setContext(Activity context) {
        userService.setContext(
                context,
                new DbActionSuccessCallback() {
                    @Override
                    public void confirmUserRegister(String userId, Activity activity) {
                        Intent intent = new Intent(activity, com.consumers.qms.features.login.dashboard.DashboardActivity.class);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                });
    }

    @Override
    public void login(String mobileNumber, String password) {

    }

    @Override
    public void register(String mobileNumber, String password) {
        User user = new User();
        user.setMobileNumber(mobileNumber);
        user.setPassword(password);
        userService.storeUser(user);
    }

    @Override
    public void forgetPassword(String mobileNumber) {

    }

}
