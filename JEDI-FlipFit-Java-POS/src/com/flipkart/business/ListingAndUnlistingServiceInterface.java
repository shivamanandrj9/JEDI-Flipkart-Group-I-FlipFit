package com.flipkart.business;

/**
 *
 * Facilitate Admin to list and unlist a particular gym
 * @author shubham
 */
public interface ListingAndUnlistingServiceInterface {

    /**
     * List a gym to Flipfit app
     * @param gymId ID of gym to be listed on Flipfit app
     */
    void listThisGym(String gymId);

    /**
     * Unlist a listed gym
     * @param gymId ID of gym to be Unlisted on Flipfit app
     */
    void unlistThisGym(String gymId);
}
