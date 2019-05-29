package com.consumers.qms.services;

import com.consumers.qms.model.User;

public interface UserService extends CommonService {
    void storeUser(User user);
}
