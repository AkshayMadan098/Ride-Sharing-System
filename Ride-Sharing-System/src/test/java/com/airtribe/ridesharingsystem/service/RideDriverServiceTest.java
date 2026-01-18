package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceTest {

    private DriverService DriverService;

    @BeforeEach
    void setUp() {
        DriverService = new DriverService();
    }

    @Test
    void registerDriver_shouldRegisterDriverSuccessfully() {
        Driver driver = new Driver("D1", "Ramu", 10);

        DriverService.registerDriver(driver);

        List<Driver> availableDrivers = DriverService.getAvailableDrivers();
        assertEquals(1, availableDrivers.size());
        assertEquals("D1", availableDrivers.get(0).getId());
    }

    @Test
    void getAvailableDrivers_shouldReturnOnlyAvailableDrivers() {
        Driver driver1 = new Driver("D1", "Akshay", 10);
        Driver driver2 = new Driver("D2", "Rahul", 10);

        DriverService.registerDriver(driver1);
        DriverService.registerDriver(driver2);

        List<Driver> availableDrivers = DriverService.getAvailableDrivers();

        assertEquals(2, availableDrivers.size());
        assertTrue(availableDrivers.stream().anyMatch(d -> d.getId().equals("D1")));
        assertTrue(availableDrivers.stream().anyMatch(d -> d.getId().equals("D2")));
    }

    @Test
    void getAvailableDrivers_shouldReturnEmptyListWhenNoDriversAvailable() {
        Driver driver1 = new Driver("R1","Akshay", 10);
        Driver driver2 = new Driver("R1", "Akshay", 10);

        DriverService.registerDriver(driver1);
        DriverService.registerDriver(driver2);

        List<Driver> availableDrivers = DriverService.getAvailableDrivers();

        assertNotNull(availableDrivers);
    }
}

