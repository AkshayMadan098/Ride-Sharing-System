package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.Driver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Rider rider, List<Driver> Drivers) {
        for (Driver driver : Drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }
}
