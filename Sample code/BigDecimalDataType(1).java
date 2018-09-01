//======================================================================
//
// Title: Big Decimal Data Type
// Description:
//   This program compares the double and Big Decimal data types.
//
//======================================================================
package wsu.BigDecimalDataType;

// Import classes
import java.math.BigDecimal;
import java.util.Scanner;

//======================================================================
// class BigDecimalDataType
//======================================================================
public class BigDecimalDataType
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
        
        // Declare constants
    	final int LOOPS = 40;
    	final double START_VALUE = 1.2;
    	final double ADDEND = 0.2;
    	final double FACTOR = 1.127;
        final String COLFMTS1 = "%4s";
        final String COLFMTS2 = "%35s";
        final String COLFMTD = "%4d";
        final String COLFMT1F = "%35.20f";
        final String COLFMT2F = "%35.30f";
    
        // Declare variables
    	double dblReal;
    	BigDecimal bigReal;
        Scanner keyboard = new Scanner(System.in);

        // Show application header
        System.out.println("Welcome to Big Decimal Data Type");
        System.out.println("--------------------------------\n");
        
        // Loop to compare additions
    	dblReal = START_VALUE;
    	bigReal = BigDecimal.valueOf(START_VALUE);
        System.out.println("Addition comparison (start value: " + 
    		START_VALUE + ", increment value: " + ADDEND + ")\n");
        System.out.printf(COLFMTS1 + COLFMTS2 + COLFMTS2 + "%n", 
    		"#", "double value", "BigDecimal value");
        for (int i = 0; i < LOOPS; i++)
        {
            System.out.printf(COLFMTD + COLFMT1F + COLFMT2F + "%n", 
        		i, dblReal, bigReal);
        	dblReal = dblReal + ADDEND;
        	bigReal = bigReal.add(BigDecimal.valueOf(ADDEND));
        }

        // Loop to compare multiplications
    	dblReal = START_VALUE;
    	bigReal = BigDecimal.valueOf(START_VALUE);
        System.out.println("\nMultiplication comparison (start " + 
    		"value: " + START_VALUE + ", multiplier value: " + 
    		FACTOR + ")\n");
        System.out.printf(COLFMTS1 + COLFMTS2 + COLFMTS2 + "%n", 
    		"#", "double value", "BigDecimal value");
        for (int i = 0; i < LOOPS; i++)
        {
            System.out.printf(COLFMTD + COLFMT1F + COLFMT2F + "%n", 
        		i, dblReal, bigReal);
        	dblReal = dblReal * 1.127;
        	bigReal = bigReal.multiply(BigDecimal.valueOf(1.127));
        }
            
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Big Decimal Data Type");

    } 

} 
