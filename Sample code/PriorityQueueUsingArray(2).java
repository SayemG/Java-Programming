//======================================================================
//
// Title: Priority Queue Using Array
// Description:
// 	 This program demonstrates a priority queue data structure 
// implemented with:
//   -An ordered array.
//   -An unordered array.
//   -A heap.
// In the ordered and heap data structures, data is stored in descending 
// order.
//
//======================================================================
package wsu.PriorityQueueUsingArray;

//Import classes
import java.util.Arrays;
import java.util.Random;

//======================================================================
// class PriorityQueueUsingArray
//======================================================================
public class PriorityQueueUsingArray
{
    
    //==================================================================
    // Fields
    //==================================================================
    
	// Declare constants
	private static final int MAX_NODES = 100;  
		// 100 thousand takes ~15 seconds; 
		// 1 million takes ~25 minutes but heap portion takes < 1 second
	private static final int RAND_UPPER_LIMIT = MAX_NODES * 10;
	private static final int MAX_PRINT = -1;
	private static final String COLFMTS1 = "%-20s";
	private static final String COLFMTS2 = "%14s";
	private static final String COLFMTD1 = "%,14d";
	private static final String COLFMTD2 = "%6d";
	private static final String COLFMTD3 = "%,1d";

    // Declare ordered variables
	private static int[] qOrdered = new int[1]; 
	private static int qOrderedCount = 0; 
	private static int qOrderedLevel = 1;
	private static int qOrderedHead = -1;
	private static int qOrderedTail = -1;

    // Declare ordered variables
	private static int[] qUnordered = new int[1]; 
	private static int qUnorderedCount = 0; 
	private static int qUnorderedLevel = 1;
	private static int qUnorderedHead = -1;
	private static int qUnorderedTail = -1;

    // Declare ordered variables
	private static int[] qHeap = new int[1]; 
	private static int qHeapCount = 0; 
	private static int qHeapLevel = 1;

	//------------------------------------------------------------------
    // listNodes
	//------------------------------------------------------------------
	private static void listNodes(String type, int[] queue, int count, 
		int head, int tail, boolean print) 
	{

		// Declare variables
		int ptr;
		
		// Test if array small enough to print
		if (count <= MAX_PRINT || print)
		{
			
			// Test if models in queue
	        System.out.printf(COLFMTS1, type + "[" + queue.length + 
        		" " + count + " " + head + " " + tail + "]: ");
	        if (head != -1)
	        {

				// Loop to show queue
	        	ptr = head;
	        	while (ptr != tail)
	        	{
	            	System.out.printf(COLFMTD2, queue[ptr]);
	            	ptr = incrementPointer(ptr);
	        	}
	        	System.out.printf(COLFMTD2, queue[ptr]);
	        	
	        }
	        System.out.println();
			
		}
			
	}

	//------------------------------------------------------------------
    // listHeapNodes
	//------------------------------------------------------------------
	private static void listHeapNodes(boolean print)
	{
		
		// Test if array small enough to print
		if (qHeapCount <= MAX_PRINT || print)
		{

	        System.out.printf(COLFMTS1, "Heap[" + qHeap.length + " " + 
	    		qHeapCount + "]: ");
	        for (int i = 0; i < qHeapCount; i++)
	        	System.out.printf(COLFMTD2, qHeap[i]);
	        System.out.println();
		}

	}

	//------------------------------------------------------------------
    // incrementPointer
	//------------------------------------------------------------------
    private static int incrementPointer(int ptr)
	{
    	
    	// Increment pointer and test if beyond array
		ptr = ptr + 1;
		if (ptr == qOrdered.length)
			ptr = 0;
		return ptr;
		
	}

	//------------------------------------------------------------------
    // decrementPointer
	//------------------------------------------------------------------
    private static int decrementPointer(int ptr)
	{
    	
    	// Decrement pointer and test if beyond array
		ptr = ptr - 1;
		if (ptr == -1)
			ptr = qOrdered.length - 1;
		return ptr;
		
	}

