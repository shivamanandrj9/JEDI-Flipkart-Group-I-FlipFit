package com.flipkart.business;

import com.flipkart.bean.Slot;

/**
 * Facilitate gym owner to add a slot to a gym
 * Facilitate Customer to book a slot
 */
public interface SlotServiceInterface {

    /**
     * Gym owner can add a slot
     * @param slot slot class with slot details
     */
    void addSlot(Slot slot);

    /**
     * user can book a slot here
     * @param userId ID of user want to book a slot
     * @param slotId ID of slot user want to book
     */
    void bookSlot(String userId,String slotId);
}
