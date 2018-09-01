// Title:      <Sphere_Calculation.java>
// Course:     CSC 3020
// Homework:   <1>
// Author:     <Sayem Chowdhury>
// Date:       <01/22/2018>

/* Description: This program will read the radius of the Sphere from the user  and 
 * calculate and print the volume, circumference, Surface Area of the  of the  Sphere.
 * 
*/
 //Package name
package Sphere_cal;
//Import Classes
import java.util.Scanner;
//java Sphere_Calculation Class
public class Sphere_Calculation {
	//main method
	public static void main(String[] args) { 
		
				// declaring constant Format constant
				final String CF1= "%-18s";
				final String CF2= "%16.3f"; 
				final String CF3= "%4s"; 
				//Application Header
				System.out.println("Welcome to Spherical Stunts");
				System.out.println("---------------------------\n");
				//prompt for the user input and reading user input
				System.out.print("please Enter the radious in cm:");
				Scanner Keyboard =new Scanner(System.in);
				Double r=Keyboard.nextDouble();
				System.out.println(" ");
				
				//Variable Deceleration
				double Volume, Circumference,Surface_area;
				final double pi=Math.PI;
				// Calculation
				Volume = (4/3)*pi*r*r;
				Circumference=2*pi*r;
				Surface_area= 4*pi*r*r; 
			 	//Display output
				System.out.printf(CF1+CF2+CF3+"\n", "Radious:", r, "   cm" ); 
				System.out.printf(CF1+CF2+CF3+"\n", "Volume:", Volume, "   cm^3" );
				System.out.printf(CF1+CF2+CF3+"\n", "Circumference:", Circumference, "   cm" );
				System.out.printf(CF1+ CF2+CF3+"\n", "Surface Area:", Surface_area, "   cm^2" );
				
				//keyboard close
				Keyboard.close();
				// Show application close
		        System.out.println("\nEnd of my Spherical Stunts");
			} 	
	}
