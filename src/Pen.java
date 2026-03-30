public class Pen {
    private String brand;
    private PenType penType;
    private CapMechanism capMechanism;
    private OperatingMechanism operatingMechanism;
    private Refill refill;
    private boolean isClosed;
    
    public Pen(String brand, PenType penType, String capMaterial, String refillColor, 
               double refillCapacity, double inkUsagePerWrite) {
        this.brand = brand;
        this.penType = penType;
        this.capMechanism = new CapMechanism(capMaterial);
        this.operatingMechanism = new ClickMechanism(inkUsagePerWrite);
        this.refill = new Refill(refillColor, refillCapacity, penType);
        this.isClosed = true;
    }
    
    public void open() throws IllegalStateException {
        if (!isClosed) {
            throw new IllegalStateException("Pen is already open");
        }
        capMechanism.open();
        isClosed = false;
        System.out.println("[" + brand + "] Cap removed. Pen is open.");
    }
    
    public void close() throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Pen is already closed");
        }
        if (operatingMechanism.isActive()) {
            operatingMechanism.deactivate();
        }
        capMechanism.close();
        isClosed = true;
        System.out.println("[" + brand + "] Cap placed. Pen is closed.");
    }
    
    public void click() throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Pen cap must be open first");
        }
        operatingMechanism.activate();
    }
    
    public void unclick() throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Pen cap is closed");
        }
        operatingMechanism.deactivate();
    }
    
    public void write(String text) throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Pen is closed. Call open() first.");
        }
        operatingMechanism.write(text, refill);
    }
    
    public void refillPen() throws IllegalStateException {
        if (!isClosed) {
            throw new IllegalStateException("Pen must be closed before refilling");
        }
        refill.refill();
        System.out.println("[" + brand + "] Refill completed. Ink: " + String.format("%.2f", refill.getRemainingInk()) + " units");
    }
    
    public String getBrand() {
        return brand;
    }
    
    public PenType getPenType() {
        return penType;
    }
    
    public boolean isClosed() {
        return isClosed;
    }
    
    public boolean hasInk() {
        return refill.hasInk();
    }
    
    public double getRemainingInk() {
        return refill.getRemainingInk();
    }
    
    public Refill getRefill() {
        return refill;
    }
    
    @Override
    public String toString() {
        return String.format("Pen{brand=%s, type=%s, state=%s, refill=%s}", 
                           brand, penType.getDescription(), isClosed ? "CLOSED" : "OPEN", refill);
    }
}
