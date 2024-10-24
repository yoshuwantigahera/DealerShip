package com.pluralsight;

import java.io.*;
//import java.lang.classfile.CodeBuilder;
import java.util.ArrayList;

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

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
         ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
         for (Vehicle vehicle : inventory) {
             if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                 filteredVehicles.add(vehicle);
             }
         } return filteredVehicles; }

    public void addVehicle(){

    }

    public void getAllVehicle(){
        for (Vehicle vehicle : inventory){
            System.out.println(vehicle);
        }
    }

    public void searchByMileage(){

    }

    public void searchByColor(){

    }

    public void searchByYear(){

    }

    public void searchByMakeModel(){

    }

    public void searchBytype(){

    }

    public void searchByPriceRange(int min, int max){

    }

    public void removeVehicle(){

    }


    //method to load vehicles from CSV file
    public void inventory(String filePath){
         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
             String line;
             while((line = br.readLine()) != null){
                 String[] details = line.split("\\|");
                 if(details.length < 8){
                     System.out.println("Invalid line: " + line);
                     continue;
                 }
                 Vehicle vehicle = new Vehicle(
                         Integer.parseInt(details[0]),
                         Integer.parseInt(details[1]),
                         details[2],
                         details[3],
                         details[4],
                         details[5],
                         Integer.parseInt(details[6]),
                         Double.parseDouble(details[7])
                 );
                 inventory.add(vehicle);
             }
         }catch (IOException e){
             System.out.println("Error reading file " + e.getMessage());
         }
    }

    //Method to save vehicles to a CSV file
    public void saveInventory(String filePath){
         try (BufferedWriter bw = new BufferedWriter(new FileWriter (filePath))){
             for(Vehicle vehicle: inventory){
             bw.write(vehicle.toString());
             bw.newLine();
            }
         } catch (IOException e){
                 System.out.println("Error writing file: " + e.getMessage());
    }      }





}

