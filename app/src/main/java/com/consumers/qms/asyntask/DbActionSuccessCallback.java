package com.consumers.qms.asyntask;

import android.app.Activity;

public interface DbActionSuccessCallback extends ActionPerformCallBack{
    void confirmUserRegister(String userId, Activity activity);
}
