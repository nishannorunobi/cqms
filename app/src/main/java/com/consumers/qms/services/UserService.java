package com.consumers.qms.services;

import com.consumers.qms.model.User;

public interface UserService{
    void storeUser(User user, OnEventListener onEventListener);
    void updateUser(User user, OnEventListener onEventListener);

    void getUserByMobileNumber(String mobileNumber, OnEventListener onEventListener);
}
