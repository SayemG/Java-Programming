//==============================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//==============================================================
package wsu.HeapWatch;

//==============================================================
// class Car
//==============================================================
public class Car
{
    
    //================================================================
    // Fields
    //================================================================
	private String make;
	private String model;
	private int MPG;
	private double rating;
    
    //================================================================
    // Constructors
    //================================================================
	
	public Car()
	{
        make = "(not set)";
        model = "(not set)";
        MPG = -10;
        rating = -1.23;
	}
	
	public Car(String make, String model, int MPG, double rating)
	{
        this.make = make;
        this.model = model;
        this.MPG = MPG;
        this.rating = rating;
	}
    
    //================================================================
    // Methods
    //================================================================
    
    //----------------------------------------------------------------
    // get methods
    //----------------------------------------------------------------

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
    
    //----------------------------------------------------------------
    // set methods
    //----------------------------------------------------------------

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
    
    //----------------------------------------------------------------
    // equals and toString methods
    //----------------------------------------------------------------

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
		return "Make: " + make + "\nModel: " + model + "\nMPG: " + MPG;        
	}
    
} 
