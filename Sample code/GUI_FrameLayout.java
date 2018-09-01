//======================================================================
//
// Title: GUI Frame Layout
// Description:
//   This program demonstrates a graphical user interface (GUI) with a 
// BorderLayout frame style.
//
//======================================================================
package wsu.GUI_FrameLayout;

//Import classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//======================================================================
// class GUI_FrameLayout
//======================================================================
public class GUI_FrameLayout
{
    
	//------------------------------------------------------------------
    // labelImage
	//------------------------------------------------------------------
    public static ImageIcon labelImage(String fileIn)
    {
    	
    	// Declare variables
    	Image image = null;
    	ImageIcon icon = null;
    	
    	// Attempt to read, scale, and convert image
		try
		{
			image = ImageIO.read(new File(fileIn));
	        image = image.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	        icon = new ImageIcon(image);
		} 
		catch (IOException e)
		{
            System.out.println("Error: cannot read file '" + fileIn + 
        		"'.");
            System.out.println("Error message:" + e.getMessage());
		}
		return icon;

    }
    
	//------------------------------------------------------------------
    // main
	//------------------------------------------------------------------
    public static void main (String[] args)
    {

		// Show application header
		System.out.println("Welcome to GUI Frame Layout");
		System.out.println("---------------------------");

        // Define images
        JLabel lblWSU = new JLabel(labelImage("logowsu.jpg"));
        JLabel lblMSU = new JLabel(labelImage("logomsu.png"));
        JLabel lblOU = new JLabel(labelImage("logoou.png"));
        JLabel lblUM = new JLabel(labelImage("logoum.png"));
        JLabel lblEMU = new JLabel(labelImage("logoemu.png"));

		// Create frame
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setTitle("BorderLayout Frame Layout");
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add controls to frame
        frame.add(lblWSU, BorderLayout.PAGE_START);
        frame.add(lblMSU, BorderLayout.LINE_START);
        frame.add(lblOU, BorderLayout.CENTER);
        frame.add(lblUM, BorderLayout.LINE_END);
        frame.add(lblEMU, BorderLayout.PAGE_END);
        
        // Show frame
        frame.setVisible(true);
		
		// Show application close
		System.out.println("\nEnd of GUI Frame Layout");

    }

}
