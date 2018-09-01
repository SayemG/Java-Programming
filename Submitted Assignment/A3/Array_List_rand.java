//======================================================================
// Title:      <Array_List_rand.java> // Sort an Array list of random numbers
// Course:     CSC 3020
// Homework:   <#3)>
// Author:     <Sayem Chowdhury>
// Date:       <2/22/2018>
// Description:
/*<
	A Java console application that sorts an array list of random real numbers.  
	Using a validation loop to prompt for and get from the user the number of real numbers to sort in the range 10-10,000. 
	To create and store in the array list that many random real numbers.  Randomly generate the real numbers in the range 0-1,000.
	Also Print the array list size and use formatted output to print the first ten values of the array list in two columns:
		The first column is the zero-based index of the value.
		The second column is the right-justified value.
>*/
//
//======================================================================

//package Name
package sort_scorchers;
//import Classes
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Array_List_rand {
	
	// [static /global variables]
	    static int cycles=0;
		static int swaps=0;
		static int total;
		// Array Size 
		public static int Random_num=10;
		
		
	// Declare Format constants
	private static final String COLFMTD1 = "%2d";
	private static final String COLFMTF = "%20.1f";
	private static final String COLFMTS1 = "%-16s";
	private static final String COLFMTS2 = "%6s";

	//------------------------------------------------------------------
    // randomizeArray
    //------------------------------------------------------------------
    private static void randomizeArray(
    		ArrayList<Double>arr, int upperLimit,int lowerLimit)
    {
    	// Loop to generate and store random numbers in array
    	Random rand = new Random();
        for (int i = 0; i < Random_num; i++)
        {
        	arr.add((double)(lowerLimit+rand.nextInt(upperLimit-lowerLimit) + 1)); 
        }
    } 
    
    //print function will display sorted and unsorted Array
    private static void printArray(String heading, ArrayList<Double>arr)
    {
    	System.out.println("\n" + heading + " values.");
    	System.out.println("Array size: " + Random_num);
    	System.out.println("-----------------------------------");
    	System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Index", "Value");
    	// Loop to print array numbers
    	for (int i = 0; i < 10; i++)
        	System.out.printf(COLFMTD1 + COLFMTF + "%n", i, arr.get(i));
    }
	
    // Insertion sort Method
    public static void insertion_sort( ArrayList<Double>arr )
    {
        	//-----------------
            int L = arr.size();
            int i, j;
            double temp;
            for (i = 1; i< L; i++) 
            {
                j = i;
                temp = arr.get(i);    
                while (j > 0 && temp < arr.get(j-1))
                {
                    arr.set(j,arr.get(j-1));
                    j = j-1; 
                    swaps=swaps+1; // counting swaps 
                    cycles=cycles+1;//counting cycles
                }
                arr.set(j,temp);      
            }    
            total=swaps+cycles; // total numbers of swap and cycles
        }   
    
 //-----------------------------------------------------------------------------------
    //main function
	public static void main(String[] args) {
		// Input Variables
		 Scanner keyboard = new Scanner(System.in);
		// Show application header
        System.out.println("Welcome to Sorting Array List Application");
        System.out.println("-----------------------------------------");
		// Validation for Array Size
        
        while(true)
    	{
    		System.out.print("Please Enter the Array Size between 10 to 10000 \n");
    		Random_num=keyboard.nextInt();
    		if((Random_num<10 || Random_num>10000))
    			
    		{
    			System.out.print("Please Enter the Array Size between 10 to 10000");
        		Random_num=keyboard.nextInt();
    		}
    		else
    		{
    			break;
    		}
    	}
    	
        //Declaring Array List
        ArrayList<Double>unsortedArray = new ArrayList<>();
        ArrayList<Double>sortedArray = new  ArrayList<>();
        ArrayList<Double>insertionSortedArray =new  ArrayList<>();
        
        //variable for calculating times take by insertion method to sort the Array LIst
        long before;
        long after;
    	
    	// Declare variables
       
        int lowerBound;
        int upperBound;
        
        // Prompt for user input of the upper and lower bound and get random range
        System.out.print("\nEnter the lower bound: ");
        lowerBound = keyboard.nextInt();
        System.out.print("Enter the upper bound: ");
        upperBound = keyboard.nextInt();
        
        //Validation Loop
        if(lowerBound<10 || upperBound>1000)
        {
        	System.out.print("Out of range");	
            System.exit(1);
        }
       
        // Place random numbers in array and print
        randomizeArray(unsortedArray, upperBound,lowerBound);
        
        //printing Unsorted Array using print function 
        printArray("Unsorted Array", unsortedArray);
       
       //copying
       for (int i = 0 ; i<unsortedArray.size();i++){
    	    sortedArray.add(unsortedArray.get(i)) ;
    	}
       
       //sorting sortedArray array 
        insertion_sort(sortedArray );
        //printing sorted array using print function 
        printArray("Sorted Array", sortedArray); 
        
        //copying
        for (int i = 0 ; i<unsortedArray.size();i++){
            insertionSortedArray.add(unsortedArray.get(i)) ;
        }
        
        //staring time of insertion sort method
        before = System.currentTimeMillis();
        
        insertion_sort(insertionSortedArray);
        
        //Ending time of insertion method 
        after = System.currentTimeMillis(); 
        //------
        	// Print headings
     		System.out.println();
     		System.out.println("------------------------------------------------------------------------------------");
         	System.out.printf("%n%-10s %15s %n%-10s%,17d %n%-10s %,16d %n%-10s%,17d %n%-10s%17d %n", "Sort method","Insertion",
         			"Swaps", swaps,"Cycles",cycles,"Total",total,"Time (ms)",(after-before));
         	System.out.println("------------------------------------------------------------------------------------");    
         	// close Keyboard 
    	keyboard.close();
	}

}
