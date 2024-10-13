package com.flipkart.business;

import com.flipkart.bean.User;

public interface GymViewingServiceInterface {
    void viewGymToOwner(User user);

    void viewGymToAdmin();

    void viewUnlistedGym();

    void viewlistedGym();
}
