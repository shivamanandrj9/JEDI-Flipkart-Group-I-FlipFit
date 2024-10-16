package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.List;
import java.util.Map;

/**
 * View listed and Unlisted gym list to Admin and Gym owner
 */
public interface GymViewingServiceInterface {

    /**
     * View listed and unlisted gyms owned by gym owner
     * @param user User class containing details of gym owner
     */
    public Map<String, List<Map<String, Object>>> viewGymToOwner(User user);

    /**
     * View all listed and unlisted gyms to Admin
     */
    void viewGymToAdmin();

    /**
     * View all unlisted gyms
     */
    void viewUnlistedGym();

    /**
     * view all listed gyms on Flipfit App
     */
    void viewlistedGym();
}
