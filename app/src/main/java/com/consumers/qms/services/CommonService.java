package com.consumers.qms.services;

import android.app.Activity;
import com.consumers.qms.asyntask.ActionPerformCallBack;

public interface CommonService {
    void setContext(Activity activity, ActionPerformCallBack callback);
}
