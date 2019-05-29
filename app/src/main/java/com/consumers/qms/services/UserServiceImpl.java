package com.consumers.qms.services;

import android.app.Activity;
import android.drm.DrmStore;
import com.consumers.qms.asyntask.ActionPerformCallBack;
import com.consumers.qms.dao.repositories.FirestoreUserDao;
import com.consumers.qms.dao.repositories.UserDao;
import com.consumers.qms.model.User;

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
    public void storeUser(User user) {
        userDao.save(user);
    }

    @Override
    public void setContext(Activity activity, ActionPerformCallBack callback) {
        this.userDao.setContext(activity, callback);
    }
}
