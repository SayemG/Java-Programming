//======================================================================
//
//  Class: Circle
//  Description:
//      This class represents a circle with a radius in centimeters.
//
//======================================================================
package wsu.Polymorphism;

//======================================================================
// class Circle
//======================================================================
public class Circle extends Shape
{
    
    //==================================================================
    // Fields
    //==================================================================
    private int radius;
    
    //==================================================================
    // Constructors
    //==================================================================
    
    public Circle(int radius)
    {
        this.radius = radius;
    }
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // calculateArea
    //------------------------------------------------------------------
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

    public int getRadius()
    {
        return radius;
    }
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

    // This method definition overrides the same method definition in
    // class Shape   
    public boolean equals (Circle b)
    {
        if (this.radius == b.radius)
            return true;
        else
            return false;
    }

    // This method definition overrides the same method definition in
    // class Shape   
    public String toString ()
    {
        return "Circle with radius of " + radius + " cm";        
    }
    
} 
