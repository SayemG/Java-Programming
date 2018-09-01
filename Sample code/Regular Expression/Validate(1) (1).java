package wsu.RegularExpressions;
// Fig. 14.21: Validate.java
// Input and validate data from user using the ValidateInput class.
import java.util.Scanner;

public class Validate
{
	public static void main(String[] args)
	{

		// Declare variables
	    Scanner scanner = new Scanner(System.in);
		
	    // Validate first name
	    System.out.print("Please enter first name: ");
	    String firstName = scanner.nextLine();
	    if (!ValidateInput.validateFirstName(firstName))
	    	System.out.println("Invalid first name");
	    
	    // Validate last name
	    System.out.print("\nPlease enter last name: ");
	    String lastName = scanner.nextLine();
	    if (!ValidateInput.validateLastName(lastName))
	    	System.out.println("Invalid last name");
	    
	    // Validate address
	    System.out.print("\nPlease enter address: ");
	    String address = scanner.nextLine();
	    if (!ValidateInput.validateAddress(address))
	    	System.out.println("Invalid address");
	    
	    // Validate city
	    System.out.print("\nPlease enter city: ");
	    String city = scanner.nextLine();
	    if (!ValidateInput.validateCity(city))
	    	System.out.println("Invalid city");
	    
	    // Validate state
	    System.out.print("\nPlease enter state: ");
	    String state = scanner.nextLine();
	    if (!ValidateInput.validateState(state))
	    	System.out.println("Invalid state");
	    
	    // Validate zip
	    System.out.print("\nPlease enter zip: ");
	    String zip = scanner.nextLine();
	    if (!ValidateInput.validateZip(zip))
	    	System.out.println("Invalid zip code");
	    
	    // Validate phone
	    System.out.print("\nPlease enter phone: ");
	    String phone = scanner.nextLine();
	    if (!ValidateInput.validatePhone(phone))
	    	System.out.println("Invalid phone number");

	    // Validate IPv4 address
	    System.out.print("\nPlease enter IPv4: ");
	    String addr = scanner.nextLine();
	    if (!addr.matches("[01]{8}\\.[01]{8}\\.[01]{8}\\.[01]{8}"))
	    	System.out.println("Invalid IPv4");
	    else
	    	System.out.println("Valid IPv4");
	    
	    // This IPv4 validation doesn't work since "." matches any 
	    // single character
//	    if (!addr.matches("[01]{8}.[01]{8}.[01]{8}.[01]{8}"))
//	    	System.out.println("Invalid IPv4");
//	    else
//	    	System.out.println("Valid IPv4");

   } 
} // end class Validate

/*
 **************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
*/
