//======================================================================
//
// Title: Text File Input And Output
// Description:
//   This program demonstrates reading from and writing to a text file.
//
//======================================================================
package wsu.TextFileInputAndOutput;

// Import classes
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

//======================================================================
// class TextFileInputAndOutput
//======================================================================
public class TextFileInputAndOutput
{
    
    //------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------
    public static final String FILE_NAME_IN = "USStateCapitals.txt";
    public static final String FILE_NAME_OUT = 
		"USStateCapitalsSelected.txt";
    public static final int STATES = 50;
    public static final String COLFMT = "%-20s";
    
    //------------------------------------------------------------------
    // readTextFile
    //------------------------------------------------------------------
    public static void readTextFile(String[] states, 
		String[] capitals)
    {
        
        // Declare variables
        Scanner fileIn = null;
        String line;
        int lineCount;
        final String DELIMITERS = "-";
        StringTokenizer tokens;
    
        // Attempt to open input file
        try
        {
        	
        	// Assign external file to file handle
            fileIn = new Scanner(new FileInputStream(FILE_NAME_IN));
            
            // Print column headers
            System.out.printf(COLFMT + COLFMT + "%n", "State", 
        		"Capital");
        
            // Loop to read US state capitals
            lineCount = 0;
            while (fileIn.hasNextLine())
            {
                
                // Tokenize input line
                line = fileIn.nextLine();
                tokens = new StringTokenizer(line, DELIMITERS);
                
                // Store and print tokens
                states[lineCount] = tokens.nextToken().trim();
                capitals[lineCount] = tokens.nextToken().trim();
                System.out.printf(COLFMT + COLFMT + "%n", 
            		states[lineCount], capitals[lineCount]);

                // Increment line counter
                lineCount = lineCount + 1;

            }
            
            // Show number of lines read
            System.out.println("\n" + lineCount + " line(s) read " +
                "from file '" + FILE_NAME_IN + "'.");

            // Close input file
            fileIn.close();
            
        }
        
        // Handle file error
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file '" + FILE_NAME_IN +
                "' not found.");
            System.out.println("Default folder: " + 
                System.getProperty("user.dir"));
            System.out.println("Error message:" + e.getMessage());
        }
    
    }
    
    //------------------------------------------------------------------
    // writeTextFile
    //------------------------------------------------------------------
    public static void writeTextFile(boolean appendFlag, 
            String firstLetter, String[] states, String[] capitals)
    {
        
        // Declare variables
        PrintWriter fileOut = null;
        int lineCount;

        // Attempt to open output file
        try
        {
        	
        	// Assign external file to file handle
            fileOut = new PrintWriter(
                new FileOutputStream(FILE_NAME_OUT, appendFlag));
            
            // Print column headers
            System.out.println();
            System.out.printf(COLFMT + COLFMT + "%n", "State", 
        		"Capital");
            
            // Loop to write selected US state capitals
            lineCount = 0;
            for (int i = 0; i < states.length; i++)
            {
                if (states[i].startsWith(firstLetter))
                {
                	
                	// Write and print selected state
                    fileOut.println(states[i] + " - " + capitals[i]);
                    System.out.printf(COLFMT + COLFMT + "%n", 
                		states[i], capitals[i]);

                    // Increment line counter
                    lineCount = lineCount + 1;

                }
            }
            
            // Show number of lines written
            System.out.println("\n" + lineCount + " line(s) written to " +
                "file '" + FILE_NAME_OUT + "'.");
                
            // Close output file
            fileOut.close();

        }
        
        // Handle file error
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file '" + FILE_NAME_OUT +
                "' cannot be created or opened.");
            System.out.println("Default folder: " + 
                System.getProperty("user.dir"));
            System.out.println("Error message: " + e.getMessage());
        }
    
    }

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {
        
        // Declare variables
        Scanner keyboard = new Scanner(System.in);
        String[] states = new String[STATES];
        String[] capitals = new String[STATES];
        String appendOption;
        String firstLetter;

        // Show application header
        System.out.println("Welcome to Text File Input And Output");
        System.out.println("-------------------------------------\n");

        // Load data from text file
        readTextFile(states, capitals);

        // Prompt for and get append option
        System.out.print("\nAppend to file '" + FILE_NAME_OUT + 
            "' (Y or N)? ");
        appendOption = keyboard.nextLine().toUpperCase();

        // Prompt for and get state letter
        System.out.print("Enter the first letter of states to " +
            (appendOption.equals("Y") ? "append to" : "save in") + 
            " file '" + FILE_NAME_OUT + "': ");
        firstLetter = keyboard.nextLine().toUpperCase();

        // Write data to text file
        writeTextFile(appendOption.equals("Y"), 
    		firstLetter.substring(0, 1), states, capitals);
    	
        // Close keyboard
        keyboard.close();

        // Show application close
        System.out.println("\nEnd of Text File Input And Output");

    } 

} 
