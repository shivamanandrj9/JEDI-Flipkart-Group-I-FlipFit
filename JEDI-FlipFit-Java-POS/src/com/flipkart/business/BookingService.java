package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.helper.StringTriplet;

import java.util.List;

public class BookingService {

    private static BookingDao bookingDao = new BookingDao();
    private static SlotDao slotDao = new SlotDao();

    public void viewAllBookings(String userId){

        List<Booking> bookingsUser=bookingDao.getUserBookings(userId);

        for(Booking booking:bookingsUser){
            System.out.print(booking.getBookingID()+" ");
            StringTriplet datetime= slotDao.getSlotTiming(booking.getSlotID());
            System.out.println(datetime.getDate()+datetime.getStarttime()+datetime.getEndtime());
        }
    }

    public void cancelBooking(String bookingID){

    }

}
