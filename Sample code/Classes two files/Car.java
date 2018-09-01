//======================================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//======================================================================
package wsu.Classes_TwoFiles;

//======================================================================
// class Car
//======================================================================
public class Car
{
    
    //==================================================================
    // Fields
    //==================================================================
	private String make;
	private String model;
	private int MPG;
    
    //==================================================================
    // Constructors
    //==================================================================
	
	public Car()
	{
        System.out.println("\nThis is the Car with no values constructor.");
        make = "(not set)";
        model = "(not set)";
        MPG = -10;
	}
	
	public Car(String make, String model, int MPG)
	{
        System.out.println("\nThis is the Car with values constructor.");
        this.make = make;
        this.model = model;
        this.MPG = MPG;
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

	public int getMPG()
	{
		return MPG;
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

	public void setMPG(int MPG)
	{
		this.MPG = MPG;
	}
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

	public boolean equals(Car b)
	{
		if (this.make.equalsIgnoreCase(b.make) && 
			this.model.equalsIgnoreCase(b.model) &&
			this.MPG == b.MPG)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "Make: " + make + 
				"\nModel: " + model + 
				"\nMPG: " + MPG;        
	}
    
} 
