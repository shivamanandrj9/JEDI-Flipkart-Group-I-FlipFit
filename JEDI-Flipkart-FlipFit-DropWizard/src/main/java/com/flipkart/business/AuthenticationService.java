package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.exception.UserNotFoundException;

public class AuthenticationService implements AuthenticationServiceInterface {

    @Override
    public User validateUser(String username, String password) throws UserNotFoundException {
        UserDao userDao = new UserDao();
        return userDao.validateUser(username, password);
    }

}
