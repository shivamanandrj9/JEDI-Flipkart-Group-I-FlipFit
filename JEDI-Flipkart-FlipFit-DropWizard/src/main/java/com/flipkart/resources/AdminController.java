package com.flipkart.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.GymViewingService;
import com.flipkart.business.GymViewingServiceInterface;
import com.flipkart.business.ListingAndUnlistingService;
import com.flipkart.business.ListingAndUnlistingServiceInterface;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.Authentication;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/flipfit/admin")
public class AdminController {

    private GymViewingServiceInterface gym_viewing_service = new GymViewingService();
    private ListingAndUnlistingServiceInterface listing_unlisting_service = new ListingAndUnlistingService();

    private User validateAdmin(String authorization) throws UserNotFoundException{
        User user = Authentication.authenticate(authorization);

        System.out.println(user);
        if (user.getRoleId().equals("2")) {
            return user;
        }else {
            throw new UserNotFoundException("User is not admin");
        }
    }

    // view listed and unlisted gyms
    @GET
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    @Path("/all_gyms")
    public Response GetAllGyms(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization){


        try {
            validateAdmin(authorization);
            List<Gym> all_gyms = gym_viewing_service.viewGymToAdmin();
            return Response.ok(all_gyms).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
            .entity(e.getMessage())
            .build();
        }
    }

    public static class GymList{
        @JsonProperty("gymId")
        public List<String> gymIds;
    }

    // list a gym
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Producing JSON response
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    @Path("/list_gym")
    public Response ListGym(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, GymList to_list_gym){
        try {
            validateAdmin(authorization);
            System.out.println(to_list_gym);
            for (String gymId : to_list_gym.gymIds) {
                listing_unlisting_service.listThisGym(gymId);
            }

            List<Gym> listed_gyms = gym_viewing_service.viewlistedGym();
            return Response.ok(listed_gyms).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
            .entity(e.getMessage())
            .build();
        }
    }

    // unlist a gym
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Producing JSON response
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    @Path("/unlist_gym")
    public Response UnListGym(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, GymList to_unlist_gym){
        try {
            validateAdmin(authorization);
            for (String gymId : to_unlist_gym.gymIds) {
                listing_unlisting_service.unlistThisGym(gymId);
            }

            return Response.ok(gym_viewing_service.viewUnlistedGym()).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
            .entity(e.getMessage())
            .build();
        }
    }
}
