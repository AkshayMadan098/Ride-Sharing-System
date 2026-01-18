package com.airtribe.ridesharingsystem.interfaces;

import com.airtribe.ridesharingsystem.model.Driver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver findDriver(Rider rider, List<Driver> Drivers);
}


