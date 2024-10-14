package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.business.GymViewingService;
import com.flipkart.business.SlotService;

import java.util.Scanner;

/**
 * Represents the gym owner menu in the FlipFit system.
 * This class provides functionalities for gym owners to manage their gyms and slots.
 */
public class GymOwnerFlipFitMenu {

    private Scanner scanner; // Scanner instance for user input
    private User user;

    /**
     * Constructor to initialize the GymOwnerFlipFitMenu with user and scanner.
     *
     * @param scanner Scanner object for capturing user input
     * @param user    The user (gym owner) accessing the menu
     */
    public GymOwnerFlipFitMenu(Scanner scanner, User user) {
        this.scanner = scanner;
        this.user = user;
    }

    /**
     * Displays the menu options for the gym owner.
     * This method provides options to view gyms, add a new gym, add gym slots, and logout.
     */
    public void showMenu() {
        int gymOwnerChoice = -1;

        RegistrationMenu registrationMenu = new RegistrationMenu();
        GymViewingService gymViewingService = new GymViewingService();
        SlotService slotService = new SlotService();
        SlotActivityMenu slotAddingMenu = new SlotActivityMenu();

        while (gymOwnerChoice != 4) { // Updated to 4 for logout
            // Display menu options
            System.out.println("Gym Owner Menu:");
            System.out.println("1. View all Gym Centers");
            System.out.println("2. Add New Gym Center");
            System.out.println("3. Add Gym Slots");
            System.out.println("4. Logout");
            System.out.println();
            System.out.print("Enter your choice: ");
            gymOwnerChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (gymOwnerChoice) {
                case 1:
                    gymViewingService.viewGymToOwner(user);
                    System.out.println();
                    break;
                case 2:
                    registrationMenu.registerGym(scanner, user.getUserId());
                    break;
                case 3:
                    slotAddingMenu.addSlot(scanner, user.getUserId());
                    break;
                case 4:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
