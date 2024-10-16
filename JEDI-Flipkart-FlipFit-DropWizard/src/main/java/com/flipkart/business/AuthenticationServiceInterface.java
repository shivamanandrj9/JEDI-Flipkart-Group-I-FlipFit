package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

/**
 * Provides authentication service to all flipfit users
 */
public interface AuthenticationServiceInterface {

    /**
     * Verifies user credentials
     * @param username username of user want to log in
     * @param password password of user set by user previously
     * @return user class with user details
     */
    User validateUser(String username, String password) throws UserNotFoundException;
}
