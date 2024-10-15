package com.flipkart.resources;

import com.flipkart.bean.Payment;
import com.flipkart.bean.User;
import com.flipkart.business.*;
import com.flipkart.dao.BookingDao;
import com.flipkart.dao.PaymentDao;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.*;
import com.flipkart.utils.DbUtils;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


@Path("/flipfit/customer")
public class CustomerController {

    @GET
    @Path("/viewbooking")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response viewBooking(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {

        if (authorization == null || !authorization.startsWith("Basic ")) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Authorization header is missing or invalid.")
                    .build();
        }

        // Decode the Base64 encoded username:password
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

        // credentials = "username:password"
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        AuthenticationService authenticationService = new AuthenticationService();

        try{

            User user = authenticationService.validateUser(username, password);

            // Fetch bookings for the user
            BookingService bookingService = new BookingService();
            List<Map<String, Object>> bookings = bookingService.viewAllBookings(user.getUserId());

            // If no bookings found, return a message
            if (bookings.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"message\": \"No bookings found.\" }")
                        .build();
            }

            // Return the bookings as JSON
            return Response.ok(bookings).build();
        }
        catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        }


    }

    @POST
    @Path("/bookslot")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    @Consumes(MediaType.APPLICATION_JSON) // Consuming JSON request body
    public Response bookSlot(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, BookingDetail bookingRequest) {

        // Validate the Authorization header
        if (authorization == null || !authorization.startsWith("Basic ")) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Authorization header is missing or invalid.")
                    .build();
        }

        // Decode the Base64 encoded username:password
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

        // credentials = "username:password"
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        AuthenticationService authenticationService = new AuthenticationService();

        try {
            // Validate user credentials
            User user = authenticationService.validateUser(username, password);
            PaymentDao paymentDao = new PaymentDao();
            DbUtils dbUtils = new DbUtils();
            Payment payment=new Payment();
            SlotService slotService = new SlotService();

            int paymentid =1+dbUtils.getTableCnt("payment");
            payment.setPaymentsId(paymentid);

            payment.setCardNumber(bookingRequest.getPayment().getCardNumber());

            payment.setExpiryDate(bookingRequest.getPayment().getExpiryDate());

            payment.setName(bookingRequest.getPayment().getName());

            payment.setCvv(bookingRequest.getPayment().getCvv());

            System.out.println(payment.getPaymentsId());
            System.out.println(bookingRequest.getSlotId());
            paymentDao.addPayment(payment);

            slotService.bookSlot(user.getUserId(), bookingRequest.getSlotId());


            return Response.ok()
                    .entity("Slot booked successfully for user: " + user.getUserId())
                    .build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while booking the slot.")
                    .build();
        }
    }

    @DELETE
    @Path("/cancelbooking")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    @Consumes(MediaType.APPLICATION_JSON) // Consuming JSON request body
    public Response cancelSlot(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization,@QueryParam("BookingId") String bookingId) {

        // Validate the Authorization header
        if (authorization == null || !authorization.startsWith("Basic ")) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Authorization header is missing or invalid.")
                    .build();
        }

        // Decode the Base64 encoded username:password
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

        // credentials = "username:password"
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        AuthenticationService authenticationService = new AuthenticationService();

        try {
            // Validate user credentials
            User user = authenticationService.validateUser(username, password);
            BookingDao bookingDao = new BookingDao();
            bookingDao.deleteSlot(bookingId);

            return Response.ok()
                    .entity("Booking with ID " + bookingId + " has been successfully deleted.")
                    .build();

        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while attempting to delete the booking.")
                    .build();
        }
    }
}
