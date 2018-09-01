//======================================================================
// Title:      <MS_Stock_Market_2018>
// Course:     CSC 3020
// Homework:   <#4>
// Author:     <Sayem Chowdhury>
// Date:       <date>
// Description:
//   <aAJava console application...
//	 ...that analyzes their stock data over the past eleven years.>
//======================================================================
//Package Name
package MS_Stock;
//Import Classes
//-------------------------------------------------------------------------
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset; 
//------------------------------------------------------------------
//Class Name
public class MS_Stock_Market_2018 {

	static int dataCount =0;
	
	//Declare formatting constants
    private static String header; 
    
  //Function that read file and save data into specified ArrayList
    public static void readTextFile(ArrayList<String> date, ArrayList<Double> close, 
    		ArrayList<Integer> volume,ArrayList<Double> open, ArrayList<Double> high, ArrayList<Double> low)
        {
            
            // Declaring variables
            Scanner fileIn = null;
            boolean headerRead;
            String line;
            // Attempt to open input file
            
            //try catch Block
            try//Exception handler 
            { 	
            	// Assign external file to file handle
                fileIn = new Scanner(new FileInputStream("MicrosoftStockData.txt"));
                // Loop to read data
                headerRead = false;
                //dataCount = 0;
                while (fileIn.hasNextLine())
                {
                    // Read each line and test if header row
                    line = fileIn.nextLine();
                	if (!headerRead)
                	{
                		header = line;
                		headerRead = true;
                	}
                	else
                	{
                		String[] Token = line.split(",");
                		date.add(Token[0]);
                		close.add(Double.parseDouble(Token[1]));
                		volume.add(Integer.parseInt(Token[2]));
                		open.add(Double.parseDouble(Token[3]));
                		high.add(Double.parseDouble(Token[4]));
                		low.add(Double.parseDouble(Token[5]));
                        // Incrementing line counter
                        dataCount = dataCount + 1;	
                	}
                }
                
                // Show number of lines read
                System.out.println(dataCount + " data line(s) " +
                        "read from file '" + "MicrosoftStockData.txt" + "'.");
                // Close input file
                fileIn.close();
                
            }    
            // Handle file error
            catch (FileNotFoundException e) //catch Block
            {
                System.out.println("Error: file '" + "MicrosoftStockData.txt" +
                    "' not found.");
                System.out.println("Default folder: " + 
                    System.getProperty("user.dir"));
                System.out.println("Error message:\n" + e.getMessage());
            } 
        }	

//---------------------------Print Function----------------------------------------------
	public static void printData(ArrayList<String> date, ArrayList<Double> close, ArrayList<Integer> volume,
    		ArrayList<Double> open, ArrayList<Double> high, ArrayList<Double> low) throws IOException
    {
    	
    	System.out.println("\nFirst 12 days of data rangaing from "
    			+ "3/5/2018 - 2/15/2018");
    	
    	
    	System.out.print("Date                  "+"close      " +"Volume             "+"Open          "+"High          "+"Low \n");
    	//System.out.printf("%13s %13s %,15s %13s %13s %13s%n", "Date","Close", "Volume", "Open", "High", "low");
    	System.out.println("-------------------------------------------------------------------------------------------------");
    	
    	int i=0;
    	while(i<12)
    	{
    		System.out.printf("%-13s %13.2f %,15d %13.2f %13.2f %13.2f%n", date.get(i), close.get(i),
    				volume.get(i), open.get(i),high.get(i), low.get(i)); 
    		i++;
    	} 	
    } 
	
//-------------------------------------------Function analyzeData-------------------------------------------------------------------

