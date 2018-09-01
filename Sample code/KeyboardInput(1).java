//======================================================================
//
// Title: Keyboard Input
// Description:
//   This program demonstrates reading from the keyboard.
//
//======================================================================
package wsu.KeyboardInput;

// Import classes
import java.util.Scanner;

//======================================================================
// class KeyboardInput
//======================================================================
public class KeyboardInput
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);  // Connect to keyboard

        // Show application header
        System.out.println("Welcome to Keyboard Input");
        System.out.println("-------------------------");

        // Read an integer
        // nextInt() reads next token from keyboard and converts to 
        // whole number
        System.out.print("\nEnter a whole number: ");
        int i = keyboard.nextInt();
        System.out.println("The number you entered was " + i + ".");
        
        // Read a real number
        // nextDouble() reads next token from keyboard and converts to
        // real number
        System.out.print("\nEnter a real number: ");
        double d = keyboard.nextDouble();
        System.out.println("The number you entered was " + d + ".");
    
        // Read a word
        // next() reads next token from keyboard
        System.out.print("\nEnter a word: ");
        String s1 = keyboard.next();
        System.out.println("The word you entered was '" + s1 + "'.");
        String junk = keyboard.nextLine(); // Need this to read past
                                           // current end-of-line
    
        // Read a line
        // nextLine() reads next line from keyboard, through 
        // end-of-line character
        System.out.println("\nEnter a line: ");
        String s2 = keyboard.nextLine();
        System.out.println("The line you entered was '" + s2 + "'.");
       
        // Close keyboard
        keyboard.close();

        // Read an integer using second keyboard object
        // This cannot be done since the close() of the first keyboard 
        // object also closes System.in.  You can only use close() ONCE
        // in a Java application.  Two solutions:
        // -Pass the keyboard object around as an argument.
        // -Declare the keyboard object as a field (fields are global).
//        Scanner keyboard2 = new Scanner(System.in);  // Connect to keyboard
//        System.out.print("\nEnter a whole number: ");
//        int j = keyboard2.nextInt();
//        System.out.println("The number you entered was " + j + ".");
//        keyboard2.close();

        // Show application close
        System.out.println("\nEnd of Keyboard Input");

    } 

} 
