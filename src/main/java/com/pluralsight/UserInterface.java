package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface extends Dealership {
    public void VehiclesByColor() {
        Scanner myscanner = new Scanner(System.in);

        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        System.out.print("Enter color: ");
        String color = myscanner.next();
        for (Vehicle vehicle : inventory){
            if (color.equalsIgnoreCase(color)){
                Vehicle Vehicle = null;
                filteredVehicles.add(vehicle);
            }
        }
    }









}
