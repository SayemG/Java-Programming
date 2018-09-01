//======================================================================
//
// Title: argsArray
// Description:
//   This program demonstrates the args array that stores parameters 
// passed into the program.
//
//======================================================================
package wsu.argsArray;

//======================================================================
// class argsArray
//======================================================================
public class argsArray
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Show application header
        System.out.println("Welcome to argsArray");
        System.out.println("---------------------\n");
    
        // Show argument count and arguments
        System.out.println("Number of arguments passed into program: " +
        	args.length);
        for (int i = 0; i < args.length; i++)
            System.out.println(i + ": " + args[i]);

        // Show application close
        System.out.println("\nEnd of argsArray");

    } 

} 
