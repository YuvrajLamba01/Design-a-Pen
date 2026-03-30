public class Refill {
    private double maxCapacity;
    private double currentInk;
    private String color;
    private PenType penType;
    
    public Refill(String color, double capacity, PenType penType) {
        this.color = color;
        this.maxCapacity = capacity;
        this.currentInk = capacity;
        this.penType = penType;
    }
    
    public void consumeInk(double amount) throws IllegalStateException {
        if (currentInk < amount) {
            throw new IllegalStateException("Insufficient ink: " + amount + " units required, " + currentInk + " available");
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
    
    public String getColor() {
        return color;
    }
    
    public PenType getPenType() {
        return penType;
    }
    
    @Override
    public String toString() {
        return String.format("Refill{color=%s, type=%s, ink=%.2f/%.2f (%.1f%%)}", 
                           color, penType.getDescription(), currentInk, maxCapacity, getCapacityPercentage());
    }
}
