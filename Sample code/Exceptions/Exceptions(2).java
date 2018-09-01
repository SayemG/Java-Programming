//======================================================================
//
// Title: Exceptions
// Description:
//   This program demonstrates exceptions.
//
//======================================================================
package wsu.Exceptions;

// Import classes
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//======================================================================
// class Exceptions
//======================================================================
public class Exceptions
{

    //------------------------------------------------------------------
	// Globals
    //------------------------------------------------------------------
	public static final String COLFMTS1 = "%-6s";
	public static final String COLFMTS2 = "%6s";
	public static final String COLFMTD1 = "%-6d";
	public static final String COLFMTD2 = "%6d";

    //------------------------------------------------------------------
    // randomizeArray
    //------------------------------------------------------------------
    private static void randomizeArray (int[] arr, int upperLimit)
    {
        
        // Loop to generate and store random numbers
    	Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(upperLimit) + 1;
        
    }
    
    //------------------------------------------------------------------
    // printArray
    //------------------------------------------------------------------
    private static void printArray (int[] arr, int values)
    {
        
        // Loop to print array values
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Index", "Value");
        for (int i = 0; i < values; i++)
            System.out.printf(COLFMTD1 + COLFMTD2 + "%n", i, arr[i]);

    }
    
    //------------------------------------------------------------------
    // printArrayWithCustomException
    //------------------------------------------------------------------
    private static void printArrayWithCustomException (
    		int[] arr, int values) 
				throws MyIndexOutOfBoundsException
    {
        
        // Loop to print array values
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Index", "Value");
        for (int i = 0; i < values; i++)
        {
            if (i == arr.length) 
                throw new MyIndexOutOfBoundsException
                    ("Invalid array index is " + i + ".");
            System.out.printf(COLFMTD1 + COLFMTD2 + "%n", i, arr[i]);
        }

    }
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        int num;
        String junk;
        boolean numberBad;
        String s_num;

        // Show application header
        System.out.println("Welcome to Exceptions");
        System.out.println("---------------------");

        // Handle arithmetic exception
        System.out.println("\nArithmetic (divide-by-zero) exception");
        System.out.println("-------------------------------------");
        System.out.print("Enter whole number 1: ");
        num = keyboard.nextInt();
        try
        {
            System.out.println("5 / " + num + " = " + (5 / num));
            System.out.println("Divided 5 by '" + num + "'.");
        }
        catch (ArithmeticException e)
        {
            System.out.println("Error: cannot divide by zero.");
            System.out.println("Exception message: " + 
        		e.getMessage());
        }

        // Handle (keyboard) input mismatch exception - a method
        System.out.println("\nInput mismatch exception");
        System.out.println("------------------------");
        System.out.print("Enter whole number 2: ");
        try
        {
            num = keyboard.nextInt();
            System.out.println("'" + num + 
        		"' is a valid whole number.");
        }
        catch (InputMismatchException e)
        {
            junk = keyboard.next();  // Previous nextInt didn't read 
                                     // anything so we need to scan 
                                     // past invalid input
            System.out.println("Error: '" + junk + 
        		"' is not a valid whole number.");
            System.out.println("Exception message: " + 
        		e.getMessage());
        }

        // Handle numeric format exception - a better method
        System.out.println("\nNumber format exception");
        System.out.println("------------------------");
        System.out.print("Enter whole number 3: ");
        s_num = keyboard.next();
        try
        {
            num = Integer.parseInt(s_num);
            System.out.println("'" + num + "' is a valid whole " +
        		"number.");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: '" + s_num + 
        		"' is not a valid whole number.");
            System.out.println("Exception message: " + 
        		e.getMessage());
        }

        // Loop to handle numeric format exception - the best method
        System.out.println("\nNumber format exception");
        System.out.println("------------------------");
        numberBad = true;
        while (numberBad)
        {
            System.out.print("\nEnter whole number 4: ");
            s_num = keyboard.next();
            try
            {
                num = Integer.parseInt(s_num);
                numberBad = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error: '" + s_num + "' is not " +
            		"a valid whole number.");
                System.out.println("Exception message: " + 
            		e.getMessage());
            }
        }
        System.out.println("'" + num + "' is a valid whole number.");
        
        // Declare array variables
        int size;
        int[] intArray = null;
        int values;

        // Handle null pointer exception
        System.out.println("\nNull pointer exception");
        System.out.println("----------------------");
        try
        {
            num = intArray[0];
            System.out.println("Integer array is not null.");
        }
        catch (NullPointerException e)
        {
            System.out.println("Error: integer array is null.");
            System.out.println("Exception message: " + 
        		e.getMessage());
        }

        // Handle negative array size exception
        System.out.println("\nNegative array size exception");
        System.out.println("-----------------------------");
        System.out.print("Enter array size: ");
        size = keyboard.nextInt();
        try
        {
            intArray = new int[size];
        }
        catch (NegativeArraySizeException e)
        {
            System.out.println("Error: array size cannot be " +
        		"negative.");
            System.out.println("Exception message: " + 
        		e.getMessage());
            intArray = new int[-size] ;
        }
        System.out.println("Integer array of length " + 
    		intArray.length + " created.");

        // Place random numbers in array
        randomizeArray(intArray, 500);

        // Handle array index-out-of-bounds exception
        System.out.println("\nArray index-out-of-bounds exception");
        System.out.println("-----------------------------------");
        System.out.print("Enter number of array values to print: ");
        values = keyboard.nextInt();
        try
        {
            printArray(intArray, values);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("Error: array index is out of " +
    			"bounds.  There are fewer than " + values + 
    			" elements in the array.");
            System.out.println("Exception message: " + 
    			e.getMessage());
        }

        // Handle array index-out-of-bounds with custom exception
        System.out.println("\nArray index-out-of-bounds with " +
    		"custom exception");
        System.out.println("---------------------------------" +
    		"--------------");
        System.out.print("Enter number of array values to print: ");
        values = keyboard.nextInt();
        try 
        {
            printArrayWithCustomException(intArray, values);
        }
        catch (MyIndexOutOfBoundsException e)
        {
            System.out.println("Error: array index is out of " +
        		"bounds.  There are fewer than " + values + 
        		" elements in the array.");
            System.out.println("Exception message: " + 
        		e.getMessage());
        }
        
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Exceptions");

    }

}
