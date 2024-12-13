package com.pluralsight.dealership;


import java.util.ArrayList;

public class Vehicle {

    private double vehiclesByPrice;
    private int vin, year, odometer;
    private String make , model, vehicleType, color;



    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double vehiclesByPrice) {
        this.vehiclesByPrice = vehiclesByPrice;
        this.vin = vin;
        this.year = year;
        this.odometer = odometer;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public double getVehiclesByPrice() {
        return vehiclesByPrice;
    }

    public void setVehiclesByPrice(double vehiclesByPrice) {
        this.vehiclesByPrice = vehiclesByPrice;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return year + " " + make + " " + model + " - $" + vehiclesByPrice + " (" + odometer + " miles)";
    }

}


