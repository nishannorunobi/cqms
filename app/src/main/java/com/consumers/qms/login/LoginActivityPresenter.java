package com.consumers.qms.login;

import android.app.Activity;

public interface LoginActivityPresenter {
    void setContext(Activity context);
    void login(String mobileNumber,String password);
    void register(String mobileNumber,String password);
    void forgetPassword(String mobileNumber);
    void notifySuccessfulRegistration(String userId);
}