	//------------------------------------------------------------------
    // insertValueOrdered
	//------------------------------------------------------------------
    private static void insertValueOrdered(int value)
	{
		
    	// Declare variables
		int prevSize;
		int addCount;
		int curr;
		int prev;
		int copyLeft;
		int copyRight;
	    
        // Test if array needs resizing
		if (qOrderedCount == qOrdered.length)
		{
			
			// Resize array
			prevSize = qOrdered.length;
			addCount = (int) Math.pow(2, qOrderedLevel);
			qOrderedLevel = qOrderedLevel + 1;
			qOrdered = Arrays.copyOf(qOrdered, qOrdered.length + 
				addCount);
//	        System.out.println("qOrdered array increased by " + 
//        		addCount + " elements.");
			
			// Test whether to reorder so qOrderedTail after qOrderedHead
	        if (qOrderedTail < qOrderedHead)
	        {
	        	for (int i = 0; i <= qOrderedTail; i++)
	        		qOrdered[prevSize + i] = qOrdered[i];
	        	qOrderedTail = prevSize + qOrderedTail;
	        }
	        
		}
		
		// Increment count
		qOrderedCount = qOrderedCount + 1;

        // Test if queue empty
		if (qOrderedHead == -1)
		{
			qOrderedHead = 0;
			qOrderedTail = 0;
			qOrdered[qOrderedTail] = value;
		}
		
    	// Test if queue has one node
		else if (qOrderedHead == qOrderedTail)
			if (qOrdered[qOrderedHead] < value)
			{
				qOrderedHead = decrementPointer(qOrderedHead);
				qOrdered[qOrderedHead] = value;
			}
			else
			{
				qOrderedTail = incrementPointer(qOrderedTail);
				qOrdered[qOrderedTail] = value;
			}

		// Handle queue with more than one node
		else
    	{
			if (qOrdered[qOrderedHead] < value)
			{
	    		qOrderedHead = decrementPointer(qOrderedHead);
				qOrdered[qOrderedHead] = value;
			}
			else
			{

	        	// Loop to locate spot to insert node
	        	prev = qOrderedHead;
	        	curr = incrementPointer(qOrderedHead);		        	
	        	while (prev != qOrderedTail && qOrdered[curr] >= value)
	        	{
		        	prev = incrementPointer(prev);
		        	curr = incrementPointer(curr);
	        	}
	        	
	        	// Test whether to add node after tail
	        	if (prev == qOrderedTail)
	        	{
	        		qOrderedTail = curr;
	        		qOrdered[qOrderedTail] = value;
	        	}
	        	
	        	// Make space in array for new node
	        	else
	        	{
	        		copyLeft = qOrderedTail;
	        		qOrderedTail = incrementPointer(qOrderedTail);
	        		copyRight = qOrderedTail;
	        		while (copyRight != curr)
	        		{
	        			qOrdered[copyRight] = qOrdered[copyLeft];
	        			copyLeft = decrementPointer(copyLeft);
	        			copyRight = decrementPointer(copyRight);
	        		}
	    			qOrdered[copyRight] = value;
	        	}
	        	
			}

    	}
		
	}

	//------------------------------------------------------------------
    // insertValueUnordered
	//------------------------------------------------------------------
    private static void insertValueUnordered(int value)
	{
		
    	// Declare variables
		int prevSize;
		int addCount;
	    
        // Test if array needs resizing
		if (qUnorderedCount == qUnordered.length)
		{
			
			// Resize array
			prevSize = qUnordered.length;
			addCount = (int) Math.pow(2, qUnorderedLevel);
			qUnorderedLevel = qUnorderedLevel + 1;
			qUnordered = Arrays.copyOf(qUnordered, qUnordered.length + addCount);
//	        System.out.println("qUnordered array increased by " + 
//        		addCount + " elements.");
			
			// Test whether to reorder so qUnorderedTail after qUnorderedHead
	        if (qUnorderedTail < qUnorderedHead)
	        {
	        	for (int i = 0; i <= qUnorderedTail; i++)
	        		qUnordered[prevSize + i] = qUnordered[i];
	        	qUnorderedTail = prevSize + qUnorderedTail;
	        }
	        
		}
		
		// Increment count
		qUnorderedCount = qUnorderedCount + 1;

        // Test if queue empty
		if (qUnorderedHead == -1)
		{
			qUnorderedHead = 0;
			qUnorderedTail = 0;
			qUnordered[qUnorderedTail] = value;
		}
		
    	// Insert node in non-empty queue
		else 
		{
			qUnorderedTail = incrementPointer(qUnorderedTail);
			qUnordered[qUnorderedTail] = value;
		}
		
	}

