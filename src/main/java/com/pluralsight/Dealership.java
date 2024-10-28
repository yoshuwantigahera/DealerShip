package com.pluralsight;

//import java.lang.classfile.CodeBuilder;
import java.util.ArrayList;
import java.util.List;
        import java.util.stream.Collectors;


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


    public List<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }



    public List<Vehicle> getVehiclesByMileageRange(double minMileage, double maxmileage){
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minMileage && vehicle.getPrice() <= maxmileage)
                .collect(Collectors.toList());
    }

    public List<Vehicle> searchByYear(int minYear, int maxMin){
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minYear && vehicle.getPrice() <= maxMin)
                .collect(Collectors.toList());
    }


    public void addVehicle(Vehicle vehicle){
            inventory.add(vehicle);
    }


    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByType(String type){
         return inventory.stream()
                 .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(type))
                 .collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }


    public boolean removeVehicle(String vin){
        return inventory.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }

    public List<Vehicle> getAllVehicle(){
        for (Vehicle vehicle : inventory){
            System.out.println(vehicle);
        }
        return null;
    }



}

