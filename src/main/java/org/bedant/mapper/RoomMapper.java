package org.bedant.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.bedant.exception.RoomNotEmptyException;

import java.util.Map;

@Provider
public class RoomMapper implements ExceptionMapper<RoomNotEmptyException> {
    public Response toResponse(RoomNotEmptyException e) {
        return Response.status(409).entity(Map.of("error", "Room has sensors")).build();
    }
}
