package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;
import com.flipkart.dao.BookingDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.helper.Config;
import com.flipkart.helper.StringTriplet;
import com.flipkart.utils.DbUtils;

import java.util.List;

public class SlotService {

    private static SlotDao slotDao=new SlotDao();
    public static DbUtils dbutils=new DbUtils();

    public static BookingDao bookingDao=new BookingDao();
    public static Config cfg=new Config();

    public void addSlot(Slot slot) {
        slotDao.addSlot(slot);
    }

    public void bookSlot(String userId,String slotId)
    {

        String id = Integer.toString(cfg.getCounter());
        cfg.increment();




        StringTriplet newdatetime=slotDao.getSlotTiming(slotId);


        List<Booking> bookingsUser=bookingDao.getUserBookings(userId);

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
                    System.out.println("Cancelling previous booking due to overlap");
                    bookingDao.deleteSlot(bookingUser.getBookingID());
                }
            }

        }


        Booking booking = new Booking(id, userId, slotId);
        bookingDao.bookSlot(booking);
    }
}