	public static void analyzeData(ArrayList<String> date, 
    		ArrayList<Double> close, ArrayList<Integer> volume,
    		ArrayList<Double> open, ArrayList<Double> high, ArrayList<Double> low, ArrayList<Integer> y, ArrayList<Double> endC)
    {

    	int i=0, maxIndex=-1; 
    	Double max= null;
    	for (Double x : close) 
    	{
		    if ((x!=null) && ((max==null) || (x>max))) 
		    {
		      max = close.get(i);
		      maxIndex = i;
		    }
		    i++;
    	 }
		 
		 int j =0, minIndex=-1; 
		 Double min= null;
		for (Double x : close) 
		{
		  if ((x!=null) && ((min==null) || (x<min))) 
		  {
		    min = close.get(j);
		    minIndex = j;
		  }
		  j++;
		}

		Double diff = high.get(0) - low.get(0);
		int diff_idx = 0;
		for (int idx = 0; idx<high.size(); idx++)
		{
			if ((high.get(idx) -low.get(idx))>diff)
			{
				diff = high.get(idx) -low.get(idx);
				diff_idx = idx;
			}			
		}
		
    	String[] only_year = date.get(0).split("/");
	  	y.add(Integer.parseInt(only_year[2]));
    	endC.add(close.get(0));
    	for (int index= 1; index<date.size(); index++)
    	{
    		String s1 = date.get(index);
    		String s2 = date.get(index -1);
    		int i1 = s1.length()-1;
    		int i2 = s2.length()-1;
    		if (s1.charAt(i1) != s2.charAt(i2))
    		{
    			only_year = new String[3];
    			only_year = date.get(index).split("/");
    			y.add(Integer.parseInt(only_year[2]));
    	    	endC.add(close.get(index));
    		}		
    	}
    	
    	System.out.printf("%n%13s %20s", "Year", "Closing Value");
    	for (int x = 0; x<y.size(); x++)
    	{    		
    		System.out.printf("\n%13s %13.2f",y.get(x), endC.get(x));
    	}
    	
    	// print Labels Data And Value
    	System.out.printf("\n\n %10s %40s %18s %n", "Labels", "Date", "Value");
    	System.out.printf("%-45s %10s %14.2f", "Highest Closing Data",date.get(maxIndex), close.get(maxIndex));
    	System.out.printf("\n%-45s %10s %14.2f", "Lowest Closing Data",date.get(minIndex), close.get(minIndex));
    	System.out.printf("\n%-45s %10s %14.2f", "Difference of Highest and Lowest Data ",date.get(diff_idx), diff);		
    }
	
//----------------------------------------Function CharData------------------------------------------------------------
//=========================================================================
	
	  private static void chartData(ArrayList<Double> yearEndClosingV, ArrayList<Integer> endY)
	    {
	    	// Create panel and frame
	        JPanel panel = createPanel(yearEndClosingV,endY);
	        JFrame frame = new JFrame();
	        frame.setSize(2400, 1800);
	        frame.setTitle("Microsoft Stock Data");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Add panel to frame and show frame
	        frame.add(panel);
	        frame.setVisible(true);	
	    }
	 
//==========================Function  creating Panel=================================================
	    public static JPanel createPanel(ArrayList<Double> endC, ArrayList<Integer> y)
	    {
	    	DefaultCategoryDataset dataset = createDataset(endC, y);
	    	JFreeChart chart = createChart(dataset);  
	    	JPanel panel = new ChartPanel(chart);
	    	return panel;
	    }	    
//==========================Function DefaultCategoryDataset========================================================================
	    
	    //Function DefaultCategoryDataset
	    private static DefaultCategoryDataset createDataset(ArrayList<Double> endC, ArrayList<Integer> y)
	    
	    {
	        // Creating Data set object
	    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    		// for loop
	    	for (int i = endC.size()-1; i>= 0; i--)
	    		dataset.setValue(endC.get(i), "Closing Value", y.get(i)); 
	    	return dataset;
	    	
	    }
	    
//=========================== Creating**Jfree***Chart ==============================================================================================
	    
	    private static JFreeChart createChart(DefaultCategoryDataset dataset)
	    {
	    	JFreeChart chart = ChartFactory.createLineChart(      
				"Microsoft Stock Data by year", "Year", "Stock Price" ,dataset);
	    	return chart;
	    }
	
//============================== Function Main =================================================================================================
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		ArrayList<String> date = new ArrayList<String>();
        ArrayList<Double> close = new ArrayList<Double>();
        ArrayList<Integer> vol = new ArrayList<Integer>();
        ArrayList<Double> open = new ArrayList<Double>();
        ArrayList<Double> high = new ArrayList<Double>();
        ArrayList<Double> low = new ArrayList<Double>();
        ArrayList<Integer> year = new ArrayList<Integer>();
        ArrayList<Double> closing_val = new ArrayList<Double>();
        
        // Header of the application
        System.out.println("Welcome to Text File Input And Output " +
    		"With File Specification");
        System.out.println("-------------------------------------------------------------------------\n");

        // Loading data from text file
        readTextFile(date, close, vol, open, high, low);
        printData(date, close, vol, open, high, low);
        analyzeData(date, close, vol, open, high, low, year, closing_val);
        chartData(closing_val, year);

        // close Application
        System.out.println("\n\nEnd of Text File Input And Output With File Specification");
        System.out.println("End of Application");

    } 
		

}
