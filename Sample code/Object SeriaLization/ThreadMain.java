//======================================================================
//
// Title: Threads
// Description
//   This Java application demonstrates threads.  This is the main 
// thread.
//
//======================================================================
package wsu.Threads;

//Import classes
import java.util.Scanner;

//======================================================================
// class Threads
//======================================================================
public class ThreadMain
{

    //------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------

	// Declare formatting constants
	private static final String COLFMT1 = "%-20s";
	private static final String COLFMT2 = "%1s";
	private static final String COLFMT3 = "%-8s";
	private static final String COLFMT4 = "%-16s";

    //------------------------------------------------------------------
    // Variables
    //------------------------------------------------------------------
	private static Scanner keyboard = new Scanner(System.in);

	//------------------------------------------------------------------
    // endThreads
	//------------------------------------------------------------------
	public static void endThreads()
	{
    		
		// Loop while threads closing
    	System.out.println("[Main] Closing worker threads ...");
    	Shared.Data.workerThreadsRunning = false;
		while (Thread.currentThread().getThreadGroup().activeCount() > 1)
		{
	    	try
			{
		    	System.out.println(
	    			"[Main] Waiting for worker threads to close ...");
				Thread.sleep(Shared.Data.LOOP_PAUSE );
			} 
	    	catch (InterruptedException e)
    		{
                System.out.println("[Main] InterruptedException " +
            		"error while closing client host.");
                System.out.println("[Main] Error message: " +
            		e.getMessage());
			}
		}
    	System.out.println("[Main] All worker threads closed.");
		
	}

	//------------------------------------------------------------------
    // listThreads
	//------------------------------------------------------------------
	public static void listThreads()
	{
    	
		// Declare variables
		Thread[] threads = 
			new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		
    	// Show group thread information
	    System.out.println("\n[Main] Start of thread information");
	    System.out.printf(COLFMT1 + COLFMT2 + "%n", "Thread group:", 
    		Thread.currentThread().getThreadGroup().getName());
	    System.out.printf(COLFMT1 + COLFMT2 + "%n", "Group threads:", 
    		Thread.currentThread().getThreadGroup().activeCount());

    	// Show thread information
	    System.out.println("Group thread list:");
	    System.out.printf(COLFMT3 + COLFMT4 + COLFMT2 + "%n",
    		"ID", "State", "Name");
		Thread.currentThread().getThreadGroup().enumerate(threads);
	    for (Thread t: threads)
	    {
		    System.out.printf(COLFMT3 + COLFMT4 + COLFMT2 + "%n", 
	    		t.getId(), t.getState().toString(), t.getName());
	    }
    	System.out.println("[Main] End of thread information.");

	}
    
	//------------------------------------------------------------------
    // menuOption
	//------------------------------------------------------------------
	public static int menuOption()
    {
        
        // Declare variables
        int option;
        
        // Show menu
        System.out.println("\nThread menu");
        System.out.println("-----------");
        System.out.println("1-Start thread");
        System.out.println("2-End threads");
        System.out.println("3-List threads");
        System.out.println("9-Exit");
        System.out.print("Enter an option: ");
        return keyboard.nextInt();

    }

    //------------------------------------------------------------------
    // startThread
	//------------------------------------------------------------------
	public static void startThread()
    {

		// Declare variables
		Thread workerThread = null;
		ThreadWorker workerThreadRun = null;

		// Set worker thread flag
    	Shared.Data.workerThreadsRunning = true;

		// Start worker thread
    	workerThreadRun = new ThreadWorker();
		workerThread = new Thread(workerThreadRun, 
			"Worker Thread " + workerThreadRun.getThreadID());
		workerThread.start();

    }

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
	public static void main(String[] args)
    {

        // Declare other variables
		int option;
        
		// Initialize variables
		Thread.currentThread().setName("Main Thread");

        // Show application header
        System.out.println("Welcome to Threads");
        System.out.println("------------------");

		// Loop to process menu options
        option = menuOption();
	    while (option != 9)
	    {
	    	
	    	// Start worker thread
	    	if (option == 1)
	    		startThread();
	    	
	    	// End all threads
	    	else if (option == 2)
	    		endThreads();
	    	
	    	// List all threads
	    	else if (option == 3)
		        listThreads();	    	

	    	// Handle invalid option
	    	else
		        System.out.println("[Main] Error: unknown option '" + 
	        		option + "'.");
	    	
	    	// Get next option
			option = menuOption();
	    	
	    }
        
        // End threads and show application close
	    keyboard.close();
	    endThreads();
        System.out.println("\nEnd of Threads");
		
    }

}
