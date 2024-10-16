package com.flipkart;

import ch.qos.logback.core.net.SocketConnector;
import com.flipkart.resources.*;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new RegistrationController());
        environment.jersey().register(new CustomerController());
        environment.jersey().register(new GymOwnerController());
        environment.jersey().register(new GymController());
    }

}
