package com.os.controller;


import com.alibaba.fastjson.JSON;
import com.os.exception.UserException;
import com.os.exception.code.UserAccountExceptionCode;
import com.os.identity.config.UserLoginToken;
import com.os.identity.utils.JwtUtils;
import com.os.service.UserServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youyuan.lv
 */
@Slf4j
@RestController
@RequestMapping(value = "/os/project/user")
public class UserOpenApiController {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @PostMapping(value = "/register")
    public String registerNewUser(String username, String password, String email) {
        log.info("Starting processing registration......");
        return JSON.toJSONString(userServiceRepository.registerAccount(username, password, email));
    }

    @GetMapping(value = "/find/password")
    public String findPasswordByEmail(String email) {
        return userServiceRepository.findPassword(email);
    }

    @GetMapping(value = "/login")
    public String loginIn(String username, String password) {
        log.info("login......");
        if (userServiceRepository.loginIn(username, password)) {
            return JwtUtils.createToken(username);
        } else {
            throw new UserException(UserAccountExceptionCode.USERNAME_PASSWORD_DOES_NOT_MATCH,
                                    "username and password does not match");
        }
    }

    @UserLoginToken
    @PostMapping(value = "/recharge")
    public long rechargeMoney(String username, long money) {
        log.info("Processing recharging......");
        return userServiceRepository.rechargeAccount(username, money);
    }

    @UserLoginToken
    @PostMapping(value = "/change/password")
    public String changePassword(String username, String password) {
        log.info("Changing the password......");
        return JSON.toJSONString(userServiceRepository.updatePassword(username, password));
    }


}
