package com.pluralsight;

import java.io.*;

public class DealerShipFileManager extends Dealership {

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
                        details[0],
                        Integer.parseInt(details[1]), //convert string to integer
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
        File file = new File("inventory.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            for(Vehicle vehicle: inventory){
                bw.write(vehicle.toString());
                bw.newLine();
            }
        } catch (IOException e){
            System.out.println("Error writing file: " + e.getMessage());
        }      }


}
