package com.flipkart.dao;

import com.flipkart.bean.Gym;

import java.util.List;

/**
 * Interface for managing gym-related operations.
 * Defines methods for adding, retrieving, listing, and unlisting gyms.
 */
public interface GymDaoInterface {

    /**
     * Adds a new gym to the database.
     * @param gym The {@link Gym} object containing details such as gym ID, name, address, city,  owner ID, and listed
     *            status.
     */
    void addGym(Gym gym);

    /**
     * Retrieves a list of gyms associated with a specific gym owner.
     * @param userId The ID of the gym owner whose gyms are to be retrieved.
     * @return A list of {@link Gym} objects representing the gyms owned by the user.
     */
    List<Gym> getGymCenters(String userId);

    /**
     * Retrieves a list of all gyms available in the system.
     * @return A list of all {@link Gym} objects in the database.
     */
    List<Gym> getAllGymCenters();

    /**
     * Marks a gym as listed, making it visible and available on the platform.
     * @param gymId The ID of the gym to be listed.
     */
    void listGym(String gymId);

    /**
     * Marks a gym as unlisted, making it invisible and unavailable on the platform.
     * @param gymId The ID of the gym to be unlisted.
     */
    void unlistGym(String gymId);

    /**
     * Retrieves the details of a specific gym based on its gym ID.
     * @param gymId The ID of the gym whose details are to be retrieved.
     * @return A {@link Gym} object representing the gym with the given ID, or {@code null} if no such gym exists.
     */
    Gym getGymFromGymId(String gymId);
}
