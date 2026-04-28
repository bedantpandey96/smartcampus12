package org.bedant.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class GlobalMapper implements ExceptionMapper<Throwable> {
    public Response toResponse(Throwable e) {
        return Response.status(500).entity(Map.of("error", "Internal Server Error")).build();
    }
}
