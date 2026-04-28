package org.bedant.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {
    @GET
    public Map<String, Object> root() {
        Map<String, Object> m = new HashMap<>();
        m.put("version", "1.0");
        m.put("admin", "bedantpandey96@gmail.com");
        m.put("rooms", "/api/v1/rooms");
        m.put("sensors", "/api/v1/sensors");
        return m;
    }
}
