package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.GymViewingService;
import com.flipkart.business.ListingAndUnlistingService;

import java.util.List;
import java.util.Scanner;

public class AdminFlipFitMenu {


    private User user;

    public AdminFlipFitMenu(User user) {
        this.user = user;
    }

    public void showMenu(Scanner scanner) {
        GymViewingService gymViewingService = new GymViewingService();

        int choice;

        do {
            System.out.println("1. Show All gyms");
            System.out.println("2. List a gym");
            System.out.println("3. Unlist a gym");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println();
            switch (choice) {
                case 1:
                    gymViewingService.viewGymToAdmin();
                    System.out.println();
                    break;
                case 2:
                    listingGymMenu(scanner);
                    break;
                case 3:
                    unlistingGymMenu(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }


    private void listingGymMenu(Scanner scanner){
        GymViewingService gymViewingService = new GymViewingService();
        ListingAndUnlistingService listingAndUnlistingService = new ListingAndUnlistingService();


        gymViewingService.viewUnlistedGym();

        System.out.println();
        System.out.print("Select the ID of the gym you want to list(-1 to exit): ");
        String selection;
        selection = scanner.next();

        if(selection.equals("-1"))
        {
            return;
        }

        listingAndUnlistingService.listThisGym(selection);

    }

    private void unlistingGymMenu(Scanner scanner){
        GymViewingService gymViewingService = new GymViewingService();
        ListingAndUnlistingService listingAndUnlistingService = new ListingAndUnlistingService();


        gymViewingService.viewlistedGym();

        System.out.println();
        System.out.print("Select the ID of the gym you want to list(-1 to exit) :");
        String selection;
        selection = scanner.next();

        if(selection.equals("-1"))
        {
            return;
        }

        listingAndUnlistingService.unlistThisGym(selection);

    }
}
