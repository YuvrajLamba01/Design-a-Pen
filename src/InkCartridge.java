public class InkCartridge {
    private double maxCapacity;
    private double currentInk;
    
    public InkCartridge(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentInk = maxCapacity;
    }
    
    public void consumeInk(double amount) throws IllegalStateException {
        if (currentInk < amount) {
            throw new IllegalStateException("Not enough ink to consume " + amount + " units");
        }
        currentInk -= amount;
    }
    
    public void refill() {
        currentInk = maxCapacity;
    }
    
    public boolean hasInk() {
        return currentInk > 0;
    }
    
    public double getRemainingInk() {
        return currentInk;
    }
    
    public double getMaxCapacity() {
        return maxCapacity;
    }
    
    public double getCapacityPercentage() {
        return (currentInk / maxCapacity) * 100;
    }
    
    @Override
    public String toString() {
        return String.format("InkCartridge{current=%.2f, max=%.2f, percentage=%.1f%%}", 
                             currentInk, maxCapacity, getCapacityPercentage());
    }
}
