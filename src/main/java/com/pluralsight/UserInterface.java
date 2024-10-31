package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface{

    private Scanner myScanner = new Scanner(System.in);
    private Dealership dealership;

    //constructor
    public UserInterface(){
        this.myScanner = new Scanner(System.in);
        init();
    }

    private void init(){
        DealerShipFileManager fileManager = new DealerShipFileManager("src/inventory.csv");
        dealership = fileManager.getDealership();
    }

    public void ShowMenu(){
        System.out.println("Welcome to Lamborigini!");
        System.out.println("**********************************************");
        System.out.println("Please Select an option from the menu below:");
        System.out.println
                ("1 - Find vehicle with price range" + "\n" +
                "2 - Find Vehicle by make/model" + "\n" +
                "3 - Find vehicles by year range" + "\n" +
                "4 - Find vehicles by color" + "\n" +
                "5 - Find vehicles by mileage range" + "\n" +
                "6 - Find vehicles by type(car, truck, Suv, van" + "\n" +
                "7 - List ALL vehicles" + "\n" +
                "8 - Add vehicle" + "\n" +
                "9 - Remove a vehicle" +"\n" +
                "99 - Quit");
        System.out.println("*********************************************");
        System.out.println("Enter your choice: ");
        int choice = myScanner.nextInt();
    }

    public void ProcessUserAnswer(){
        while(true){
            ShowMenu();
            int choice = myScanner.nextInt();
            myScanner.nextLine();
            switch (choice) {
                case 1:
                    processFindVehiclesByPriceRange();
                    break;
                case 2:
                    processFindVehiclesByMakeModel();
                    break;
                case 3:
                    processFindVehiclesByYearRange();
                    break;
                case 4:
                    processFindVehiclesByColor();
                    break;
                case 5:
                    processFindVehiclesByMileageRange();
                    break;
                case 6:
                    processFindVehiclesByType();
                    break;
                case 7:
                    processGetAllVehicles();
                    break;
                case 8:
                    processAddVehicle();
                    break;
                case 9:
                    processRemoveVehicle();
                    break;
                case 99:
                    System.out.println("Exiting...");
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display a list of vehicles
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s %-10d %-10.2f\n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getMake(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice());
            }
        }
    }

    public void processFindVehiclesByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = myScanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = myScanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPriceRange(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByMakeModel() {
        System.out.print("Enter make: ");
        String make = myScanner.next();
        System.out.print("Enter model: ");
        String model = myScanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByYearRange() {
        System.out.print("Enter start year: ");
        int startYear = myScanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = myScanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByPriceRange(startYear, endYear);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByColor() {
        System.out.print("Enter color: ");
        String color = myScanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByMileageRange() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = myScanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = myScanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileageRange(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByType() {
        System.out.print("Enter type (car, truck, SUV, van): ");
        String type = myScanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicle();
        displayVehicles(vehicles);
    }

    public void processAddVehicle() {
         String vin;
         int year;
         String make;
         String model;
         String vehicleType;
         String color;
         int mileage;
         double price;

        System.out.print("Enter vehicle ID: ");
         vin = this.myScanner.nextLine();

        System.out.print("Enter vehicle make: ");
         make = this.myScanner.next();

        System.out.print("Enter vehicle model: ");
         model = this.myScanner.next();

        System.out.print("Enter vehicle year: ");
         year = this.myScanner.nextInt();

        System.out.print("Enter vehicle color: ");
         color = this.myScanner.next();

        System.out.print("Enter vehicle mileage: ");
         mileage = this.myScanner.nextInt();

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
         vehicleType = this.myScanner.next();

        System.out.print("Enter vehicle price: ");
         price = this.myScanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, make, model, year, color, mileage, vehicleType, price);

        dealership.addVehicle(newVehicle);


        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicle() {
        System.out.print("Enter vehicle ID to remove: ");
        int vehicleId = myScanner.nextInt();
        dealership.removeVehicle(String.valueOf(vehicleId));
    }
}
