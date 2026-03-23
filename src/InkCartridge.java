/**
 * InkCartridge.java - Represents an ink cartridge that can be used in a pen
 * 
 * This class manages the ink capacity and consumption
 */
public class InkCartridge {
    
    private double maxCapacity;  // Maximum ink capacity
    private double currentInk;   // Current ink amount
    
    /**
     * Constructor to initialize an ink cartridge
     * 
     * @param maxCapacity - Maximum ink capacity
     */
    public InkCartridge(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentInk = maxCapacity;
    }
    
    /**
     * Consume a specified amount of ink
     * 
     * @param amount - Amount of ink to consume
     * @throws IllegalStateException if not enough ink is available
     */
    public void consumeInk(double amount) throws IllegalStateException {
        if (currentInk < amount) {
            throw new IllegalStateException("Not enough ink to consume " + amount + " units");
        }
        currentInk -= amount;
    }
    
    /**
     * Refill the cartridge to full capacity
     */
    public void refill() {
        currentInk = maxCapacity;
    }
    
    /**
     * Check if there's any ink left
     * 
     * @return true if current ink is greater than 0, false otherwise
     */
    public boolean hasInk() {
        return currentInk > 0;
    }
    
    /**
     * Get the remaining ink
     * 
     * @return Current ink amount
     */
    public double getRemainingInk() {
        return currentInk;
    }
    
    /**
     * Get the maximum capacity of the cartridge
     * 
     * @return Maximum capacity
     */
    public double getMaxCapacity() {
        return maxCapacity;
    }
    
    /**
     * Get the capacity filled percentage
     * 
     * @return Percentage of ink remaining (0-100)
     */
    public double getCapacityPercentage() {
        return (currentInk / maxCapacity) * 100;
    }
    
    /**
     * String representation of the ink cartridge
     * 
     * @return String with cartridge details
     */
    @Override
    public String toString() {
        return String.format("InkCartridge{current=%.2f, max=%.2f, percentage=%.1f%%}", 
                             currentInk, maxCapacity, getCapacityPercentage());
    }
}
