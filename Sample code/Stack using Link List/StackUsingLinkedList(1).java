//======================================================================
//
// Title: Stack Using Linked List
// Description:
// 	 This program demonstrates a stack data structure implemented with a
// linked list.
//
//======================================================================
package wsu.StackUsingLinkedList;

//Import classes
import java.util.Scanner;

//======================================================================
// class StackUsingLinkedList
//======================================================================
public class StackUsingLinkedList
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final String COLFMTS = "%-16s";

    // Declare variables
	private static Car top = null;
	private static Scanner keyboard = new Scanner(System.in);

	//------------------------------------------------------------------
    // pushCar
	//------------------------------------------------------------------
	private static Car pushCar() 
	{
		
		// Declare variables
		String make;
		String model;
		Car ptr;
	    
        // Prompt for and read make and model
        System.out.println("\nCar push");
        System.out.print("Enter the car make: ");
        make = keyboard.nextLine();
        System.out.print("Enter the car model: ");
        model = keyboard.nextLine();

        // Create car node and push on stack
        ptr = new Car(make, model, top);
        top = ptr;
        return ptr;
		
	}

	//------------------------------------------------------------------
    // popCar
	//------------------------------------------------------------------
	private static Car popCar()
	{

		// Declare variables
		Car ptr;
		
		// Test if stack is empty
        System.out.println("\nCar pop");
		if (top == null)
			return null;
		else
		{

	        // Pop car and update top
	        ptr = top;
			top = top.getNext();
	        return ptr;

		}

	}

	//------------------------------------------------------------------
    // listCarModels
	//------------------------------------------------------------------
	private static void listCarModels() 
	{
		
		// Declare variables
		Car ptr = top;
		int count = 0;
		
		// Loop to print cars
        System.out.println("\nCar stack");
    	System.out.printf(COLFMTS + COLFMTS + "%n", "Make", "Model");
		while (ptr != null)
		{
	    	System.out.printf(COLFMTS + COLFMTS, ptr.getMake(), 
    			ptr.getModel());
			if (ptr == top)
				System.out.println("    <--- top");
			else
				System.out.println();
			ptr = ptr.getNext();
			count = count + 1;
		}
		
		// Show stack count
        System.out.println("Car models in stack: " + count);
			
	}

	//------------------------------------------------------------------
    // menuOption
	//------------------------------------------------------------------
    private static int menuOption()
    {
        
        // Declare variables
        int option;
        String junk;
        
        // Show menu
        System.out.println("\nStack Manager Menu");
        System.out.println("------------------");
        System.out.println("1 - Push car model");
        System.out.println("2 - Pop car model");
        System.out.println("3 – List car models");
        System.out.println("9 - Exit");
        
        // Prompt for and get menu option
        System.out.print("\nEnter an option: ");
        option = keyboard.nextInt();
        junk = keyboard.nextLine();
        return option;

    }

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
	public static void main (String[] args)
    {

		// Declare variables
		int option;
		Car car;
		int count = 0;
		
        // Show application header
        System.out.println("Welcome to Stack Using Linked List");
        System.out.println("----------------------------------");
        
		// Loop to process menu options
		option = menuOption();
	    while (option != 9)
	    {
	    	
	    	// Test if "push" option
	    	if (option == 1)
	    	{
	    		
	    		// Show pushed car model and show stack count
	    		car = pushCar();
	            System.out.println("Pushed car: " + car.getMake() + 
            		" " + car.getModel());
	    		count = count + 1;
	            System.out.println("Car models in stack: " + count);

	    	}
	    	
	    	// Test if "pop" option
	    	else if (option == 2)
	    	{
	    		
	    		// Test if car model to pop
	    		car = popCar();
	            if (car == null)
	            	System.out.println("Nothing to pop.  The car " +
            			"model stack is empty.");
	            else
	            {

		    		// Show popped car model and stack count
	            	System.out.println("Popped car: " + car.getMake() + 
		            		" " + car.getModel());
		    		count = count - 1;
		            System.out.println("Car models in stack: " + count);

	            }
	    	
	    	}
	    	
	    	// Test if "list" option
	    	else if (option == 3)
	    		listCarModels();
	    	
	    	// Handle invalid option
	    	else
		        System.out.println("Error: unknown option '" + 
	        		option + "'.");
	    	
	    	// Get next option
			option = menuOption();
			
	    }
	       
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Stack Using Linked List");

    }

}
