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

    public void showMenu(Scanner scanner){

        GymViewingService gymViewingService = new GymViewingService();

        System.out.println("Welcome Admin " + user.getUsername());
        System.out.println("1. Show All gyms");
        System.out.println("2. List a gym");
        System.out.println("3. Unlist a gym");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        while(choice!=4)
        {
            switch (choice) {
                case 1:
                    gymViewingService.viewGymToAdmin();
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
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
        }

    }

    private void listingGymMenu(Scanner scanner){
        GymViewingService gymViewingService = new GymViewingService();
        ListingAndUnlistingService listingAndUnlistingService = new ListingAndUnlistingService();

        System.out.println("Select the id of the gym you want to list:");
        gymViewingService.viewUnlistedGym();
        String selection;
        selection = scanner.next();

        listingAndUnlistingService.listThisGym(selection);

    }

    private void unlistingGymMenu(Scanner scanner){
        GymViewingService gymViewingService = new GymViewingService();
        ListingAndUnlistingService listingAndUnlistingService = new ListingAndUnlistingService();

        System.out.println("Select the id of the gym you want to list:");
        gymViewingService.viewlistedGym();
        String selection;
        selection = scanner.next();

        listingAndUnlistingService.unlistThisGym(selection);

    }
}
