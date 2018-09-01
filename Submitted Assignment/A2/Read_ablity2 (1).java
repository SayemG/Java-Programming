//======================================================================
// Title:      <Read_ability2.>
// Course:     CSC 3020
// Homework:   <2>
// Author:     <Sayem Chowdhury>
// Date:       <02/06/2018>
// Description:
/* The Java console application that analyzes a paragraph for readability using the Coleman–Liau index.  
 * Also, Prompt the user for a paragraph, and then calculate and show the following:
	Number of characters.
	Number of whitespace characters.
	Number of non-whitespace characters.
	Number of sentences – these are delimited by periods (.).
	Number of words – these are delimited by one or more spaces, commas, and periods.
	Number of word letters.
	Coleman–Liau index – this is calculated as follows:
		1) Count the number of sentences.
		2) Count the number of words.
		3) Count the number of letters in words.
		4) Calculate L = Letters ÷ Words × 100.
		5) Calculate S = Sentences ÷ Words × 100.
		6) Calculate CLI = 0.0588L - 0.296S - 15.8.
 */
//=================================================================
//Package 
package Read;
//Import Classes
import java.util.Scanner; 
//Main class
public class Read_ablity2 {
	//main function
	public static void main(String[] args) {
		
	// Constant Format Specifier
		  final String CFMT1 = "%-20s";
		  final String CFMT2 = "%12d";
		  final String CFMT3 = "%15.2f";
		  
	// variables Decelerations
	      int LTs = 0;
	      int WDs = 0;
	      int CTs = 0;
	      int W_Space = 0;
	      int Non_W_Space = 0;
	      int sentences = 0;
   //String arrays to store the tokens
	      String[] T1_Array;
	      String[] T2_Array;
	      String[] T3_Array;
	//Variable decelerations
	      double L;
	      double S;
	      double CLI;
	      Scanner KBD = new Scanner(System.in);
	      //Application Header
	      System.out.println("Welcome to Paragraph Readability Analyzing Application"); 
		  System.out.println("-----------------------------------\n");
	      //Prompt user to enter in a paragraph
	     System.out.println("Please enter a paragraph to Analyze: ");
	     System.out.println("-----------------------------------\n");
	     String PRGH = KBD.nextLine();
	     
	     //counting the whitespace and letters
	     
	     for (int i = 0; i < PRGH.length(); i++)
	     {
	    	if(Character.isWhitespace(PRGH.charAt(i)))
	    		W_Space++;
	    	if(Character.isLetter(PRGH.charAt(i)) || Character.isDigit(PRGH.charAt(i)))
	    		LTs++;
	     }
	 //will count the number of characters
	     T1_Array = PRGH.split("");
	     CTs =T1_Array.length;
	     
	     //counting the number of sentence
	     T2_Array = PRGH.split("\\.");
	     sentences = T2_Array.length;
	     
	     //counting the number of words
	     T3_Array = PRGH.split("[ ]");
	     WDs =T3_Array.length;
	    
	     //subtracting character from the whitespace will give the Non-whitespace character
	     Non_W_Space = CTs - W_Space;
	     
	     L = ((LTs*1.0)/WDs) *100;
	     S = ((sentences*1.0)/WDs) *100;
	     CLI = (0.0588*L) - (0.296*S) - 15.8;
	     
	   //Display Output
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Characters: ",CTs);
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Whitespaces: ",W_Space);
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Non-Whitespaces: ",Non_W_Space);
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Sentences: ",sentences);
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Words: ",WDs);
	     System.out.printf(CFMT1 + CFMT2 + "%n", "Letters: ",LTs);
	     System.out.printf(CFMT1 + CFMT3 + "%n", "L: ",L);
	     System.out.printf(CFMT1 + CFMT3 + "%n", "S: ",S);
	     System.out.printf(CFMT1 + CFMT3 + "%n", "CLI: ",CLI);
	   // Close keyboard
	      KBD.close();
	      System.out.println("");
	   // show end of the application
	      System.out.println("End of the Application Paragraph Readability");
	  } 
	}

