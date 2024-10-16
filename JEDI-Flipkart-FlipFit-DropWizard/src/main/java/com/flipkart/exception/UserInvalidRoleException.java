package com.flipkart.exception;

public class UserInvalidRoleException extends Exception{

    static String prefix = "User Role Invalid";
    public UserInvalidRoleException() {
        super(prefix);
    }

    public UserInvalidRoleException(String uname, String role) {
        super(prefix + "{User Name}:" + uname + "{Role}:" + role);
    }
}
