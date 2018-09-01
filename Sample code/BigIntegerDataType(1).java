//======================================================================
//
// Title: BigInteger Data Type
// Description:
//   This program compares integer and Big Integer data types.
//
//======================================================================
package wsu.BigIntegerDataType;

//Import classes
import java.math.BigInteger;

//======================================================================
// class BigIntegerDataType
//======================================================================
public class BigIntegerDataType
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
    	final String COLFMT1 = "%-10s";
    	final String COLFMT2S = "%36s";
    	final String COLFMT2D = "%,36d";
    	final String COLFMT3S = "%-14s";
    	final String COLFMT3D = "%,60d";

        // Declare variables
    	String s;
    	BigInteger bigIntegerSmall;
    	BigInteger bigIntegerBig;

        // Show application header
        System.out.println("Welcome to Big Integer Data Type");
        System.out.println("--------------------------------\n");

		// Show Wrapper class fields
        System.out.println("Integer data types");
        System.out.printf(COLFMT1 + COLFMT2S + COLFMT2S + "%n", 
    		"Data type", "Min", "Max");
        System.out.printf(COLFMT1 + COLFMT2D + COLFMT2D + "%n", 
    		"Byte", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf(COLFMT1 + COLFMT2D + COLFMT2D + "%n", 
    		"Short", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf(COLFMT1 + COLFMT2D + COLFMT2D + "%n", 
    		"Integer", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf(COLFMT1 + COLFMT2D + COLFMT2D + "%n", 
    		"Long", Long.MIN_VALUE, Long.MAX_VALUE);
        
        // Set BigInteger values
    	bigIntegerSmall = 
			new BigInteger("-999999999999999999999999999999999999999"); 
    	bigIntegerBig =
			new BigInteger("+999999999999999999999999999999999999999"); 
        
        // Show BigInteger values
        System.out.println("\nBigInteger values");
        System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    		"-Small:", bigIntegerSmall);
        System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    		"-Big:", bigIntegerBig);
        
        // Update and show BigInteger values
        System.out.println("\nBigInteger values modified");
        System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    		"-Small - 1:", bigIntegerSmall.subtract(BigInteger.ONE));
        System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    		"-Big + 1:", bigIntegerBig.add(BigInteger.ONE));
        
        // Loop to show next ten prime numbers
        System.out.println("\nNext ten prime numbers after bigIntegerBig");
        for (int i = 0; i < 10; i++)
        {
        	bigIntegerBig = bigIntegerBig.nextProbablePrime();
        	System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    			String.format("%2d", i + 1), bigIntegerBig);
        }
        
        // Loop to show next four squares of bigIntegerBig
        System.out.println("\nNext four squares of bigIntegerBig");
        for (int i = 0; i < 4; i++)
        {
        	bigIntegerBig = bigIntegerBig.pow(2);
        	System.out.printf(COLFMT3S + COLFMT3D + "%n", 
    			String.format("%2d", i + 1), bigIntegerBig);
        }
        
        // Create number with one million 9s
        System.out.println("\nbigIntegerBig with one million 9s");
        System.out.println("Creating ... ");
        s = new String(new char[1000000]).replace("\0", "9");
    	bigIntegerBig = new BigInteger(s); 
        System.out.println("Done!");
        
        // Create number with Integer.MAX_VALUE 9s
//        System.out.println("\nbigIntegerBig with Integer.MAX_VALUE 9s");
//        System.out.println("Creating ... ");
//        s = "";
//        for (int i = 0; i < Integer.MAX_VALUE; i++)
//        {
//        	s = s + "9";
//            if (i % 1000000 == 0) 
//            	System.out.println("Still working (" + 
//            			String.format("%,1d", i) + ") ... ");
//        }
//    	bigIntegerBig = new BigInteger(s); 
//        System.out.println("Done!");

        // Show application close
        System.out.println("\nEnd of Big Integer Data Type");

    } 

} 
