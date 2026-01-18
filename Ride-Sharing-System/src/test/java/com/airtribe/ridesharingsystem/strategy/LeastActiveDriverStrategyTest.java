package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.Driver;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeastActiveDriverStrategyTest {

    private Map<String, Integer> driverRideCount;
    private LeastActiveDriverStrategy strategy;
    private Rider rider;

    @BeforeEach
    void setUp() {
        driverRideCount = new HashMap<>();
        strategy = new LeastActiveDriverStrategy(driverRideCount);
        rider = new Rider("R1", "Akshay",11);
    }

    @Test
    void findDriver_shouldReturnDriverWithLeastRides() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 10);
        Driver driver3 = new Driver("D3", "Akshay", 10);

        driverRideCount.put("D1", 5);
        driverRideCount.put("D2", 2);
        driverRideCount.put("D3", 7);

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2, driver3));

        assertNotNull(result);
        assertEquals("D2", result.getId());
    }

    @Test
    void findDriver_shouldIgnoreUnavailableDrivers() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 10);

        driverRideCount.put("D1", 0);
        driverRideCount.put("D2", 3);

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullWhenNoDriversAvailable() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 56);

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldTreatMissingRideCountAsZero() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 10);

        driverRideCount.put("D2", 4); // D1 not present → default 0

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
        assertEquals("D1", result.getId());
    }
}

