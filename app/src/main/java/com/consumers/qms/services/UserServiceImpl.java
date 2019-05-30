package com.consumers.qms.services;

import android.util.Log;
import com.consumers.qms.dao.repositories.FirestoreUserDao;
import com.consumers.qms.dao.repositories.UserDao;
import com.consumers.qms.model.User;

import static android.support.constraint.Constraints.TAG;

public class UserServiceImpl implements UserService {
    private static UserService userService = null;
    private UserDao userDao = FirestoreUserDao.getInstance();

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public void storeUser(User user, OnEventListener onEventListener) {
        userDao.save(user, onEventListener);
    }

    @Override
    public void updateUser(User user, OnEventListener onEventListener) {
        userDao.update(user, onEventListener);
    }

    @Override
    public void getUserByMobileNumber(String mobileNumber, final OnEventListener onEventListener) {
        userDao.getByMobileNo(mobileNumber, onEventListener);
    }
}
