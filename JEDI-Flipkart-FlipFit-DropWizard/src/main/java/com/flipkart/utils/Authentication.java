package com.flipkart.utils;

import com.flipkart.bean.User;
import com.flipkart.business.AuthenticationService;
import com.flipkart.exception.UserNotFoundException;
import jakarta.ws.rs.core.Response;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Authentication {

    public static User authenticate(String authorization) throws UserNotFoundException{
        if (authorization == null || !authorization.startsWith("Basic ")) {
            throw new UserNotFoundException("No authorization credentails");
        }

        // Decode the Base64 encoded username:password
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

        // credentials = "username:password"
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        AuthenticationService authenticationService = new AuthenticationService();
        return authenticationService.validateUser(username, password);

    }
}
