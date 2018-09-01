//======================================================================
//
//  Class: Square
//  Description:
//  	This class represents a equilateral triangle with a side length 
// in centimeters.
//
//======================================================================
package wsu.Polymorphism;

//======================================================================
// class Square
//======================================================================
public class Square extends Shape
{
    
    //==================================================================
    // Fields
    //==================================================================
	private int sideLength;
    
    //==================================================================
    // Constructors
    //==================================================================
	
	public Square(int sideLength)
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
		return sideLength * sideLength;
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
	public boolean equals (Square b)
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
		return "Square with side length of " + sideLength + " cm";        
	}
    
} 
