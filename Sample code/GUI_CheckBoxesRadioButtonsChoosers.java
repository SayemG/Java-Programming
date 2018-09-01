//======================================================================
//
// Title: GUI Check Boxes, Radio buttons, Color Chooser, and File 
//        Chooser
// Description:
//   This program demonstrates a graphical user interface (GUI) with 
// check boxes, radio buttons, a color chooser, and a file chooser.
//
//======================================================================
package wsu.GUI_CheckBoxesRadioButtonsChoosers;

//Import AWT classes
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//Import Swing classes
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//======================================================================
// class GUI_CheckBoxesRadioButtonsChoosers
//======================================================================
public class GUI_CheckBoxesRadioButtonsChoosers
{
    
	//------------------------------------------------------------------
    // Constants
	//------------------------------------------------------------------
    
    // Declare font constants
	public static Font controlFont = new Font("Verdana", Font.BOLD, 42);
	
	//------------------------------------------------------------------
    // Variables
	//------------------------------------------------------------------

    // Define status variables
	private static JLabel lblStatusCheckBoxes = 
		new JLabel("Check box status: ");
	private static JLabel lblStatusRadioButtons = 
		new JLabel("Radio button status: ");
    
	//------------------------------------------------------------------
    // showStatusCheckBoxes
	//------------------------------------------------------------------
    public static void showStatusCheckBoxes(JCheckBox cb1, 
		JCheckBox cb2, JCheckBox cb3, JCheckBox cb4)
    {
    	
    	// Declare variables
    	String s = "";
    	
    	// Test which check boxes selected
		if (cb1.isSelected())
            s = cb1.getText().trim();
		if (cb2.isSelected())
		{
			if (s.length() != 0) s = s + ", ";
			s = s + cb2.getText().trim();
		}
		if (cb3.isSelected())
		{
			if (s.length() != 0) s = s + ", ";
			s = s + cb3.getText().trim();
		}
		if (cb4.isSelected())
		{
			if (s.length() != 0) s = s + ", ";
			s = s + cb4.getText().trim();
		}
		
		// Show check box status    
		lblStatusCheckBoxes.setText("Check box status: '" + s + 
			"' selected.");

    }
    
	//------------------------------------------------------------------
    // showStatusRadioButtons
	//------------------------------------------------------------------
    public static void showStatusRadioButtons(String button, 
		boolean selected)
    {
    	
    	// Test if radio button selected
		if (selected)
            lblStatusRadioButtons.setText("Radio button status: '" + 
        		button.trim() + "' selected.");
		else
            lblStatusRadioButtons.setText("Radio button status: '" + 
        		button.trim() + "' unselected.");
		
    }
    
