//======================================================================
//
// Title: Queue Using Array
// Description:
// 	 This program demonstrates a queue data structure 
// implemented with an array.
//
//======================================================================
package QueueUsingArray;

//Import classes
import java.util.Arrays;
import java.util.Scanner;

//======================================================================
// class QueueUsingArray
//======================================================================
public class QueueUsingArray
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare constants
	private static final int ARRAY_SIZE = 3;
	private static final String EMPTY_MAKE = "~";

    // Declare variables
	private static String[] models = new String[ARRAY_SIZE]; 
	private static int head = -1;
	private static int tail = -1;

	//------------------------------------------------------------------
    // insertCarModel
	//------------------------------------------------------------------
	private static void insertCarModel() 
	{
		
		// Declare variables
        Scanner keyboard = new Scanner(System.in);
		String m;
		int prevSize;
	    
        // Prompt for and read model
        System.out.println("\nCar model insert");
        System.out.print("Enter the model to insert: ");
        m = keyboard.nextLine();
	    
        // Test if array needs resizing
		if (modelCount() == models.length)
		{
			
			// Resize array
			prevSize = models.length;
			models = Arrays.copyOf(models, models.length * 2);
	        System.out.println("Car model array doubled in size to " + 
	        		models.length + " elements.");
			
			// Test whether to reorder so tail after head
	        if (tail < head)
	        	for (int i = 0; i <= tail; i++)
	        		models[prevSize + i] = models[i];
	        tail = prevSize + tail;
	        
		}

        // Update head and tail pointers
		if (head == -1)
		{
			head = 0;
			tail = 0;
		}
		else
			tail = incrementPointer(tail);

        // Insert model
        models[tail] = m;
		
	}

	//------------------------------------------------------------------
    // removeCarModel
	//------------------------------------------------------------------
	private static String removeCarModel()
	{

		// Declare variables
		String removedMake;
		
		// Test if queue is empty
        System.out.println("\nCar model remove");
		if (head == -1)
			return EMPTY_MAKE;
		else
		{

	        // Remove model
			removedMake = models[head];

	        // Update head and tail pointers
			if (head == tail)
			{
				head = -1;
				tail = -1;
			}
			else
				head = incrementPointer(head);
	        return removedMake;
	        
		}

	}

	//------------------------------------------------------------------
    // listCarModels
	//------------------------------------------------------------------
	private static void listCarModels() 
	{

		// Declare variables
		int ptr;
		
		// Test if models in queue
        System.out.println("\nCar model queue");
        if (head != -1)
        {
			if (head == tail)
			{
	        	System.out.printf("%-6d%-20s", head, models[head]);
				System.out.println("    <--- head and tail");
			}
			else
			{

				// Loop to show rest of queue
	        	ptr = head;
	        	while (ptr != tail)
	        	{
	            	System.out.printf("%-6d%-20s", ptr, models[ptr]);
	    			if (ptr == head)
	    				System.out.println("    <--- head");
	    			else
	    				System.out.println();
	            	ptr = incrementPointer(ptr);
	        	}

				// Show queue tail
	        	System.out.printf("%-6d%-20s", tail, models[tail]);
				System.out.println("    <--- tail");
				
			}
        	
        }
		
		// Show queue count
        System.out.println("Car models in queue: " + modelCount());
			
	}

	//------------------------------------------------------------------
    // incrementPointer
	//------------------------------------------------------------------
    private static int incrementPointer(int ptr)
	{
    	
    	// Increment pointer and test if beyond array
		ptr = ptr + 1;
		if (ptr == models.length)
			ptr = 0;
		return ptr;
		
	}

	//------------------------------------------------------------------
    // modelCount
	//------------------------------------------------------------------
    private static int modelCount()
	{
    	if (head == -1)
    		return 0;
    	else if (head <= tail)
			return (tail - head + 1);
		else
			return (models.length - head) + (tail + 1);
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
        System.out.println("\nQueue Manager Menu");
        System.out.println("------------------");
        System.out.println("1 - Insert car model");
        System.out.println("2 - Remove car model");
        System.out.println("3 – List car models");
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
		String removedMake;
		
        // Show application header
        System.out.println("Welcome to Queue Using Array");
        System.out.println("----------------------------");
        
		// Loop to process menu options
		option = menuOption();
	    while (option != 9)
	    {
	    	
	    	// Test if "insert" option
	    	if (option == 1)
	    	{
	    		
	    		// Insert car model and show queue count
	    		insertCarModel();
	            System.out.println("Inserted car model: " + 
            		models[tail]);
	            System.out.println("Car models in queue: " + 
            		modelCount());

	    	}
	    	
	    	// Test if "remove" option
	    	else if (option == 2)
	    	{
	    		
	    		// Test if car model to remove
	    		removedMake = removeCarModel();
	            if (removedMake.equals(EMPTY_MAKE))
	            	System.out.println("Nothing to remove.  The car " +
            			"model queue is empty.");
	            else
	            {

		    		// Show removed car model and queue count
	            	System.out.println("Removed car model: " + 
            			removedMake);
		            System.out.println("Car models in queue: " + 
	            		modelCount());

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

        // Show application close
        System.out.println("\nEnd of Queue Using Array");

    }

}
