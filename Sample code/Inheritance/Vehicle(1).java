//======================================================================
//
// Class: Vehicle
// Description:
//   This class represents a vehicle.
//
//======================================================================
package wsu.Inheritance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//======================================================================
// class Vehicle
//======================================================================
public class Vehicle
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
    public final String COLFMTS1 = "%-18s";
    public final String COLFMTS2 = "%-30s";
    public final String COLFMTS3 = "%-14s";
    public final String COLFMTS4 = "%14s";
    public final String COLFMTS5 = "%-50s";
    public final String COLFMTS6 = "%-24s";
	
	// Declare variables
    private String make;
    private String model;
    private int wheels;
    public String hidden = "hiddenInVehicle";
    public static String hiddenStatic = "hiddenStaticInVehicle";

    //==================================================================
    // Constructors
    //==================================================================
    
    public Vehicle()
    {
        System.out.println("\nThis is the Vehicle with no values constructor.");
        make = "(not set)";
        model = "(not set)";
        wheels = 0;
    }
    
    public Vehicle(String make, String model, int wheels)
    {
        System.out.println("\nThis is the Vehicle with values constructor.");
        this.make = make;
        this.model = model;
        this.wheels = wheels;
    }
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

    public String getMake() 
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getWheels()
    {
        return wheels;
    }
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

    public void setMake(String make) 
    {
        this.make = make;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setWheels(int wheels)
    {
        if (wheels < 2)
            System.out.println("Error: you can't ride on the frame.");
        else
            this.wheels = wheels;
    }
    
    //------------------------------------------------------------------
    // printObjectInfo method
    //------------------------------------------------------------------
    public void printObjectInfo (String name)
    {

        // Show class info
        System.out.println("\nObject '" + name + "' info");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Class:", this.getClass().getName());
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Parent class:", this.getClass().getSuperclass().getName());

        // List declared fields
        Field[] fields = this.getClass().getDeclaredFields();
        System.out.printf(COLFMTS1 + "%n", "Declared fields:");
        for (Field f : fields)
            System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "", 
    		f.getName());

        // List declared methods
        Method[] methods = this.getClass().getDeclaredMethods();
        System.out.printf(COLFMTS1 + "%n", "Declared methods:");
        for (Method m : methods)
            System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "",
    		m.getName());

    }
    
    //------------------------------------------------------------------
    // printVehicle method
    //------------------------------------------------------------------
    public void printVehicle(String name)
    {
        System.out.println("\nVehicle '" + name + "' info");
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Make:", getMake());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Model:", getModel());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Wheels:", getWheels());
    }
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

    public boolean equals (Vehicle b)
    {
        if (this.make.equalsIgnoreCase(b.make) && 
            this.model.equalsIgnoreCase(b.model) &&
            this.wheels == b.wheels)
            return true;
        else
            return false;
    }

    public String toString ()
    {
        return "Make: " + make + 
        		"\nModel: " + model + 
        		"\nWheels: " + wheels;        
    }
    
} 
