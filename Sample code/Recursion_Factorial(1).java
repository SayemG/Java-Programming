//======================================================================
//
// Title: Recursion-Factorial
// Description:
//   This program demonstrates iteration and recursion for factorial.
//
//======================================================================
package wsu.Recursion_Factorial;

// Import classes
import java.util.Scanner;

//======================================================================
// class Recursion_Factorial
//======================================================================
public class Recursion_Factorial
{
	
    //------------------------------------------------------------------
    // factorial
    //------------------------------------------------------------------
    public static int factorial(int m)
    {
        
        // Test if base case reached
        System.out.println("-In factorial call, m is " + m);
    	if (m == 0 || m == 1)
    		return 1;
    	else
    		return m * factorial(m - 1);
    	
    }

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    	
    	// Declare constants
    	final String COLFMTD = "%,1d";
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);  // Connect to keyboard
        int n;
        int fact;

        // Show application header
        System.out.println("Welcome to Recursion-Factorial");
        System.out.println("------------------------------");

        // Loop to calculate factorials
        System.out.print("\nEnter a whole number between 0 and 12 " +
    		"(negative number to exit): ");
        n = keyboard.nextInt();
        while (n >= 0)
        {
        	
        	// Test if number too high
        	if (n > 12)
        		System.out.println("Error: cannot calculate a " +
    				"factorial that large.");
        	else
        	{
                
                // Loop to calculate factorial using for statement
                fact = 1;
                for (int i = n; i >= 2; i--)
                	fact = fact * i;
                System.out.println("Using for statement: " + n + 
            		"! = " + String.format(COLFMTD, fact));
                
                // Calculate factorial using recursion
                System.out.println("Using recursion: " + n + 
            		"! = " + String.format(COLFMTD, factorial(n)));
        		
        	}
        
            // Prompt for and get next whole number
            System.out.print("\nEnter a whole number between 0 and 12 " +
            		"(negative number to exit): ");
            n = keyboard.nextInt();

        }
       
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Recursion-Factorial");

    } 

} 
