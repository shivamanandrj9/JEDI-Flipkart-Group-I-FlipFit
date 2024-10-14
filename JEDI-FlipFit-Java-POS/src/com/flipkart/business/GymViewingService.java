package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.GymDao;

import java.util.List;

public class GymViewingService implements GymViewingServiceInterface {


    public static GymDao gymDao = new GymDao();

    @Override
    public void viewGymToOwner(User user) {
        List<Gym> gymList = gymDao.getGymCenters(user.getUserId());
        System.out.println();
        System.out.println("=== Listed Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }
        System.out.println("-----------------------------");

        System.out.println("\n=== Unlisted Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }
        System.out.println("-----------------------------");

    }

    @Override
    public void viewGymToAdmin() {
        List<Gym> gymList = gymDao.getAllGymCenters();

        System.out.println("=== Listed Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }
        System.out.println("-----------------------------");

        System.out.println("\n=== Unlisted Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }
        System.out.println("-----------------------------");

    }

    @Override
    public void viewUnlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();

        System.out.println("=== Unlisted Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }

    }

    @Override
    public void viewlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();

        System.out.println("=== Listed Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        }

    }


}
