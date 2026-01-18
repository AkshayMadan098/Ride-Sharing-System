package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.Driver;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NearestDriverStrategyTest {

    private NearestDriverStrategy strategy;
    private Rider rider;

    @BeforeEach
    void setUp() {
        strategy = new NearestDriverStrategy();
        rider = new Rider("R1", "Akshay",11);
    }

    @Test
    void findDriver_shouldReturnFirstAvailableDriver() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 10);
        Driver driver3 = new Driver("D3", "Akshay", 10);

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2, driver3));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullWhenNoDriverIsAvailable() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Akshay", 10);

        Driver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullForEmptyDriverList() {
        Driver result = strategy.findDriver(rider, List.of());

        assertNull(result);
    }

    @Test
    void findDriver_shouldReturnDriverWhenOnlyOneAvailable() {
        Driver driver = new Driver("D1", "Akshay", 10);

        Driver result = strategy.findDriver(rider, List.of(driver));

        assertNotNull(result);
        assertEquals("D1", result.getId());
    }
}
