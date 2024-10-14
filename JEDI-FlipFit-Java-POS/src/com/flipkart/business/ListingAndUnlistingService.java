package com.flipkart.business;

import com.flipkart.dao.GymDao;

public class ListingAndUnlistingService implements ListingAndUnlistingServiceInterface {

    public static GymDao gymDao = new GymDao();

    @Override
    public void listThisGym(String gymId){
        gymDao.listGym(gymId);
    }

    @Override
    public void unlistThisGym(String gymId){
        gymDao.unlistGym(gymId);
    }
}
