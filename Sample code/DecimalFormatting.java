//======================================================================
//
// Title: Decimal Formatting
// Description:
//   This program demonstrates the DecimalFormat class.
//
//======================================================================
package wsu.DecimalFormatting;

import java.text.DecimalFormat;

//======================================================================
// class DecimalFormatting
//======================================================================
public class DecimalFormatting
{
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
        final String COLFMTS1 = "%-20s";
        final String COLFMTS2 = "%16s";

        // Declare variables
    	DecimalFormat numFmt1 = new DecimalFormat("#,##0");
    	DecimalFormat numFmt2 = new DecimalFormat("#,000");
    	DecimalFormat numFmt3 = new DecimalFormat("#,##0.00");
    	DecimalFormat numFmt4 = new DecimalFormat("#,##0.00#");
    	DecimalFormat numFmt5 = new DecimalFormat("0");
    	DecimalFormat numFmt6 = new DecimalFormat("0.00");
    	DecimalFormat numFmt7 = new DecimalFormat("#0");
    	DecimalFormat numFmt8 = new DecimalFormat("#,##0");
    	DecimalFormat numFmt9 = new DecimalFormat("#,##0.0%");
    	DecimalFormat numFmt10 = new DecimalFormat("#,##0E00");
        double num1 = 57.3866;
        double num2 = 9126357.3866;
        double num3 = 0.45;

		// Show application header
		System.out.println("Welcome to Decimal Formatting");
		System.out.println("-----------------------------\n");
        
        // Show num1 formatted
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Num 1:", num1);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 1:", numFmt1.format(num1));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 2:", numFmt2.format(num1));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 3:", numFmt3.format(num1));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 4:", numFmt4.format(num1));
        
        // Show num2 formatted
		System.out.println();
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Num 2:", num2);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 5:", numFmt5.format(num2));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 6:", numFmt6.format(num2));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 7:", numFmt7.format(num2));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 8:", numFmt8.format(num2));
        
        // Show num3 formatted
		System.out.println();
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", "Num 3:", num3);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 9:", numFmt9.format(num3));
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"Number format 10:", numFmt10.format(num3));
        
		// Show application close
		System.out.println("\nEnd of Decimal Formatting");
		
    } 

} 
