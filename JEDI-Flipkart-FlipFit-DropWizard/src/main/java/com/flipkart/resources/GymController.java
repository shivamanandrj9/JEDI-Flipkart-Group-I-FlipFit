package com.flipkart.resources;


import com.flipkart.bean.*;
import com.flipkart.business.GymViewingService;
import com.flipkart.dao.GymDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.SlotDetail;
import com.flipkart.utils.Authentication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/flipfit/gym")
public class GymController {


    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGym(@QueryParam("city") String city) {

            // Retrieve gyms
            GymDao gymDao = new GymDao();
            List<Gym> gymList = gymDao.getAllGymCenters();

            // Filter gyms based on the city and if they are listed
            List<Gym> filteredGyms = gymList.stream()
                    .filter(gym -> gym.getIsListed() && gym.getCity().equals(city))
                    .collect(Collectors.toList());

            // If no gyms found, return a message
            if (filteredGyms.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No gyms found for the specified city.")
                        .build();
            }

            // Return the filtered gyms as a JSON response
            return Response.ok(filteredGyms).build();


    }

    @GET
    @Path("/slot")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewSlots(@QueryParam("gymid") String gymid) {

        SlotDao slotDao = new SlotDao();
        List<Slot> slotList = slotDao.getAllSlotForGym(gymid);



        // If no gyms found, return a message
        if (slotList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No slot found for the specified gym.")
                    .build();
        }

        // Return the filtered gyms as a JSON response
        return Response.ok(slotList).build();


    }
}
