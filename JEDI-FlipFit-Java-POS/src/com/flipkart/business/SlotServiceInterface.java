package com.flipkart.business;

import com.flipkart.bean.Slot;

public interface SlotServiceInterface {
    void addSlot(Slot slot);
    void bookSlot(String userId,String slotId);
}
