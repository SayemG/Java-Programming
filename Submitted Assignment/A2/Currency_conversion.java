//======================================================================
// Title:      <Currency_conversion>
// Course:     CSC 3020
// Homework:   <2>
// Author:     <Sayem Chowdhury>
// Date:       <02/06/2018>
// Description:
/*<The Java console application that converts between currencies US Dollar ($), Euro (€), and Japanese Yen (¥). 
 * and  Prompt the user to choose a conversion code until choosing exit option.>
*/
//
//======================================================================
//Package name
package Money_M;
// Import Classes
import java.util.Scanner;
//main class 
public class Currency_conversion {
	//main function 
	public static void main(String[] args) {
		// Constant variables for currency symbol
		final String USD="\u0024";
		final String JYEN="\u00A5"; 
		final String EURO="\u20AC";
		//Show application Header
		System.out.println("Welcome to Currency Conversion"); 
		System.out.println("---------------------------------------\n");
		// Display Conversion Rate
		System.out.println("Code\t\t Conversion");
		System.out.println("----------------------------------------");
		System.out.println(" a\t\t US Dollar-> Euro ");
		System.out.println(" b\t\t US Dollar-> Japanese Yen ");
		System.out.println(" c\t\t Euro-> US Dollar ");
		System.out.println(" d\t\t Euro-> Japanese Yen ");
		System.out.println(" e\t\t Japanese Yen-> US Dollar ");
		System.out.println(" f\t\t Japanese Yen-> Euro ");
		System.out.println(" x\t\t Exit ");
		System.out.println("----------------------------------------\n");
	//constant Variables for money conversion Rate
		final double D2E=0.81;
		final double D2JY=109.42;
		final double E2UD=1.23;
		final double E2JY=135.11;
		final double JY2UD=0.0091;
		final double JY2E=0.0074; 
	// Creating Input Object
		Scanner kbd= new Scanner (System.in);
	//loop that prompt for code conversion until choose exit option
		while(true)
		{
			System.out.print("Please enter the code for currency conversion:\n ");
			String In=kbd.next(); 
			//variables for user input and saving calculation
			double M=0.0; 
			double CM;
			
			if (In.equals("a")) // conversion of Dollar to Euro
			{
				 System.out.println("Please enter the curreny value in US Dollar:");
	               M=kbd.nextDouble();
	               CM=M*D2E;
	               System.out.printf("%2.2f%s%2.2f%s",M, USD+"=", CM, EURO);
	               System.out.println("\n");	
			}
			
			else if(In.equals("b"))//conversion of Dollar to YEN
			{
				 System.out.println("Please enter the curreny value in US Dollar:");
	               M=kbd.nextDouble();
	               CM=M*D2JY;
	               System.out.printf("%2.2f%s%2.2f%s",M, USD+" =", CM, JYEN );
	               System.out.println("\n");	
			} 
			
			else if(In.equals("c"))//Conversion of Euro to Dollar
			{
				 System.out.println("Please enter the curreny value in Euro:");
	               M=kbd.nextDouble();
	               CM=M*E2UD;
	               System.out.printf("%2.2f%s%2.2f%s",M, EURO+" =", CM, USD);
	               System.out.println("\n");
			} 
			
			else if(In.equals("d"))//Conversion of Euro Japanese YEN
			{
				System.out.println("Please enter the curreny value in Euro:");
	               M=kbd.nextDouble();
	               CM=M*E2JY;
	               System.out.printf("%2.2f%s%2.2f%s",M, EURO+"=", CM, JYEN);
	               System.out.println("\n");
			} 
			else if(In.equals("e"))//Conversion of Japanese YEN to Dollar
				
			{
				System.out.println("Please enter the curreny value in Japanese Yen:");
	               M=kbd.nextDouble();
	               CM=M*JY2UD;
	               System.out.printf("%2.2f%s%2.2f%s",M, JYEN+"=", CM, USD);
	               System.out.println("\n");
			} 
			
			else if(In.equals("f"))// Conversion of Japanese YEN to Euro
				
			{
				System.out.println("Please enter the curreny value in Japanese Yen:");
	               M=kbd.nextDouble();
	               CM=M*JY2E;
	               System.out.printf("%2.2f%s%2.2f%s",M, JYEN+"=", CM, EURO );
	               System.out.println("\n");
			} 
			
			else if(In.equals("x"))// Exit option from the Application
				
			{
				
				//End of Application
				System.out.println("End of Currency Conversion");
				//close kbd
				kbd.close();
				System.exit(0);
			} 
			else // If user input wrong code prompt the message 
			{
				System.out.println("You chooses wrong code");
				
			}
			
		}
		
	}

}

