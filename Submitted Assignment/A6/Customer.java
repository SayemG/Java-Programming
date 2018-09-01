package Homework6;

import java.util.Random;

public class Customer {
	
		Random random=new Random();
	//private static variables of the class 
		private static int  totalCustomers=0; 
		private static int totalItems=0;
		private static double  totalCost=0;
		  
	//private instant variables of the class
		private int ID;
		private int items;
		private double cost;
		Customer next ; //reference to the next object/nodes
			
		//default constructor
		public Customer() 
		{
			totalCustomers=totalCustomers+1;
			ID=-1;
			items=-1;
			cost=-1;
			next =null; 
		} 
			
	//constructor with parameters/arguments
		public Customer(int items,double cost)  //:code (code),name (name),cost (cost),count(count)
		{	
			//item and costs initialized by random numbers
			items=1+random.nextInt(40-1+1);
			cost=1.0+random.nextInt(200-1+1);
			
			//initializing static variables
			totalCustomers = totalCustomers +1;
			totalItems = totalItems + items;
			totalCost = totalCost + cost;		
			//----------------------------
			//initializing instant variables
			this.ID=totalCustomers-1;
			this.items = items;
			this.cost = cost;	
		}
		
		//Methods
		//all setter methods 
		//==============================================================================================================	
		//for static variables	
		public void settotalCustomers(int tCustomers)
		{
			totalCustomers=tCustomers;
		}
		
		public void settotalItems(int tItems)
		{
			totalItems=tItems;	
		}
		
		public void settotalCost(double tCost)
		{
			totalCost=tCost;
		}  
		//-----------------------------------------------
		
	//for instant variables
		public void setID(int ID)
		{
			this.ID=ID;
		}
		
		public void setitems(int items)
		{
			this.items=items;
		} 
		
		public void setcost(double cost)
		{
			this.cost=cost;
		}
		
//=================================================================================
		
	//all getter methods 
		
		// for Static variables
		public int gettotalCustomers()
		{
			return totalCustomers;
		}
		
		public int gettotalItems()
		{
			return totalItems;	
		}

		public double gettotalCost()
		{
			return totalCost;
		} 
		
	//--------------------------------
		//for instant variables
		public int getID()
		{
			return ID;
		}
			
		public int getitems()
		{
			return items;
		} 
			
		public double getCost()
		{
			return cost;
		}
			
	//============================================================================= 
	//------------------------------------------------------------------
	//equals and toString methods
	//------------------------------------------------------------------
		 public boolean equals (Customer b)
		 {
		     if (this.ID==b.ID && this.items==(b.items) && this.cost == b.cost)
		         return true;
		     else
		         return false;
		 }
		
		 public String toString ()
		 {
		     return "Customer ID: " + ID + "\nItems: " + items + "\nCost: "+ cost ;
		 }
		//---------------------------------------------------------------------------

}
