package com.flipkart.business;

import com.flipkart.bean.User;

public interface AuthenticationServiceInterface {
    User validateUser(String username, String password);
}
