public class Circle {
    private double radius;

    public Circle() {
        this(1.0); // Default radius value
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public void displayInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.displayInfo();

        System.out.println();

        Circle circle2 = new Circle(5.5);
        circle2.displayInfo();
    }
}
