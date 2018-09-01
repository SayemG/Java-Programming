//======================================================================
//
// Title: FormattedPrint
// Description:
//   This program demonstrates formatted printing using the printf 
// statement and the DecimalFormat class.
//
//======================================================================
package wsu.FormattedPrint;

// Import classes
import java.text.DecimalFormat;

//======================================================================
// class FormattedPrint
//======================================================================
public class FormattedPrint
{
    
	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {

    	// Declare constants
        final String COLFMT1 = "%-18s";
        final String COLFMT2 = "%8d";
        final String COLFMT3 = "%10.2f";

		// Show application header
		System.out.println("Welcome to Formatted Print");
		System.out.println("--------------------------\n");
		System.out.println("Note that the pound sign (#) in the " +
		                   "following statements is simply used to " +
		                   "\nmark where the next field after the " +
		                   "formatted output would begin.\n");
	    
        // Show integer (d) formatting
        System.out.println("Integer (d) formatting");
        System.out.println("123456789+123456789+");
        System.out.printf("%10d#%n", 765);  // right-justified
        System.out.printf("%-10d#%n", 765);  // left-justified
        System.out.printf("%d#%n", 765);  // just enough space
        System.out.printf("%6d%6d#%n", 765, 234);
        System.out.printf("%,20d%n", 7654321);  // commas
        System.out.printf("%+20d%n", 7654321);  // leading number sign
        System.out.printf("%020d%n", 7654321);  // leading zeroes
        System.out.printf("%+,20d%n", 7654321);  // both leading number sign and commas
        System.out.println("123456789+123456789+");
        System.out.println("");
	    
        // Show floating-point (f) formatting
        System.out.println("Floating-point (f) formatting");
        System.out.println("123456789+123456789+");
        System.out.printf("%10.2f#%n", 765.456);  // right-justified
        System.out.printf("%-10.2f#%n", 765.456);  // left-justified
        System.out.printf("%f#%n", 765.456);  // just enough space
        System.out.printf("%6.1f%6.1f#%n", 765.45, 234.67);
        System.out.printf("%,20.1f%n", 76543.25);  // commas
        System.out.printf("%+20.1f%n", 76543.25);  // leading number sign
        System.out.printf("%020.1f%n", 76543.25);  // leading zeroes
        System.out.printf("%+,20.1f%n", 76543.25);  // both leading number sign and commas
        System.out.println("123456789+123456789+");
        System.out.println("");
	    
        // Show string (s) formatting
        System.out.println("String (s) formatting");
        System.out.println("123456789+123456789+");
        System.out.printf("%10s#%n", "Detroit");
        System.out.printf("%-10s#%n", "Detroit");
        System.out.printf("%s#%n", "Detroit");
        System.out.printf("%8s%8s#%n", "Detroit", "Chicago");
        System.out.println("123456789+123456789+");
        System.out.println("");
	    
        // Show floating-point (f) formatting
        DecimalFormat fourPlaces = new DecimalFormat("#,##0.0000");
        System.out.println("DecimalFormat formatting");
        System.out.println("123456789+123456789+");
        System.out.println(fourPlaces.format(12345.45678));
        System.out.printf("%20s%n", fourPlaces.format(12345.45678));
        System.out.printf("%-20s%n", fourPlaces.format(12345.45678));
        System.out.println("123456789+123456789+");
        System.out.println("");
	    
        // Show stored formatting (Dakota formatting)
        System.out.println("Dakota formatting");
        System.out.println("123456789+123456789+123456789+123456789+");
        System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + "%n", 
    		"Wayne State", 1868, 0.82);
        System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + "%n", 
    		"Michigan State", 1855, 21.0);
        System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + "%n", 
    		"Michigan", 1817, 12.86);
        System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + "%n", 
    		"Notre Dame", 1842, 5.1);
        System.out.println("123456789+123456789+123456789+123456789+");
        System.out.println("");

        // Show application close
		System.out.println("End of Formatted Print");

    } 

} 
