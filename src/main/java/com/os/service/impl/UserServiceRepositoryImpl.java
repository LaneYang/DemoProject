package com.os.service.impl;

import com.os.dao.UserRepository;
import com.os.exception.UserException;
import com.os.exception.code.UserAccountExceptionCode;
import com.os.model.User;
import com.os.service.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceRepositoryImpl implements UserServiceRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerAccount(String username, String password, String email) {
        return userRepository.registerAccount(username, password, email);
    }

    @Override
    public boolean loginIn(String username, String password) {
        String pw = userRepository.userLoginIn(username);
        return password.equals(pw);
    }

    @Override
    public long rechargeAccount(String username, long money) {
        userRepository.rechargeAccount(username, money);
        return userRepository.checkMoney(username);
    }

    @Override
    public User updatePassword(String username, String password) {
        return userRepository.updatePassword(username, password);
    }

    @Override
    public String findPassword(String email) {
        if (userRepository.checkEmailExists(email) < 1) {
            throw new UserException(UserAccountExceptionCode.EMAIL_WAS_NEVER_REGISTERED,
                                   "Email was never registered");
        }
        return userRepository.findPassword(email);
    }

}
