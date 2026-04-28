package org.bedant.datastore;

import org.bedant.model.Room;
import org.bedant.model.Sensor;
import org.bedant.model.SensorReading;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TempDatabase {
    public static Map<String, Room> rooms = new ConcurrentHashMap<>();
    public static Map<String, Sensor> sensors = new ConcurrentHashMap<>();
    public static Map<String, List<SensorReading>> readings = new ConcurrentHashMap<>();
}
