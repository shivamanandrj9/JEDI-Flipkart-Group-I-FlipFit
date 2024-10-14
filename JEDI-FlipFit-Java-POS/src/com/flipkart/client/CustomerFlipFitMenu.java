package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.business.BookingService;

import java.util.Scanner;

public class CustomerFlipFitMenu {

    private User user;

    public CustomerFlipFitMenu(User user) {
        this.user = user;
    }

    public void showMenu(Scanner scanner) {
        int userChoice = -1;
        SlotActivityMenu slotActivityMenu=new SlotActivityMenu();

        while (userChoice != 4) {

            System.out.println("Customer Menu:");
            System.out.println("1. Book Slot");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Logout");
            System.out.println();
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();


            switch (userChoice) {
                case 1:

                    slotActivityMenu.bookSlot(scanner,user);
                    break;
                case 2:
                    BookingService bookingService =new BookingService();
                    bookingService.viewAllBookings(user.getUserId());
                    break;
                case 3:

                    slotActivityMenu.cancelSlot(scanner,user);
                    break;
                case 4:
                    System.out.println("Logging Out!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}
