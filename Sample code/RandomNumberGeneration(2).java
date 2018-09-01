//======================================================================
//
// Title: Random Number Generation
// Description:
//   This program demonstrates generation of random numbers.
//
//======================================================================
package wsu.RandomNumberGeneration;

// Import classes
import java.util.Random;
import java.util.Scanner;

//==============================================================
// class RandomNumberGeneration
//==============================================================
public class RandomNumberGeneration
{

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
        
        // Declare constants
    	final int RANDOM_NUMBERS = 20;
    	final String COLFMTS = "%16s";
    	final String COLFMTD = "%16d";
    	final String COLFMTF = "%16.2f";
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        int lowerBound;
        int upperBound;
        double randomRaw;
        int randomNumber;

        // Show application header
        System.out.println("Welcome to Random Number Generation");
        System.out.println("-----------------------------------");

        // Prompt for and get random range
        System.out.print("\nEnter the lower bound: ");
        lowerBound = keyboard.nextInt();
        System.out.print("Enter the upper bound: ");
        upperBound = keyboard.nextInt();
        
        // Loop to show random numbers using Math.random
        System.out.println("\nUsing Math.random");
        System.out.printf(COLFMTS + COLFMTS + COLFMTS + "%n", "Index",
    		"Random Raw", "Random Number");
        for (int i = 0; i < RANDOM_NUMBERS; i++)
        {
        	randomRaw = Math.random();
        	randomNumber = 
    			(int) (randomRaw * (upperBound - lowerBound + 1)) + 
    			lowerBound;
            System.out.printf(COLFMTD + COLFMTF + COLFMTD + "%n", 
        		i + 1, randomRaw, randomNumber);
        }
        
        // Loop to show random numbers using Random object
        System.out.println("\nUsing Random object");
        System.out.printf(COLFMTS + COLFMTS + COLFMTS + "%n", "Index",
    		"", "Random Number");
        Random rand = new Random();
        for (int i = 0; i < RANDOM_NUMBERS; i++)
        {
        	randomNumber = 
    			rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.printf(COLFMTD + COLFMTS + COLFMTD + "%n", 
        		i + 1, "", randomNumber);
        }
        
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Random Number Generation");

    }

}
