package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.GymDao;


import java.util.*;


public class GymViewingService implements GymViewingServiceInterface {


    public static GymDao gymDao = new GymDao();

    @Override
    public Map<String, List<Map<String, Object>>> viewGymToOwner(User user) {
        List<Gym> gymList = gymDao.getGymCenters(user.getUserId());

        List<Map<String, Object>> listedGyms = new ArrayList<>();
        List<Map<String, Object>> unlistedGyms = new ArrayList<>();

        for (Gym gym : gymList) {
            Map<String, Object> gymDetails = new HashMap<>();
            gymDetails.put("gymId", gym.getGymId());
            gymDetails.put("gymName", gym.getGymName());

            if (gym.getIsListed()) {
                listedGyms.add(gymDetails);
            } else {
                unlistedGyms.add(gymDetails);
            }
        }

        Map<String, List<Map<String, Object>>> gymData = new HashMap<>();
        gymData.put("listedGyms", listedGyms);
        gymData.put("unlistedGyms", unlistedGyms);

        return gymData;
    }

    @Override
    public List<Gym> viewGymToAdmin() {
        List<Gym> gymList = gymDao.getAllGymCenters();

        System.out.println("=== Listed Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        gymList.forEach(gym -> {
            if (gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        });

        System.out.println("-----------------------------");

        System.out.println("\n=== Unlisted Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        gymList.forEach(gym -> {
            if (!gym.getIsListed()) {
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        });

        System.out.println("-----------------------------");

        return gymList;

    }

    @Override
    public List<Gym> viewUnlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();
        List<Gym> unlistedGyms = new ArrayList<>();

        System.out.println("=== Unlisted Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        gymList.forEach(gym -> {
            if (!gym.getIsListed()) {
                unlistedGyms.add(gym);
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        });

        return unlistedGyms;
    }

    @Override
    public List<Gym> viewlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();
        List<Gym> listedGyms = new ArrayList<>();

        System.out.println("=== Listed Gym List ===");
        System.out.printf("%-15s %-25s%n", "Gym ID", "Gym Name");
        System.out.println("-----------------------------");
        gymList.forEach(gym -> {
            if (gym.getIsListed()) {
                listedGyms.add(gym);
                System.out.printf("%-15s %-25s%n", gym.getGymId(), gym.getGymName());
            }
        });

        return listedGyms;
    }


}
