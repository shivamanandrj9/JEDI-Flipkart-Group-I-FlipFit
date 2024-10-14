package com.flipkart.dao;

import com.flipkart.bean.Slot;
import com.flipkart.helper.StringTriplet;

import java.util.List;

public interface SlotDaoInterface {

    void addSlot(Slot slot);

    List<Slot> getSlots(String gymId, String date);

    StringTriplet getSlotTiming(String slotId);

    Slot getSlotFromSlotId(String slotId);
}
