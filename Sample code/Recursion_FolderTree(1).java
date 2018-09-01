//======================================================================
//
// Title: Recursion-FileList
// Description:
//   This program demonstrates recursion of the project folder.
//
//======================================================================
package wsu.Recursion_FolderTree;

// Import classes
import java.io.File;
import java.io.IOException;

//======================================================================
// class Recursion_FileList
//======================================================================
public class Recursion_FolderTree
{
    
    //------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------
    public static final String FOLDER_NAME = ".";  // Current folder
    public static final String PARENT_FOLDER_NAME = "..";  // Parent folder
	
    //------------------------------------------------------------------
    // printFileTree
    //------------------------------------------------------------------
    public static void printFileTree(File f, String spacer)
    {
    	
    	// Declare variables
    	File[] fileList;
    	
    	// Test whether to print output header
		if (spacer.length() == 0)
		{
			try
			{
				System.out.println("\nFolder tree for '" + 
					f.getCanonicalPath() + "'");
			}
			catch (IOException e)
			{
	            System.out.println("Error: cannot get path.");
	            System.out.println("Error message: " + e.getMessage());
			}
		}
    	
    	// Test if base case reached
    	if (f.isFile())
    		System.out.println(spacer + "f: " + f.getName());
    	else
    	{
    		
    		// Print directory name
    		System.out.println(spacer + "d: " + f.getName());
    		
    		// Loop through directories and files within current directory
    		fileList = f.listFiles();
    		for (File e: fileList)
    			printFileTree(e, spacer + "  ");
    		
    	}
    }

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
        File fileObj1 = null;  // Create file object
        File fileObj2 = null;  // Create file object

        // Show application header
        System.out.println("Welcome to Recursion-FileList");
        System.out.println("-----------------------------");
        System.out.println("d - directory");
        System.out.println("f - file");
        
        // Create file objects
        fileObj1 = new File(FOLDER_NAME);
        fileObj2 = new File(PARENT_FOLDER_NAME);

        // Show file tree
        printFileTree(fileObj1, "");
        printFileTree(fileObj2, "");

        // Show application close
        System.out.println("\nEnd of Recursion-FileList");

    } 

} 
