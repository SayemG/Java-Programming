//======================================================================
//
// Title: Object Class
// Description:
//   This program demonstrates the Object class.
//
//======================================================================
package wsu.ObjectClass;

//======================================================================
// class ObjectClass
//======================================================================
public class ObjectClass
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Show application header
        System.out.println("Welcome to Object Class");
        System.out.println("-----------------------");
        
        // Create car objects
        Car car1 = new Car ("Ford", "Mustang", 14);
        Car car2 = new Car ("Pontiac", "Grand Prix", 18);
//        car2 = car1;
        Car temp;

        // Compare two objects
    	System.out.println("\nequals method");
        if (car1.equals(car2))  // Same as car1 == car2
        	System.out.println("Objects car1 and car2 are equal " +
    			"(have the same memory address).");
        else
        	System.out.println("Objects car1 and car2 are NOT equal " +
    			"(do NOT have the same memory address).");

        // Show hash codes 
    	System.out.println("\nhashCode method before setting car1 to car2");
    	System.out.println("Hash code for car1: " + car1.hashCode());
    	System.out.println("Hash code for car2: " + car2.hashCode());
    	temp = car1;
    	car1 = car2;
    	System.out.println("\nhashCode method after setting car1 to car2");
    	System.out.println("Hash code for car1: " + car1.hashCode());
    	System.out.println("Hash code for car2: " + car2.hashCode());

        // Show toStrings
    	car1 = temp;
    	System.out.println("\ntoString method");
    	System.out.println("toString for car1: " + car1.toString());
    	System.out.println("toString for car2: " + car2.toString());

        // Show class names
    	System.out.println("\ngetClass method");
    	System.out.println("toString for car1: " + 
			car1.getClass().getCanonicalName());
    	System.out.println("toString for car2: " + 
			car2.getClass().getCanonicalName());

        // Clone object
    	String colFmtS = "%-10s";
    	String colFmtD = "%10d";
    	System.out.println("\nBefore clone of car1 to car2");
    	System.out.printf(colFmtS + colFmtS + colFmtS + colFmtD + 
			"%n", "car1", car1.getMake(), car1.getModel(), 
			car1.getMPG());
    	System.out.printf(colFmtS + colFmtS + colFmtS + colFmtD + 
			"%n", "car2", car2.getMake(), car2.getModel(), 
			car2.getMPG());
    	try
		{
			car2 = (Car) car1.clone();
		}
    	catch (CloneNotSupportedException e)
		{
            System.out.println("Error: cannot clone object.");
            System.out.println("Exception message:\n" + e.getMessage());
		}
    	System.out.println("\nAfter clone of car1 to car2");
    	System.out.printf(colFmtS + colFmtS + colFmtS + colFmtD + 
			"%n", "car1", car1.getMake(), car1.getModel(), 
			car1.getMPG());
    	System.out.printf(colFmtS + colFmtS + colFmtS + colFmtD + 
			"%n", "car2", car2.getMake(), car2.getModel(), 
			car2.getMPG());

        // Compare two objects
    	System.out.println("\nequals method");
        if (car1.equals(car2))  // Same as car1 == car2
        	System.out.println("Objects car1 and car2 are equal " +
    			"(have the same memory address).");
        else
        	System.out.println("Objects car1 and car2 are NOT equal " +
    			"(do NOT have the same memory address).");
 
        // Show application close
        System.out.println("\nEnd of Object Class");

    } 

} 
