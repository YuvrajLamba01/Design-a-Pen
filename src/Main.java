public class Main {
    public static void main(String[] args) {
        System.out.println("=== ADVANCED PEN DESIGN DEMO ===\n");
        
        demonstrateClickPen();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateRefill();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateErrorHandling();
    }
    
    private static void demonstrateClickPen() {
        System.out.println("--- Click Mechanism Pen Demo ---\n");
        
        Pen pen = new Pen("Parker Jotter", PenType.BALLPOINT, "Plastic", "Blue", 100.0, 10.0);
        System.out.println("Created: " + pen + "\n");
        
        try {
            pen.open();
            pen.click();
            pen.write("Hello, Advanced Pen Design!");
            pen.write("This is the second line");
            pen.unclick();
            pen.close();
            System.out.println("\nFinal state: " + pen);
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateRefill() {
        System.out.println("--- Refill Demo ---\n");
        
        Pen pen = new Pen("Pilot G2", PenType.GEL, "Metal", "Red", 50.0, 12.0);
        
        try {
            System.out.println("1. Using pen until low on ink...");
            pen.open();
            pen.click();
            
            for (int i = 1; i <= 4; i++) {
                pen.write("Message " + i);
            }
            
            pen.unclick();
            pen.close();
            
            System.out.println("\n2. Refilling the pen...");
            pen.refillPen();
            
            System.out.println("\n3. Using refilled pen...");
            pen.open();
            pen.click();
            pen.write("Writing with fresh ink!");
            pen.unclick();
            pen.close();
            
            System.out.println("\nFinal state: " + pen);
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateErrorHandling() {
        System.out.println("--- Error Handling Demo ---\n");
        
        Pen pen = new Pen("Staedtler", PenType.BALLPOINT, "Plastic", "Black", 75.0, 8.0);
        
        System.out.println("1. Trying to write without opening...");
        try {
            pen.write("Should fail");
        } catch (IllegalStateException e) {
            System.out.println("   ✓ Caught: " + e.getMessage());
        }
        
        System.out.println("\n2. Trying to click without opening...");
        try {
            pen.click();
        } catch (IllegalStateException e) {
            System.out.println("   ✓ Caught: " + e.getMessage());
        }
        
        System.out.println("\n3. Opening and clicking correctly...");
        try {
            pen.open();
            pen.click();
            System.out.println("   ✓ Success: Pen is ready to write");
            pen.unclick();
            pen.close();
        } catch (IllegalStateException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n4. Trying to refill while open...");
        try {
            pen.open();
            pen.refillPen();
        } catch (IllegalStateException e) {
            System.out.println("   ✓ Caught: " + e.getMessage());
            try {
                pen.close();
            } catch (IllegalStateException ignored) {}
        }
    }
}
