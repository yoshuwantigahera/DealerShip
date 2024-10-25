package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface extends Dealership {

    private Scanner myScanner = new Scanner(System.in);

    public void ShowMenu(){

        System.out.println("1. Find vehicle with price range" + "\n" +
                "2. Find Vehicle by make/model" + "\n" +
                "3. Find vehicles by year range" + "\n" + "4. Find vehicles by color" + "\n" +
                "5 - Find vehicles by mileage range" + "\n" +
                "6 - Find vehicles by type(car, truck, Suv, van" + "\n" +
                "7 - List ALL vehicles" + "\n" +
                "8 - Add vehicle" + "\n" +
                "9 - Remove a vehicle" +"\n" +
                "99 - Quit");
        int userinput = myScanner.nextInt();
    }

    public void ProcessUserAnswer(){
        while(true){
            ShowMenu();
            int userInput = myScanner.nextInt();
            myScanner.nextLine();
            switch (userInput) {
                case 1:
                    // Call method to find vehicle by price range
                    break;
                case 2:
                    // Call method to find vehicle by make/model
                    break;
                case 3:
                    // Call method to find vehicles by year range
                    break;
                case 4:
                    // Call method to find vehicles by color
                    break;
                case 5:
                    // Call method to find vehicles by mileage range
                    break;
                case 6:
                    // Call method to find vehicles by type
                    break;
                case 7:
                    // Call method to list all vehicles
                    break;
                case 8:
                    // Call method to add a vehicle
                    break;
                case 9:
                    // Call method to remove a vehicle
                    break;
                case 99:
                    System.out.println("Exiting...");
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}
