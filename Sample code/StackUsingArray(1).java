//======================================================================
//
// Title: Stack Using Array
// Description:
// 	 This program demonstrates a stack data structure implemented with 
// an array.
//
//======================================================================
package StackUsingArray;

//Import classes
import java.util.Arrays;
import java.util.Scanner;

//======================================================================
// class StackUsingArray
//======================================================================
public class StackUsingArray
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final int ARRAY_SIZE = 3;
	private static final String EMPTY_MAKE = "~";
	private static final String COLFMTS1 = "%-8s";
	private static final String COLFMTS2 = "%-16s";
	private static final String COLFMTD = "%-8d";

    // Declare variables
	private static String[] makes = new String[ARRAY_SIZE]; 
	private static String[] models = new String[ARRAY_SIZE]; 
	private static int top = -1;

	//------------------------------------------------------------------
    // pushCar
	//------------------------------------------------------------------
	private static String pushCar() 
	{
		
		// Declare variables
        Scanner keyboard = new Scanner(System.in);
		String make;
		String model;
	    
        // Prompt for and read make and model
        System.out.println("\nCar push");
        System.out.print("Enter the car make: ");
        make = keyboard.nextLine();
        System.out.print("Enter the car model: ");
        model = keyboard.nextLine();
	    
        // Test if array needs resizing
		if (top == (makes.length - 1))
		{
			makes = Arrays.copyOf(makes, models.length * 2);
			models = Arrays.copyOf(models, models.length * 2);
	        System.out.println("Car array doubled in size to " + 
        		makes.length + " elements.");
		}

        // Update top and push car
        top = top + 1;
        makes[top] = make;
        models[top] = model;
        return make + " " + model;
		
	}

	//------------------------------------------------------------------
    // popCar
	//------------------------------------------------------------------
	private static String popCar()
	{

		// Declare variables
		String make;
		String model;
		
		// Test if stack is empty
        System.out.println("\nCar pop");
		if (top == -1)
			return EMPTY_MAKE;
		else
		{

	        // Pop car and update top
			model = models[top];
			make = makes[top];
			top = top - 1;
	        return make + " " + model;

		}

	}

	//------------------------------------------------------------------
    // listCars
	//------------------------------------------------------------------
	private static void listCars() 
	{
		
		// Loop to print cars
        System.out.println("\nCar stack");
    	System.out.printf(COLFMTS1 + COLFMTS2 + COLFMTS2 + "%n", 
			"Index", "Make", "Model");
        for (int i = top; i >= 0; i--)
        {
        	System.out.printf(COLFMTD + COLFMTS2 + COLFMTS2, i, 
    			makes[i], models[i]);
			if (i == top)
				System.out.println("    <--- top");
			else
				System.out.println();
        }
		
		// Show stack count
        System.out.println("Cars in stack: " + (top + 1));
			
	}

	//------------------------------------------------------------------
    // menuOption
	//------------------------------------------------------------------
    private static int menuOption()
    {
        
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        int option;
        
        // Show menu
        System.out.println("\nStack Manager Menu");
        System.out.println("------------------");
        System.out.println("1 - Push car");
        System.out.println("2 - Pop car");
        System.out.println("3 – List cars");
        System.out.println("9 - Exit");
        
        // Prompt for and get menu option
        System.out.print("\nEnter an option: ");
        option = keyboard.nextInt();
        return option;

    }

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
	public static void main (String[] args)
    {

		// Declare variables
		int option;
		String car;
		
        // Show application header
        System.out.println("Welcome to Stack Using Array");
        System.out.println("----------------------------");
        
		// Loop to process menu options
		option = menuOption();
	    while (option != 9)
	    {
	    	
	    	// Test if "push" option
	    	if (option == 1)
	    	{
	    		
	    		// Show pushed car model and show stack count
	    		car = pushCar();
	            System.out.println("Pushed car: " + car);
	            System.out.println("Cars in stack: " + (top + 1));

	    	}
	    	
	    	// Test if "pop" option
	    	else if (option == 2)
	    	{
	    		
	    		// Test if car model to pop
	    		car = popCar();
	            if (car.equals(EMPTY_MAKE))
	            	System.out.println("Nothing to pop.  The car " +
            			"stack is empty.");
	            else
	            {

		    		// Show popped car model and stack count
	            	System.out.println("Popped car: " + car);
		            System.out.println("Cars in stack: " + (top + 1));

	            }
	    	
	    	}
	    	
	    	// Test if "list" option
	    	else if (option == 3)
	    		listCars();
	    	
	    	// Handle invalid option
	    	else
		        System.out.println("Error: unknown option '" + 
	        		option + "'.");
	    	
	    	// Get next option
			option = menuOption();
			
	    }

        // Show application close
        System.out.println("\nEnd of Stack Using Array");

    }

}
