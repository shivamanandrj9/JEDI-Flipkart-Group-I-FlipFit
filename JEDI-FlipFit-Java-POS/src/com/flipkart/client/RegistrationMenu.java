package com.flipkart.client;

import com.flipkart.business.RegistrationService;

import java.util.Scanner;

public class RegistrationMenu {

    private RegistrationService registrationService=new RegistrationService();

    public void registerCustomer(Scanner scanner) {
        System.out.println("Enter your Username");
        String username = scanner.nextLine();
        System.out.println("Enter your Password");
        String password = scanner.nextLine();
        System.out.println("Enter your Name");
        String name = scanner.nextLine();
        System.out.println("Enter your Phone");
        String phone = scanner.nextLine();
        System.out.println("Enter your Email");
        String email = scanner.nextLine();
        System.out.println("Enter your Age");
        int age = Integer.parseInt(scanner.nextLine());
        String roleId="1";
        registrationService.createUser(username,password, name, phone,email, age, roleId);
        System.out.println("Customer registered successfully!");
    }

    public void registerGymOwner(Scanner scanner) {
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your Password");
        String password = scanner.nextLine();
        System.out.println("Enter your Name");
        String name = scanner.nextLine();
        System.out.println("Enter your Phone");
        String phone = scanner.nextLine();
        System.out.println("Enter your Email");
        String email = scanner.nextLine();
        System.out.println("Enter your Age");
        int age = Integer.parseInt(scanner.nextLine());
        String roleId="3";
        registrationService.createUser(username,password, name, phone,email, age, roleId);
        System.out.println("Gym Owner registered successfully!");
    }

    public void registerGym(Scanner scanner, String gymOwnerId) {
        System.out.println();
        System.out.print("Enter your Gym name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Gym Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your Gym City: ");
        String city = scanner.nextLine();

        registrationService.createGym(name,address,city,gymOwnerId);
        System.out.println();
        System.out.println("------Gym added for listing. Will be available after Admin's approval------");
        System.out.println();
    }

}
