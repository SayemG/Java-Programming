//======================================================================
//
// Title: Polymorphism
// Description:
//   This program demonstrates polymorphism with parent class 
// Shape and child classes Circle, Triangle, and Square.  
// Methods calculateArea() and toString exist in each class.
//
//======================================================================
package wsu.Polymorphism;

//======================================================================
// class ShapeDemo
//======================================================================
public class Polymorphism
{

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
        
        // Declare constants
        final int ARRAY_SIZE = 8;
        final String COLFMTS1 = "%-36s";
        final String COLFMTS2 = "%18s";
        final String COLFMTF = "%18.2f";

        // Declare variables
        Shape[] shapes = new Shape[ARRAY_SIZE];
        
        // Show application header
        System.out.println("Welcome to Polymorphism");
        System.out.println("-----------------------\n");
        
        // Create shape
        Shape s1 = new Shape();
        
        // Create circles
        Circle c1 = new Circle (4);
        Circle c2 = new Circle (7);
        Circle c3 = new Circle (2);
        
        // Create triangles
        Triangle t1 = new Triangle (11);
        Triangle t2 = new Triangle (14);
        
        // Create squares
        Square q1 = new Square (4);
        Square q2 = new Square (9);

        // Store circles and triangles in shapes array
        shapes[0] = s1; 
        shapes[1] = c1; 
        shapes[2] = c2; 
        shapes[3] = c3; 
        shapes[4] = t1; 
        shapes[5] = t2; 
        shapes[6] = q1; 
        shapes[7] = q2; 
        
        // Print shape information
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Shape " + 
    		"information", "Shape area (sq cm)");
        for (int i = 0; i < shapes.length; i++)
            System.out.printf(COLFMTS1 + COLFMTF + "%n", 
        		shapes[i].toString(), shapes[i].calculateArea());
        System.out.println("\nWith one call to methods toString " +
    		"and calculateArea,\nmultiple versions of each method " +
    		"are run.");

        // Show application close
        System.out.println("\nEnd of Polymorphism");

    }

}
