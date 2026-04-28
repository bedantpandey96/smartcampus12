package org.bedant.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.bedant.exception.LinkedResourceNotFoundException;

import java.util.Map;

@Provider
public class LinkedMapper implements ExceptionMapper<LinkedResourceNotFoundException> {
    public Response toResponse(LinkedResourceNotFoundException e) {
        return Response.status(422).entity(Map.of("error", "Room does not exist")).build();
    }
}
