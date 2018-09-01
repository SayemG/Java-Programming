//======================================================================
// Class: <Product > //Product.java
// Description:
//   <This class represents one product in the inventory and includes the product informations code, 
//    Name, cost, count, Also setter and getter methods to set and get information of the class objects>
//
//======================================================================
//Package 
package HW5;
//java implemented class product for class HW5.java 
public class Product {

//Fields / Instant Variables 
//----------------------------------	
//private static variables of the class 
	private static int  productCount=0; 
	private static double inventoryValue=0;
	private static int  inventoryCount=0;
	 
//private instant variables of the class
	private int code;
	private String name;
	private double cost;
	private int count; 
		
	//default constructor
	public Product() 
	{
		productCount = productCount + 1;
		code = -1;
		name = "(not set)";
		cost = -1;
		count = -1;
	} 
		
//constructor with parameters/arguments
	public Product(int code,String name, double cost,int count)  //:code (code),name (name),cost (cost),count(count)
	{	
		//initializing static variables
		productCount = productCount + 1;
		inventoryValue = inventoryValue + (cost * count);
		inventoryCount = inventoryCount + count;		
	//----------------------------
		//initializing instant variables
		this.code = code;
		this.name = name;
		this.cost = cost;
		this.count = count;
	}
	
	//Methods
	//all setter methods 
	//==============================================================================================================	
		//for static variables	
	public void setProductCount(int PdC)
	{
		productCount=PdC;
	}
	
	public void setInventoryValue(double InV)
	{
		inventoryValue=InV;	
	}
	
	public void setInventoryCount(int InC)
	{
		inventoryCount=InC;
	}  
	//-----------------------------------------------
	
		//for instant variables

	public void setCode(int code)
	{
		this.code=code;
	}
	
	public void setName(String name)
	{
		this.name=name;
	} 
	
	public void setCost(double cost)
	{
		this.cost=cost;
	}

	public void setCount(int count)
	{
		this.count=count;
	}
			
	//=================================================================================
	
//all getter methods 
	
	// for Static variables
	public int getProductCount()
	{
		return productCount;
	}
	
	public double getInventoryValue()
	{
		return inventoryValue;	
	}

	public int setInventoryCount()
	{
		return inventoryCount;
	} 
	
//--------------------------------
	//for instant variables
	public int getCode()
	{
		return code;
	}
		
	public String getName()
	{
		return name;
	} 
		
	public double getCost()
	{
		return cost;
	}
		
		
	public int getCount()
	{
		return count;
	}	
//============================================================================= 
//------------------------------------------------------------------
//equals and toString methods
//------------------------------------------------------------------

	 public boolean equals (Product b)
	 {
	     if (this.code==b.code && this.name.equalsIgnoreCase(b.name) && this.cost == b.cost && this.count==b.count)
	     	
	         return true;
	     else
	         return false;
	 }
	
	 public String toString ()
	 {
	     return "Code: " + code + "\nName: " + name + "\nCost: " + cost +"\nCount: " + count;
	 }
		 
	//---------------------------------------------------------------------------------------
	 //Method that used in HW5 class to update the sale after make a product sale
	//--------------------------------------------------------------------------------------
	 public void updateSale(int q1)
	 {	
	 	//(static) inventoryValue
	 	//(static) inventoryCount
	 	//count for the product  
	 	inventoryValue=inventoryValue-(cost*q1);
	 	inventoryCount=inventoryCount-q1;
	 	count=count-q1;
	 }
	 
	//----------------------------------------------------------------------------------------------
	//Method that used in HW5 class to update the ordered product info after make a product ordered
	//-----------------------------------------------------------------------------------------------
	 public  void updateordered(int q1)
	 {
	 	inventoryValue=inventoryValue+(cost*q1);
	 	inventoryCount=inventoryCount+q1;
	 	count=count+q1;
	 }
	 //
	//---------------------------------------------------------------------------------------
	//Method that used in HW5 class to print the Total product count, inventory value, and inventory count.
	//--------------------------------------------------------------------------------------		
	public void print_l()
	{ 
	//System.out.println("\nProduct Inventory Total Product count and Value :");
		System.out.printf("%n%s%d%n%s%.2f%n%s%d%n", "Product Count:", productCount, 
				"Inventory Value:$",inventoryValue, "Inventory Count:", inventoryCount);
		
	} 
	// Function increment the product counted 
	public void incrementProductCount()
	{
		productCount=productCount+1;
	}
	 	
}
//-----------------------------------------------------------------------------------------------