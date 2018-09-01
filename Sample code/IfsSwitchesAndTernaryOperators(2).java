//======================================================================
//
// Title: Ifs, Switches, and Ternary Operators
// Description:
//   This program demonstrates the if and switch statements, and the 
// ternary operator.
//
//======================================================================
package wsu.IfsSwitchesAndTernaryOperators;

// Import classes
import java.util.Random;
import java.util.Scanner;

//======================================================================
// class IfsSwitchesAndTernaryOperators
//======================================================================
public class IfsSwitchesAndTernaryOperators
{

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        Scanner keyboard = new Scanner(System.in);

        // Show application header
        System.out.println("Welcome to Ifs, Switches, and Ternary " +
    		"Operators");
        System.out.println("--------------------------------------" +
    		"---------");

        // Test whether a number is positive or not
        System.out.println("\nIf 1 (i)");
        System.out.print("Enter a whole number: ");
        int i;
        i = keyboard.nextInt();
        if (i > 0)
            System.out.println(i + " is a positive number.");
        else
            System.out.println(i + " is NOT a positive number.");

        // Test whether a number is even or odd
        System.out.println("\nIf 2 (j)");
        System.out.print("Enter a whole number: ");
        int j;
        j = keyboard.nextInt();
        if (j % 2 == 0)
            System.out.println(j + " is an even number.");
        else
            System.out.println(j + " is an odd number.");

        // Test whether a number is within a range or not
        System.out.println("\nIf 3 (k)");
        System.out.print("Enter a whole number in the range 1-100: ");
        double k;
        k = keyboard.nextDouble();
        if (k < 0)
            System.out.println(k + " is less than range 0-100.");
        else if (k <= 100)
            System.out.println(k + " is within range 0-100.");
        else
            System.out.println(k + " is greater than range 0-100.");

        // Test whether user entered "Wendy" or not
        String junk;
        junk = keyboard.nextLine();  // This is needed to read past 
                                     // newline character from 
                                     // previous keyboard read
        System.out.println("\nIf 4");
        System.out.print("Enter a name: ");
        String name;
        name = keyboard.nextLine();
        if (name.equals("Wendy"))
            System.out.println("'" + name + 
        		"' is the name we were looking for.");
        else
            System.out.println("'" + name + 
        		"' is NOT the name we were looking for.");

        // Test which name entered
        System.out.println("\nSwitch 1");
        System.out.print("Enter a city: ");
        String city;
        city = keyboard.next().toLowerCase();
        switch (city)
        {
            case "dearborn":
                System.out.println("Dearborn was incorporated as a " +
            		"city in 1927.");
                break;
            case "detroit":
                System.out.println("Detroit was incorporated as a " +
            		"city in 1806.");
                break;
            case "windsor":
                System.out.println("Windsor was incorporated as a " +
            		"city in 1854.");
                break;
            default:
                System.out.println("There is no information for '" + 
            		city + "'.");
        }

        // Test which gas type entered
        System.out.println("\nSwitch 2");
        System.out.print("Enter a gas type (r-regular, " +
    		"m-mid-grade, p-premium): ");
        String type;
        type = keyboard.next().toLowerCase();
        char t;
        t = type.charAt(0);
        switch (t)
        {
            case 'r':
                System.out.println("Gas type 'regular' has an " +
            		"octane rating of 87.");
                break;
            case 'm':
                System.out.println("Gas type 'mid-grade' has an " +
            		"octane rating of 89.");
                break;
            case 'p':
                System.out.println("Gas type 'premium' has an " +
            		"octane rating of 92.");
                break;
            default:
                System.out.println("'" + t + "' is an unknown gas type.");
        }

        // Test which number rolled on die
        System.out.println("\nSwitch 3");
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;  // Random number from 1 to 6
        switch (n)
        {
            case 1:
                System.out.println("Rolled a 1.");
                break;
            case 2:
                System.out.println("Rolled a 2.");
                break;
            case 3:
                System.out.println("Rolled a 3.");
                break;
            case 4:
                System.out.println("Rolled a 4.");
                break;
            case 5:
                System.out.println("Rolled a 5.");
                break;
            case 6:
                System.out.println("Rolled a 6.");
                break;
            default:
                System.out.println("'" + n + 
            		"' is an unknown die number.");
        }

        // Test if even number rolled on die
        System.out.println("\nSwitch 4");
        switch (n)
        {
            case 2: case 4: case 6:
                System.out.println("Even number rolled.");
                break;
            default:
                System.out.println("Odd number rolled.");
        }

        // Test use ternary operator
        System.out.println("\nTernary operators");
        
        System.out.println("Die test:    " + 
        		(n <= 3 ? "<= 3" : "> 3"));
        
        k = (k != 0 ? 10 / k : -999);
        System.out.println("10/k:        " + k);

        System.out.println("Name test:   " + 
    		(name.equalsIgnoreCase("Wendy") ? "it's Wendy!" : "it's NOT Wendy"));
        
        System.out.println("Octane test: " + 
    		(t == 'r' ? 87 : (t == 'm' ? 89 : (t == 'p' ? 92 : "unknown"))));
          
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Ifs, Switches, and Ternary " +
    		"Operators");

    }

}
