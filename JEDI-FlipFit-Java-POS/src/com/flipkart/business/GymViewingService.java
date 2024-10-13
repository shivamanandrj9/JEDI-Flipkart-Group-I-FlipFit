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

        System.out.println("Listed Gym List");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.print(gym.getGymName() + " ");
            }
        }

        System.out.println("UnListed Gym List");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.println(gym.getGymName() + " ");
            }
        }
    }

    @Override
    public void viewGymToAdmin() {
        List<Gym> gymList = gymDao.getAllGymCenters();

        System.out.println("Listed Gym List");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.print(gym.getGymName() + " ");
            }
        }

        System.out.println("UnListed Gym List");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.println(gym.getGymName() + " ");
            }
        }
    }

    @Override
    public void viewUnlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();


        System.out.println("UnListed Gym List");
        for (Gym gym : gymList) {
            if (!gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.println(gym.getGymName() + " ");
            }
        }
    }

    @Override
    public void viewlistedGym() {
        List<Gym> gymList = gymDao.getAllGymCenters();
        System.out.println("Listed Gym List");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.print(gym.getGymId() + " ");
                System.out.println(gym.getGymName() + " ");
            }
        }
    }


}
