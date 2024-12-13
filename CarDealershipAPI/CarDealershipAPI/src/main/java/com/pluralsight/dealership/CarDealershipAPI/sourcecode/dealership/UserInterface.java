package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Vehicle> vehicleList = new ArrayList<>();

    private Dealership dealership; // dealership attribute
    public UserInterface(Dealership dealership){
        this.dealership = dealership; //assigning dealership
    }
    public void Display() {

     Scanner scan = new Scanner(System.in);

     boolean exit = false;

     while (!exit){
         System.out.println("Welcome to cowboy cars! ");
         System.out.println("A : Price range ");
         System.out.println("B: Make/model ");
         System.out.println("C : Year ");
         System.out.println("D : Mileage ");
         System.out.println("E : Vehicle Type ");
         System.out.println("F : List all vehicles ");
         System.out.println("G : Add vehicle ");
         System.out.println("H : Remove vehicle ");
         System.out.println("I : Sell Vehicle");
         System.out.println("J : Lease Vehicle");
         System.out.println("X : Quit ");


         String option = scan.nextLine().toUpperCase().trim();
         switch (option){
             case "A":
                 handlePriceRange(scan);
                 break;
             case "B":
                 handleMakeModelSearch(scan);
                 break;
             case "C":
                 handleYearSearch(scan);
                 break;
             case "D":
                 handleMileageSearch(scan);
                 break;
             case "E":
                 handleVehicleType(scan);
                 break;
             case "F":
                 listAllVehicles();
                 break;
             case "G":
             addVehicle(scan);
             break;
             case "H":
                 removeVehicle(scan);
                 break;
             case "I":
                 processAllVehiclesRequest();
                 break;
             case"X":
                 exit = true;
                 System.out.println("See ya later partner!");
                 break;
             default:
                 System.out.println("Invalid option. please try again. ");
                 break;


         }
     }
}
private  void processAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
}

    private void removeVehicle(Scanner scan) {
        System.out.println("Enter VIN of the vehicle to remove: ");
        int vinToRemove = Integer.parseInt(scan.nextLine().trim());

        boolean removed = dealership.removeVehicle(vinToRemove);

        if (removed) {
            System.out.println("Vehicle with VIN " + vinToRemove + " removed successfully!");
        } else {
            System.out.println("No vehicle found with VIN: " + vinToRemove);
        }
    }
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("Here are all the vehicles:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle); // Calls toString() of Vehicle
            }
        }
    }


    private void listAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("Here are all the vehicles:");
            for (Vehicle vehicle : vehicleList) {
                System.out.println(vehicle); // Calls toString() of Vehicle
            }
        }
    }
private void handleVehicleType(Scanner scanner){
    System.out.println("Enter Vehicle type: ");
    String vehicleType = scanner.nextLine().trim();

    List<Vehicle> foundVehicles = getVehiclesByType( vehicleType);

    if (foundVehicles.isEmpty()) {
        System.out.println("No cars found with this type: " + vehicleType);
    }else {
        System.out.println("Here are the vehicles found: " );
        for (Vehicle vehicle : foundVehicles) {
            System.out.println(vehicle);
        }
    }
}
private List<Vehicle> getVehiclesByType(String vehicleType) {
    List<Vehicle> result = new ArrayList<>();
    for (Vehicle vehicle : vehicleList) {
        if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
            result.add(vehicle);
        }
    }
   return result;

}
private void handleMileageSearch(Scanner scanner) {
    System.out.println("Enter mileage:");
    int odometer = Integer.parseInt(scanner.nextLine().trim());

    List<Vehicle> foundVehicles = getVehiclesByMileage(odometer);

    if (foundVehicles.isEmpty()) {
        System.out.println("No cars found with this mileage: " + odometer);

    } else {
        System.out.println("Here are the vehicles found: ");
        for (Vehicle vehicle : foundVehicles) {
            System.out.println(vehicle);
        }
    }
}
private List<Vehicle> getVehiclesByMileage(int odometer){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: vehicleList){
            if (vehicle.getOdometer() == odometer){
                result.add(vehicle);
            }
        }
        return result;
}
private void handleYearSearch(Scanner scanner) {
    System.out.println("Enter year:");
    int year = Integer.parseInt(scanner.nextLine().trim());

    List<Vehicle> foundVehicles = getVehiclesByYear(year);

    if (foundVehicles.isEmpty()) {
        System.out.println("No cars found for year: " + year);
    } else {
        System.out.println("Here are the vehicles found: ");
        for (Vehicle vehicle : foundVehicles){
            System.out.println(vehicle);
        }
    }
}
private List<Vehicle> getVehiclesByYear(int year ){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: vehicleList){
            if (vehicle.getYear() == year){
                result.add(vehicle);
            }
        }
        return result;
}
private void handleMakeModelSearch(Scanner scanner){
    System.out.println("Enter make: ");
    String make = scanner.nextLine().trim();
    System.out.println("Enter model: ");
    String model = scanner.nextLine().trim();

    List<Vehicle> foundVehicles = getVehiclesByMakeModel(make,model);

    if (foundVehicles.isEmpty()){
        System.out.println("No cars found for make: " + make + "and model: " + model);

    }else {
        System.out.println("Here are the vehicles: ");
        for (Vehicle vehicle : foundVehicles){
            System.out.println(vehicle);
        }
    }
}
    private List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }

private void handlePriceRange(Scanner scanner){
    System.out.println("What is your minimum price? ");
    double minimum = Double.parseDouble(scanner.nextLine().trim());
    System.out.println("What is your maximum price?");
    double maximum = Double.parseDouble(scanner.nextLine().trim());

    List<Vehicle> filteredVehicles = getVehiclesByPriceRange(minimum,maximum);

    if (filteredVehicles.isEmpty()){
        System.out.println("No vehicles in this range.");

    }else {
        System.out.println("Here are vehicles in your price range.");
        for (Vehicle vehicle: filteredVehicles){
            System.out.println(vehicle);
        }
    }
}

private List<Vehicle> getVehiclesByPriceRange(double min, double max){
     List<Vehicle> result = new ArrayList<>();
     for (Vehicle vehicle : vehicleList){
         if (vehicle.getVehiclesByPrice() >= min && vehicle.getVehiclesByPrice() <= max){
             result.add(vehicle);
         }
     }
     return result;
}
    private void addVehicle(Scanner scan) {
        try {


            System.out.println("Enter VIN: ");
            int vin = Integer.parseInt(scan.nextLine().trim());
            System.out.println("Enter year: ");
            int year = Integer.parseInt(scan.nextLine().trim());
            System.out.println("Enter make: ");
            String make = scan.nextLine().trim();
            System.out.println("Enter model: ");
            String model = scan.nextLine().trim();
            System.out.println("Enter vehicle type: ");
            String vehicleType = scan.nextLine().trim();
            System.out.println("Enter color: ");
            String color = scan.nextLine().trim();
            System.out.println("Enter odometer reading: ");
            int odometer = Integer.parseInt(scan.nextLine().trim());
            System.out.println("Enter price: ");
            double vehiclesByPrice = Double.parseDouble(scan.nextLine().trim());

            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, vehiclesByPrice);
            vehicleList.add(newVehicle);
            System.out.println("Vehicle added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers");
        }

    }
}
