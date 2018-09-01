//======================================================================
//
// Title: GUI Dialog Boxes
// Description:
//   This program demonstrates a graphical user interface (GUI) with 
// dialog boxes.
//
//======================================================================
package wsu.GUI_DialogBoxes;

// Import classes
import javax.swing.JOptionPane;

//======================================================================
// class GUI_DialogBoxes
//======================================================================
public class GUI_DialogBoxes
{
    
	//------------------------------------------------------------------
    // main
	//------------------------------------------------------------------
    public static void main (String[] args)
    {
    
        // Declare variables
    	boolean numberBad = true;
    	String numString = "";
    	int num = 0;
    	int option = JOptionPane.NO_OPTION;

		// Show application header
		System.out.println("Welcome to GUI Dialog Boxes");
		System.out.println("---------------------------");

		// Loop to attempt to get whole number
		while (numberBad || option == JOptionPane.NO_OPTION)
		{
			
			// Attempt to get whole number
			try
			{
				
				// Prompt for and get whole number
				numberBad = true;
				numString = JOptionPane.showInputDialog(null, 
						"Enter a whole number", "Whole number prompt", 
						JOptionPane.QUESTION_MESSAGE);

				// Test if prompt operation cancelled
				if (numString == null)
				{
					numberBad = false;
					option = JOptionPane.CANCEL_OPTION;
				}
				else
				{
					
					// Attempt to convert string to number
					num = Integer.parseInt(numString);
					numberBad = false;

					// Confirm whole number
					option = JOptionPane.showConfirmDialog(null, 
						"Is whole number '" + num + "' okay?",
						"Whole number confirmation", 
						JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
					
				}

			}
			
			// Handle error
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error: '" +
					numString + "' is not a valid whole number.",
					"Whole number error", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		// Test if operation cancelled
		if (option == JOptionPane.CANCEL_OPTION)
			JOptionPane.showMessageDialog(null, 
				"Operation cancelled.", "Whole number message", 
				JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, 
				"Entered number '" + num + "' is a valid whole number.", 
				"Whole number message", JOptionPane.INFORMATION_MESSAGE);
		
		// Show application close
		System.out.println("\nEnd of GUI Dialog Boxes");

    }

}
