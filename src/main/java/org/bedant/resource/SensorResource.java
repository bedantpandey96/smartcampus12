package org.bedant.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bedant.datastore.TempDatabase;
import org.bedant.exception.LinkedResourceNotFoundException;
import org.bedant.model.Room;
import org.bedant.model.Sensor;

import java.util.Collection;

@Path("sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {
    @GET
    public Collection<Sensor> all(@QueryParam("type") String type) {
        if (type == null) return TempDatabase.sensors.values();
        return TempDatabase.sensors.values().stream().filter(s -> s.getType().equalsIgnoreCase(type)).toList();
    }

    @POST
    public Response create(Sensor s) {
        Room room = TempDatabase.rooms.get(s.getRoomId());
        if (room == null) throw new LinkedResourceNotFoundException();
        TempDatabase.sensors.put(s.getId(), s);
        room.getSensorIds().add(s.getId());
        return Response.status(201).entity(s).build();
    }

    @Path("{id}/readings")
    public SensorReadingResource sub(@PathParam("id") String id) {
        return new SensorReadingResource(id);
    }
}