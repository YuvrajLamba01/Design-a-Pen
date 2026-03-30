public class CapMechanism {
    private boolean isOpen;
    private String material;
    
    public CapMechanism(String material) {
        this.material = material;
        this.isOpen = false;
    }
    
    public void open() throws IllegalStateException {
        if (isOpen) {
            throw new IllegalStateException("Cap is already open");
        }
        isOpen = true;
    }
    
    public void close() throws IllegalStateException {
        if (!isOpen) {
            throw new IllegalStateException("Cap is already closed");
        }
        isOpen = false;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public String getMaterial() {
        return material;
    }
    
    @Override
    public String toString() {
        return String.format("CapMechanism{material=%s, state=%s}", material, isOpen ? "OPEN" : "CLOSED");
    }
}
