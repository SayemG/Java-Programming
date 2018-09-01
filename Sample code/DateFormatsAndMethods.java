//======================================================================
//
// Title: Date Formats and Methods
// Description:
//   This program demonstrates Date formats and methods.
//
//======================================================================
package wsu.DateFormatsAndMethods;

// Import classes
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//======================================================================
// class DateFormatsAndMethods
//======================================================================
public class DateFormatsAndMethods
{
    
    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    	
    	// Declare constants
    	final String COLFMTS1 = "%-30s";
    	final String COLFMTS2 = "%-24s";
    	final String COLFMTD = "%,12d";
    
        // Declare variables
    	long currTimeMill = System.currentTimeMillis();
    	long currTimeNano = System.nanoTime();
        
        // Declare Calendar variables
    	Calendar currAsCalendarObj = Calendar.getInstance();
    		// Create Calendar object from current date and time
    	Calendar specAsCalendarObj = 
			new GregorianCalendar(2018,4,1,7,14,21);
    		// Create Gregorian Calendar object from specified date and time
    		// Month parameter is zero-based
        
        // Declare LocalDateTime variables
    	LocalDateTime currAsLocalObj = LocalDateTime.now();
    	LocalDateTime specAsLocalObj = 
			LocalDateTime.of(2018, 9, 3, 11, 52, 17);
    		// Month parameter is one-based

        // Show application header
        System.out.println("Welcome to Date Formats and Methods");
        System.out.println("-----------------------------------\n");
        
        // Show format header
        System.out.println("----------------------------------------");
        System.out.println("Date Formats");
        System.out.println("----------------------------------------");
    
        // Show current date in different formats
        System.out.println("\ncurrAsCalendarObj (current date and time): " + 
    		currAsCalendarObj.getTime());

        // Show set date
        System.out.println("\nspecAsCalendarObj (specified date and " +
    		"time): " + specAsCalendarObj.getTime());

        System.out.printf("%n" + COLFMTS1 + "%-10tD%n", "mm/dd/yy:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tF%n", "yyyy-mm-dd:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tc%n", 
    		"ddd mmm dd hh:mm:ss zzz yyyy:", currAsCalendarObj);

        System.out.printf("%n" + COLFMTS1 + "%-10tY%n", "4-digit year:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10ty%n", "2-digit year:", 
    		currAsCalendarObj);

        System.out.printf("%n" + COLFMTS1 + "%-10tm%n", "2-digit month:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tB%n", "Month name:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tb%n", "3-character month name:",
    		currAsCalendarObj);

        System.out.printf("%n" + COLFMTS1 + "%-10td%n", "Two-digit day:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10te%n", "1- or 2-digit day:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tA%n", "Day-of-week name:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10ta%n", 
    		"3-character day-of-week name:", currAsCalendarObj);

        System.out.printf("%n" + COLFMTS1 + "%-10tR%n", "hh:mm:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tT%n", "hh:mm:ss:", 
    		currAsCalendarObj);
        System.out.printf(COLFMTS1 + "%-10tr%n", "hh:mm:ss am/pm:", 
    		currAsCalendarObj);
        
        // Use argument index to refer to same expression multiple times
        System.out.printf("%n%1$s %2$tB %2$td, %2$tY%n%n", 
    		"Current date using argument index:", currAsCalendarObj);
        
        // Show format header
        System.out.println("----------------------------------------");
        System.out.println("Date Methods");
        System.out.println("----------------------------------------");

        // Show milliseconds since epoch
        System.out.println("\nMilliseconds since 1-Jan-1970: " + 
    		String.format("%,1d", System.currentTimeMillis()));
        
        // Measure operation
        System.out.println("\nOperation timer");
        long loops = 1000000;
        long before = System.currentTimeMillis();
        for (long i = 1L; i <= loops; i++);
        long after = System.currentTimeMillis();
        System.out.printf(COLFMTS2 + COLFMTD + "%n", "Loops:", loops);
        System.out.printf(COLFMTS2 + COLFMTD + "%n", "Time (milliseconds):", 
    		(after - before));

