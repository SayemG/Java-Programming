//======================================================================
//
// Title: GUI Labels, Text Boxes, and Buttons
// Description:
//   This program demonstrates a graphical user interface (GUI) with 
// labels, text boxes, and buttons.
//
//======================================================================
package wsu.GUI_LabelsTextBoxesButtons;

//Import classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//======================================================================
// class GUI_LabelsTextBoxesButtons
//======================================================================
public class GUI_LabelsTextBoxesButtons
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Show application header
        System.out.println("Welcome to GUI Labels, Text Boxes, Buttons");
        System.out.println("------------------------------------------");

        // Define controls
        JLabel lblHeight = new JLabel("Enter your eye height above " +
            "the water (feet): ");
        final JTextField txtHeight = new JTextField(10);
        JButton btnCalc = new JButton("Calculate");
        JLabel lblHorizon = new JLabel("Your distance to the " +
            "horizon (miles): ");
        final JTextField txtHorizon = new JTextField(10);
        JButton btnReset = new JButton("Reset");

        // Define text box entry response
        // Event triggered when Enter key pressed
        txtHeight.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                JOptionPane.showMessageDialog(null,
                    "'" + txtHeight.getText() + "' entered for height.", 
                    "Height message", JOptionPane.INFORMATION_MESSAGE);
            }
                            
        });

        // Define calculate button response
        btnCalc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                double height;
                double distance;
                try
                {
                    height = Double.parseDouble(txtHeight.getText());
                    distance = Math.sqrt(height * 1.5);
                    distance = Math.round(distance * 100) / 100.;
                        // Round distance to two decimal places
                    txtHorizon.setText(String.valueOf(distance));
                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Error: '" +
                        txtHeight.getText() + "' is not a valid number.", 
                        "Number error", JOptionPane.ERROR_MESSAGE);
                    txtHeight.setText("");
                }
            }
        });

        // Define reset button response
        btnReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                txtHeight.setText("");
                txtHorizon.setText("");
            }
        });
        
        // Create panel and add controls to it
        JPanel panel = new JPanel();
        panel.add(lblHeight);
        panel.add(txtHeight);
        panel.add(btnCalc);
        panel.add(lblHorizon);
        panel.add(txtHorizon);
        panel.add(btnReset);

        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(560, 120);
        frame.setTitle("Horizon Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);
        
        // Show application close
        System.out.println("\nEnd of GUI Labels, Text Boxes, Buttons");

    }

}
