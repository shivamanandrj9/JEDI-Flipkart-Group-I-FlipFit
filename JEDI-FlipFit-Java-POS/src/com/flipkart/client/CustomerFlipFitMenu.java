package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.business.BookingService;

import java.util.Scanner;

/**
 * Represents the customer menu in the FlipFit system.
 * This class provides functionalities for customers to book, view, and cancel bookings.
 */
public class CustomerFlipFitMenu {

    private User user;

    /**
     * Constructor to initialize the CustomerFlipFitMenu with the user.
     *
     * @param user The user (customer) accessing the menu
     */
    public CustomerFlipFitMenu(User user) {
        this.user = user;
    }

    /**
     * Displays the menu options for the customer.
     *
     * @param scanner Scanner object to capture user input
     */
    public void showMenu(Scanner scanner) {
        int userChoice = -1;
        SlotActivityMenu slotActivityMenu = new SlotActivityMenu();

        while (userChoice != 4) {

            // Display menu options
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

                    slotActivityMenu.bookSlot(scanner, user);
                    break;
                case 2:
                    BookingService bookingService = new BookingService();
                    bookingService.viewAllBookings(user.getUserId());
                    break;
                case 3:

                    slotActivityMenu.cancelSlot(scanner, user);
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
