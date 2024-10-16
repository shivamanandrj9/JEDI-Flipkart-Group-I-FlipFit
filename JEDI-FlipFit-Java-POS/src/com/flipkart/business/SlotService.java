package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;
import com.flipkart.dao.BookingDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.helper.Config;
import com.flipkart.helper.StringTriplet;
import com.flipkart.utils.DbUtils;

import java.util.List;

public class SlotService implements SlotServiceInterface {

    private static SlotDao slotDao=new SlotDao();
    public static DbUtils dbutils=new DbUtils();

    public static BookingDao bookingDao=new BookingDao();
    public static Config cfg=new Config();

    @Override
    public void addSlot(Slot slot) {
        slotDao.addSlot(slot);
    }
    @Override
    public void bookSlot(String userId,String slotId)
    {

        String id = "00";
        StringTriplet newdatetime=slotDao.getSlotTiming(slotId);

        List<Booking> bookingsUser= null;
        bookingsUser = bookingDao.getUserBookings(userId);

        for(Booking bookingUser:bookingsUser)
        {
            StringTriplet prevDateTime=slotDao.getSlotTiming(bookingUser.getSlotID());

            String curr_date=prevDateTime.getDate();
            String curr_starttime=prevDateTime.getStarttime();
            String curr_endtime=prevDateTime.getEndtime();

            if(curr_date.equals(newdatetime.getDate()))
            {
                if ((curr_starttime.compareTo(newdatetime.getEndtime()) < 0) &&
                        (newdatetime.getStarttime().compareTo(curr_endtime) < 0)) {
                    System.out.println("Cancelling previous booking due to overlap. Refund of previous booking has been initiated ");
                    bookingDao.deleteSlot(bookingUser.getBookingID());
                }
            }

        }

        Booking booking = new Booking(id, userId, slotId);
        bookingDao.bookSlot(booking);
    }
}
