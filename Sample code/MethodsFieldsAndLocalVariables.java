//======================================================================
//
// Title: Methods, Fields, and Local Variables
// Description:
//   This program demonstrates user-defined methods, fields, and local 
// variables.  It also shows parameters and arguments.
//
//======================================================================
package wsu.MethodsFieldsAndLocalVariables;

//Import classes
import java.util.Scanner;

//======================================================================
// class MethodsFieldsAndLocalVariables
//======================================================================
public class MethodsFieldsAndLocalVariables
{
    
    //------------------------------------------------------------------
    // Fields
    //------------------------------------------------------------------

    // Declare constant fields
    private final static String COLFMTS1 = "%-40s";
    private final static String COLFMTS2 = "%8s";
    private final static String COLFMTS3 = "%-16s";
    private final static String COLFMTD = "%8d";
    private final static String COLFMTF = "%8.2f";
    
    // Declare variable fields
    private static int f_int;
    private static double f_dbl;
    private static String f_str;

    //------------------------------------------------------------------
    // changeValues
    //------------------------------------------------------------------
    public static void changeValues(int num_int, double num_dbl, 
		String name_str) 
    {

        // Change fields
        f_int = 33;
        f_dbl = 3.3;
        f_str = "Mark";

        // Change local variables
        num_int = 44;
        num_dbl = 4.4;
        name_str = "Denise";
        
        // Print variables within method
        printFieldsAndVariables(false, "Within " +
    		"method after values changed", num_int, num_dbl, name_str);
        
    }
    
    //------------------------------------------------------------------
    // numberToPower - any power
    //------------------------------------------------------------------
    public static double numberToPower(double num_dbl, int power) 
    {
    	double result = 1;
    	if (power > 0)
    		for (int i = 1; i <= power; i++)
    			result = result * num_dbl;
		return result;
    }
    
    //------------------------------------------------------------------
    // numberToPower - power is 2
    //------------------------------------------------------------------
    public static double numberToPower(double num_dbl) 
    {
		return num_dbl * num_dbl;
    }

    //------------------------------------------------------------------
    // printFieldsAndVariables
    //------------------------------------------------------------------
    public static void printFieldsAndVariables(boolean headings, 
		String type, int num_int, double num_dbl, String name_str) 
    {
    	
    	// Test whether to print headings
    	if (headings)
    	{
    		System.out.println();
            System.out.printf(COLFMTS1 + COLFMTS2 + COLFMTS2 + 
        		COLFMTS2 + COLFMTS2 + COLFMTS2 + COLFMTS2 + "%n", 
        		"Program location", "f_int", "f_dbl", "f_str", 
        		"l_int", "l_dbl", "l_str");
    	}

    	// Print values
        System.out.printf(COLFMTS1 + COLFMTD + COLFMTF + COLFMTS2 + 
    		COLFMTD + COLFMTF + COLFMTS2 + "%n", type, f_int, f_dbl, 
    		f_str, num_int, num_dbl, name_str);
        
    }
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare local variables
        int l_int;
        double l_dbl;
        String l_str;
        Scanner keyboard = new Scanner(System.in);
        
        // Declare other variables
        double base;
        int power;
        double result;
        double result2;

        // Show application header
        System.out.println("Welcome to Methods, Fields, and, Local " +
    		"Variables");
        System.out.println("---------------------------------------" +
    		"---------");

        // Set fields
        f_int = 11;
        f_dbl = 1.1;
        f_str = "Luke";

        // Set local variables
        l_int = 22;
        l_dbl = 2.2;
        l_str = "Wendy";
       
        // Print fields and variables before method call
        printFieldsAndVariables(true, "In main before method call", 
    		l_int, l_dbl, l_str);

        // Call method
        changeValues(l_int, l_dbl, l_str);
        
        // Print fields and variables after method call
        printFieldsAndVariables(false, "In main after method call", 
    		l_int, l_dbl, l_str);
        System.out.println("\nOnly the fields retained changes " +
    		"after the method call because they are global to the " +
    		"\nclass while the local variables are not.");
        
        // Loop to calculate base-to-powers until sentinel value
        System.out.println("\nBases to powers");
        System.out.print("Enter a real number for the base " +
    		"(-9 to exit): ");
        base = keyboard.nextDouble();
        while (base != -9)
        {
            System.out.print("Enter an integer power: ");
            power = keyboard.nextInt();
            result = numberToPower(base, power);
            result2 = numberToPower(base);
            System.out.println();
            System.out.printf(COLFMTS3 + COLFMTF + "%n", "Base:", 
        		base);
            System.out.printf(COLFMTS3 + COLFMTD + "%n", "Power:", 
        		power);
            System.out.printf(COLFMTS3 + COLFMTF + "%n", "Result (" + 
        		base + "^" + power + "):", result);
            System.out.printf(COLFMTS3 + COLFMTD + "%n", "Power:", 
        		2);
            System.out.printf(COLFMTS3 + COLFMTF + "%n", "Result (" + 
        		base + "^2):", result2);
            System.out.print("\nEnter a real number for the base " +
        		"(-9 to exit): ");
            base = keyboard.nextDouble();
        }
        
	    // Close keyboard
	    keyboard.close();
        
        // Show application close
        System.out.println("\nEnd of Methods, Fields, and, Local " +
    		"Variables");

    } 

} 
