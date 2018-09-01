//======================================================================
//
// Class: Shape Filling
// Description:
//   This class demonstrates shape filling.
//
//======================================================================
package wsu.Drawing;

//Import classes
import java.awt.Color;
import java.awt.Graphics; 
import javax.swing.JPanel;

//======================================================================
// class ShapeFilling
//======================================================================
@SuppressWarnings("serial")
public class ShapeFilling extends JPanel
{
	
    //------------------------------------------------------------------
    // paintComponent
    //------------------------------------------------------------------
	public void paintComponent(Graphics g)
	{
	   
		// Display panel
		super.paintComponent(g);
	      
		// Get panel diameters
		int width = getWidth();
		int height = getHeight();

		// Loop to draw ovals
		g.setColor(Color.ORANGE);
		g.fillOval(10, 10, 100, 100);

		// Loop to draw rectangles
		g.setColor(Color.MAGENTA);
		g.fillRect(200, 10, 100, 80);

		// Loop to draw rectangles
		g.setColor(Color.RED);
		g.fillRoundRect(400, 10, 100, 80, 40, 40);
      
   } 
   
} 
