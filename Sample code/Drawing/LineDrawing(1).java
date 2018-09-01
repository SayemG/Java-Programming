//======================================================================
//
// Class: LineDrawing
// Description:
//   This class demonstrates line drawing.
//
//======================================================================
package wsu.Drawing;

//Import classes
import java.awt.Color;
import java.awt.Graphics; 
import javax.swing.JPanel;

//======================================================================
// class LineDrawing
//======================================================================
@SuppressWarnings("serial")
public class LineDrawing extends JPanel
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

		// Loop to draw vertical lines
		g.setColor(Color.GREEN);
		for (int i = 0; i <= width; i = i + 20)
			g.drawLine(i, 0, i, height);

		// Loop to draw horizontal lines
		g.setColor(Color.BLUE);
		for (int i = 0; i <= height; i = i + 30)
			g.drawLine(0, i, width, i);
      
   } 
   
} 
