//======================================================================
//
// Class: Thread Worker
// Description:
//   This Java class represents a worker thread.  It is spawned by the 
// main thread.
//
//======================================================================
package wsu.Threads;

//Import classes
import java.io.BufferedReader;
import java.net.Socket;

//======================================================================
// class ThreadWorker
//======================================================================
public class ThreadWorker implements Runnable
{

    //------------------------------------------------------------------
    // Variables
    //------------------------------------------------------------------
	private Socket serverClientSocket;
	private static int threadCount = 0;
	private int threadID;

    //------------------------------------------------------------------
    // Constructors
    //------------------------------------------------------------------
    ThreadWorker()
	{
		threadCount = threadCount + 1;
		threadID = threadCount;
    	System.out.println("[" + threadID + "] Thread " + threadID + 
			" has started ...");
	}

    //------------------------------------------------------------------
    // getThreadID
    //------------------------------------------------------------------
	public int getThreadID() 
	{
		return threadID;
	}

    //------------------------------------------------------------------
    // run
    //------------------------------------------------------------------
	@Override
	public void run()
	{
		while (Shared.Data.workerThreadsRunning)
		{
	    	try
			{
		    	System.out.println("[" + threadID + "] Thread " + 
	    			threadID + " is running ...");
				Thread.sleep(Shared.Data.LOOP_PAUSE);
			} 
	    	catch (InterruptedException e)
    		{
                System.out.println("[" + threadID + "] " +
            		"InterruptedException error while thread running.");
                System.out.println("[" + threadID + "] Error " +
            		"message: " + e.getMessage());
			}
		}
    	System.out.println("[" + threadID + "] Thread " + threadID + 
			" has ended.");
		
	}

}
