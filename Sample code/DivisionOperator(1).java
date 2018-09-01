//======================================================================
//
// Title: Division Operator
// Description:
//   This program demonstrates the division operator.
//
//======================================================================
package wsu.DivisionOperator;

//======================================================================
// class DivisionOperator
//======================================================================
public class DivisionOperator
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
        final String COLFMTS = "%-16s";
        final String COLFMTD = "%10d";
        final String COLFMTF = "%10.4f";

        // Declare variables
        int m = 1;
        int n = 4;

        // Show application header
        System.out.println("Welcome to Division Operator");
        System.out.println("----------------------------\n");

        // Show operands
        System.out.printf(COLFMTS + COLFMTD + "%n", "m", m);
        System.out.printf("%-16s%10d%n", "n", n);

        // Show division operation without casting 
        System.out.printf(COLFMTS + COLFMTD + "%n", "m / n", (m / n));

        // Show division operation with casting
        System.out.printf(COLFMTS + COLFMTF + "%n", "m / (double) n", 
    		(m / (double) n));

        // Show application close
        System.out.println("\nEnd of Division Operator");

    } 

} 
