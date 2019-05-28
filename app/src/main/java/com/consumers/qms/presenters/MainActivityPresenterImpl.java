package com.consumers.qms.presenters;

import android.app.Activity;
import com.consumers.qms.dao.repositories.FirestoreUserDao;
import com.consumers.qms.dao.repositories.UserDao;
import com.consumers.qms.model.User;

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private UserDao userDao = FirestoreUserDao.getInstance();
    private Activity context = null;
    private static MainActivityPresenter mainActivityPresenter = null;

    public static MainActivityPresenter getInstance() {
        if (mainActivityPresenter == null) {
            mainActivityPresenter = new MainActivityPresenterImpl();
        }
        return mainActivityPresenter;
    }

    @Override
    public void setContext(Activity context) {
        this.context = context;
        userDao.setContext(context);
    }

    @Override
    public void login(String mobileNumber, String password) {

    }

    @Override
    public void register(String mobileNumber, String password) {
        User user = new User();
        user.setMobileNumber(mobileNumber);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void forgetPassword(String mobileNumber) {

    }
}
