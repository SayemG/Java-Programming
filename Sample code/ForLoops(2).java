//======================================================================
//
// Title: For Loops
// Description:
//   This program demonstrates for loops.
//
//======================================================================
package wsu.ForLoops;

import java.util.HashSet;
// Import classes
import java.util.Scanner;
import java.util.Set;

//======================================================================
// class ForLoops 
//======================================================================
public class ForLoops
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
        final String COLHDRFMT1 = "%-6s";
        final String COLHDRFMT2 = "%-10s";
        final String COLHDRFMT3 = "%10s";
        final String COLDTLFMT1 = "%-6d";
        final String COLDTLFMT2 = "%-10c";
        final String COLDTLFMT3 = "%10d";

        // Declare variables
        Scanner keyboard = new Scanner(System.in);

        // Show application header
        System.out.println("Welcome to For Loops");
        System.out.println("--------------------");
    
        // Loop up from 1 to 5
        System.out.println("\nFor loop from 1 to 5");
        for (int i = 1; i <= 5; i++)
            System.out.println("i is now " + i);
        
        // Loop up from 1.2 to 2.2
        System.out.println("\nFor loop with double from 1.2 to 2.2");
        for (float i = 1.2f; i <= 2.2f; i = i + .2f)
            System.out.println("i is now " + i);

        // Loop up from 10 to 1 by 2
        System.out.println("\nFor loop from 10 to 1 by 2");
        for (int j = 10; j >= 2; j = j - 2)
            System.out.println("j is now " + j);

        // Loop up from 10 to given number
        System.out.println("\nFor loop from 10 to given number");
        System.out.print("Enter a whole number to loop from 10 to: ");
        int n;
        n = keyboard.nextInt();
        for (int k = 10; k <= n; k++)
            System.out.println("k is now " + k);
        System.out.println("Looped from 10 to " + n + ".");

        // Loop through each character in a string
        String junk;
        junk = keyboard.nextLine();  // This is needed to read past 
                                     // newline character from 
                                     // previous keyboard read
        System.out.println("\nFor loop to show each string character");
        System.out.print("Enter a string: ");
        String s;
        s = keyboard.nextLine();
        System.out.printf(COLHDRFMT1 + COLHDRFMT2 + COLHDRFMT3 + "%n",
            "#", "Character", "Unicode");
        
        // Loop using for statement
        System.out.println("\nFor statement");
        for (int m = 0; m < s.length(); m++)
            System.out.printf(COLDTLFMT1 + COLDTLFMT2 + COLDTLFMT3 + 
                "%n", m, s.charAt(m), (int) s.charAt(m));
        
        // Loop using for-each statement
        System.out.println("\nFor-each statement on string");
        char[] arrS = s.toCharArray();  // Convert string to array so iterable
        int m = 0;
        for (char c : arrS)
        {
            System.out.printf(COLDTLFMT1 + COLDTLFMT2 + COLDTLFMT3 + 
                "%n", m, c, (int) c);
            m = m + 1;
        }
        
        // Loop using for-each statement on char array
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        System.out.println("\nFor-each statement on array");
        for (char c : vowels)
            System.out.println("Vowel is " + c);
        
        // Loop using for-each statement on hash set
        Set grades = new HashSet();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");
        System.out.println("\nFor-each statement on hash set");
        for (Object o : grades)
            System.out.println("Grade is " + o);

        // Loop with continue statement to count spaces
        int spaces = 0;
        for (int i = 0; i < s.length(); i++) 
        {
             if (s.charAt(i) != ' ')
                 continue;
             spaces = spaces + 1;
         }
         System.out.println("\nString: '" + s + "'");
         System.out.println("Spaces found: " + spaces + ".");

        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of For Loops");

    }

}
