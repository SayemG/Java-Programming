//======================================================================
//
// Class: Autonomous Car
// Description:
//   This class represents an autonomous car.
//
//======================================================================
package wsu.Inheritance;

//======================================================================
// class AutonomousCar
//======================================================================
public class AutonomousCar extends Car
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare variables
    private boolean hasDSRC;  // Dedicated short-range communication 
    
    //==================================================================
    // Constructors
    //==================================================================

	public AutonomousCar()
    {
        System.out.println("\nThis is the Autonomous Car with no " +
    		"values constructor.");
        hasDSRC = false;
    }
    
    public AutonomousCar(String make, String model, int wheels, 
		int MPG, boolean hasDSRC)
    {
        super(make, model, wheels, MPG);
        System.out.println("\nThis is the Autonomous Car with " +
    		"values constructor.");
        this.hasDSRC = hasDSRC;
    }
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------
    
    public boolean getHasDSRC()
	{
		return hasDSRC;
	}
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

	public void setHasDSRC(boolean hasDSRC)
	{
		this.hasDSRC = hasDSRC;
	}
    
    //------------------------------------------------------------------
    // printAutonomousCar method
    //------------------------------------------------------------------
    public void printAutonomousCar(String name)
    {
        System.out.println("\nAutonomous Car '" + name + "' info");
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Make:", getMake());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Model:", getModel());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Wheels:", getWheels());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"MPG:", getMPG());
        System.out.printf(COLFMTS3 + COLFMTS4 + "%n", 
    		"Has DSRC?", getHasDSRC());
    }
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

    // This method definition overrides the same method definition in
    // class Car   
    public boolean equals(AutonomousCar b)
    {
        if (super.equals(b) && this.hasDSRC == b.hasDSRC)
            return true;
        else
            return false;
    }

    // This method definition overrides the same method definition in
    // class Car   
    public String toString()
    {
        return super.toString() + "\nHas DSRC? " + hasDSRC;        
    }
    
} 
