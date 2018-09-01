//======================================================================
//
// Title: Character Methods
// Description:
//   This program demonstrates Character methods.
//
//======================================================================
package wsu.CharacterMethods;

// Import classes
import java.util.Scanner;

//======================================================================
// class CharacterMethods
//======================================================================
public class CharacterMethods
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
    	final String COLFMTS1 = "%-22s";
    	final String COLFMTS2 = "%1s";  // Used as placeholder
    	final String COLFMTS3 = "%12s";
    	final String COLFMTD = "%12d";
    	final String COLFMTC = "%12c";
    	final String COLFMTB = "%12b";
    	final int MIN_CHAR = 0;
    	final int MAX_CHAR = 1000;

        // Declare variables
    	String message;
    	char c;
        char c1;
        char c2;
        Scanner keyboard = new Scanner(System.in);

        // Show application header
        System.out.println("Welcome to Character Methods");
        System.out.println("----------------------------\n");

        // Prompt for and get string
        System.out.print("Enter a message: ");
        message = keyboard.nextLine();

        // Trim string
        System.out.println();
        System.out.printf(
    		COLFMTS1 + COLFMTS2 + "%n", 
    		"Before trim (length):", 
    		"'" + message + "' (" + message.length() + ")");

        message = message.trim();
        System.out.printf(
    		COLFMTS1 + COLFMTS2 + "%n", 
    		"After trim:", 
    		"'" + message + "' (" + message.length() + ")");

        // Loop to list characters
        System.out.println("\nCharacter list");
        System.out.printf(
    		COLFMTS3 + COLFMTS3 + COLFMTS3 + COLFMTS3 + 
    		COLFMTS3 + COLFMTS3 + COLFMTS3 + " " + COLFMTS2 + "%n", 
    		"Index", "Char", "Ltr?", "Dgt?", 
    		"Lower?", "Upper?", "WSpace?", "Name");
        for (int i = 0; i < message.length(); i++)
        {
        	c = message.charAt(i);
            System.out.printf(
        		COLFMTD + COLFMTC + COLFMTB + COLFMTB + COLFMTB + 
        		COLFMTB + COLFMTB + " " + COLFMTS2 + "%n", 
        		i, c, Character.isLetter(c), Character.isDigit(c),
        		Character.isLowerCase(c), Character.isUpperCase(c),
        		Character.isWhitespace(c), Character.getName((int) c));
        }

        // Loop to list character names
        System.out.println("\nCharacter names");
        System.out.printf(
    		COLFMTS3 + COLFMTS3 + COLFMTS3 + " " + COLFMTS2 + "%n", 
    		"Index (dec)", "Index (hex)", "Char", "Name");
        for (int i = MIN_CHAR; i < MAX_CHAR; i++)
        {
            System.out.printf(
        		COLFMTD + COLFMTS3 + COLFMTC + " " + COLFMTS2 + "%n", 
        		i, Integer.toHexString(i).toUpperCase(),
        		(i == 9 || i == 10 || i == 13 ? ' ' : (char) i), 
        		Character.getName(i));
        }

        // Compare two characters
        System.out.println("\nCharacter comparison");
        c1 = 'o';
        c2 = 'O';
        System.out.println("Comparing '" + 
    		c1 + "' (" + Character.hashCode(c1) + ") and '" +
    		c2 + "' (" + Character.hashCode(c2) + "): " + 
    		Character.compare(c1, c2));
        c1 = '!';
        c2 = '*';
        System.out.println("Comparing '" + 
    		c1 + "' (" + Character.hashCode(c1) + ") and '" +
    		c2 + "' (" + Character.hashCode(c2) + "): " + 
    		Character.compare(c1, c2));
        c1 = 'q';
        c2 = 'q';
        System.out.println("Comparing '" + 
    		c1 + "' (" + Character.hashCode(c1) + ") and '" +
    		c2 + "' (" + Character.hashCode(c2) + "): " + 
    		Character.compare(c1, c2));
            
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Character Methods");

    } 

} 
