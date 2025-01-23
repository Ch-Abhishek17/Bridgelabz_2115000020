import java.util.Scanner;
public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input base and height in inches
        System.out.print("Enter the base and height of the triangle (in inches): ");
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        // Calculate the area of the triangle in square inches
        double areaInSquareInches = 0.5 * base * height;
        // Convert area to square centimeters (1 square inch = 6.4516 square cm)
        double areaInSquareCm = areaInSquareInches * 6.4516;
        System.out.println("The area of the triangle in square inches: "+areaInSquareInches);
        System.out.println("The area of the triangle in square cm: "+areaInSquareCm);

        sc.close();
    }
}
