package org.yasynskyi.myshop.dao;

import org.yasynskyi.myshop.entity.User;

public interface UserDao {
    void add(User user);

    boolean isEmailValid(String email);

    User findUser(String email, String password);
}