	//------------------------------------------------------------------
    // insertValueHeap
	//------------------------------------------------------------------
    private static void insertValueHeap(int value)
	{
		
    	// Declare variables
		int prevSize;
		int addCount;
		int parent;
		int child;
		int temp;
	    
        // Test if array needs resizing
		if (qHeapCount == qHeap.length)
		{
			
			// Resize array
			prevSize = qHeap.length;
			addCount = (int) Math.pow(2, qHeapLevel);
			qHeapLevel = qHeapLevel + 1;
			qHeap = Arrays.copyOf(qHeap, qHeap.length + addCount);
//	        System.out.println("qHeap array increased by " + 
//        		addCount + " elements.");
	        
		}
		
		// Insert node
		qHeap[qHeapCount] = value;
		
		// Increment count
		qHeapCount = qHeapCount + 1;
		
		// Loop to filter node up to correct position
		// Loop continues as long as root not passed and child value 
		// larger than parent.  Child and parent are pointers using logic that 
		// assigns:
		// -Root node a value of 1.
		// -Its children values of 2 and 3, respectively.
		// -Its children values of 4, 5, 6, and 7, respectively.
		// -Etc.
		child = qHeapCount;
		parent = child / 2;
		while (parent > 0 && (qHeap[child - 1] > qHeap[parent - 1]))
		{

			// Swap parent and child nodes
			temp = qHeap[parent - 1];
			qHeap[parent - 1] = qHeap[child - 1];
			qHeap[child - 1] = temp;
			
			// Set new child and parent
			child = parent;
			parent = child / 2;

		}

	}

	//------------------------------------------------------------------
    // removeValueOrdered
	//------------------------------------------------------------------
    private static int removeValueOrdered()
	{
    	
		// Declare variables
		int value;
		
		// Test if queue is empty
		if (qOrderedHead == -1)
			return -1;
		else
		{
			
			// Decrement count
			qOrderedCount = qOrderedCount - 1;

	        // Remove node
			value = qOrdered[qOrderedHead];

	        // Update qOrderedHead and qOrderedTail pointers
			if (qOrderedHead == qOrderedTail)
			{
				qOrderedHead = -1;
				qOrderedTail = -1;
			}
			else
				qOrderedHead = incrementPointer(qOrderedHead);
	        return value;
	        
		}

	}

	//------------------------------------------------------------------
    // removeValueUnordered
	//------------------------------------------------------------------
    private static int removeValueUnordered()
	{
    	
		// Declare variables
		int value;
		int valuePtr;
		int curr;
		int prev;
		int copyLeft;
		int copyRight;

		// Test if queue is empty
		if (qUnorderedHead == -1)
			return -1;
		
		else
		{
			
			// Decrement count
			qUnorderedCount = qUnorderedCount - 1;
			
	    	// Test if queue has one node
			if (qUnorderedHead == qUnorderedTail)
			{
				value = qUnordered[qUnorderedHead];
				qUnorderedHead = -1;
				qUnorderedTail = -1;
				return value;
			}

			// Handle queue with more than one node
			else
	    	{

	        	// Loop to locate spot to insert node
	        	prev = qUnorderedHead;
	        	curr = incrementPointer(qUnorderedHead);		        	
				valuePtr = qUnorderedHead;
	        	while (prev != qUnorderedTail)
	        	{
	        		if (qUnordered[curr] > qUnordered[valuePtr]) 
	        			valuePtr = curr;
		        	prev = incrementPointer(prev);
		        	curr = incrementPointer(curr);
	        	}
	        	value = qUnordered[valuePtr];
	        	
	        	// Test whether to remove node at tail
	        	if (valuePtr == qUnorderedTail)
	        		qUnorderedTail = decrementPointer(qUnorderedTail);
	        	
	        	// Remove node
	        	else
	        	{
	        		copyLeft = valuePtr;
	        		copyRight = incrementPointer(copyLeft);
	        		while (copyLeft != qUnorderedTail)
	        		{
	        			qUnordered[copyLeft] = qUnordered[copyRight];
	        			copyLeft = incrementPointer(copyLeft);
	        			copyRight = incrementPointer(copyRight);
	        		}
	        		qUnorderedTail = decrementPointer(qUnorderedTail);
	        	}

	    	}
			
	        return value;

		}

	}

