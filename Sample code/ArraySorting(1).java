//======================================================================
//
// Title: Array Sorting
// Description:
//   This program demonstrates sorting integers in an array using the 
// insertion, selection, and bubble sort methods.
//
//======================================================================
package wsu.ArraySorting;

// Import classes
import java.util.Arrays;
import java.util.Random;

//======================================================================
// class ArraySorting
//======================================================================
public class ArraySorting
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final String COLFMTD1 = "%,16d";
	private static final String COLFMTD2 = "%,1d";
	private static final String COLFMTD3 = "%,6d";
	private static final String COLFMTS1 = "%6s";
	private static final String COLFMTS2 = "%-12s";
	private static final String COLFMTS3 = "%16s";
	private static final String COLFMTS4 = "%1s";

	//------------------------------------------------------------------
    // bubbleSortArray
    //------------------------------------------------------------------
    private static String bubbleSortArray(int[] arr)
    {
    	
    	// Declare variables
    	int i;
    	boolean swapNeeded;
    	int temp;
    	long cycles = 0;
    	long swaps = 0;
    	
    	// Loop to bubble up smallest value within each group
    	i = 0;
    	swapNeeded = true;
    	while (i < arr.length - 1 && swapNeeded)
    	{

    		// Loop to bubble up smallest value within group
    		swapNeeded = false;
        	for (int j = arr.length - 2; j >= i; j--)
        	{
        		if (arr[j] > arr[j + 1])
        		{
        			temp = arr[j];
        			arr[j] = arr[j + 1];
        			arr[j + 1] = temp;
            		swaps = swaps + 1;
        			swapNeeded = true;
        		}
        		cycles = cycles + 1;
        	}
    		
    		// Increment pointer
    		i = i + 1;
    		
    	}
    	
    	// Return cycles and swaps
    	return String.format(COLFMTD1 + COLFMTD1 + COLFMTD1, cycles, 
			swaps, cycles + swaps);

    }

	//------------------------------------------------------------------
    // insertionSortArray
    //------------------------------------------------------------------
    private static String insertionSortArray(int[] arr)
    {
    	
    	// Declare variables
    	int value;
    	int spot;
    	long cycles = 0;
    	long swaps = 0;
    	
    	// Loop to test each value
    	for (int i = 1; i < arr.length; i++)
    	{
        	
        	// Loop to find spot to place value
    		value = arr[i];
    		spot = i - 1;
		    while (spot >= 0 && arr[spot] > value)
		    {
		        arr[spot + 1] = arr[spot];
        		swaps = swaps + 1;
        		cycles = cycles + 1;
		        spot = spot - 1;
		    }
		    
		    // Place value in spot
		    arr[spot + 1] = value;
		    
    	}
    	
    	// Return cycles and swaps
    	return String.format(COLFMTD1 + COLFMTD1 + COLFMTD1, cycles, 
			swaps, cycles + swaps);

    }

	//------------------------------------------------------------------
    // selectionSortArray
    //------------------------------------------------------------------
    private static String selectionSortArray(int[] arr)
    {
    	
    	// Declare variables
    	int minIndex;
    	int temp;
    	long cycles = 0;
    	long swaps = 0;
    	
    	// Loop to find min index within each group
    	for (int i = 0; i < arr.length - 1; i++)
    	{

    		// Loop to find min index within group
    		minIndex = i;
        	for (int j = i + 1; j < arr.length; j++)
        	{
        		if (arr[j] < arr[minIndex])
        			minIndex = j;
        		cycles = cycles + 1;
        	}
    		
    		// Test if swap needed
    		if (minIndex != i)
    		{
    			temp = arr[minIndex];
    			arr[minIndex] = arr[i];
    			arr[i] = temp;
        		swaps = swaps + 1;
    		}
    		
    	}
    	
    	// Return cycles and swaps
    	return String.format(COLFMTD1 + COLFMTD1 + COLFMTD1, cycles, 
			swaps, cycles + swaps);
        
    }

    //------------------------------------------------------------------
    // randomizeArray
    //------------------------------------------------------------------
    private static void randomizeArray(int[] arr, int upperLimit)
    {
    	
    	// Loop to generate and store in array random numbers from 1
    	// to upperLimit
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
    	System.out.println("\n" + heading);
		System.out.println("Array size: " + 
			String.format(COLFMTD2, arr.length));
    	System.out.printf(COLFMTS1 + COLFMTS1 + "%n", "Index",
			"Value");
        for (int i = 0; i < arr.length; i++)
        	System.out.printf(COLFMTD3 + COLFMTD3 + "%n", i, arr[i]);

    }
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    	
    	// Declare constants
    	final int ARRAY_SIZE = 100000;
    		// 100 thousand takes ~25 seconds; 1 million takes ~45 minutes!
    	final int ARRAY_PRINT_MAX = 10;

        // Declare variables
        int[] unsortedArray = new int[ARRAY_SIZE];
        int[] insertionSortedArray = new int[ARRAY_SIZE];
        int[] selectionSortedArray = new int[ARRAY_SIZE];
        int[] bubbleSortedArray = new int[ARRAY_SIZE];
        long before;
        long after;
        String results;

		// Show application header
		System.out.println("Welcome to Array Sorting");
		System.out.println("------------------------");
        
        // Place random numbers in array and print
        randomizeArray(unsortedArray, ARRAY_SIZE * 100);
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Unsorted array", unsortedArray);

        // Print headings
		System.out.println();
		System.out.println("Array size: " + 
			String.format(COLFMTD2, ARRAY_SIZE));
    	System.out.printf(COLFMTS2 + COLFMTS3 + COLFMTS3 + COLFMTS3 +
			COLFMTS3 + "%n", "Sort method", "Cycles", "Swaps", 
			"Total", "Time (ms)");
    	
        // Insertion sort array
        insertionSortedArray = Arrays.copyOf(unsortedArray,
    		unsortedArray.length);
        before = System.currentTimeMillis();
        results = insertionSortArray(insertionSortedArray);
        after = System.currentTimeMillis();
    	System.out.printf(COLFMTS2 + COLFMTS4 + COLFMTD1 + "%n", 
			"Insertion", results, (after - before));

        // Selection sort array
        selectionSortedArray = Arrays.copyOf(unsortedArray, 
    		unsortedArray.length);
        before = System.currentTimeMillis();
        results = selectionSortArray(selectionSortedArray);
        after = System.currentTimeMillis();
    	System.out.printf(COLFMTS2 + COLFMTS4 + COLFMTD1 + "%n", 
			"Selection", results, (after - before));

        // Bubble sort array
        bubbleSortedArray = Arrays.copyOf(unsortedArray,
    		unsortedArray.length);
        before = System.currentTimeMillis();
        results = bubbleSortArray(bubbleSortedArray);
        after = System.currentTimeMillis();
    	System.out.printf(COLFMTS2 + COLFMTS4 + COLFMTD1 + "%n", 
			"Bubble", results, (after - before));
        
        // Print one of sorted arrays
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Sorted array - insertion", insertionSortedArray);

		// Show application close
		System.out.println("\nEnd of Array Sorting");

    }

}
