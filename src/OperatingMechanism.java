public interface OperatingMechanism {
    void activate() throws IllegalStateException;
    void deactivate() throws IllegalStateException;
    void write(String text, Refill refill) throws IllegalStateException;
    boolean isActive();
}
