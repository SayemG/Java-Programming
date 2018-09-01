//======================================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//======================================================================
package wsu.StackUsingLinkedList;

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
	private Car next;
    
    //==================================================================
    // Constructors
    //==================================================================
	
	public Car()
	{
        System.out.println("\nThis is the Car with no values constructor.");
        make = "(not set)";
        model = "(not set)";
	}
	
	public Car(String make, String model, Car next)
	{
        System.out.println("\nThis is the Car with values constructor.");
        this.make = make;
        this.model = model;
        this.next = next;
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

	public Car getNext()
	{
		return next;
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

	public void setNext(Car next)
	{
		this.next = next;
	}
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

	public boolean equals(Car b)
	{
		if (this.make.equalsIgnoreCase(b.make) && 
			this.model.equalsIgnoreCase(b.model))
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "Make: " + make + "\nModel: " + model;        
	}
    
} 
