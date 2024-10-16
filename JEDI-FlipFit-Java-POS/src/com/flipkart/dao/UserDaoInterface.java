package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;

/**
 *
 * Interface for managing user-related operations.
 * Defines methods for adding new users and validating user credentials.
 * @author sudhir
 */
public interface UserDaoInterface {

    /**
     * Adds a new user to the system.
     *
     * @param user The {@link User} object containing user details such as ID, username, password,
     *             name, email, phone, age, and role ID.
     */
    void addUser(User user) throws UserAlreadyExistsException;

    /**
     * Validates a user's credentials (username and password) and retrieves the user details if valid.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password associated with the provided username.
     * @return A {@link User} object containing the user's details if the credentials are valid,
     *         or {@code null} if the credentials are incorrect.
     */
    User validateUser(String username, String password) throws UserNotFoundException;
}
