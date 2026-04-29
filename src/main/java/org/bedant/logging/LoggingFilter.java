package org.bedant.logging;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    Logger log = Logger.getLogger("API");

    public void filter(ContainerRequestContext req) {
        log.info(req.getMethod() + " " + req.getUriInfo().getPath());
    }

    public void filter(ContainerRequestContext req, ContainerResponseContext res) {
        log.info("Status: " + res.getStatus());
    }
}