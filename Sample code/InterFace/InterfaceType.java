//======================================================================
//
//  Title: Interface Type
//  Description:
//  	This program demonstrates an interface.
//
//======================================================================
package wsu.InterfaceType;

//======================================================================
// class InterfaceType
//======================================================================
public class InterfaceType
{

	//------------------------------------------------------------------
    // compareUsingPrecedes
    //------------------------------------------------------------------
	public static Ordered compareUsingPrecedes(Ordered o1, Ordered o2)
	{
		if (o1.precedes(o2))
			return o1;
		else
			return o2;
	}

	//------------------------------------------------------------------
    // compareUsingFollows
    //------------------------------------------------------------------
	public static boolean compareUsingFollows(Ordered o1, Ordered o2)
	{
        return o1.follows(o2);
	}

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    	
    	// Declare variables
    	Car cPrecedes;
    	
        // Show application header
        System.out.println("Welcome to Interface Type");
        System.out.println("-------------------------\n");
        
        // Create cars
        Car c1 = new Car("Ford", "Escape", 26);
        Car c2 = new Car("Volkswagen", "Beetle", 25);
        Car c3 = new Car("Ford", "Fusion", 29);
        
        // Print car information
        System.out.println("\nc1: " + c1.toString());
        System.out.println("c2: " + c2.toString());
        System.out.println("c3: " + c3.toString());
        
        // Print "precedes" information
        String colFmt = "%-10s";
        System.out.println();
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"Precedes", "c1", "c2", "c3");
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c1", c1.precedes(c1), c1.precedes(c2), c1.precedes(c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c2", c2.precedes(c1), c2.precedes(c2), c2.precedes(c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c3", c3.precedes(c1), c3.precedes(c2), c3.precedes(c3));
        
        // Print "follows" information
        System.out.println("\nFollows using object call");
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"Follows", "c1", "c2", "c3");
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c1", c1.follows(c1), c1.follows(c2), c1.follows(c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c2", c2.follows(c1), c2.follows(c2), c2.follows(c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c3", c3.follows(c1), c3.follows(c2), c3.follows(c3));
        
        // Compare objects using interface method parameter
        System.out.println("\nFollows using interface parameters");
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"Follows", "c1", "c2", "c3");
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c1", 
    		compareUsingFollows(c1, c1), 
    		compareUsingFollows(c1, c2), 
    		compareUsingFollows(c1, c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c2", 
    		compareUsingFollows(c2, c1), 
    		compareUsingFollows(c2, c2), 
    		compareUsingFollows(c2, c3));
        System.out.printf(colFmt + colFmt + colFmt + colFmt + "%n", 
    		"c3", 
    		compareUsingFollows(c3, c1), 
    		compareUsingFollows(c3, c2), 
    		compareUsingFollows(c3, c3));
        
        // Show "precedes" object
        cPrecedes = (Car) compareUsingPrecedes(c1, c2);
        System.out.println("\nPreceding object of " + c1.toString() + 
    		" and " + c2.toString() + " is " + cPrecedes.toString() + 
    		".");
        
        // Show application close
        System.out.println("\nEnd of Interface Type");

    }

}
