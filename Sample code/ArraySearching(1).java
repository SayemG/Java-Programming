//======================================================================
//
// Title: Array Searching
// Description:
//   This program demonstrates linear and binary searching for integers 
// in an array.
//
//======================================================================
package wsu.ArraySearching;

// Import classes
import java.util.Arrays;
import java.util.Random;

//======================================================================
// class ArraySearching
//======================================================================
public class ArraySearching
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final String COLFMTD1 = "%-,6d";
	private static final String COLFMTD2 = "%,6d";
	private static final String COLFMTD3 = "%,1d";
	private static final String COLFMTD4 = "%,16d";
	private static final String COLFMTF = "%,16.2f";
	private static final String COLFMTS1 = "%-6s";
	private static final String COLFMTS2 = "%6s";
	private static final String COLFMTS3 = "%-14s";
	private static final String COLFMTS4 = "%16s";

	//------------------------------------------------------------------
    // linearSearchArray
    //------------------------------------------------------------------
    private static int linearSearchArray(int[] arr, int value)
    {
    	
    	// Loop to find value
    	int compares = 0;
    	while (compares < arr.length && arr[compares] != value)
    		compares = compares + 1;
    	
    	// Return cycles
    	return compares;
        
    }

	//------------------------------------------------------------------
    // binarySearchArray
    //------------------------------------------------------------------
    private static int binarySearchArray(int[] arr, int value)
    {
    	
    	// Declare variables
    	int compares = 0;
        int low;
        int high;
        int mid;
    	
    	// Loop to find value
        low = 0;
        high = arr.length - 1;
        while (low <= high) 
        {
           mid = (low + high) / 2;
           if (arr[mid] == value)
        	   low = high + 1;
           else if (arr[mid] < value)
        	   low = mid + 1;
           else 
        	   high = mid - 1;
           compares = compares + 1;
        }
    	
    	// Return cycles
    	return compares;
    	
    }

	//------------------------------------------------------------------
    // randomizeArray
    //------------------------------------------------------------------
    private static void randomizeArray(int[] arr, int upperLimit)
    {
    	
    	// Loop to generate and store random numbers in array
    	Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        	arr[i] = rand.nextInt(upperLimit) + 1;
        
    }
	
	//------------------------------------------------------------------
    // printArray
    //------------------------------------------------------------------
    private static void printArray(String heading, int[] arr)
    {
    	
    	// Loop to print array numbers
    	System.out.println("\n" + heading + " values");
    	System.out.println("Array size: " + arr.length);
    	System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Index", "Value");
        for (int i = 0; i < arr.length; i++)
        	System.out.printf(COLFMTD1 + COLFMTD2 + "%n", i, arr[i]);

    }
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {
    	
    	// Declare constants
    	final int ARRAY_SIZE = 10;  // 1 million takes ~2 minutes
    	final int ARRAY_PRINT_MAX = 50;

        // Declare variables
        int[] unsortedArray = new int[ARRAY_SIZE];
        int[] sortedArray = new int[ARRAY_SIZE];
        long totalCompares;
        long before;
        long after;

		// Show application header
		System.out.println("Welcome to Array Searching");
		System.out.println("--------------------------");
        
        // Place random numbers in array and print
        randomizeArray(unsortedArray, ARRAY_SIZE * 100);
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Unsorted array", unsortedArray);

        // Sort array
        sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Arrays.sort(sortedArray);
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Sorted array", sortedArray);

        // Print headings
		System.out.println();
		System.out.println("Array size: " + 
			String.format(COLFMTD3, ARRAY_SIZE));
    	System.out.printf(COLFMTS3 + COLFMTS4  + COLFMTS4 + COLFMTS4 +
			COLFMTS4 + "%n", "Search method", "Searches", 
			"Total compares", "Avg compares", "Time (ms)");

        // Loop to linear search array
        totalCompares = 0;
    	before = System.currentTimeMillis();
        for (int i = 0; i < unsortedArray.length; i++)
        	totalCompares = totalCompares + 
        		linearSearchArray(unsortedArray, unsortedArray[i]);
        after = System.currentTimeMillis();
        	
        // Print linear search results
    	System.out.printf(COLFMTS3 + COLFMTD4 + COLFMTD4 + COLFMTF + 
			COLFMTD4 + "%n", "Linear", ARRAY_SIZE, totalCompares, 
			(double) totalCompares / ARRAY_SIZE, after - before);

        // Loop to binary search array
        totalCompares = 0;
    	before = System.currentTimeMillis();
        for (int i = 0; i < sortedArray.length; i++)
        	totalCompares = totalCompares + 
    			binarySearchArray(sortedArray, sortedArray[i]);
        after = System.currentTimeMillis();
        	
        // Print binary search results
    	System.out.printf(COLFMTS3 + COLFMTD4 + COLFMTD4 + COLFMTF +
			COLFMTD4 + "%n", "Binary", ARRAY_SIZE, totalCompares, 
			(double) totalCompares / ARRAY_SIZE, after - before);

		// Show application close
		System.out.println("\nEnd of Array Searching");

    }

}
