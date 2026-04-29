package org.bedant.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bedant.datastore.TempDatabase;
import org.bedant.exception.RoomNotEmptyException;
import org.bedant.model.Room;

import java.util.Collection;

@Path("rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorRoomResource {
    @GET
    public Collection<Room> all() {
        return TempDatabase.rooms.values();
    }

    @POST
    public Response create(Room r) {
        TempDatabase.rooms.put(r.getId(), r);
        return Response.status(201).entity(r).build();
    }

    @GET
    @Path("{id}")
    public Room one(@PathParam("id") String id) {
        return TempDatabase.rooms.get(id);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        Room room = TempDatabase.rooms.get(id);
        if (room != null && !room.getSensorIds().isEmpty()) throw new RoomNotEmptyException();
        TempDatabase.rooms.remove(id);
        return Response.ok().build();
    }
}
