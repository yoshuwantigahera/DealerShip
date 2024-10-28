package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class DealerShipFileManager {
    private String filename;


    public DealerShipFileManager(String filename) {
        this.filename = filename;

    }


    //method to load vehicles from CSV file
    public Dealership getDealership() {
        Dealership dealership = null;
        try (Scanner myScanner = new Scanner(new File(filename))) {
            if (myScanner.hasNextLine()) {
                String[] dealershipInfo = myScanner.nextLine().split("\\|");
                dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);


                while (myScanner.hasNextLine()) {
                    String line = myScanner.nextLine();
                    String[] vehicleInfo = line.split("\\|");
                    String vin = vehicleInfo[0];
                    int year = Integer.parseInt(vehicleInfo[1]);
                    String make = vehicleInfo[2];
                    String model = vehicleInfo[3];
                    String type = vehicleInfo[4];
                    String color = vehicleInfo[5];
                    int mileage = Integer.parseInt(vehicleInfo[6]);
                    double price = Double.parseDouble(vehicleInfo[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
                    dealership.addVehicle(vehicle);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Inventory file not.");
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number format in inventory file.");
            e.printStackTrace();
        }
        return dealership;
    }
}



