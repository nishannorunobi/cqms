package com.consumers.qms.dao.repositories;

import com.consumers.qms.services.OnEventListener;

public interface CommonDao {
    void addOnEventListener(OnEventListener onEventListener);
}
