package com.flipkart.business;

public interface RegistrationServiceInterface {
    void createUser(String username,String password,String name, String phone,String email, int age, String roleId);
    void createGym(String name, String address, String city, String gymOwnerId);
}
