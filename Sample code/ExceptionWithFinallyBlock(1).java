//======================================================================
//
// Title: Exception With Finally Block
// Description:
//   This program demonstrates an exception with a finally 
// block.
//
//======================================================================
package wsu.ExceptionWithFinallyBlock;

// Import classes
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//======================================================================
// class ExceptionWithFinallyBlock
//======================================================================
public class ExceptionWithFinallyBlock
{
    
	//------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------
    public static final String FILE_NAME = "USStateCapitals.txt";
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner fileIn = null;
        int line;
        String[] states = new String[50];

		// Show application header
		System.out.println("Welcome to Exceptions, Finally Block");
		System.out.println("------------------------------------");
    
		// Attempt to open input file
		try
		{

	        // Open input file
			fileIn = new Scanner(new FileInputStream(FILE_NAME));

	        // Loop to read US state capitals
			line = 0;
	        while (fileIn.hasNextLine())
	        {
	            // Read and write US state capital
	            states[line] = fileIn.nextLine();
	            line = line + 1;
	        }
	        System.out.println("\n" + line + 
        		" line(s) read from file '" + FILE_NAME + 
        		"' and stored in an array.");

		}
		catch (FileNotFoundException e)
		{
            System.out.println("\nError: file '" + FILE_NAME + 
        		"' not found.");
			System.out.println("Exception message:\n" + 
        		e.getMessage());
		}
		finally
		{
			
			// Test if file handle created
            if (fileIn == null) 
            {
                System.out.println("File handle not created.");
            }
            else 
            { 
        		fileIn.close();
                System.out.println("File handle closed.");
            } 

		}

		// Show application close
		System.out.println("\nEnd of Exceptions, Finally Block");

    } 

} 
