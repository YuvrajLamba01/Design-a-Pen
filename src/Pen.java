/**
 * Pen.java - Represents a pen with start, write, close, and refill functionalities
 * 
 * This class models a real-world pen with the following states:
 * - CLOSED: Pen cap is on, cannot write
 * - OPEN: Pen cap is off, can write
 * - IN_USE: Currently writing
 * - EMPTY: Out of ink
 * 
 * A pen has an ink cartridge that can be refilled when empty
 */
public class Pen {
    
    // Pen states
    enum PenState {
        CLOSED,
        OPEN,
        IN_USE,
        EMPTY
    }
    
    // Attributes
    private String brand;
    private String color;
    private InkCartridge inkCartridge;
    private PenState currentState;
    private double inkUsagePerWrite; // ink units used per write operation
    
    /**
     * Constructor to initialize a Pen with specified properties
     * 
     * @param brand - Brand name of the pen
     * @param color - Color of the pen
     * @param initialInkCapacity - Initial ink capacity in the cartridge
     * @param inkUsagePerWrite - Amount of ink used per write operation
     */
    public Pen(String brand, String color, double initialInkCapacity, double inkUsagePerWrite) {
        this.brand = brand;
        this.color = color;
        this.inkCartridge = new InkCartridge(initialInkCapacity);
        this.currentState = PenState.CLOSED;
        this.inkUsagePerWrite = inkUsagePerWrite;
    }
    
    /**
     * Start - Open the pen (remove cap)
     * Transitions from CLOSED to OPEN state
     * Precondition: Pen must be in CLOSED state
     */
    public void start() throws IllegalStateException {
        if (currentState == PenState.CLOSED) {
            if (inkCartridge.hasInk()) {
                currentState = PenState.OPEN;
                System.out.println("[" + brand + "] Pen cap removed. Pen is ready to write.");
            } else {
                currentState = PenState.EMPTY;
                System.out.println("[" + brand + "] Pen is out of ink. Please refill before using.");
                throw new IllegalStateException("Cannot start pen: No ink available");
            }
        } else {
            throw new IllegalStateException("Pen is already open or in use. Close it first.");
        }
    }
    
    /**
     * Write - Write using the pen
     * Transitions from OPEN to IN_USE, consumes ink
     * Precondition: Pen must be in OPEN state with sufficient ink
     * 
     * @param text - The text to write
     */
    public void write(String text) throws IllegalStateException {
        if (currentState != PenState.OPEN && currentState != PenState.IN_USE) {
            throw new IllegalStateException("Pen is not open. Call start() first.");
        }
        
        if (!inkCartridge.hasInk()) {
            currentState = PenState.EMPTY;
            throw new IllegalStateException("No ink left. Call refill() to continue writing.");
        }
        
        // Check if there's enough ink for the write operation
        if (inkCartridge.getRemainingInk() < inkUsagePerWrite) {
            currentState = PenState.EMPTY;
            System.out.println("[" + brand + "] Not enough ink to complete the write. Pen is now empty.");
            throw new IllegalStateException("Insufficient ink for this write operation");
        }
        
        currentState = PenState.IN_USE;
        inkCartridge.consumeInk(inkUsagePerWrite);
        System.out.println("[" + brand + " - " + color + "] Writing: \"" + text + "\"");
        System.out.println("    Remaining ink: " + String.format("%.2f", inkCartridge.getRemainingInk()) + " units");
        currentState = PenState.OPEN; // After writing, pen is back to open state
    }
    
    /**
     * Close - Close the pen (put cap back on)
     * Transitions from OPEN or IN_USE to CLOSED state
     * Precondition: Pen must not be in CLOSED state
     */
    public void close() throws IllegalStateException {
        if (currentState == PenState.CLOSED) {
            throw new IllegalStateException("Pen is already closed.");
        }
        
        if (currentState == PenState.EMPTY) {
            currentState = PenState.CLOSED;
            System.out.println("[" + brand + "] Pen cap placed back. Note: Pen is empty, needs refill.");
        } else {
            currentState = PenState.CLOSED;
            System.out.println("[" + brand + "] Pen cap placed back.");
        }
    }
    
    /**
     * Refill - Refill the ink cartridge to full capacity
     * Transitions from EMPTY to CLOSED state
     * Precondition: Pen must be in CLOSED or EMPTY state
     */
    public void refill() throws IllegalStateException {
        if (currentState == PenState.OPEN || currentState == PenState.IN_USE) {
            throw new IllegalStateException("Cannot refill while pen is open. Close the pen first.");
        }
        
        inkCartridge.refill();
        currentState = PenState.CLOSED;
        System.out.println("[" + brand + "] Ink cartridge refilled to full capacity.");
        System.out.println("    Current ink: " + String.format("%.2f", inkCartridge.getRemainingInk()) + " units");
    }
    
    /**
     * Get the current state of the pen
     * 
     * @return The current PenState
     */
    public PenState getCurrentState() {
        return currentState;
    }
    
    /**
     * Get the remaining ink in the cartridge
     * 
     * @return Amount of remaining ink
     */
    public double getRemainingInk() {
        return inkCartridge.getRemainingInk();
    }
    
    /**
     * Get the brand of the pen
     * 
     * @return Brand name
     */
    public String getBrand() {
        return brand;
    }
    
    /**
     * Get the color of the pen
     * 
     * @return Pen color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Check if pen has ink
     * 
     * @return true if pen has ink, false otherwise
     */
    public boolean hasInk() {
        return inkCartridge.hasInk();
    }
    
    /**
     * Get information about the pen
     * 
     * @return String representation of pen details
     */
    @Override
    public String toString() {
        return "Pen{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", currentState=" + currentState +
                ", remainingInk=" + String.format("%.2f", inkCartridge.getRemainingInk()) +
                '}';
    }
}
