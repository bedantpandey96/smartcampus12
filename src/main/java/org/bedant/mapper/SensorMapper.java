package org.bedant.mapper;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.bedant.exception.SensorUnavailableException;

import java.util.Map;

@Provider
public class SensorMapper implements ExceptionMapper<SensorUnavailableException> {
    public Response toResponse(SensorUnavailableException e) {
        return Response.status(403).entity(Map.of("error", "Sensor unavailable")).build();
    }
}
