package com.airtribe.ridesharingsystem.model;

public class Ride {
    private final String id;
    private final Rider rider;
    private Driver driver;
    private final double distance;
    private RideStatus status;

    public Ride(String id, Rider rider, double distance) {
        this.id = id;
        this.rider = rider;
        this.distance = distance;
        this.status = RideStatus.REQUESTED;
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = RideStatus.ASSIGNED;
    }

    public void completeRide() {
        this.status = RideStatus.COMPLETED;
    }
}