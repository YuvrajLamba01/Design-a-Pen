public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen("Parker", "Blue", 100.0, 10.0);
        
        try {
            pen.start();
            pen.write("Hello, World!");
            pen.write("This is a pen design");
            pen.close();
            pen.refill();
            pen.start();
            pen.write("Writing after refill");
            pen.close();
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
