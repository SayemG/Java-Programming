//======================================================================
//
// Class: Car
// Description:
//   This class represents a car and implements interface Ordered.
//
//======================================================================
package wsu.InterfaceType;

//======================================================================
// class Car
//======================================================================
public class Car implements Ordered
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
        System.out.println("This is the no-parameter constructor.");
        make = "(not set)";
        model = "(not set)";
        MPG = -10;
	}
	
	public Car(String make, String model, int MPG)
	{
        System.out.println("This is the three-parameter constructor.");
        this.make = make;
        this.model = model;
        this.MPG = MPG;
	}
    
    //==================================================================
    // Methods
    //==================================================================

	//------------------------------------------------------------------
    // precedes
    //------------------------------------------------------------------
	@Override
	public boolean precedes(Object b)
	{
		Car car2 = (Car) b;
		if (this.getMake().compareToIgnoreCase(car2.getMake()) < 0 ||
		   (this.getMake().compareToIgnoreCase(car2.getMake()) == 0 &&
			this.getModel().compareToIgnoreCase(car2.getModel()) < 0))
			return true;
		else
			return false;
	}

	//------------------------------------------------------------------
    // follows
    //------------------------------------------------------------------
	@Override
	public boolean follows(Object b)
	{
		Car car2 = (Car) b;
		if (this.getMake().compareToIgnoreCase(car2.getMake()) > 0 ||
		   (this.getMake().compareToIgnoreCase(car2.getMake()) == 0 &&
			this.getModel().compareToIgnoreCase(car2.getModel()) > 0))
			return true;
		else
			return false;
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

	public String toString ()
	{
		return make + "-" + model + "-" + MPG;        
	}
    
} 
