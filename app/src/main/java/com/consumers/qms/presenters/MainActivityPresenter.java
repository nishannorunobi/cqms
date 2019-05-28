package com.consumers.qms.presenters;

import android.app.Activity;

public interface MainActivityPresenter {
    void setContext(Activity context);
    void login(String mobileNumber,String password);
    void register(String mobileNumber,String password);
    void forgetPassword(String mobileNumber);
}
