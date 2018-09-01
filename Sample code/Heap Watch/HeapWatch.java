//======================================================================
//
// Title: Heap Watch
// Description:
//   This program monitors heap memory as objects are created and 
// deleted.
//
//======================================================================
package wsu.HeapWatch;

//======================================================================
// class HeapWatch
//======================================================================
public class HeapWatch
{

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {
    	
    	// Declare constants
    	final int ARRAY_SIZE = 100000;
    	final String COLFMTS = "%26s";
    	final String COLFMTD = "%,26d";
    	
    	// Declare variables
    	long prevBytes;
    	long bytes;
    	int objects;
    	Car cars[] = new Car[ARRAY_SIZE];

        // Show application header
        System.out.println("Welcome to Heap Watch");
        System.out.println("---------------------\n");

        // Get initial free memory and show headings
        prevBytes = Runtime.getRuntime().freeMemory();
        System.out.println("Creating objects ...");
        System.out.printf(COLFMTS + COLFMTS + COLFMTS + "%n", 
    		"Objects", "Free memory (bytes)", "Memory change (bytes)");
        System.out.printf(COLFMTD + COLFMTD + "%n", 0, prevBytes);
        
        // Loop to create objects
    	objects = 0;
        for (int i = 0; i < ARRAY_SIZE; i++)
        {
        	
        	// Create object and increment object count
        	cars[i] = new Car("Ford", "Edge", 25, 9.87);
        	objects = objects + 1;
        	
        	// Get free byte count
        	bytes = Runtime.getRuntime().freeMemory();
        	if (bytes != prevBytes) 
        		System.out.printf(COLFMTD + COLFMTD + COLFMTD + "%n", 
    				objects, bytes, (bytes - prevBytes));
        	prevBytes = bytes;
        	
        }

        // Show headings
        System.out.println("Deleting objects ...");
        System.out.printf(COLFMTS + COLFMTS + COLFMTS + "%n", 
    		"Objects", "Free memory (bytes)", "Memory reclaimed (bytes)");
        
        // Loop to delete objects
        for (int i = ARRAY_SIZE - 1; i >= 0; i--)
        {
        	
        	// Delete object and decrement object count
        	cars[i] = null;
        	objects = objects - 1;
        	
        	// Test whether to run garbage collection
        	if (i % 1000 == 0)
    		{
            	prevBytes = Runtime.getRuntime().freeMemory();
        		Runtime.getRuntime().gc();
            	bytes = Runtime.getRuntime().freeMemory();
        		System.out.printf(COLFMTD + COLFMTD + COLFMTD + "%n", 
    				objects, bytes, (bytes - prevBytes));
    		}

        }

        // Show application close
        System.out.println("\nEnd of Heap Watch");

    }

}
