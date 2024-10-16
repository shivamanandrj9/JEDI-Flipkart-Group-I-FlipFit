package com.flipkart.resources;


import com.flipkart.model.RegistrationDetail;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.flipkart.business.RegistrationService;

@Path("/flipfit")
public class RegistrationController {

    @POST
    @Path("/register/gymowner")
    @Consumes(MediaType.APPLICATION_JSON) // Consuming JSON
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response createGymowner(RegistrationDetail registrationDetail) {

        RegistrationService registrationService = new RegistrationService();
        registrationService.createUser(registrationDetail.getUsername(), registrationDetail.getPassword(), registrationDetail.getName(), registrationDetail.getPhone(), registrationDetail.getEmail(), registrationDetail.getAge(), "3");
        return Response.status(Response.Status.CREATED).entity(registrationDetail).build();
    }

    @POST
    @Path("/register/customer")
    @Consumes(MediaType.APPLICATION_JSON) // Consuming JSON
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response createCustomer(RegistrationDetail registrationDetail) {

        RegistrationService registrationService = new RegistrationService();
        registrationService.createUser(registrationDetail.getUsername(), registrationDetail.getPassword(), registrationDetail.getName(), registrationDetail.getPhone(), registrationDetail.getEmail(), registrationDetail.getAge(), "1");
        return Response.status(Response.Status.CREATED).entity(registrationDetail).build();
    }



}
