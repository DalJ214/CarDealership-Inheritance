package com.pluralsight.dealership;

import java.io.*;

public class DealershipFileManager {
    private String filePath;

    public DealershipFileManager(String filePath){
        this.filePath = filePath;
    }



    public Dealership getDealership() {

        Dealership dealership = new Dealership("Cowboy cars","2146 Arroyo lane", "324-355-0003");

        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            String line;

            while ((line = bufRead.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 8) {
                    System.out.println("Skip line " + line);
                    continue; //will skip line and continue
                }
                {
                    int vin = Integer.parseInt(parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String make = parts[2].trim();
                    String model = parts[3].trim();
                    String vehicleType = parts[4].trim();
                    String color = parts[5].trim();
                    int odometer = Integer.parseInt(parts[6]);
                    double vehiclesByPrice = Double.parseDouble(parts[7]);


                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, vehiclesByPrice);
                    dealership.addVehicle(vehicle);

                }
                }
            }catch(NumberFormatException e){
            System.out.println("Error parsing " );



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (FileWriter writer = new FileWriter("src/main/resources/inventory.csv")) {
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getVehiclesByPrice()));
            }
        } catch (IOException e) {
            System.out.println("Error saving the dealership data: " + e.getMessage());
        }
    }
}
