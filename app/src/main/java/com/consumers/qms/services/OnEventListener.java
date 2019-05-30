package com.consumers.qms.services;

public interface OnEventListener<T> {
    void fire(T... t);
}
