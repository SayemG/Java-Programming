
//======================================================================
//Title:      <HW6.java>
//Course:     CSC 3020
//Homework:   <#6>
//Author:     <Sayem Chowdhury>
//Date:       <4/12/2018>
//Description:
// < A Java console application that processes customers through their store checkout line.>
//======================================================================
//package name
//-------------------
package Homework6;
//import classes
//-----------------------
import java.util.Random;

//class HW6
public class HW6 {
	//reference object of class Customer are member of class HW6
	Customer first,last;  
	
	//default constructor of the class HW6
	public HW6() 
	{
		first=last=null;//initialized to null
	} 
	
	//static member of the class HW6
	static int total_customer_Handled=0;
	static int customer_left_Q=0;
	static int customer_in_Q=0; 
	
	
	//Function insert a customer to the Queue
	void insertCustomer(Customer headRef)
    {
        // Create a new LinkList node/Customer object
        Customer temp = new Customer(1,0.0);
      
        // If queue is empty, then new node is the first and last customer both
        if (this.last == null)
        {
           this.first = this.last = temp;//first and last are initialized to temp node
           return;
        }
      
        // If temp is not the only node, add the temp node at the end of queue and change last node
        this.last.next = temp;
        this.last = temp;
    }
      
    // Method to remove a Customer from the queue.  
    Customer removeCustomer()
    {
        // If queue is empty, return NULL.
        if (this.first == null)
           return null;
      
        // Store previous first and move first one node ahead
        Customer temp = this.first;
    
        this.first = this.first.next;
      
        // If first becomes NULL, then change rear also as NULL
        if (this.first == null)
           this.last = null;
        return temp;
   }
    
   //print the customer information from the queue 
   void printCustomers()
	{ 
	   if (this.first==null) //empty queue
		   return;
	   Customer temp;
	   temp=this.first;
	   //while(temp!=null)
	   {
		   //System.out.println("\nProduct Inventory Total Product count and Value :");
		   //System.out.printf("%n%-10s      %-20s         %-20s%n", "Customer ID", "Items", "Cost");
		   //
		   System.out.println("Customer --> ("+temp.getID()+") -->left the Queue.");
		   System.out.print("<Customer ID>" +"        <Items>"+ "                       <Cost>\n");
		   System.out.print("------------------------------------------------------------\n");
		   System.out.printf("%8d              %-24d      %-10.2f%n",temp.getID(),temp.getitems(),temp.getCost()); 
		   //System.out.println("\n");
		   //temp=temp.next;
	   }  
	}
   void printCustomerinQueue()
	{
		Customer temp3=this.first;
		
		if(temp3!=null)
			System.out.println("Customers remain in the Queue.");
		else
			System.out.println("No Customer remain in Queue, Queue is empty\n.");
		
		while(temp3!=null)
		{
			   //System.out.println("Customer --> ("+temp3.getID()+") -->left the Queue.");
			   System.out.print("<Customer ID>" +"        <Items>"+ "                       <Cost>\n");
			   System.out.print("------------------------------------------------------------\n");
			   System.out.printf("%8d              %-24d      %-10.2f%n",temp3.getID(),temp3.getitems(),temp3.getCost()); 
			   System.out.println("\n");
			   temp3=temp3.next;
		}	
	}

	//----------------------------------------------------
	//------Function Main----------------------
   
	public static void main(String[] args) throws InterruptedException 
	{
		Customer First_Customer = new Customer();//just a customer object used to call the inertCustomer function
		HW6 customerLinkList=new HW6(); //object of HW^ class with node first and last 
										//used to track the first and last customer in the Queue 
		Random random = new Random();
		int loop=1;//loop control variable
		while(loop<21)
		{
			System.out.println("loop:"+ loop);
			if(customerLinkList.first==null)
			{
				//System.out.println("Line is empty...So adding new Customer in line ");
				customerLinkList.insertCustomer(First_Customer);
				Customer addedCustomer = customerLinkList.last;
				System.out.println("Welcome at Millennial Mart");
				System.out.println("Customer --> ("+addedCustomer.getID()+") --> added into the Queue.\n\n");
				//customerLinkList.printCustomers(); 
				
				total_customer_Handled++;
				customer_in_Q++; 	
			}
			
			else if(random.nextBoolean())
			{
				//System.out.println("Line is empty...So adding new Customer in line ");
				customerLinkList.insertCustomer(First_Customer);
				System.out.println("Welcome at Millennial Mart");
				Customer addedCustomer = customerLinkList.last;//addedCustomer point to last customer in the Queue
				System.out.println("Customer --> ("+ addedCustomer.getID() +") --> added into the Queue.\n\n");
				//customerLinkList.printCustomers(); 
				total_customer_Handled++;
				customer_in_Q++; 	
			}
			
			else if(!random.nextBoolean())
			{
				customerLinkList.printCustomers();
				Customer Remove=customerLinkList.removeCustomer();
				//System.out.println("Customer --> ("+Remove.getID()+") -->left the Queue.\n");
				//customerLinkList.printCustomers(); 
				System.out.println("Thank you for shopping at Millennial Mart\n\n");
				
				Remove=null;
				customerLinkList.printCustomerinQueue();
				//
				customer_in_Q--;
				customer_left_Q++;
				
			} 
			else if(customerLinkList.first!=null)
			{
				customerLinkList.printCustomers();
				Customer Remove=customerLinkList.removeCustomer();
				//System.out.println("Customer --> ("+Remove.getID()+") -->left the Queue.\n");
				
				System.out.println("Thank you for shopping at Millennial Mart\n\n");
				Remove=null;
				//
				customerLinkList.printCustomerinQueue();
				customer_in_Q--;
				customer_left_Q++;	
			} 
			loop++; 
			Thread.sleep(1000);  //pausing 1 second
		}
		
		//After the loop print//
		//------------------------
		System.out.println("<Customer Summary Information>");
		System.out.println("-----------------------------");
		System.out.printf("%-25s%d%n","Total Customer:",total_customer_Handled);
		System.out.printf("%-25s%d%n","Customer in Queue:",customer_in_Q);
		System.out.printf("%-25s%d%n","Customer left Queue:", customer_left_Q);
		
		System.out.printf("%-25s%d%n","Total items Purchased:", First_Customer.gettotalItems());
		System.out.printf("%-25s%.2f%n","Total Cost:",First_Customer.gettotalCost()); 
		System.out.println("End of Shift/day at Millennial Mart");
			
	}
}
