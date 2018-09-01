//======================================================================
//
// Title: Array Sorting - Recursive
// Description:
//   This program demonstrates sorting values in an array using the 
// merge and quick sort methods.
//
//======================================================================
package wsu.ArraySorting_Recursive;

// Import classes
import java.util.Arrays;
import java.util.Random;

//======================================================================
// class ArraySorting_Recursive
//======================================================================
public class ArraySorting_Recursive
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final int ARRAY_SIZE = 1000000;
	private static final int ARRAY_PRINT_MAX = 50;
	private static final String COLFMTS1 = "%6s";
	private static final String COLFMTD1 = "%6d";
	private static final String COLFMTS2 = "%-16s";
	private static final String COLFMTS3 = "%16s";
	private static final String COLFMTD2 = "%,16d";

	//------------------------------------------------------------------
    // mergeSortArray
    //------------------------------------------------------------------
    private static void mergeSortArray(int[] arr, int leftIndex, 
		int rightIndex)
    {

    	// Declare variables
    	int midIndex;
    	
    	// Test for recursive case
        if (leftIndex < rightIndex)
        {
        	
        	// Get middle index of current array
        	midIndex = (leftIndex + rightIndex) / 2;
        	
        	// Merge sort left and right halves
        	mergeSortArray(arr, leftIndex, midIndex);
        	mergeSortArray(arr, midIndex + 1, rightIndex);
        	mergeArrays(arr, leftIndex, midIndex, rightIndex);
        	
        }
    	
    }
    
	//------------------------------------------------------------------
    // mergeArrays
    //------------------------------------------------------------------
    private static void mergeArrays(int arr[], int leftIndex, 
		int midIndex, int rightIndex)
    {
    	
    	// Declare variables
        int arrSizeLeft = midIndex - leftIndex + 1;
        int arrSizeRight =  rightIndex - midIndex;
        int i;
        int j;
        int k;
     
        // Create half arrays
    	int[] arrLeft = new int[arrSizeLeft];
        int[] arrRight = new int[arrSizeRight];
     
        // Copy data to half arrays
        for (i = 0; i < arrSizeLeft; i++)
        	arrLeft[i] = arr[leftIndex + i];
        for(i = 0; i < arrSizeRight; i++)
        	arrRight[i] = arr[midIndex + 1 + i];
     
        // Loop to merge data from half arrays
        i = 0;
        j = 0;
        k = leftIndex;
        while (i < arrSizeLeft && j < arrSizeRight)
        {
            if (arrLeft[i] <= arrRight[j])
            {
                arr[k] = arrLeft[i];
                i++;
            }
            else
            {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }
     
        // Loop to copy remaining elements of left half to merged array
        while (i < arrSizeLeft)
        {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }
     
        // Loop to copy remaining elements of right half to merged array
        while (j < arrSizeRight)
        {
            arr[k] = arrRight[j];
            j++;
            k++;
        }

    }

	//------------------------------------------------------------------
    // quickSortArray
    //------------------------------------------------------------------
    private static void quickSortArray(int[] arr, int lowIndex, 
		int highIndex)
    {
    	
    	// Declare variables
    	int pivotIndex;
    	
    	// Test for recursive case
        if (lowIndex < highIndex)
        {
        	pivotIndex = partitionArray(arr, lowIndex, highIndex);
        	quickSortArray(arr, lowIndex, pivotIndex - 1);
        	quickSortArray(arr, pivotIndex + 1, highIndex);
        }
    	
    }

	//------------------------------------------------------------------
    // partitionArray
    //------------------------------------------------------------------
    private static int partitionArray(int[] arr, int lowIndex, 
		int highIndex)
    {
    	
    	// Declare variables
    	int pivotIndex;
    	int i;
    	int temp;
    	
    	// Partition array around pivot
        pivotIndex = arr[highIndex];
	    i = lowIndex;
	    for (int j = lowIndex; j < highIndex; j++)
    		if (arr[j] <= pivotIndex)
    		{
    			temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;
				i = i + 1;
    		}
		temp = arr[i];
		arr[i] = arr[highIndex];
		arr[highIndex] = temp;
	    return i;
    	
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
    	System.out.println("Array size: " + arr.length);
    	System.out.printf(COLFMTS1 + COLFMTS1 + "%n", "Index",
			"Value");
        for (int i = 0; i < arr.length; i++)
        	System.out.printf(COLFMTD1 + COLFMTD1 + "%n", i, arr[i]);

    }
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Declare variables
        int[] unsortedArray = new int[ARRAY_SIZE];
        int[] mergeSortedArray = new int[ARRAY_SIZE];
        int[] quickSortedArray = new int[ARRAY_SIZE];
        long before;
        long after;

		// Show application header
		System.out.println("Welcome to Array Sorting - Recursive");
		System.out.println("------------------------------------");
        
        // Place random numbers in array and print
        randomizeArray(unsortedArray, ARRAY_SIZE * 100);
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Unsorted array", unsortedArray);

        // Print headings
		System.out.println();
    	System.out.printf(COLFMTS2 + COLFMTD2 + "%n%n", "Array size:", 
			ARRAY_SIZE);
    	System.out.printf(COLFMTS2 + COLFMTS3 + "%n", "Sort method", 
			"Time (millis)");
    	
    	// Merge sort array
    	mergeSortedArray = Arrays.copyOf(unsortedArray,
			unsortedArray.length);
    	before = System.currentTimeMillis();
        mergeSortArray(mergeSortedArray, 0, mergeSortedArray.length - 1);
        after = System.currentTimeMillis();
    	System.out.printf(COLFMTS2 + COLFMTD2 + "%n", 
			"Merge", (after - before));

        // Quick sort array
        quickSortedArray = Arrays.copyOf(unsortedArray, 
    		unsortedArray.length);
        before = System.currentTimeMillis();
        quickSortArray(quickSortedArray, 0, quickSortedArray.length - 1);
        after = System.currentTimeMillis();
    	System.out.printf(COLFMTS2 + COLFMTD2 + "%n", 
			"Quick", (after - before));

    	if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Merge sorted array", mergeSortedArray);
        if (ARRAY_SIZE < ARRAY_PRINT_MAX)
        	printArray("Quick sorted array", quickSortedArray);

		// Show application close
		System.out.println("\nEnd of Array Sorting - Recursive");

    }

}
