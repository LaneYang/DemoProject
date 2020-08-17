package com.os.dao;


import com.os.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author youyuan.lv
 */
@Repository
public interface UserRepository {

    // 注册用户账户
    User registerAccount(String username, String password, String email);

    // 验证用户登录
    String userLoginIn(String username);

    // 充值
    void rechargeAccount(String username, long money);

    // 查询账户金额
    long checkMoney(String username);

    // 更新密码
    User updatePassword(String username, String password);

    // 查询用户邮箱是否存在
    long checkEmailExists(String email);

    // 找回密码
    String findPassword(String email);

}
