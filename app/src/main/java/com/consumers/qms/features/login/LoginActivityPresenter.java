package com.consumers.qms.features.login;

import android.app.Activity;

public interface LoginActivityPresenter {
    void login(String mobileNumber,String password,Activity activity);
    void register(String mobileNumber,String password,Activity activity);
    void forgetPassword(String mobileNumber);
}
