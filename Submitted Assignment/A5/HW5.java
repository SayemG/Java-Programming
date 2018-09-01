//======================================================================
//
// Title:      <HW5.java>
// Course:     CSC 3020
// Homework:   <#5>
// Author:     <Sayem Chowdhury>
// Date:       <3/31/2011>
// Description:
//   <A Java console application that manages product inventory.  >
//
//======================================================================

//Package Name
package HW5;

//import Classes
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

//Class Hw5.java
public class HW5 {

	//declare variables
	public static String output_file = "ProductInventoryOut.txt"; 
	static int dataCount =0; 
	public static Scanner KBD=new Scanner(System.in);
	//--------------------------------------------------------
	
	// function that sell the product 
	public static void sellproduct(Product [] pd)
	{
		// validate loop  
		int pcode;
		int q;
		int pn = 0;
		System.out.println("\nPlease Enter the product code you want to sale:");
		
		pcode=KBD.nextInt(); 
		//String garbage=KBD.nextLine();
		boolean b=false;
		for (int i=0;i<pd.length;i++)
		{ 
			if (pd[i].getCode()==pcode)
			{
				pn=i; // saving index of the product found in variable pn
				b=true;
			}
		} 
		
		if (b==true)
		{
			System.out.println("\nPlease enter the quantity of product you want to sell:");
			//taking input from the user the number of product to sale
			q=KBD.nextInt();
			//validating quantity
			if(q!=0 && q<=pd[pn].getCount())
			{
				pd[pn].updateSale(q);// call function that declare in class product to sale the product
				
				//Print a "product sold" message that includes: Code ,Quantity, Revenue from the sale, 
				//(static) inventoryValue,(static) inventoryCount and count for the product 
				System.out.println("\nProduct Sold");
				System.out.printf("%s%d%n%s%d%n%s%.2f%n", "Code:", pcode, "Quantity:",q, 
														  "Revenue from the Sale:$", (pd[pn].getCost()*q));
			}
			else 
				{
					System.out.println("Invalid Quantity or Number of Quantity is out of Stack");
				}
		}
		else 
			{
				System.out.println("Sorry! Product code not Found");
			} 
	}
	
//---------------------------------------------------------------------------------------------	
	//Function that take ordered and update the ordered 
	public static void orderproduct(Product [] pd)
	{
		//declare local variables
		int pcode;
		int q;
		int pn = 0;
		System.out.println("Please Enter the product code you want to order: ");
		pcode=KBD.nextInt(); // user input 
		//String garbage=KBD.nextLine();
		boolean b=false;
		for (int i=0;i<pd.length;i++)
		{ 
			if (pd[i].getCode()==pcode)
			{
				pn=i;
				b=true;
			}
		} 
		
		if (b==true) // product code matched to ordered
		{
			System.out.println("Please enter the quantity of product you want to Ordered: ");
			q=KBD.nextInt();
			if(q!=0 )
			{
				pd[pn].updateordered(q);
				System.out.println("\nProduct ordered");
				System.out.printf("%s%d%n%s%d%n%s%.2f%n", "Code:", pcode, "Quantity Ordered:",q, 
															"Cost Of the Ordered:$", (q*pd[pn].getCost()));				
			}
			else 
				{
					System.out.println("Sorry! Ordered not Received, Invalid Quantity you Entered");
				}
		}
		else 
			{
				System.out.println("Sorry! Product code not found");
			} 
	}
	
	//Function that,List product inventory / shows all product data in formatted columns.  
	public static void Print_p_data(Product[] pdts) 
	{
		System.out.println("***Product Inventory***");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("%-18s %-15s %15s %10s", "<Product Code> ||","<Product Name> ||",
													"  <Product Cost> ||","  <Product Quantity>\n");
		System.out.println("=============================================================================");
		for(int i=0;i<pdts.length;i++) 
	        { 	
				System.out.printf("%-18d  %-14s%15.2f %15d",pdts[i].getCode(),pdts[i].getName(),
															pdts[i].getCost(),pdts[i].getCount());
				System.out.println("");
	        	//System.out.println(pdts[i].getCode()+"\t"+pdts[i].getName()+"\t"+pdts[i].getCost()+"\t"+
				//pdts[i].getCount()); 
					
	        }	
	}
	