        // Show date parts from current date calendar
        System.out.println("\nCalendar object (current date and time)");
        System.out.printf(COLFMTS1 + "%-10d%n", "Year:", 
    		currAsCalendarObj.get(Calendar.YEAR));
        System.out.printf(COLFMTS1 + "%-10d%n", "Month:", 
    		currAsCalendarObj.get(Calendar.MONTH));  // This is zero based
        System.out.printf(COLFMTS1 + "%-10d%n", "Day of month:", 
    		currAsCalendarObj.get(Calendar.DAY_OF_MONTH));
        System.out.printf(COLFMTS1 + "%-10d%n", "Day of week:", 
    		currAsCalendarObj.get(Calendar.DAY_OF_WEEK));
        System.out.printf(COLFMTS1 + "%-10d%n", "Hour:", 
    		currAsCalendarObj.get(Calendar.HOUR));
        System.out.printf(COLFMTS1 + "%-10d%n", "Minute:", 
    		currAsCalendarObj.get(Calendar.MINUTE));
        System.out.printf(COLFMTS1 + "%-10d%n", "Second:", 
    		currAsCalendarObj.get(Calendar.SECOND));

        // Show date parts from specified date calendar
        System.out.println("\nCalendar object (specified date and time)");
        System.out.printf(COLFMTS1 + "%-10d%n", "Year:", 
    		specAsCalendarObj.get(Calendar.YEAR));
        System.out.printf(COLFMTS1 + "%-10d%n", "Month:", 
    		specAsCalendarObj.get(Calendar.MONTH));
        System.out.printf(COLFMTS1 + "%-10d%n", "Day of month:", 
    		specAsCalendarObj.get(Calendar.DAY_OF_MONTH));
        System.out.printf(COLFMTS1 + "%-10d%n", "Day of week:", 
    		specAsCalendarObj.get(Calendar.DAY_OF_WEEK));
        System.out.printf(COLFMTS1 + "%-10d%n", "Hour:", 
    		specAsCalendarObj.get(Calendar.HOUR));
        System.out.printf(COLFMTS1 + "%-10d%n", "Minute:", 
    		specAsCalendarObj.get(Calendar.MINUTE));
        System.out.printf(COLFMTS1 + "%-10d%n", "Second:", 
    		specAsCalendarObj.get(Calendar.SECOND));

        // Add time to calendar
        specAsCalendarObj.add(Calendar.MONTH, 1);
        System.out.println("\nSpecified date plus 1 month: " + 
    		String.format("%-1tF", specAsCalendarObj.getTime()));

        // Subtract time form calendar
        specAsCalendarObj.add(Calendar.DAY_OF_MONTH, -30);
        System.out.println("Specified date minus 30 days: " + 
    		String.format("%-1tF", specAsCalendarObj.getTime()));

        // Echo dates
        System.out.println("\ncurrAsCalendarObj (current date and " +
    		"time): " + String.format("%-1tF", currAsCalendarObj));
        System.out.println("specAsCalendarObj (specified date and " +
    		"time): " + String.format("%-1tF", specAsCalendarObj));

        // Test if dates equal
        if (currAsCalendarObj.equals(specAsCalendarObj))
            System.out.println("\ncurrAsCalendarObj is the same date " +
        		"and time as specAsCalendarObj.");
        else
            System.out.println("\ncurrAsCalendarObj is NOT the same " +
        		"date and time as specAsCalendarObj.");

        // Compare two dates
        System.out.println("\nComparing dates using method compareTo");
		System.out.println("(1-after; 0-same; -1-before)"); 
        System.out.println("currAsCalendarObj compared to " +
    		"specAsCalendarObj: " + 
    		currAsCalendarObj.compareTo(specAsCalendarObj));
        System.out.println("specAsCalendarObj compared to " +
    		"currAsCalendarObj: " + 
    		specAsCalendarObj.compareTo(currAsCalendarObj));

        // Test if one date before another
        System.out.println("\nComparing dates using method before");
        if (currAsCalendarObj.before(specAsCalendarObj))
            System.out.println("currAsCalendarObj is before " +
        		"specAsCalendarObj.");
        else
            System.out.println("currAsCalendarObj is after " +
        		"specAsCalendarObj.");

        // Test if one date after another
        System.out.println("\nComparing dates using method after");
        if (currAsCalendarObj.after(specAsCalendarObj))
            System.out.println("currAsCalendarObj is after " +
        		"specAsCalendarObj.");
        else
            System.out.println("currAsCalendarObj is before " +
        		"specAsCalendarObj.");

        // Show application close
        System.out.println("\nEnd of Date Formats and Methods");

    } 

} 
