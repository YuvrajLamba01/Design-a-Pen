public class ClickMechanism implements OperatingMechanism {
    private boolean isExtended;
    private int clickCount;
    private double inkUsagePerWrite;
    
    public ClickMechanism(double inkUsagePerWrite) {
        this.isExtended = false;
        this.clickCount = 0;
        this.inkUsagePerWrite = inkUsagePerWrite;
    }
    
    @Override
    public void activate() throws IllegalStateException {
        if (isExtended) {
            throw new IllegalStateException("Tip already extended");
        }
        isExtended = true;
        clickCount++;
        System.out.println("[Click] Pen tip extended. Click count: " + clickCount);
    }
    
    @Override
    public void deactivate() throws IllegalStateException {
        if (!isExtended) {
            throw new IllegalStateException("Tip already retracted");
        }
        isExtended = false;
        System.out.println("[Click] Pen tip retracted.");
    }
    
    @Override
    public void write(String text, Refill refill) throws IllegalStateException {
        if (!isExtended) {
            throw new IllegalStateException("Pen tip not extended. Call activate() first.");
        }
        
        if (!refill.hasInk()) {
            throw new IllegalStateException("No ink available");
        }
        
        if (refill.getRemainingInk() < inkUsagePerWrite) {
            throw new IllegalStateException("Insufficient ink for writing");
        }
        
        refill.consumeInk(inkUsagePerWrite);
        System.out.println("[" + refill.getColor() + "] Writing: \"" + text + "\"");
        System.out.println("    Remaining ink: " + String.format("%.2f", refill.getRemainingInk()) + " units");
    }
    
    @Override
    public boolean isActive() {
        return isExtended;
    }
    
    public int getClickCount() {
        return clickCount;
    }
    
    public double getInkUsagePerWrite() {
        return inkUsagePerWrite;
    }
    
    @Override
    public String toString() {
        return String.format("ClickMechanism{extended=%s, clicks=%d, inkUsage=%.2f}", isExtended, clickCount, inkUsagePerWrite);
    }
}
