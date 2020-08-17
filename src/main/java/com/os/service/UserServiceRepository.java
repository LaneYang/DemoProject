package com.os.service;


import com.os.model.User;

public interface UserServiceRepository {

    User registerAccount(String username, String password, String email);

    boolean loginIn(String username, String password);

    long rechargeAccount(String username, long money);

    User updatePassword(String username, String password);

    String findPassword(String email);

}
