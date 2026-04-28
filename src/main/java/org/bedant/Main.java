package org.bedant;


import org.bedant.config.AppConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        URI uri = URI.create("http://localhost:8080/");
        ResourceConfig config = new AppConfig();
        GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.println("Running on http://localhost:8080/api/v1");
    }
}