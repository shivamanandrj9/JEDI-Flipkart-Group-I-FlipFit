
import com.flipkart.bean.User;
import com.flipkart.business.AuthenticationService;
import com.flipkart.business.RegistrationService;
import com.flipkart.client.*;

import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FlipFitApplication
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);




        RegistrationMenu registrationMenu = new RegistrationMenu();

        AuthenticationService authenticationService = new AuthenticationService();


        int choice=-1;
        while (choice != 4) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("----------------------- Welcome to FlipFit ---------------------");
            System.out.println("----------------------------------------------------------------");
            displayCurrentDateTime(); // Display current date and time
            System.out.println("1. Login");
            System.out.println("2. Registration of the Gym Customer");
            System.out.println("3. Registration of the Gym Owner");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            System.out.println();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleLogin(scanner);
                    break;
                case 2:
                    registrationMenu.registerCustomer(scanner);
                    break;
                case 3:
                    registrationMenu.registerGymOwner(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void displayCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println(formattedDateTime);
    }

    public static void handleLogin(Scanner scanner)
    {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        AuthenticationService authenticationService = new AuthenticationService();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = authenticationService.validateUser(username, password);

        if (user != null) {
            System.out.println();
            System.out.println("-----------------------");
            System.out.println("Logged in successfully.");



            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            System.out.println("Current Date and Time: " + formattedDateTime);

            String roleId = user.getRoleId();
            switch (roleId) {
                case "1":
                    System.out.println("Welcome Customer "+ user.getName()+ "!!!");
                    System.out.println("-----------------------");
                    System.out.println();
                    CustomerFlipFitMenu customerFlipFitMenu=new CustomerFlipFitMenu(user);
                    customerFlipFitMenu.showMenu(scanner);
                    break;
                case "2":
                    System.out.println("Welcome Admin "+user.getName()+" !!!");
                    System.out.println("-----------------------");
                    System.out.println();
                    AdminFlipFitMenu adminFlipFitMenu = new AdminFlipFitMenu(user);
                    adminFlipFitMenu.showMenu(scanner);
                    break;
                case "3":
                    System.out.println("Welcome Gym Owner "+user.getName()+" !!!");
                    System.out.println("-----------------------");
                    System.out.println();
                    GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu(scanner, user);
                    gymOwnerFlipFitMenu.showMenu();
                    break;

            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}