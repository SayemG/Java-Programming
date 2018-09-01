//======================================================================
//
// Title:      <B_Readers> // BRAILLE READERS
// Course:     CSC 3020
// Homework:   <#3>
// Author:     <Sayem Chowdhury>
// Date:       <2/22/2018>
// Description:
/*<
	A Java console application that prints the equivalent Braille of the text entered by the user. 
	Braille is a special language used by the blind to read text.  It uses a 3x2 grid of dots to represent different characters. 
>*/
//
//======================================================================

//Package Name
package b_readers1234;
//Import Classes


import java.util.Scanner; 
// Class B_Readers
public class B_Readers {
	//main Function
	public static void main(String[] args) {
		// Show application header
        System.out.println("Welcome to BRAILLE BUDDIES!");
        System.out.println("--------------------------------\n");		
		
	// 3 Dimensional Array //Matrix
		final int[][][] BRAILLE_GRIDS = 
			{
			  {{ 1, 0},  // Inside of Each Level (3 *2 ) dimensional Matrix 
			   { 0, 0}, 
			   { 0, 0}},  // 'a' - 0
			   {{ 1, 0}, 
				{ 1, 0},
				{ 0, 0}},  // 'b' - 1
				  
				  {{ 1, 1}, { 0, 0}, { 0, 0}},  // 'c' - 2
			      {{ 1, 1}, { 0, 1}, { 0, 0}},  // 'd' - 3
				  {{ 1, 0}, { 0, 1}, { 0, 0}},  // 'e' - 4
				  {{ 1, 1}, { 1, 0}, { 0, 0}},  // 'f' - 5
				  {{ 1, 1}, { 1, 1}, { 0, 0}},  // 'g' - 6
				  {{ 1, 0}, { 1, 1}, { 0, 0}},  // 'h' - 7
				  {{ 0, 1}, { 1, 0}, { 0, 0}},  // 'i' - 8
				  {{ 0, 1}, { 1, 1}, { 0, 0}},  // 'j' - 9
				  {{ 1, 0}, { 0, 0}, { 1, 0}},  // 'k' - 10
				  {{ 1, 0}, { 1, 0}, { 1, 0}},  // 'l' - 11
				  {{ 1, 1}, { 0, 0}, { 1, 0}},  // 'm' - 12
				  {{ 1, 1}, { 0, 1}, { 1, 0}},  // 'n' - 13
				  {{ 1, 0}, { 0, 1}, { 1, 0}},  // 'o' - 14
				  {{ 1, 1}, { 1, 0}, { 1, 0}},  // 'p' - 15
				  {{ 1, 1}, { 1, 1}, { 1, 0}},  // 'q' - 16
				  {{ 1, 0}, { 1, 1}, { 1, 0}},  // 'r' - 17
				  {{ 0, 1}, { 1, 0}, { 1, 0}},  // 's' - 18
				  {{ 0, 1}, { 1, 1}, { 1, 0}},  // 't' - 19
				  {{ 1, 0}, { 0, 0}, { 1, 1}},  // 'u' - 20
				  {{ 1, 0}, { 1, 0}, { 1, 1}},  // 'v' - 21
				  {{ 0, 1}, { 1, 1}, { 0, 1}},  // 'w' - 22
				  {{ 1, 1}, { 0, 0}, { 1, 1}},  // 'x' - 23
				  {{ 1, 1}, { 0, 1}, { 1, 1}},  // 'y' - 24
				  {{ 1, 0}, { 0, 1}, { 1, 1}},  // 'z' - 25
				  {{ 0, 0}, { 0, 0}, { 0, 1}}   // upper case follows - 26
				}; 
		
			// user Input Variables 
			Scanner KBD = new Scanner(System.in);
			// Prompting for user input (a string )
			System.out.print("Please Enter a  and for exit please choose -1: ");	
			String ST = KBD.nextLine();
			if(ST.equals("-1"))
				System.exit(0);
			//checking validation of sentence
			String Sp=ST.replaceAll("\\s+", ""); 
			
			//System.out.print(Sp);
		     boolean n=Sp.matches("[a-zA-Z]*");
		     //System.out.print(n);
		      while(!n)
		      {
		    	  System.out.print("You Entered Invalid Sentence\n");
		    	  System.out.print("Please Enter a Sentence: ");
		    	  ST = KBD.nextLine(); 
		    	  if(ST.equals("-1") )
					  System.exit(0);
		    	  
		    	  Sp=ST.replaceAll("\\s+", ""); 
				  boolean  p=Sp.matches("[a-zA-Z]*");
		    	  if (p)
				  n=true;
				  
		      }
			System.out.println("-----------------------------------------------------------------------------------------------\n");	
			
			String token;
			//converting string to lower case string
			token = ST.toLowerCase();
			
			
			System.out.print("\nChracter: ");
			for (int i = 0; i<ST.length();i++)
				
			{
				if ('A' <=ST.charAt(i) && ST.charAt(i)<= 'Z')
				{
					System.out.printf("%-10s","UP");
					System.out.printf("%-5s",(token.charAt(i)));
				}
				else
					System.out.printf("%-11s",ST.charAt(i));

			}
			//calling function print
			print(BRAILLE_GRIDS, ST);
			// close KBD
			KBD.close();
		}

