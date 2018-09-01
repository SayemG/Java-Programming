//======================================================================
//
// Title: Classes - One File
// Description:
//   This program demonstrates a class in one file.
//
//======================================================================
package wsu.Classes_OneFile;

//Import classes
import java.util.Scanner;

//======================================================================
// class Boat
//======================================================================
public class Classes_OneFile
{
    
    //================================================================
    // Fields / instance variables
    //================================================================
    private String name;
    private String type;
    private int length;  // Measured in feet
    
    //==================================================================
    // Constructors
    //==================================================================
    
    public Classes_OneFile()
    {
        System.out.println("\nThis is the Boat with no values constructor.");
        name = "(not set)";
        type = "(not set)";
    }
    
    public Classes_OneFile(String name, String type, int length)
    {
        System.out.println("\nThis is the Boat with values constructor.");
        this.name = name;
        this.type = type;
        this.length = length;
    }
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

    public String getName() 
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getLength()
    {
        return length;
    }
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setLength(int length)
    {
        this.length = length;
    }
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

    public boolean equals(Classes_OneFile b)
    {
        if (this.name.equalsIgnoreCase(b.name) && 
            this.type.equalsIgnoreCase(b.type) &&
            this.length == b.length)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return "Name: " + name + "\nType: " + type +
               "\nLength: " + length + " feet";        
    }

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {
        
        // Declare local variables
        Scanner keyboard = new Scanner(System.in);
        String l_name;
        String l_type;
        int l_length;

        // Show application header
        System.out.println("Welcome to my Boat");
        System.out.println("------------------\n");
    
        // Prompt for and read boat info
        System.out.print("Enter the name of your boat: ");
        l_name = keyboard.next();
        System.out.print("Enter the type of your boat: ");
        l_type = keyboard.next();
        System.out.print("Enter the length of your boat in feet: ");
        l_length = keyboard.nextInt();
        
        // Create boat 1 object
        Classes_OneFile boat1 = new Classes_OneFile(l_name, l_type, l_length);

        // Print boat 1 object info
        System.out.println("\nBoat 1 object info");
        System.out.println("Name:   " + boat1.getName());
        System.out.println("Type:   " + boat1.getType());
        System.out.println("Length: " + boat1.getLength() + " feet");
        
        // Create boat 2 object
        Classes_OneFile boat2 = new Classes_OneFile();
        boat2.setName("Fancy Free");
        boat2.setType("sailboat");
        boat2.setLength(55);
        
        // Print boat 2 object info
        System.out.println("\nBoat 2 object info");
        System.out.println("Name:   " + boat2.getName());
        System.out.println("Type:   " + boat2.getType());
        System.out.println("Length: " + boat2.getLength() + " feet");
        
        // Compare boat 1 and boat 2
        if (boat1.equals(boat2))
            System.out.println("\nThe boats have the same info.");
        else
        {
            System.out.println("\nThe boats do not have the same info:");
            System.out.println("Boat 1\n" + boat1.toString());
            System.out.println("Boat 2\n" + boat2.toString());
        }
    
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of my Boat");

    }
    
} 
