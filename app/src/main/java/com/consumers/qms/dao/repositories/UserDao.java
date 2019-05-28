package com.consumers.qms.dao.repositories;

import android.app.Activity;
import com.consumers.qms.model.User;

public interface UserDao {
    void setContext(Activity context);

    void save(User user);

    void update(User user);

    User getByMobileNo(String mobileNumber);

    User getById(String id);
}