	//**************************************
	//Function that Write Inventory Data into file
	//---------------------------------------------------------------
	public static void Wrt_Str_UBW(Product[]pdts) //write string using buffer writer
    		  throws IOException {
    		    BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));
    		    
		    	for(int i=0;i<pdts.length;i++) 
		        { 
		    		writer.write(String.format("%-18d  %-14s %15.2f %15d%n",
		    		pdts[i].getCode(),pdts[i].getName(),pdts[i].getCost(),pdts[i].getCount()));		
		        }
                
                writer.flush();
                writer.close();    
    }
	
//-----------------------------------------------------------------------------------------------
//Function will display the menu for user 
//---------------------------------------------------------------------------------------------------
	public static void Show_Menu(Product [] pr) throws IOException 
	{
		while(true)
	{
		System.out.println("***Camping Critters Menu***");
		System.out.println("---------------------------");
		System.out.println("1-> Sell Product");
		System.out.println("2-> Ordered Product");
		System.out.println("3-> List Product Inventory"); 
		System.out.println("4-> Exit \n"); 
		
		//Scanner KBD =new Scanner(System.in);
		int choice;  
		System.out.println("Enter an option: ");
		choice=KBD.nextInt();

		if(choice>=1 && choice<=3) 
			{
				if (choice==1)
				{
					sellproduct(pr); //function call to sale product 
					System.out.println(" ");
					Wrt_Str_UBW(pr); 
				}
				else if (choice==2)
				{
					orderproduct(pr); //function call to ordered product
					System.out.println(" ");
					Wrt_Str_UBW(pr); 
				}
				else if(choice==3)
				{
					Print_p_data(pr);//function call to print inventory
					pr[1].print_l();
					System.out.println(" ");
					Wrt_Str_UBW(pr); 
				}
			}
				
		else if (choice==4)
		{
			KBD.close(); //close keyboard
			Wrt_Str_UBW(pr);// function call to Write in file
			break;
		}
		else 
		{
			System.out.println("sorry Invalid Entry");
		}
	}			
	}
	
//----------------------------------------------------------
//----------[Main Function]------------------------------
//-------------------------------------------------------------

	public static void main(String[] args) throws IOException {
		// array of the products / object type
		 Product [] products = new Product [10]; 
		
		//file reading 
		// Declaring variables
        Scanner fileIn = null;
        String line;
        
        // Attempt to open input file
        //try catch Block
        try//Exception handler 
        { 	
        	// Assign external file to file handle
            fileIn = new Scanner(new FileInputStream("ProductInventoryIn.txt"));
            // Loop to read data
            //dataCount = 0;
            while (fileIn.hasNextLine())
            {
                // Read each line 
                line = fileIn.nextLine();
            	{
            		products[dataCount]=new Product (Integer.parseInt(line.substring(0,5).trim()),
            				(line.substring(7,20).trim()),Double.parseDouble(line.substring(35,42).trim()),
            				Integer.parseInt(line.substring(48,51).trim()));
            		dataCount = dataCount + 1;//updating index	
                   //products[0].incrementProductCount();    
            	}
            }
              fileIn.close(); //close the file     
        }    
        // Handle file error
        catch (FileNotFoundException e) //catch Block
        {
            System.out.println("Error: file '" + "ProductInventoryIn.txt" +
                "' not found.");
            System.out.println("Default folder: " + 
                System.getProperty("user.dir"));
            System.out.println("Error message:\n" + e.getMessage());
         	
        } 
        
  // writing file before update information 
        Wrt_Str_UBW(products); 
        Show_Menu(products); // function call to show menu 
        Wrt_Str_UBW(products); 
          
	}
	
}
// -------------------------------------------------------------------------------------------

