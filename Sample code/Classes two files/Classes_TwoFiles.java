//======================================================================
//
// Title: Classes - Two Files
// Description:
//   This program demonstrates a class in one file and a driver
// program in another file.
//
//======================================================================
package wsu.Classes_TwoFiles;

//Import classes
import java.util.Scanner;

//======================================================================
// class CarDemo
//======================================================================
public class Classes_TwoFiles
{

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {

    	// Declare constants
        final String COLFMTS = "%-14s";

        // Declare local variables
        Scanner keyboard = new Scanner(System.in);
    	String l_make;
    	String l_model;
    	int l_MPG;

        // Show application header
        System.out.println("Welcome to my Car Demo");
        System.out.println("----------------------\n");
    
        // Prompt for and read car info
        System.out.print("Enter the make of your car: ");
        l_make = keyboard.next();
        System.out.print("Enter the model of your car: ");
        l_model = keyboard.next();
        System.out.print("Enter the MPG of your car: ");
        l_MPG = keyboard.nextInt();
        
        // Create car 1 object
        Car car1 = new Car (l_make, l_model, l_MPG);
        
        // Reference Car instance variables - can't since private!
//        System.out.println("\nCar 1 object info");
//        System.out.printf(COLFMTS + COLFMTS + "%n", "Make:", car1.make);
//        System.out.printf(COLFMTS + COLFMTS + "%n", "Model:", car1.model);
//        System.out.printf(COLFMTS + COLFMTS + "%n", "MPG:", car1.MPG);
        
        // Print car 1 object info
        System.out.println("\nCar 1 object info");
        System.out.printf(COLFMTS + COLFMTS + "%n", "Make:", car1.getMake());
        System.out.printf(COLFMTS + COLFMTS + "%n", "Model:", car1.getModel());
        System.out.printf(COLFMTS + COLFMTS + "%n", "MPG:", car1.getMPG());
        
        // Create car 2 object
        Car car2 = new Car();
        car2.setMake("Ford");
        car2.setModel("Mustang");
        car2.setMPG(24);
        
        // Print car 2 object info
        System.out.println("\nCar 2 object info");
        System.out.printf(COLFMTS + COLFMTS + "%n", "Make:", car2.getMake());
        System.out.printf(COLFMTS + COLFMTS + "%n", "Model:", car2.getModel());
        System.out.printf(COLFMTS + COLFMTS + "%n", "MPG:", car2.getMPG());
        
        // Compare car 1 and car 2
        if (car1.equals(car2))
            System.out.println("\nThe cars have the same info.");
        else
    	{
            System.out.println("\nThe cars do not have the same info:");
            System.out.println("Car 1\n" + car1.toString());
            System.out.println("Car 2\n" + car2.toString());
    	}
    
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of my Car Demo");

    }

}
