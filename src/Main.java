/**
 * Main.java - Demonstration of the Pen class functionality
 * 
 * This class demonstrates how to use the Pen class with its
 * start, write, close, and refill operations
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== PEN DESIGN AND IMPLEMENTATION DEMO ===\n");
        
        // Create a pen with 100 units of ink capacity
        // Each write operation uses 10 units of ink
        Pen myPen = new Pen("Parker", "Blue", 100.0, 10.0);
        
        System.out.println("Pen Details: " + myPen + "\n");
        
        // Demonstrate the write lifecycle
        demonstrateNormalUsage(myPen);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Create another pen to demonstrate refill
        Pen anotherPen = new Pen("Pilot", "Red", 50.0, 15.0);
        demonstrateRefill(anotherPen);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demonstrate error handling
        Pen errorPen = new Pen("Staedtler", "Black", 30.0, 5.0);
        demonstrateErrorHandling(errorPen);
    }
    
    /**
     * Demonstrate normal pen usage workflow
     * 
     * @param pen - The pen to use
     */
    private static void demonstrateNormalUsage(Pen pen) {
        System.out.println("--- Normal Usage Demo ---\n");
        
        try {
            // Start the pen (open it)
            System.out.println("1. Starting the pen...");
            pen.start();
            
            // Write something
            System.out.println("\n2. Writing first message...");
            pen.write("Hello, World!");
            
            // Write again
            System.out.println("\n3. Writing second message...");
            pen.write("The Pen is working great!");
            
            // Close the pen
            System.out.println("\n4. Closing the pen...");
            pen.close();
            
            System.out.println("\nFinal pen state: " + pen);
            
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrate pen refill functionality
     * 
     * @param pen - The pen to use
     */
    private static void demonstrateRefill(Pen pen) {
        System.out.println("--- Refill Demo ---\n");
        
        try {
            // Use the pen until it runs out
            System.out.println("1. Starting the pen...");
            pen.start();
            
            System.out.println("\n2. Writing multiple times to exhaust ink...");
            for (int i = 1; i <= 4; i++) {
                System.out.println("\n   Write #" + i + ":");
                pen.write("Message " + i);
            }
            
            System.out.println("\n3. Attempting one more write (should fail - no ink)...");
            try {
                pen.write("This should fail");
            } catch (IllegalStateException e) {
                System.out.println("   Error caught: " + e.getMessage());
            }
            
            // Close the pen
            System.out.println("\n4. Closing the empty pen...");
            pen.close();
            
            // Refill the pen
            System.out.println("\n5. Refilling the pen...");
            pen.refill();
            
            // Use it again
            System.out.println("\n6. Starting the refilled pen...");
            pen.start();
            
            System.out.println("\n7. Writing after refill...");
            pen.write("Fresh start with refilled ink!");
            
            // Close again
            System.out.println("\n8. Closing the pen...");
            pen.close();
            
            System.out.println("\nFinal state: " + pen);
            
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrate error handling
     * 
     * @param pen - The pen to use
     */
    private static void demonstrateErrorHandling(Pen pen) {
        System.out.println("--- Error Handling Demo ---\n");
        
        System.out.println("1. Trying to write without opening...");
        try {
            pen.write("Should fail");
        } catch (IllegalStateException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println("\n2. Opening the pen normally...");
        try {
            pen.start();
        } catch (IllegalStateException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n3. Trying to open an already open pen...");
        try {
            pen.start();
        } catch (IllegalStateException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println("\n4. Writing to exhaust ink...");
        try {
            pen.write("Message 1");
            pen.write("Message 2");
            pen.write("Message 3");
        } catch (IllegalStateException e) {
            System.out.println("   Caught when exhausted: " + e.getMessage());
        }
        
        System.out.println("\n5. Trying to refill without closing first...");
        try {
            pen.refill();
        } catch (IllegalStateException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println("\n6. Closing and refilling properly...");
        try {
            pen.close();
            pen.refill();
            System.out.println("   Successfully refilled: " + pen);
        } catch (IllegalStateException e) {
            System.out.println("   Error: " + e.getMessage());
        }
    }
}
