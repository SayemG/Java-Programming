//======================================================================
//
// Class: Oval And Rectangle Drawing
// Description:
//   This class demonstrates oval and rectangle drawing.
//
//======================================================================
package wsu.Drawing;

//Import classes
import java.awt.Color;
import java.awt.Graphics; 
import javax.swing.JPanel;

//======================================================================
// class OvalAndRectangleDrawing
//======================================================================
@SuppressWarnings("serial")
public class OvalAndRectangleDrawing extends JPanel
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
		for (int i = 0; i < 7; i++)
			g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 
				50 + i * 10);

		// Loop to draw rectangles
		g.setColor(Color.MAGENTA);
		for (int i = 0; i < 7; i++)
			g.drawRect(200 + i * 10, 10 + i * 10, 50 + i * 10, 
				50 + i * 10);

		// Loop to draw rectangles
		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i < 7; i++)
			g.drawRoundRect(400 + i * 10, 10 + i * 10, 50 + i * 10, 
				50 + i * 10, 40, 40);
      
   } 
   
} 
