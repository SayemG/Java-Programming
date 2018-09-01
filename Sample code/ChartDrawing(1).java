//======================================================================
//
// Title: ChartDrawing
// Description:
//   This program demonstrates drawing charts with chart library
// JFreeChart.
//
//======================================================================
package wsu.ChartDrawing;

//Import classes
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

//======================================================================
// class ChartDrawing
//======================================================================
public class ChartDrawing
{
	
	//------------------------------------------------------------------
    // Fields
    //------------------------------------------------------------------
	private static String[] counties = 
		{"Wayne", "Macomb", "Oakland", "Washtenaw", "Monroe"};
	private static Integer[] populations = 
		{1749366, 867730, 1243970, 364709, 149208};  

	//------------------------------------------------------------------
    // createDataset
    //------------------------------------------------------------------
    private static PieDataset createDataset()
    {
    	
        // Create dataset object
        DefaultPieDataset dataset = new DefaultPieDataset();
    	
        // Loop to set dataset pairs (label, value)
    	for (int i = 0; i < counties.length; i++)
    		dataset.setValue(counties[i], populations[i]); 
    	return dataset;
    	
    }

	//------------------------------------------------------------------
    // createChart
    //------------------------------------------------------------------
    private static JFreeChart createChart(PieDataset dataset)
    {
    	JFreeChart chart = ChartFactory.createPieChart(      
			"2016 County Populations",	// Chart title 
			dataset,
			true,	                  	// Show legend
			true,   	               	// Show tooltips
			false);     	            // Don't show URLs
    	return chart;
    }

	//------------------------------------------------------------------
    // createPanel
    //------------------------------------------------------------------
    public static JPanel createPanel()
    {
    	PieDataset dataset = createDataset();
    	JFreeChart chart = createChart(dataset);  
    	JPanel panel = new ChartPanel(chart);
    	return panel;
    }

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

        // Show application header
        System.out.println("Welcome to Chart Drawing");
        System.out.println("------------------------");
        
        // Create panel and frame
        JPanel panel = createPanel();
        JFrame frame = new JFrame();
        frame.setSize(2400, 1800);
        frame.setTitle("2016 County Populations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);

        // Show application close
        System.out.println("\nEnd of Chart Drawing");

    } 

} 
