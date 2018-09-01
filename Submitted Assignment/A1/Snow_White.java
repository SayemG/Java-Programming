// Title:      <Snow_White.java>
// Course:     CSC 3020
// Homework:   <1>
// Author:     <Sayem Chowdhury>
// Date:       <01/22/2018>

/* Description:This program will take 3 arguments as snow fall for three months.
 * Also calculates and shows the total and average snow fall for three winter months.

*/ 
//Package Name

package Snow_Man;
//java Snow_White Class
public class Snow_White {
	//Main Method
	public static void main(String[] args) {
		
	    //------------------------------------------------------------------
	        // Show application header
	        System.out.println("Welcome to SnowStars");
	        System.out.println("---------------------\n");
	    
	        // Show argument count and arguments
	        System.out.println("Number of arguments passed into program: " + 
	        	args.length);
	        System.out.println("Index " + "      "+ " Argument ");
	        for (int i = 0; i < args.length; i++)
	            System.out.println( (" "+(i+1)) + " " + "            " + args[i]);
	        
	        System.out.print("\n");
	        for (int i = 0; i < args.length; i++)
	            System.out.println("SnowFall Motnths "+ (i+1) + ": " + args[i]);
	        
	       //variable Deceleration for calculating total Snow fall
	        int total=0;
	       
	        for (int i = 0; i < args.length; i++)
	        	{
	        		total=total+ Integer.parseInt(args[i]); //converting string argument to integer
	        	} 
	        System.out.print("\nTotal Snowfall = " );
	        System.out.print(total);
	        System.out.print("  inches\n");
	        
	        int number_of_args=args.length; //returning total number of passing arguments to the number_of_args
	        
	        double average=(double)total/number_of_args;//average Snow fall per month
	        //Display output
	        System.out.print("Average Snowfall = ");
	        System.out.print(average); 
	        System.out.print("  inches\n");
	        
	        System.out.println("\nEnd of SnowStars");
	     // Show application close
	        System.out.println("End of my Application");
}
}
