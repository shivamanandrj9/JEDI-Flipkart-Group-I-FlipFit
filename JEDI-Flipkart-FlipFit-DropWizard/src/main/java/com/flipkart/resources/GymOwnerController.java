package com.flipkart.resources;


import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.dao.GymDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.GymRegistrationDetail;
import com.flipkart.model.SlotDetail;
import com.flipkart.utils.Authentication;
import com.flipkart.utils.DbUtils;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.*;

@Path("/flipfit/gymowner")
public class GymOwnerController {
    @GET
    @Path("/gymcenters")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response viewGymCenters(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {

        try{

            User user = Authentication.authenticate(authorization);

            if(!user.getRoleId().equals("3"))
            {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Not a gymowner")
                        .build();
            }
            GymViewingService gymViewingService = new GymViewingService();
            Map<String, List<Map<String, Object>>> gymData = gymViewingService.viewGymToOwner(user);

            return Response.ok(gymData).build();
        }
        catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        }


    }

    @POST
    @Path("/gym")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)// Producing JSON response
    public Response registerGym(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, GymRegistrationDetail gymRegistrationDetail) {

        try{

            User user = Authentication.authenticate(authorization);

            if(!user.getRoleId().equals("3"))
            {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Not a gymowner")
                        .build();
            }
            RegistrationService registrationService = new RegistrationService();
            registrationService.createGym(gymRegistrationDetail.getName(), gymRegistrationDetail.getAddress(), gymRegistrationDetail.getCity(), user.getUserId());
            return Response.status(Response.Status.CREATED).entity(gymRegistrationDetail).build();

        }
        catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        }


    }

    @POST
    @Path("/slot")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)// Producing JSON response
    public Response createSlot(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, SlotDetail slotDetail) {

        try{

            User user = Authentication.authenticate(authorization);

            if(!user.getRoleId().equals("3"))
            {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Not a gymowner")
                        .build();
            }
            DbUtils dbUtils = new DbUtils();

            String id = Integer.toString(1 + dbUtils.getTableCnt("Slot"));
            Slot slt = new Slot(slotDetail.getGymId(),id, slotDetail.getDate() , slotDetail.getStartTime(), slotDetail.getEndTime(), slotDetail.getCapacity());
            SlotService slotService = new SlotService();
            slotService.addSlot(slt);
            return Response.status(Response.Status.CREATED).entity(slt).build();

        }
        catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        }


    }

    @GET
    @Path("/slot")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewSlot(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {

        try{

            User user = Authentication.authenticate(authorization);

            if(!user.getRoleId().equals("3"))
            {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Not a gymowner")
                        .build();
            }
            GymDao gymDao = new GymDao();
            SlotDao slotDao = new SlotDao();
            List<Gym> gymList = gymDao.getAllGymCenters();
            List<Slot> slots = new ArrayList<Slot>();

            for (Gym gym : gymList) {
                if (gym.getGymOwnerID().equals(user.getUserId())) {
                    List<Slot> curr_slots = slotDao.getAllSlotForGym(gym.getGymId());
                    slots.addAll(curr_slots);
                }
            }
            return Response.ok(slots).build();



        }
        catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password.")
                    .build();
        }


    }
}
