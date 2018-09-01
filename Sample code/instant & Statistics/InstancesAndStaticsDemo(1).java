//======================================================================
//
// Title: Instances and Statics Demo
// Description:
//   This program demonstrates the accessibility of this class to the 
// members of class 'InstancesAndStatics' including:
//   -Instance variables
//   -Static variables and constants
//   -Instance methods
//   -Static methods
//
//======================================================================
package wsu.InstancesAndStatics;

//======================================================================
// class InstancesAndStaticsDemo
//======================================================================
public class InstancesAndStaticsDemo
{

	//------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
        
        // Show application header
        System.out.println("Welcome to Instances and Statics");
        System.out.println("--------------------------------\n");
        
        // Show field references header
        System.out.println("Attempting to reference " +
    		"InstancesAndStatics fields from class " +
    		"InstancesAndStaticsDemo ...");
        
        // Attempt to reference fields in class InstancesAndStatics
    	//ins_var_private = 1;  // Can't, not visible and no object prefix
    	//ins_var_public = 2;  // Can't, no object prefix
    	//sta_var_private = 3;  // Can't, not visible and no class prefix
    	//sta_var_public = 4;  // Can't, no class prefix
    	//System.out.println("CONST_PRIVATE is " + CONST_PRIVATE);
        	// Can't, not visible and no class prefix
    	//System.out.println("CONST_PUBLIC is " + CONST_PUBLIC);  
        	// Can't, no class prefix

        // Attempt to reference static variables and constants in 
        // class InstancesAndStatics with class prefix 'InstancesAndStatics'
    	//InstancesAndStatics.sta_var_private = 1;  // Can't, not visible
    	InstancesAndStatics.sta_var_public = 2;  // Yes!
    	System.out.println("Success: referenced " +
			"InstancesAndStatics.sta_var_public."); 
    	//System.out.println("CONST_PRIVATE is " + 
    		//InstancesAndStatics.CONST_PRIVATE);  // Can't, not visible
    	System.out.println("InstancesAndStatics.CONST_PUBLIC is " + 
    		InstancesAndStatics.CONST_PUBLIC);  // Yes!
    	System.out.println("Success: referenced " +
			"InstancesAndStatics.CONST_PUBLIC.");

    	// Create InstancesAndStatics object
    	InstancesAndStatics obj1 = new InstancesAndStatics();

        // Attempt to reference instance variables in class 
    	// InstancesAndStatics with object prefix 'obj1'
    	//obj1.ins_var_private = 1;  // Can't, not visible
    	obj1.ins_var_public = 2;  // Yes!
    	System.out.println("Success: referenced obj1.ins_var_public.");

    	// Show field reference attempt results
        System.out.println("\nField reference attempt results:");
        System.out.println("-Can only reference a field through an" +
    		" object or its class");
        System.out.println("-Can only reference a static field " +
    		"(variable or constant) with the class prefix.");
        System.out.println("-Can only reference an instance " +
    		"variable with an object prefix.");

        // Show method calls header
        System.out.println("\nAttempting to call " +
    		"InstancesAndStatics methods from class InstancesAndStaticsDemo ...");
        
        // Attempt to call methods in class InstancesAndStatics
        //ins_meth_private();  // Can't, not visible and no object prefix
        //ins_meth_public();  // Can't, no object prefix
    	//sta_meth_private();  // Can't, not visible and no class prefix
    	//sta_meth_public();  // Can't, no class prefix

        // Attempt to call static methods in class InstancesAndStatics
    	// with class prefix 'InstancesAndStatics'
    	//InstancesAndStatics.sta_meth_private();  // Can't, not visible
    	InstancesAndStatics.sta_meth_public();  // Yes!
    	System.out.println("Success: " +
			"called InstancesAndStatics.sta_meth_public().");

    	// Create InstancesAndStatics object
    	InstancesAndStatics obj2 = new InstancesAndStatics();

        // Attempt to call instance methods in class InstancesAndStatics
    	// with object prefix 'obj2'
    	//obj2.ins_meth_private();  // Can't, not visible
    	obj2.ins_meth_public();  // Yes!
    	System.out.println("Success: called obj2.ins_meth_public().");

    	// Show method call attempt results
        System.out.println("\nMethod call attempt results:");
        System.out.println("-Can only call a method through an " +
    		"object or its class");
        System.out.println("-Can only call a static method with the" +
    		" class prefix.");
        System.out.println("-Can only call an instance method with" +
    		" an object prefix.");
    	
        // Show application close
        System.out.println("\nEnd of Instances and Statics");

    }

}
