package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService {
    private final Map<String, Driver> drivers = new HashMap<>();

    public void registerDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> available = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                available.add(driver);
            }
        }
        return available;
    }
}


