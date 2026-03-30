public class Pen {
    enum PenState {
        CLOSED, OPEN, IN_USE, EMPTY
    }
    
    private String brand;
    private String color;
    private InkCartridge inkCartridge;
    private PenState currentState;
    private double inkUsagePerWrite;
    
    public Pen(String brand, String color, double initialInkCapacity, double inkUsagePerWrite) {
        this.brand = brand;
        this.color = color;
        this.inkCartridge = new InkCartridge(initialInkCapacity);
        this.currentState = PenState.CLOSED;
        this.inkUsagePerWrite = inkUsagePerWrite;
    }
    
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
    
    public void refill() throws IllegalStateException {
        if (currentState == PenState.OPEN || currentState == PenState.IN_USE) {
            throw new IllegalStateException("Cannot refill while pen is open. Close the pen first.");
        }
        
        inkCartridge.refill();
        currentState = PenState.CLOSED;
        System.out.println("[" + brand + "] Ink cartridge refilled to full capacity.");
        System.out.println("    Current ink: " + String.format("%.2f", inkCartridge.getRemainingInk()) + " units");
    }
    
    public PenState getCurrentState() {
        return currentState;
    }
    
    public double getRemainingInk() {
        return inkCartridge.getRemainingInk();
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getColor() {
        return color;
    }
    
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
