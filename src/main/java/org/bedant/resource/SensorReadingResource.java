package org.bedant.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bedant.datastore.TempDatabase;
import org.bedant.exception.SensorUnavailableException;
import org.bedant.model.Sensor;
import org.bedant.model.SensorReading;

import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.List;

public class SensorReadingResource {
    private String sensorId;

    public SensorReadingResource(String sensorId) {
        this.sensorId = sensorId;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorReading> all() {
        return TempDatabase.readings.getOrDefault(sensorId, new ArrayList<>());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(SensorReading r) {
        Sensor s = TempDatabase.sensors.get(sensorId);
        if ("MAINTENANCE".equalsIgnoreCase(s.getStatus())) throw new SensorUnavailableException();
        TempDatabase.readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(r);
        s.setCurrentValue(r.getValue());
        return Response.status(201).entity(r).build();
    }
}
