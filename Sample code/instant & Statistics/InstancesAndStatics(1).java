//======================================================================
//
// Class: InstancesAndStatics
// Description:
//   This class represents an InstancesAndStatics object.  Since this 
// class is demonstrated by another file within the same package, the 
// access modifiers package-private (no modifier), 'protected', and 
// 'public' behave identically.  Only 'private' and 'public' are 
// demonstrated.
//
//======================================================================
package wsu.InstancesAndStatics;

//======================================================================
// class InstancesAndStatics
//======================================================================
public class InstancesAndStatics
{
    
    //==================================================================
    // Fields
    //==================================================================
	
	// Declare instance variables
	private int ins_var_private;
	public int ins_var_public;
	
	// Declare static variables
	private static int sta_var_private;
	public static int sta_var_public;
	
	// Declare constants
	private static final int CONST_PRIVATE = 1;
	public static final int CONST_PUBLIC = 2;
    
    //==================================================================
    // Constructors
    //==================================================================
    
    //==================================================================
    // Methods
    //==================================================================
	
    //------------------------------------------------------------------
    // instance methods
    //------------------------------------------------------------------

	private void ins_meth_private()
	{
		System.out.println("This is method ins_meth_private.");
	}
	
	public void ins_meth_public()
	{
		System.out.println("This is method ins_meth_public.");
	}
    
    //------------------------------------------------------------------
    // static methods
    //------------------------------------------------------------------

	private static void sta_meth_private()
	{
		System.out.println("This is method sta_meth_private.");
	}
	
	public static void sta_meth_public()
	{
		System.out.println("This is method sta_meth_public.");
	}
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

	public boolean equals (InstancesAndStatics b)
	{
		if (this.ins_var_private == b.ins_var_private)
			return true;
		else
			return false;
	}

	public String toString ()
	{
		return "Value of ins_var_private: " + ins_var_private;        
	}
    
    //------------------------------------------------------------------
    // Referencing fields and calling methods in a static method
    //------------------------------------------------------------------

	private static void sta_meth()
	{
        
        // Show field references header
        System.out.println("Attempting to reference fields in " +
    		"static method in class InstancesAndStatics ...");
        
        // Attempt to reference private fields
    	//ins_var_private = 1;  // Can't, no object prefix
    	sta_var_private = 2;  // Yes!
    	System.out.println("CONST_PRIVATE is " + CONST_PRIVATE);  // Yes!

    	// Show field reference attempt results
        System.out.println("\nField reference attempt results:");
        System.out.println("-Can only reference an instance " +
    		"variable with an object prefix.");
        System.out.println("-Can reference a static field " +
    		"(variable or constant) by name alone.");

        // Show method references header
        System.out.println("\nAttempting to call methods from " +
    		"static method in class InstancesAndStatics");
        
        // Attempt to call methods in class InstancesAndStatics
        //ins_meth_private();  // Can't, no object prefix
    	sta_meth_private();  // Yes!

    	// Show method call attempt results
        System.out.println("\nMethod call attempt results:");
        System.out.println("-Can only call an instance method with an " +
    		"object prefix.");
        System.out.println("-Can call a static method by name alone.");
		
	}
    
    //------------------------------------------------------------------
    // Referencing fields and calling methods in an instance method
    //------------------------------------------------------------------

	private void ins_meth()
	{
        
        // Show field references header
        System.out.println("Attempting to reference fields in " +
    		"instance method in class InstancesAndStatics");
        
        // Attempt to reference private fields
    	ins_var_private = 1;  // Yes!
    	sta_var_private = 2;  // Yes!
    	System.out.println("CONST_PRIVATE is " + CONST_PRIVATE);  // Yes!

    	// Show field reference attempt results
        System.out.println("\nField reference attempt results:");
        System.out.println("-Can reference any field by name alone.");

        // Show method references header
        System.out.println("\nAttempting to call methods from " +
    		"instance method in class InstancesAndStatics");
        
        // Attempt to call methods in class InstancesAndStatics
        ins_meth_private();  // Yes!
    	sta_meth_private();  // Yes!

    	// Show method call attempt results
        System.out.println("\nMethod call attempt results:");
        System.out.println("-Can call any method by name alone.");
	
	}
    
} 
