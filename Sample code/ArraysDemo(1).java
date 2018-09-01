//======================================================================
//
// Title: Arrays
// Description:
//   This program demonstrates arrays.
//
//======================================================================
package wsu.Arrays;

// Import classes
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//======================================================================
// class ArraysDemo
//   This class is called ArraysDemo so that there is no 
// conflict with class java.util.Arrays.
//======================================================================
public class ArraysDemo  
{
    
    //------------------------------------------------------------------
    // Fields
    //------------------------------------------------------------------

    // Declare constant fields
    private final static String COLFMTS1 = "%-6s";
    private final static String COLFMTS2 = "%6s";
    private final static String COLFMTD1 = "%-6d";
    private final static String COLFMTD2 = "%6d";
	
	//----------------------------------------------------------------
	// randomizeArray
	//----------------------------------------------------------------
	private static void randomizeArray(String heading, int[] arr,
		int upperLimit)
    {
      
		// Loop to generate and store random numbers in array
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(upperLimit) + 1;
		System.out.println("\nRandomized numbers in the range 1 to " + 
			upperLimit + " stored in array " + heading + " values");
        
    }
  
	//------------------------------------------------------------------
	// printArray
	//------------------------------------------------------------------
	private static void printArray(String heading, int[] arr)
	{

		// Loop to print array numbers
		System.out.println("\n" + heading);
		System.out.println("Array size: " + arr.length);
		System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Index", "Value");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(COLFMTD1 + COLFMTD2 + "%n", i, arr[i]);

  }
    
	//------------------------------------------------------------------
	// copyArray
	//------------------------------------------------------------------
	private static int[] copyArray(int[] source)
	{
      
	    // Loop to generate and store random numbers in array
	    int arraySize = source.length;
	    int[] target = new int[arraySize];
	    for (int i = 0; i < source.length; i++)
	      target[i] = source[i];
	    return target;
        
	}
   
	//------------------------------------------------------------------
	// main
	//------------------------------------------------------------------
	public static void main(String[] args)
	{
	      
		// Declare constants
		final int ARRAY_SIZE = 6;
	
		// Declare variables
		Scanner keyboard = new Scanner(System.in);
		int[] intArray1 = new int[3];  // Use integer for array size
		int[] intArray2 = new int[ARRAY_SIZE];  // Use constant for array size
		int[] intArray3 = new int[ARRAY_SIZE * 2];  // Use expression for array size
		int[] intArray4; 
		int[] intArray5;
		int[] intArray6 = { 100, 200, 300 };
		int arraySize;
		int values;
		int valuesIndex = 0;
		
		// Show application header
		System.out.println("Welcome to Arrays");
		System.out.println("-----------------");
		
		// Prompt for and get array size
		System.out.print("\nEnter an Array 4 size between 1 and 5: ");
		arraySize = keyboard.nextInt();
		while (arraySize < 1 || arraySize > 5)
		{
			System.out.println("Error: array size must be between 1 and 5.");
			System.out.print("Enter an array size between 1 and 5: ");
			arraySize = keyboard.nextInt();
		}
		  
		// Create array from user input
		intArray4 = new int[arraySize]; 
		
		// Place random numbers in each array
		randomizeArray("intArray1", intArray1, 10);
		randomizeArray("intArray2", intArray2, 20);
		randomizeArray("intArray3", intArray3, 30);
		randomizeArray("intArray4", intArray4, 40);
		
		// Print numbers in each array
		printArray("Array 1 values", intArray1);
		printArray("Array 2 values", intArray2);
		printArray("Array 3 values", intArray3);
		printArray("Array 4 values", intArray4);
		
		// Resize array but lose contents
		intArray4 = new int[arraySize * 2]; 
		printArray("Array 4 values after being recreated with size " +
			"doubled but before randomized numbers stored " +
			"(original contents NOT saved)", intArray4);
		randomizeArray("intArray4", intArray4, 30);
		printArray("Array 4 values after randomized numbers stored", 
			intArray4);
		
		// Resize array but preserve contents
		intArray4 = Arrays.copyOf(intArray4, arraySize * 4);
		printArray("Array 4 values after copyOf with size doubled " +
			"(original contents saved)", intArray4);
		
		// Sort array
		Arrays.sort(intArray4);
		printArray("Array 4 values sorted", intArray4);
		
		// Initialize array to single value
		Arrays.fill(intArray1, 77);
		System.out.println("\nArray 1 filled with same value");
		System.out.printf(COLFMTS2 + "%n", "Value");
		for (int e: intArray1)
			System.out.printf(COLFMTD2 + "%n", e);
		
		// Copy array using custom method
		intArray5 = new int[3];
		intArray5 = copyArray(intArray1);
		printArray("Array 4 values (copied from Array 1)", intArray5);
		
		// Attempt to reference past end of array
		try
		{
			
			// Prompt for and get number of values to print in Array 1
			System.out.println("\nIndex out-of-bounds test.");
			System.out.print("Enter the number of values to print " +
				"in Array 1 (<= " + intArray1.length + "): ");
			values = keyboard.nextInt();
		
			// Loop to print Array 1 values
			for (valuesIndex = 0; valuesIndex < values; valuesIndex++)
				System.out.println(intArray1[valuesIndex]);
			System.out.println();
		
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Error: index value '" + valuesIndex +
				"' for array 1 is out of bounds.");
		}
		
		// Close keyboard
		keyboard.close();
		
		// Show application close
		System.out.println("\nEnd of Arrays");
	
  }

}
