public enum PenType {
    BALLPOINT("Ballpoint Pen", 0.7),
    GEL("Gel Pen", 0.5),
    FOUNTAIN("Fountain Pen", 1.0),
    MARKER("Marker", 2.0);
    
    private final String description;
    private final double nozzleSize;
    
    PenType(String description, double nozzleSize) {
        this.description = description;
        this.nozzleSize = nozzleSize;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getNozzleSize() {
        return nozzleSize;
    }
}
