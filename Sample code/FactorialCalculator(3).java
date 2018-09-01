//======================================================================
//
// Title: Factorial Calculator
// Description:
// 	 This application prompts for and reads a whole number from the user 
// until it is between 0 and 170.  It then calculates and display its 
// factorial.
//
//======================================================================
package wsu.FactorialCalculator;

//Import classes
import java.util.Scanner;

//======================================================================
// class FactorialCalculator
//======================================================================
public class FactorialCalculator
{
	
	//------------------------------------------------------------------
	// main
	//------------------------------------------------------------------
	public static void main(String[] args)
	{
	
		// Declare variables
		Scanner keyboard = new Scanner(System.in);  // Connect to keyboard
		int number;
		double fact; // Declared 'double' to hold larger numbers 
		             // than 'int'
	
		// Show application header
		System.out.println("Welcome to Factorial Calculator");
		System.out.println("-------------------------------\n");
	
		// Loop to get number.
		// -Factorial is not defined for numbers less than 0.
		// -double cannot hold number larger than 170!.
		System.out.print("Enter a whole number to calculate the " +
			"factorial of (between 0 and 170): ");
		number = keyboard.nextInt();
		while (number < 0 || number > 170)
		{
			System.out.print("\nEnter a whole number to calculate " +
				"the factorial of (between 0 and 170): ");
			number = keyboard.nextInt();
		}
	
		// Test which number entered
		if (number == 0 || number == 1)
			fact = 1;
	
		// Calculate factorial of numbers greater than 1
		else
		{
	
			// Loop to calculate factorial
		    fact = 1;
		    for (int i = number; i > 1; i--)
		    	fact = fact * i;
	
		}
		System.out.println(number + "! = " + fact);
        
	    // Close keyboard
	    keyboard.close();
	
		// Show application close
		System.out.println("\nEnd of Factorial Calculator\n");

	}

}
