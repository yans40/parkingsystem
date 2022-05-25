package com.parkit.parkingsystem.model;

import java.util.Date;

public
class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Date inTime;
    private Date outTime;

    private boolean isRecurrent;

    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }

    public
    ParkingSpot getParkingSpot() {
        return new ParkingSpot(parkingSpot.getId(), parkingSpot.getParkingType(), parkingSpot.isAvailable());
    }

    public
    void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = new ParkingSpot(parkingSpot.getId(), parkingSpot.getParkingType(), parkingSpot.isAvailable());
    }

    public
    String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public
    void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public
    double getPrice() {
        return price;
    }


    public
    void setPrice(double price) {
        this.price = price;
    }

    public
    Date getInTime() {
        return new Date(inTime.getTime());
    }

    public
    void setInTime(Date inTime) {
        this.inTime = new Date(inTime.getTime());
    }

    public
    Date getOutTime() {
        if (outTime == null) {
            return null;
        } else {
            return new Date(outTime.getTime());
        }
    }

    public
    void setOutTime(Date outTime) {
        this.outTime = new Date(outTime.getTime());
    }

    public
    boolean isRecurrent() {
        return isRecurrent;
    }

    public
    void setIsRecurrent(boolean recurrent) {
        this.isRecurrent = recurrent;
    }
}
