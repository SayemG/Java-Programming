//======================================================================
//
// Title: Drawing
// Description:
//   This program demonstrates Java drawing methods.
//
//======================================================================
package wsu.Drawing;

//Import classes
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

//======================================================================
// class Drawing
//======================================================================
public class Drawing
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Show application header
        System.out.println("Welcome to Drawing");
        System.out.println("------------------\n");
        
        // Create panels
        JPanel panel = new JPanel();
        
		// Create line drawing panel
        JPanel panel1 = new LineDrawing();
        panel1.setPreferredSize(new Dimension(700, 200));
        System.out.println("Line drawing panel created.");
        
		// Create oval and rectangle drawing panel
        JPanel panel2 = new OvalAndRectangleDrawing();
        panel2.setPreferredSize(new Dimension(700, 200));
        System.out.println("Oval and rectangle drawing panel created.");
        
		// Create shape-filling panel
        JPanel panel3 = new ShapeFilling();
        panel3.setPreferredSize(new Dimension(700, 200));
        System.out.println("Shape-filling panel created.");

		// Place drawing panels within containing panel
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        System.out.println("Drawing panels placed within containing panel.");

		// Create frame
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setTitle("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Frame created.");
        
        // Add containing panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);
        System.out.println("Containing panel placed within frame.");

        // Show application close
        System.out.println("\nEnd of Drawing");

    } 

} 