	//------------------------------------------------------------------
    // removeValueHeap
	//------------------------------------------------------------------
    private static int removeValueHeap()
	{
    	
		// Declare variables
		int value;
		int parent;
		int childLeft;
		int childRight;
		int temp;

		// Test if queue is empty
		if (qHeapCount == 0)
			return -1;
		
		else
		{

			// Get value
	    	value = qHeap[0];

	    	// Replace root node with "last" node
	    	qHeap[0] = qHeap[qHeapCount - 1];
			
			// Decrement count
			qHeapCount = qHeapCount - 1;
			
			// Loop to filter node down to correct position
			// Loop continues as long a parent has two children
			// Child and parent are pointers using logic that assigns:
			// -Root node a value of 1.
			// -Its children values of 2 and 3, respectively.
			// -Its children values of 4, 5, 6, and 7, respectively.
			// -Etc.
			parent = 1;
			childLeft = 2;
			childRight = 3;
			while (childRight <= qHeapCount &&
				   (qHeap[parent - 1] < qHeap[childLeft - 1] || 
					qHeap[parent - 1] < qHeap[childRight - 1]))
			{
				
				// Test which branch to filter node down to
				if (qHeap[childLeft - 1] > qHeap[childRight - 1])
				{

					// Swap parent and left child nodes
					temp = qHeap[parent - 1];
					qHeap[parent - 1] = qHeap[childLeft - 1];
					qHeap[childLeft - 1] = temp;
					
					// Set new parent to left child node
					parent = childLeft;

				}
				else
				{

					// Swap parent and right child nodes
					temp = qHeap[parent - 1];
					qHeap[parent - 1] = qHeap[childRight - 1];
					qHeap[childRight - 1] = temp;
					
					// Set new parent to right child node
					parent = childRight;
					
				}
				
				// Set new children
				childLeft = parent * 2;
				childRight = (parent * 2) + 1;

			}
			
			// Test if parent has only left child
			if (childLeft == qHeapCount && qHeap[parent - 1] < qHeap[childLeft - 1])
			{

				// Swap parent and left child nodes
				temp = qHeap[parent - 1];
				qHeap[parent - 1] = qHeap[childLeft - 1];
				qHeap[childLeft - 1] = temp;

			}
			
	    	return value;
			
		}
    	
	}

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
	public static void main (String[] args)
    {

		// Declare variables
    	Random rand = new Random();
		int addValue;
        long before;
		int removedValueOrdered = -1;
		int removedValueUnordered = -1;
		int removedValueHeap = -1;
        long insertTimeOrdered;
        long insertTimeUnordered;
        long insertTimeHeap;
        long removeTimeOrdered;
        long removeTimeUnordered;
        long removeTimeHeap;
		
        // Show application header
        System.out.println("Welcome to Priority Queue Using Array");
        System.out.println("-------------------------------------");
        
		// Initialize insert times
        insertTimeOrdered = 0;
        insertTimeUnordered = 0;
        insertTimeHeap = 0;
        
		// Loop to add nodes
        for (int i = 0; i < MAX_NODES; i++)
        {
        	
        	// Generate random value
            addValue = rand.nextInt(RAND_UPPER_LIMIT ) + 1;
            if (i % (MAX_NODES / 10) == 0) 
            	System.out.println("Value " + 
        			String.format(COLFMTD3, i) + " added: " + addValue);
            
            // Insert into ordered array
            before = System.currentTimeMillis();
        	insertValueOrdered(addValue);
            insertTimeOrdered = insertTimeOrdered + 
        		(System.currentTimeMillis() - before);
            listNodes("Ordered array", qOrdered, qOrderedCount,
        		qOrderedHead, qOrderedTail, false);

            // Insert into unordered array
            before = System.currentTimeMillis();
        	insertValueUnordered(addValue);
            insertTimeUnordered = insertTimeUnordered + 
        		(System.currentTimeMillis() - before);
            listNodes("Unordered array", qUnordered, qUnorderedCount, 
        		qUnorderedHead, qUnorderedTail, false);
            
            // Insert into heap
            before = System.currentTimeMillis();
        	insertValueHeap(addValue);
            insertTimeHeap = insertTimeHeap + 
        		(System.currentTimeMillis() - before);
            listHeapNodes(false);
            
        }
        
		// Initialize remove times
        removeTimeOrdered = 0;
        removeTimeUnordered = 0;
        removeTimeHeap = 0;

		// Loop to remove nodes
        for (int i = 0; i < MAX_NODES; i++)
        {
            
            // Remove from ordered array
            before = System.currentTimeMillis();
    		removedValueOrdered = removeValueOrdered();
    		removeTimeOrdered = removeTimeOrdered + 
        		(System.currentTimeMillis() - before);
            if (i % (MAX_NODES / 10) == 0) 
            	System.out.println("Value " + 
        			String.format(COLFMTD3, i) + " removed: " + 
            			removedValueOrdered);
            listNodes("Ordered array", qOrdered, qOrderedCount, 
        		qOrderedHead, qOrderedTail, false);

            // Remove from unordered array
            before = System.currentTimeMillis();
            removedValueUnordered = removeValueUnordered();
            removeTimeUnordered = removeTimeUnordered + 
        		(System.currentTimeMillis() - before);
            listNodes("Unordered array", qUnordered, qUnorderedCount, 
        		qUnorderedHead, qUnorderedTail, false);
            
            // Remove from heap
            before = System.currentTimeMillis();
    		removedValueHeap = removeValueHeap();
    		removeTimeHeap = removeTimeHeap + 
        		(System.currentTimeMillis() - before);
            listHeapNodes(false);
    		
    		// Verify that removed value from each structure matches
    		if (removedValueOrdered != removedValueUnordered)
    			System.out.println("i=" + i + 
					": removed ordered value unequal to unordered value.");
    		if (removedValueOrdered != removedValueHeap)
    			System.out.println("i=" + i + 
					": removed ordered value unequal to heap value.");
    		if (removedValueUnordered != removedValueHeap)
    			System.out.println("i=" + i + 
					": removed unordered value unequal to heap value.");
    		
    		// Print nodes from each structure if removed values don't match
    		if (removedValueOrdered != removedValueUnordered ||
				removedValueOrdered != removedValueHeap ||
				removedValueUnordered != removedValueHeap)
    		{
                listNodes("Ordered array", qOrdered, qOrderedCount, 
                		qOrderedHead, qOrderedTail, true);
                listNodes("Unordered array", qUnordered, qUnorderedCount, 
                		qUnorderedHead, qUnorderedTail, true);
                listHeapNodes(true);
    		}

        }

		// Print times
    	System.out.printf("%n" + COLFMTS1 + COLFMTD1 + "%n%n", 
			"Max nodes:", MAX_NODES);
    	System.out.printf(COLFMTS1 + COLFMTS2 + COLFMTS2 + COLFMTS2 + 
			COLFMTS2 + "%n", "Type", "Array size", "Insert (ms)", 
			"Remove (ms)", "Total (ms)");
    	System.out.printf(COLFMTS1 + COLFMTD1 + COLFMTD1 + COLFMTD1 + 
			COLFMTD1 + "%n", "Ordered array", qOrdered.length, 
			insertTimeOrdered, removeTimeOrdered, 
			(insertTimeOrdered + removeTimeOrdered));
    	System.out.printf(COLFMTS1 + COLFMTD1 + COLFMTD1 + COLFMTD1 + 
			COLFMTD1 + "%n", "Unordered array", qUnordered.length, 
			insertTimeUnordered, removeTimeUnordered, 
			(insertTimeUnordered + removeTimeUnordered));
    	System.out.printf(COLFMTS1 + COLFMTD1 + COLFMTD1 + COLFMTD1 + 
			COLFMTD1 + "%n", "Heap", qHeap.length, insertTimeHeap, 
			removeTimeHeap, (insertTimeHeap + removeTimeHeap));

        // Show application close
        System.out.println("\nEnd of Priority Queue Using Array");

    }

}
