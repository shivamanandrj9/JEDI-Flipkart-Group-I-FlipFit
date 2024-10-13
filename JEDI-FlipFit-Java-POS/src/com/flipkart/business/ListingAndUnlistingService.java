package com.flipkart.business;

import com.flipkart.dao.GymDao;

public class ListingAndUnlistingService {

    public static GymDao gymDao = new GymDao();

    public void listThisGym(String gymId){
        gymDao.listGym(gymId);
    }

    public void unlistThisGym(String gymId){
        gymDao.unlistGym(gymId);
    }
}
