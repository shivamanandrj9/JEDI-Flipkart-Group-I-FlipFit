package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.utils.DbUtils;

public class AuthenticationService implements AuthenticationServiceInterface {

    @Override
    public User validateUser(String username, String password) {
        UserDao userDao = new UserDao();
        return userDao.validateUser(username, password);
    }

}
