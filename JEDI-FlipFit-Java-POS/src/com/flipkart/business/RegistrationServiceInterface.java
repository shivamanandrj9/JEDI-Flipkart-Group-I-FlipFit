package com.flipkart.business;

/**
 * Registration service to users and gym
 */
public interface RegistrationServiceInterface {

    /**
     * Registration of new user with all details
     * @param username username to be set by user
     * @param password password to be set by user
     * @param name name of user
     * @param phone phone no of user
     * @param email email ID of user
     * @param age age of user
     * @param roleId Roll of user in Flipfit App(Customer,gym owner,Admin)
     */
    void createUser(String username,String password,String name, String phone,String email, int age, String roleId);

    /**
     * Create a gym by gym owner
     * @param name Name of gym
     * @param address Address of gym
     * @param city City in which gym available
     * @param gymOwnerId ID of gym owner created the gym
     */
    void createGym(String name, String address, String city, String gymOwnerId);
}
