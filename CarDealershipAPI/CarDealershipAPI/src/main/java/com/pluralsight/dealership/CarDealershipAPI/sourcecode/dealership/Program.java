package com.pluralsight.dealership;


public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager("src/main/resources/inventory.csv");

        Dealership cowboyCars = fileManager.getDealership();

        UserInterface ui = new UserInterface(cowboyCars);

        ui.Display();
    }
}
