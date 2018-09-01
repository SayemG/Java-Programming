//======================================================================
//
// Title: Files
// Description:
//   This program demonstrates the File class.
//
//======================================================================
package wsu.FileClass;

// Import classes
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;

import javax.swing.filechooser.FileSystemView;

//======================================================================
// class FileClass
//======================================================================
public class FileClass
{
    
    //------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------
    private static final String FILE_NAME =
    		"Data" + File.separator + "USStateCapitals.txt";
    private static final String FILE_NAME_TGT =
    		"Data" + File.separator + "USStateCapitals-COPY.txt";
    private static final String FOLDER_NAME = "Data";
    private static final SimpleDateFormat SDF = 
    		new SimpleDateFormat("EEE, d-MMM-yyyy");
    private static final String COLFMT1 = "%-24s";
    private static final String COLFMT2 = "%-20s";
    private static final String COLFMT3 = "%,-20d";

    //------------------------------------------------------------------
    // printFileObjectInfo
    //------------------------------------------------------------------
    public static void printFileObjectInfo(String objType, File f)
    {
    	
    	// Print file object info
    	System.out.println("\nObject (" + objType + ") information");
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Name:", 
			f.getName());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Path:", 
			f.getPath());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Folder?",
			f.isDirectory());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "File?", 
			f.isFile());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Hidden?",
			f.isHidden());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Readable?", 
			f.canRead());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Writable?",
			f.canWrite());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Executable?", 
			f.canExecute());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Parent path:", 
			f.getParent());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", "Absolute path:", 
			f.getAbsolutePath());
    	System.out.printf(COLFMT1 + COLFMT3 + "%n", 
			"Length (bytes):", f.length());
    	System.out.printf(COLFMT1 + COLFMT2 + "%n", 
			"Date last modified:", SDF.format(f.lastModified()));
    	
     }
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main(String[] args)
    {
    
        // Declare variables
        File drives[] = null;  // Create drives array
        File fileObj = null;  // Create file object
        File folderObj = null;  // Create file object
        File fileTgt = null;  // Create file object

        // Show application header
        System.out.println("Welcome to File Class");
        System.out.println("---------------------");
        
        // Loop to list drives on this computer
        drives = File.listRoots();
    	System.out.println ("\nDrive information");
        for (File f : drives)
			System.out.printf(COLFMT1 + COLFMT2 + "%n", "Drive:", f);

        // Create file objects
        fileObj = new File(FILE_NAME);
        folderObj = new File(FOLDER_NAME);

        // Print file/folder object information
        printFileObjectInfo("file", fileObj);
        printFileObjectInfo("folder", folderObj);
        
        // Attempt to copy file
        fileTgt = new File(FILE_NAME_TGT);        
        Path pathSrc = fileObj.toPath();
        Path pathTgt = fileTgt.toPath();
        try
		{
			Files.copy(pathSrc, pathTgt, 
				StandardCopyOption.REPLACE_EXISTING);
		} 
        catch (IOException e)
		{
            System.out.println("Error: file not copied from '" + 
        		FILE_NAME + "' to '" + FILE_NAME_TGT + "'.");
            System.out.println("Default folder: " + 
                System.getProperty("user.dir"));
            System.out.println("Error message: " + e.getMessage());
		}

        // Loop to print folder files
        System.out.println("\nFiles in folder ..." + File.separator + 
    		folderObj.getPath() + " after copy");
        for (String f : folderObj.list())
        	System.out.println(f);
        
        // Attempt to delete file
        try 
        {
			Files.delete(pathTgt);
        }
        catch (IOException e)
        {
            System.out.println("Error: file '" + FILE_NAME_TGT +
        		"' not deleted.");
            System.out.println("Default folder: " + 
                System.getProperty("user.dir"));
            System.out.println("Error message: " + e.getMessage());
        } 

        // Loop to print folder files
        System.out.println("\nFiles in folder ..." + File.separator + 
    		folderObj.getPath() + " after delete");
        for (String f : folderObj.list())
        	System.out.println(f);
 
        // Show application close
        System.out.println("\nEnd of File Class");

    } 

} 
