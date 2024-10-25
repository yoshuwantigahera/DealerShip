package com.pluralsight;

import java.io.*;
//import java.lang.classfile.CodeBuilder;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    String name;
    String address;
    String phone;

    ArrayList<Vehicle>inventory;

     public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    public Dealership(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) {
         ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
         for (Vehicle vehicle : inventory) {
             if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                 filteredVehicles.add(vehicle);
             }
         } return filteredVehicles;
     }



    public ArrayList<Vehicle> searchByMileage(double minMileage, double maxmileage){
         ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
         for (Vehicle vehicle : inventory){
             if (vehicle.getMileage() >= minMileage && vehicle.getMileage() <= maxmileage);
             filteredVehicles.add(vehicle);
         }
            return filteredVehicles;
    }

    ArrayList<Vehicle> searchByYear(int minYear, int maxMin){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= vehicle.getYear()){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public void addVehicle(Vehicle vehicle){
            inventory.add(vehicle);
    }


    public void VehiclesByColor() {
        Scanner myscanner = new Scanner(System.in);

        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        System.out.print("Enter color: ");
        String color = myscanner.next();
        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehicles.add(vehicle);
            }
        }

    }


    public void searchByMakeModel(){

    }

//    ArrayList<Vehicle>searchBytype(){
//
//    }


    public boolean removeVehicle(String vin){
        return inventory.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }


    public void getAllVehicle(){
        for (Vehicle vehicle : inventory){
            System.out.println(vehicle);
        }
    }





}

