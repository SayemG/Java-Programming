//======================================================================
//
// Title: Vehicle Demo
// Description:
//   This program demonstrates the Vehicle class and some subclasses.
//
//======================================================================
package wsu.Inheritance;

//======================================================================
// class VehicleDemo
//======================================================================
public class VehicleDemo
{

    //------------------------------------------------------------------
    // main
    //------------------------------------------------------------------
    public static void main (String[] args)
    {
    	
    	// Declare constants
        final String COLFMTS1 = "%-40s";
        final String COLFMTS2 = "%-10s";

        // Show application header
        System.out.println("Welcome to Vehicle Demo");
        System.out.println("-----------------------");
        
        // Create and print vehicle 1 info
        System.out.println("\n------------ veh1 ------------");
        Vehicle veh1 = new Vehicle("Mack", "Granite", 10);
        veh1.printVehicle("veh1");
        veh1.printObjectInfo("veh1");
        
        // Create and print vehicle 2 info
        System.out.println("\n------------ veh2 ------------");
        Vehicle veh2 = new Car("Ford", "Mustang", 4, 22);
        veh2.printVehicle("veh2");
        veh2.printObjectInfo("veh2");

        // Create and print car 1 info
        System.out.println("\n------------ car1 ------------");
        Car car1 = new Car();
        car1.printCar("car1");
        car1.printObjectInfo("car1");
        
        // Create and print car 2 info
        System.out.println("\n------------ car2 ------------");
        Car car2 = new Car("Dodge", "Challenger", 4, 18);
        car2.printCar("car2");
        car2.printObjectInfo("car2");
        
        // Print hidden fields
        car1.printHiddens();

        // Create and print autonomous car 1 info
        System.out.println("\n------------ aCar1 ------------");
        AutonomousCar aCar1 = new AutonomousCar();
        aCar1.printAutonomousCar("aCar1");
        aCar1.printObjectInfo("aCar1");

        // Create and print car 3 info
        //Car car3 = new Vehicle ("Mack", "Titan", 20);  // Can't go from type Vehicle to type Car

        // Test class equalities using getClass method
        System.out.println("\n------------ equalities ------------");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh1 class equals veh2 class?",
            veh1.getClass() == veh2.getClass());
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"car1 class equals car2 class?", 
    		car1.getClass() == car2.getClass());
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"car1 class equals veh1 class?",
            car1.getClass() == veh1.getClass());
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"aCar1 class equals veh1 class?",
            aCar1.getClass() == veh1.getClass());
            
        // Test class types using instanceof operator
        System.out.println("\n------------ instanceof ------------");
        
        System.out.println("veh1");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh1 instanceof Vehicle?", veh1 instanceof Vehicle);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh1 instanceof Car?", veh1 instanceof Car);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh1 instanceof AutonomousCar?", veh1 instanceof AutonomousCar);

        System.out.println("veh2");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh2 instanceof Vehicle?", veh2 instanceof Vehicle);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh2 instanceof Car?", veh2 instanceof Car);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"veh2 instanceof AutonomousCar?", veh2 instanceof AutonomousCar);
        
        System.out.println("car1");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"car1 instanceof Vehicle?", car1 instanceof Vehicle);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"car1 instanceof Car?", car1 instanceof Car);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"car1 instanceof AutonomousCar?", car1 instanceof AutonomousCar);
        
        System.out.println("aCar1");
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"aCar1 instanceof Vehicle?", aCar1 instanceof Vehicle);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"aCar1 instanceof Car?", aCar1 instanceof Car);
        System.out.printf(COLFMTS1 + COLFMTS2 + "%n", 
    		"aCar1 instanceof AutonomousCar?", aCar1 instanceof AutonomousCar);

        // Create an array of vehicles
        System.out.println("\n------------ vehicles array ------------");
        Vehicle[] vehicles = new Vehicle[3];  // This creates three null vehicles

        // Loop to create and store vehicles
        for (int v = 0; v < vehicles.length; v++)
            vehicles[v] = new Vehicle("Mack", "Titan", 20);

        // Loop to print vehicles
        for (Vehicle v: vehicles)
            v.printVehicle("Vehicle");
        
        // Show application close
        System.out.println("\nEnd of Vehicle Demo");

    }

}
