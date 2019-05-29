package com.consumers.qms.login;

import android.app.Activity;
import com.consumers.qms.model.User;
import com.consumers.qms.services.UserService;
import com.consumers.qms.services.UserServiceImpl;

public class LoginActivityPresenterImpl implements LoginActivityPresenter {
    private UserService userService = UserServiceImpl.getInstance();
    private static LoginActivityPresenter loginActivityPresenter = null;
    private LoginActivity loginActivity = null;

    public static LoginActivityPresenter getInstance() {
        if (loginActivityPresenter == null) {
            loginActivityPresenter = new LoginActivityPresenterImpl();
        }
        return loginActivityPresenter;
    }

    @Override
    public void setContext(Activity activity) {
        loginActivity = (LoginActivity) activity;
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

    @Override
    public void notifySuccessfulRegistration(String userId) {

    }
}
