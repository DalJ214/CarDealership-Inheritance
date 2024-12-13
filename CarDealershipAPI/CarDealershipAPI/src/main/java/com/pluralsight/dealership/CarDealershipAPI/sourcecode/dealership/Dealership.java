package com.pluralsight.dealership;


import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name, address, phone;

    private List<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>(vehicles != null ? vehicles : new ArrayList<>()); // initialize with provided array list or create empty array list
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);

    }

    public boolean removeVehicle(int vin) {
            return vehicles.removeIf(vehicle -> vehicle.getVin() == vin );

    }
//Methods
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles); //returning list of vehicles and creating new arraylist

    }
public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles){
            if (vehicle.getVehiclesByPrice() >= min && vehicle.getVehiclesByPrice() <= max){
                result.add(vehicle);
            }
        }
        return result;

}
public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
}
public List<Vehicle> getVehiclesByYear(int Year){
        return null;
}
public List<Vehicle> getVehiclesByColor(String Color){
        return null;

}
public List<Vehicle> getVehiclesByMileage(int Mileage){
        return null;

}
public List<Vehicle> getVehiclesByType(String Type){
        return null;
}


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

