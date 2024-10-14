package com.flipkart.dao;

import com.flipkart.bean.User;

public interface UserDaoInterface {

    void addUser(User user);

    User validateUser(String username, String password);
}
