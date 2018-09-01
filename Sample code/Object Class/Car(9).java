//======================================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//======================================================================
package wsu.ObjectClass;

//======================================================================
// class Car
//======================================================================
public class Car implements Cloneable
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
        make = "(not set)";
        model = "(not set)";
        MPG = -10;
        System.out.println("Car object created using " +
    		"no-parameter constructor.");
	}
	
	public Car(String make, String model, int MPG)
	{
        this.make = make;
        this.model = model;
        this.MPG = MPG;
        System.out.println("Car object created using " +
    		"three-parameter constructor.");
	}
    
    //==================================================================
    // Methods
    //==================================================================

	//------------------------------------------------------------------
	// clone
	//------------------------------------------------------------------
	public Car clone() throws CloneNotSupportedException
	{
		return (Car) super.clone();  
	}  

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
    
} 
