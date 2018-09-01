//======================================================================
//
// Title: Math Fields And Methods
// Description:
//   This program demonstrates the static Math class.
//
//======================================================================
package wsu.MathFieldsAndMethods;

// Import classes
import java.util.Scanner;

//======================================================================
// class MathFieldsAndMethods
//======================================================================
public class MathFieldsAndMethods
{
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
    	final String COLFMTS = "%-30s";
    	final String COLFMTF = "%24.2f";
    	final String COLFMTD = "%24d";
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        double num;

		// Show application header
		System.out.println("Welcome to Math Fields and Methods");
		System.out.println("----------------------------------");

		// Show Math class fields
        System.out.println("\nMath class fields");
        System.out.printf(COLFMTS + COLFMTF + "%n", 
    		"Base of natural logarithm:", Math.E);
        System.out.printf(COLFMTS + COLFMTF + "%n", "PI:", Math.PI);
		
        // Read a real number
        System.out.print("\nEnter a real number: ");
        num = keyboard.nextDouble();

		// Apply some Math class methods to given number
        System.out.println("\nMath class methods");
        System.out.printf(COLFMTS + COLFMTF + "%n", 
    		"Absolute value:", Math.abs(num));
        System.out.printf(COLFMTS + COLFMTF + "%n",
    		"Cube root:", Math.cbrt(num));
        System.out.printf(COLFMTS + COLFMTF + "%n", 
    		"Ceiling:", Math.ceil(num));
        System.out.printf(COLFMTS + COLFMTF + "%n",
    		"Euler's number:", Math.exp(num));
        System.out.printf(COLFMTS + COLFMTF + "%n",
    		"Floor:", Math.floor(num));
        System.out.printf(COLFMTS + COLFMTF + "%n",
    		"Natural log:", Math.log(num));
        System.out.printf(COLFMTS + COLFMTF + "%n",
    		"Next up:", Math.nextUp(num));
        System.out.printf(COLFMTS + COLFMTD + "%n", 
    		"Round:", Math.round(num));
        System.out.printf(COLFMTS + COLFMTF + "%n", 
    		"Square root:", Math.sqrt(num));
        
        // Generate random number
        System.out.printf(COLFMTS + COLFMTF + "%n", 
    		"Random (0 <= n < 1.0):", Math.random());

        // Close keyboard
        keyboard.close();
        
		// Show application close
		System.out.println("\nEnd of Math Fields and Methods");
		
    } 

} 
