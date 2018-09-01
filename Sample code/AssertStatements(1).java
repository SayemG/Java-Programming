//======================================================================
//
// Title: Assert Statements
// Description:
//   This program demonstrates the Assert statement.
//
//======================================================================
package wsu.AssertStatements;

// Import classes
import java.util.Scanner;

//======================================================================
// class AssertStatements
//======================================================================
public class AssertStatements
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        int num;

        // Show application header
        System.out.println("Welcome to Assert Statements");
        System.out.println("----------------------------");

        // Prompt for and get number
        System.out.print("\nEnter whole number 1: ");
        num = keyboard.nextInt();
        assert num != 0;
        System.out.println("5 / " + num + " = " + (5 / num));

        // Prompt for and get number
        System.out.print("\nEnter whole number 2: ");
        num = keyboard.nextInt();
        assert num != 0 : "Cannot divide by zero.";
        System.out.println("5 / " + num + " = " + (5 / num));
        
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Assert Statements");

    }

}
