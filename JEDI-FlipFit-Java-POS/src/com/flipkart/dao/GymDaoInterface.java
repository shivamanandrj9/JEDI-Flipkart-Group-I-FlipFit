package com.flipkart.dao;

import com.flipkart.bean.Gym;
import java.util.List;

public interface GymDaoInterface {

    void addGym(Gym gym);

    List<Gym> getGymCenters(String userId);

    List<Gym> getAllGymCenters();

    void listGym(String gymId);

    void unlistGym(String gymId);
}
