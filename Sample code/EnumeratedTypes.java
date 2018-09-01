//======================================================================
//
// Title: Enumerated Types
// Description:
//   This program demonstrates enumerated types.
//
//======================================================================
package wsu.EnumeratedTypes;

//Import classes
import java.util.Scanner;

//======================================================================
// class EnumeratedTypes
//======================================================================
public class EnumeratedTypes
{

    //------------------------------------------------------------------
    // Enumerated types
    //------------------------------------------------------------------
    enum Seasons {WINTER, SPRING, SUMMER, FALL};
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        Seasons s;
        String favorite;

        // Show application header
        System.out.println("Welcome to Enumerated Types");
        System.out.println("---------------------------");

        // Set season variable
        s = Seasons.FALL;
        System.out.println ("\nVariable s is now '" + s + 
        		"' and its ordinal value is " + s.ordinal());
        s = Seasons.SPRING;
        System.out.println ("Variable s is now '" + s + 
        		"' and its ordinal value is " + s.ordinal());

        // Loop to list each value in Seasons
        System.out.println ();
        for (Seasons y: Seasons.values())
            System.out.println ("Seasons value is '" + y + 
            		"' and its ordinal value is " + y.ordinal());

        // Prompt user for favorite season
        System.out.print ("\nEnter your favorite season: ");
        favorite = keyboard.next();
        favorite = favorite.toUpperCase();
        
        // Check if season valid
        try
        {
            
            // Attempt to convert string to season
            s = Seasons.valueOf(favorite);
            System.out.println ("\nYour favorite season is " + s);

        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: '" + favorite + 
            		"' is an invalid season.");
        }

        // Close keyboard
        keyboard.close();
            
        // Show application close
        System.out.println("\nEnd of Enumerated Types");

    }

}
