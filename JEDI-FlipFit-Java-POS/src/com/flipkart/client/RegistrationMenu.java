package com.flipkart.client;

import com.flipkart.business.RegistrationService;

import java.util.Scanner;

/**
 *
 * Represents the registration menu in the FlipFit system.
 * This class provides functionalities for registering customers, gym owners, and gyms.
 * @author shubham
 */
public class RegistrationMenu {

    private RegistrationService registrationService = new RegistrationService();


    /**
     * Registers a new customer by capturing user details from input.
     *
     * @param scanner Scanner instance for capturing user input
     */
    public void registerCustomer(Scanner scanner) {
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        String roleId = "1";
        registrationService.createUser(username, password, name, phone, email, age, roleId);
        System.out.println("---- Signed In successfully!----");
    }

    /**
     * Registers a new gym owner by capturing their details from input.
     *
     * @param scanner Scanner instance for capturing user input
     */
    public void registerGymOwner(Scanner scanner) {
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        String roleId = "3";
        registrationService.createUser(username, password, name, phone, email, age, roleId);
        System.out.println("-----Gym Owner registered successfully!-----");
    }

    /**
     * Registers a new gym by capturing gym details from input.
     *
     * @param scanner    Scanner instance for capturing user input
     * @param gymOwnerId The ID of the gym owner registering the gym
     */
    public void registerGym(Scanner scanner, String gymOwnerId) {
        System.out.println();
        System.out.print("Enter your Gym name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Gym Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your Gym City: ");
        String city = scanner.nextLine();

        registrationService.createGym(name, address, city, gymOwnerId);
        System.out.println();
        System.out.println("------Gym added for listing. Will be available after Admin's approval------");
        System.out.println();
    }

}