	//------------------------------------------------------------------
    // main
	//------------------------------------------------------------------
    public static void main(String[] args)
    {

		// Show application header
		System.out.println("Welcome to GUI Check Boxes, " +
			"Radio buttons, Color Chooser, and File Chooser");
		System.out.println("---------------------------");
		
		lblStatusCheckBoxes.setFont(controlFont);
		lblStatusRadioButtons.setFont(controlFont); 

    	// Declare check box controls
    	JLabel lblCheckBoxes = new JLabel("Check Boxes: ");
    	lblCheckBoxes.setFont(controlFont);
    	
    	JCheckBox cb1 = new JCheckBox("Salt   ");
    	cb1.setBackground(Color.GREEN);
    	cb1.setFont(controlFont);
    	
    	JCheckBox cb2 = new JCheckBox("Pepper ");
    	cb2.setBackground(Color.GREEN);
    	cb2.setFont(controlFont);
    	
    	JCheckBox cb3 = new JCheckBox("Mustard");
    	cb3.setBackground(Color.GREEN);
    	cb3.setFont(controlFont);
    	
    	JCheckBox cb4 = new JCheckBox("Ketchup");
    	cb4.setBackground(Color.GREEN);
    	cb4.setFont(controlFont);

        // Define check box click responses
        cb1.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusCheckBoxes(cb1, cb2, cb3, cb4); 
			}
        });
        cb2.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusCheckBoxes(cb1, cb2, cb3, cb4); 
			}
        });
        cb3.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusCheckBoxes(cb1, cb2, cb3, cb4); 
			}
        });
        cb4.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusCheckBoxes(cb1, cb2, cb3, cb4); 
			}
        });
        
    	// Declare radio button variables
    	JLabel lblRadioButtons = new JLabel("Radio Buttons: ");
    	lblRadioButtons.setFont(controlFont);
    	
    	JRadioButton rb1 = new JRadioButton("Summer");
    	rb1.setBackground(Color.ORANGE);
    	rb1.setFont(controlFont);
    	
    	JRadioButton rb2 = new JRadioButton("Fall  ");
    	rb2.setBackground(Color.ORANGE);
    	rb2.setFont(controlFont);
    	
    	JRadioButton rb3 = new JRadioButton("Winter");
    	rb3.setBackground(Color.ORANGE);
    	rb3.setFont(controlFont);
    	
    	JRadioButton rb4 = new JRadioButton("Spring");
    	rb4.setBackground(Color.ORANGE);
    	rb4.setFont(controlFont);

        // Define radio button click responses
        rb1.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusRadioButtons(rb1.getText(), rb1.isSelected()); 
			}
        });
        rb2.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusRadioButtons(rb2.getText(), rb2.isSelected()); 
			}
        });
        rb3.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusRadioButtons(rb3.getText(), rb3.isSelected()); 
			}
        });
        rb4.addItemListener(new ItemListener()
        {
			@Override
			public void itemStateChanged(ItemEvent e)
			{ 
				showStatusRadioButtons(rb4.getText(), rb4.isSelected()); 
			}
        });

        // Define choosers
    	JColorChooser ccColors = new JColorChooser();
    	JFileChooser fcFileChooser = new JFileChooser();

    	// Define panels and groups
    	JPanel plCheckBoxes = new JPanel();
    	JPanel plRadioButtons = new JPanel();
    	ButtonGroup bgRadioButtons = new ButtonGroup();

    	// Create check boxes panel and add controls to it
    	plCheckBoxes.setBackground(Color.GREEN);
    	plCheckBoxes.add(lblCheckBoxes);
    	plCheckBoxes.add(cb1);
    	plCheckBoxes.add(cb2);
    	plCheckBoxes.add(cb3);
    	plCheckBoxes.add(cb4);
    	plCheckBoxes.add(lblStatusCheckBoxes);
		
    	// Create radio buttons panel and add controls to it
    	plRadioButtons.setBackground(Color.ORANGE);
    	plRadioButtons.add(lblRadioButtons);
    	plRadioButtons.add(rb1);
    	plRadioButtons.add(rb2);
    	plRadioButtons.add(rb3);
    	plRadioButtons.add(rb4);
    	plRadioButtons.add(lblStatusRadioButtons);
		
    	// Create radio button group
    	bgRadioButtons.add(rb1);
    	bgRadioButtons.add(rb2);
    	bgRadioButtons.add(rb3);
    	bgRadioButtons.add(rb4);
	
		// Create and run frame
    	JFrame frame = new JFrame();
    	frame.setLayout(new GridLayout(2, 2, 10, 10));
        frame.setSize(3000, 2000);
        frame.setTitle("GUI Check Boxes, Radio Buttons, Choosers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add panels to frame and show it
        frame.add(plCheckBoxes);
        frame.add(plRadioButtons); 
        frame.add(ccColors);        
        frame.add(fcFileChooser);        
        frame.setVisible(true);
    	
    	// Show application close
    	System.out.println("\nEnd of GUI Check Boxes, " +
			"Radio buttons, Color Chooser, and File Chooser");

    }

}