		// Function Print Will display Braille Letters
		private static void print(int [][][] ARRAY, String stg)
		{
			System.out.println("\nROW(1):	\t");
			for(int m=0; m<stg.length(); m++)
			{
				if ('A' <=stg.charAt(m) && stg.charAt(m)<= 'Z')
				{
					System.out.printf("%12s%s", ARRAY[26][0][0]," ");
					System.out.print(ARRAY[26][0][1]);
					char CH = Character.toLowerCase(stg.charAt(m));
				    int ASKI = ((int)CH - 97);
				    System.out.printf("%12s%s", ARRAY[ASKI][0][0]," ");
					System.out.print(ARRAY[ASKI][0][1]);
					
				}
				else if(stg.charAt(m) == ' ') // checking for white space character in string
				{
					System.out.print(" ");
				}
				else
				{
					System.out.printf("%12s%s", ARRAY[(int)stg.charAt(m)-97][0][0]," ");
					System.out.print(ARRAY[(int)stg.charAt(m)-97][0][1]);
				}	
			}
			
				System.out.println("\nROW(2):	");
				
			for(int i=0; i<stg.length(); i++)
			{
				if ('A' <=stg.charAt(i) && stg.charAt(i)<= 'Z') // checking if there is upper case letter in string
				{
					System.out.printf("%12s%s", ARRAY[26][1][0]," ");
					System.out.print(ARRAY[26][1][1]);
					char ch = Character.toLowerCase(stg.charAt(i));
				    int AS = ((int)ch - 97);
				    System.out.printf("%12s%s", ARRAY[AS][1][0]," ");
					System.out.print(ARRAY[AS][1][1]);
				}
				else if(stg.charAt(i) == ' ')
					{
					System.out.print(" ");
					}
				else
					{	
						System.out.printf("%12s%s", ARRAY[(int)stg.charAt(i)-97][1][0]," ");
						System.out.print(ARRAY[(int)stg.charAt(i)-97][1][1]);
					}
			}
			
			System.out.println("\nROW(3):	");
			for(int i=0; i<stg.length(); i++)
			{
				if ('A' <=stg.charAt(i) && stg.charAt(i)<= 'Z')
				{
					System.out.printf("%12s%s", ARRAY[26][2][0]," ");
					System.out.print(ARRAY[26][2][1]);
					char Ch = Character.toLowerCase(stg.charAt(i));
				    int CI = ((int)Ch - 97);
				    System.out.printf("%12s%s", ARRAY[CI][2][0]," ");
					System.out.print(ARRAY[CI][2][1]);
				}
				
				else if(stg.charAt(i) == ' ')
				{
					System.out.print(" ");
				}
				else
				{
					System.out.printf("%12s%s", ARRAY[(int)stg.charAt(i)-97][2][0]," ");
					System.out.print(ARRAY[(int)stg.charAt(i)-97][2][1]);
				}
			}
			System.out.println("\n------------------------------------------------------------------------------------------------\n");		
			System.out.println();
			System.out.print("\nEnd of the Application BRAILLE BUDDIES");
		} 
}

	


