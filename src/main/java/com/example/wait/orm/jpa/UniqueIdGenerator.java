package com.example.wait.orm.jpa;


public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}