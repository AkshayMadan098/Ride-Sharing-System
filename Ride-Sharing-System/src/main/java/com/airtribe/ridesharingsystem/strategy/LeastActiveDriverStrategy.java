package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.Driver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;
import java.util.Map;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {

    private final Map<String, Integer> driverRideCount;

    public LeastActiveDriverStrategy(Map<String, Integer> driverRideCount) {
        this.driverRideCount = driverRideCount;
    }

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        Driver selectedDriver = null;
        int minRides = Integer.MAX_VALUE;

        for (Driver driver : drivers) {
            if (!driver.isAvailable()) continue;

            int rides = driverRideCount.getOrDefault(driver.getId(), 0);
            if (rides < minRides) {
                minRides = rides;
                selectedDriver = driver;
            }
        }
        return selectedDriver;
    }
}
