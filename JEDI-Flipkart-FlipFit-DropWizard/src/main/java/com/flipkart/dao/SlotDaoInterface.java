package com.flipkart.dao;

import com.flipkart.bean.Slot;
import com.flipkart.helper.StringTriplet;

import java.util.List;

/**
 * Interface for managing slot-related operations.
 * Defines methods to add, retrieve, and fetch slot information based on various criteria.
 */
public interface SlotDaoInterface {

    /**
     * Adds a new slot to the database.
     * @param slot The {@link Slot} object containing details such as slot ID, gym ID, date, start time, end time, and
     *             capacity.
     */
    void addSlot(Slot slot);

    /**
     * Retrieves a list of available slots for a specific gym on a given date.
     * @param gymId The ID of the gym for which slots are being retrieved.
     * @param date  The date for which the slots are to be fetched (format: YYYY-MM-DD).
     * @return A list of {@link Slot} objects representing the slots available for the given gym and date.
     */
    List<Slot> getSlots(String gymId, String date);

    /**
     * Retrieves the timing information (start time, end time, and date) for a specific slot.
     * @param slotId The ID of the slot for which timing information is to be retrieved.
     * @return A {@link StringTriplet} containing the date, start time, and end time of the slot,
     *         or {@code null} if the slot does not exist.
     */
    StringTriplet getSlotTiming(String slotId);

    /**
     * Retrieves the details of a specific slot based on its slot ID.
     * @param slotId The ID of the slot whose details are to be fetched.
     * @return A {@link Slot} object representing the slot with the given ID, or {@code null} if no such slot exists.
     */
    Slot getSlotFromSlotId(String slotId);
}
