package com.consumers.qms.dao.repositories;

import com.consumers.qms.model.User;
import com.consumers.qms.services.OnEventListener;

public interface UserDao{

    void save(User user,OnEventListener onEventListener);

    void update(User user,OnEventListener onEventListener);

    void getByMobileNo(String mobileNumber, OnEventListener onEventListener);

    User getById(String id, OnEventListener onEventListener);
}
