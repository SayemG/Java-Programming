//======================================================================
//
//  Class: Triangle
//  Description:
//  	This class represents a equilateral triangle with a side length 
// in centimeters.
//
//======================================================================
package wsu.Polymorphism;

//======================================================================
// class Triangle
//======================================================================
public class Triangle extends Shape
{
    
    //==================================================================
    // Fields
    //==================================================================
	private int sideLength;
    
    //==================================================================
    // Constructors
    //==================================================================
	
	public Triangle(int sideLength)
	{
        this.sideLength = sideLength;
	}
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // calculateArea
    //------------------------------------------------------------------
	public double calculateArea()
	{
		return 0.5 * sideLength * sideLength;
	}
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

	public int getSideLength()
	{
		return sideLength;
	}
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

	public void setSideLength(int sideLength)
	{
		this.sideLength = sideLength;
	}
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

	// This method definition overrides the same method definition in
	// class Shape   
	public boolean equals (Triangle b)
	{
		if (this.sideLength == b.sideLength)
			return true;
		else
			return false;
	}

	// This method definition overrides the same method definition in
	// class Shape   
	public String toString ()
	{
		return "Triangle with side length of " + sideLength + " cm";        
	}
    
} 
