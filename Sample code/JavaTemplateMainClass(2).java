//======================================================================
//
// Title:      <application>
// Course:     CSC 3020
// Homework:   <number>
// Author:     <author>
// Date:       <date>
// Description:
//   <brief description of application including its inputs, processing,
// and outputs>
//
//======================================================================
package wsu.JavaTemplates;

// Import classes
import java.util.Scanner;

//======================================================================
// class JavaTemplateMainClass
//======================================================================
public class JavaTemplateMainClass
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        // int someInt;
        // double someReal;
        // String someString;
        Scanner keyboard = new Scanner(System.in);

        // Show application header
        System.out.println("Welcome to my Application!");
        System.out.println("--------------------------\n");
    
        // Display output
        System.out.println("This is the Java template - Main class, " +
            "with keyboard input.");
        System.out.println("This " + "is the Java template.");

        // keyboard.nextInt() reads token from keyboard and converts to whole number
        // keyboard.nextDouble() reads token from keyboard and converts to real number
        // keyboard.next() reads token from keyboard
        // keyboard.nextLine() reads line from keyboard through end-of-line character
            
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of my Application");

    } 

} 
