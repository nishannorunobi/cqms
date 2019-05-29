package com.consumers.qms.dao.repositories;

import android.app.Activity;
import com.consumers.qms.asyntask.ActionPerformCallBack;

public interface CommonDao {
    void setContext(Activity activity, ActionPerformCallBack callback);
}
