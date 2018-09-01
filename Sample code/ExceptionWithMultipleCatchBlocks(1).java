//======================================================================
//
// Title: Exceptions With Multiple Catch Blocks
// Description:
//   This program demonstrates an exception caught by multiple catch 
// blocks.
//
//======================================================================
package wsu.ExceptionWithMultipleCatchBlocks;

// Import classes
import java.util.Scanner;

//======================================================================
// class ExceptionWithMultipleCatchBlocks
//======================================================================
public class ExceptionWithMultipleCatchBlocks
{
    
	//------------------------------------------------------------------
    // main
	//------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
    	boolean numberBad;
    	String s_num = "";
    	int num1;
    	int num2;
    	int result;

		// Show application header
		System.out.println("Welcome to Exceptions, Multiple Catch Blocks");
		System.out.println("--------------------------------------------");

		// Loop to handle multiple exceptions
		numberBad = true;
		while (numberBad)
		{
			try
			{
				
				// Prompt for and get numerator and denominator
				System.out.print("\nEnter a whole number numerator: ");
				s_num = keyboard.next();
				num1 = Integer.parseInt(s_num);
				System.out.print("Enter a whole number denominator: ");
				s_num = keyboard.next();
				num2 = Integer.parseInt(s_num);
				
				// Divide numerator by denominator
				result = num1 / num2;
				System.out.printf("%n%-24s%8d%n", "Numerator:",
					num1);
				System.out.printf("%-24s%8d%n", "Denominator:", 
					num2);
				System.out.printf("%-24s%8d%n", 
					"Quotient (truncated):",  result);
				numberBad = false;

			}
			
			// Catch invalid number errors
			catch (NumberFormatException e1)
			{
				System.out.println("Error: '" + s_num + 
					"' is not a valid whole number.");
				System.out.println("Exception message:\n" + 
					e1.getMessage());
			}
			
			// Catch divide-by-zero errors
			catch (ArithmeticException e2)
			{
				System.out.println("Error: cannot divide by zero.");
				System.out.println("Exception message:\n" + 
					e2.getMessage());
			}
			
			// Catch any other RuntimeException errors
			catch (RuntimeException e3)
			{
				System.out.println("Error: some type of " +
					"RuntimeException error.");
				System.out.println("Exception message:\n" + 
					e3.getMessage());
			}
			
			// Catch any other Exception errors
			catch (Exception e4)
			{
				System.out.println("Error: some type of " +
					"Exception error.");
				System.out.println("Exception message:\n" + 
					e4.getMessage());
			}
			
			// Catch any other Throwable errors
			catch (Throwable e5)
			{
				System.out.println("Error: some type of " +
					"Throwable error.");
				System.out.println("Exception message:\n" + 
					e5.getMessage());
			}

		}
    	
        // Close keyboard
        keyboard.close();

		// Show application close
		System.out.println("\nEnd of Exceptions, Multiple Catch Blocks");

    }

}
