package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Gym;
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
    List<Gym> viewGymToAdmin();

    /**
     * View all unlisted gyms
     */
    List<Gym> viewUnlistedGym();

    /**
     * view all listed gyms on Flipfit App
     */
    List<Gym> viewlistedGym();
}
