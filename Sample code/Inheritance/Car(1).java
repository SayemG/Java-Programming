//======================================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//======================================================================
package wsu.Inheritance;

//======================================================================
// class Car
//======================================================================
public class Car extends Vehicle
{
    
    //==================================================================
    // Fields
    //==================================================================

	// Declare variables
    private int MPG;
    private String hidden = "hiddenInCar";
    private static String hiddenStatic = "hiddenStaticInCar";
    
    //==================================================================
    // Constructors
    //==================================================================
    
    public Car()
    {
        System.out.println("\nThis is the Car with no values constructor.");
        MPG = -10;
    }
    
    public Car(String make, String model, int wheels, int MPG)
    {
        super(make, model, wheels);
        System.out.println("\nThis is the Car with values constructor.");
        this.MPG = MPG;
    }
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

    public int getMPG()
    {
        return MPG;
    }
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

    public void setMPG(int MPG)
    {
        this.MPG = MPG;
    }
    
    //------------------------------------------------------------------
    // printCar method
    //------------------------------------------------------------------
    public void printCar(String name)
    {
        System.out.println("\nCar '" + name + "' info");
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Make:", getMake());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Model:", getModel());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Wheels:", getWheels());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"MPG:", getMPG());
    }
    
    //------------------------------------------------------------------
    // printHiddens method
    //------------------------------------------------------------------
    public void printHiddens()
    {
        System.out.println("\nHidden fields");
        System.out.printf(COLFMTS5 + COLFMTS6 + "%n", 
          "Instance variable 'hidden' in Car:", 
          hidden);
        System.out.printf(COLFMTS5 + COLFMTS6 + "%n",
          "Static variable 'hiddenStatic' in Car:", 
          hiddenStatic);
//        System.out.printf(COLFMTS5 + COLFMTS6 + "%n", 
//	        "Instance variable 'hidden' in Vehicle:", 
//	        hidden);  // Can't, it's overridden
        System.out.printf(COLFMTS5 + COLFMTS6 + "%n", 
          "Static variable 'hiddenStatic' in Vehicle:", 
          Vehicle.hiddenStatic);
    }
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

    // This method definition overrides the same method definition in
    // class Vehicle   
    public boolean equals(Car b)
    {
        if (super.equals(b) && this.MPG == b.MPG)
            return true;
        else
            return false;
    }

    // This method definition overrides the same method definition in
    // class Vehicle   
    public String toString()
    {
        return super.toString() + "\nMPG: " + MPG;        
    }
    
} 
