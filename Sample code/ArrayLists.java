//======================================================================
//
// Title: ArrayLists
// Description:
//   This program demonstrates ArrayLists.
//
//======================================================================
package wsu.ArrayLists;

// Import classes
import java.util.ArrayList;
import java.util.Random;

//======================================================================
// class ArrayLists
//======================================================================
public class ArrayLists
{
    
    //------------------------------------------------------------------
    // Fields
    //------------------------------------------------------------------

    // Declare constant fields
    private final static String COLFMTD = "%3d";

	//------------------------------------------------------------------
    // randomizeArrayList
    //------------------------------------------------------------------
    private static void randomizeArrayList(ArrayList<Integer> al, 
		int newElements, int upperLimit)
    {
    	
    	// Loop to generate and store random numbers in ArrayList
    	Random rand = new Random();
        for (int i = 1; i <= newElements; i++)
        	al.add(rand.nextInt(upperLimit) + 1);
        
    }
	
	//------------------------------------------------------------------
    // printArrayList
	//------------------------------------------------------------------
    private static void printArrayList(String heading, 
		ArrayList<Integer> al)
    {
    	
    	// Loop to print ArrayList
    	System.out.print(heading + ": [");
        for (int i = 0; i < al.size(); i++)
        	System.out.printf(COLFMTD, al.get(i));
    	System.out.println("]");

    }
    
	//------------------------------------------------------------------
    // main
	//------------------------------------------------------------------
	@SuppressWarnings("unchecked")  // Needed for method clone
	public static void main(String[] args)
    {

        // Declare variables
		ArrayList<Integer> aList1 = new ArrayList<Integer>();
			// Create ArrayList of initial size 10
		ArrayList<Integer> aList2 = new ArrayList<Integer>(20);  
			// Create ArrayList of initial size 20
		
		// Show application header
		System.out.println("Welcome to ArrayLists");
		System.out.println("---------------------");

		// Print integer ArrayLists before adds
		printArrayList("\nEmpty ArrayList 1", aList1);
		printArrayList("Empty ArrayList 2", aList2);
		System.out.println("The size of ArrayList 1 is " + 
			aList1.size() + ".");

		// Add random values to and print integer ArrayList 1
		randomizeArrayList(aList1, 4, 99);
		printArrayList("\nArrayList 1 after value adds", aList1);
		System.out.println("The size of ArrayList 1 is " +
			aList1.size() + ".");

		// Add random values to and print integer ArrayList 2
		randomizeArrayList(aList2, 6, 99);
		printArrayList("ArrayList 2 after value adds", aList2);

		// Set some values and print integer ArrayList 1
		aList1.set(0,  30);
		aList1.set(3,  60);
		printArrayList("\nArrayList 1 after values changed", aList1);

		// Test if ArrayList 1 contains 30
		if (aList1.contains(30))
			System.out.println("ArrayList 1 contains 30.");
		else
			System.out.println("ArrayList 1 DOES NOT contain 30.");

		// Remove value from ArrayList 1
		aList1.remove(Integer.valueOf(60));
		printArrayList("\nArrayList 1 after value removed", aList1);
		System.out.println("The size of ArrayList 1 is " + 
			aList1.size() + ".");

		// Clear and print integer ArrayList 2
		aList2.clear();
		printArrayList("\nArrayList 2 after cleared", aList2);
		
    	// Clone ArrayList
		aList2 = (ArrayList<Integer>) aList1.clone();
		printArrayList("\nArrayList 1 after cloning", aList1);
		printArrayList("ArrayList 2 after cloning", aList2);
		aList2.set(0, 77);
		printArrayList("ArrayList 1 after element change", aList1);
		printArrayList("ArrayList 2 after element change", aList2);

        // Use for-each loop
    	System.out.println("\nFor-each looping through ArrayList 1");
    	System.out.print("[");
        for (int e : aList1)
        	System.out.printf(COLFMTD, e);
    	System.out.println("]");

		// Show application close
		System.out.println("\nEnd of ArrayLists");

    }

}
