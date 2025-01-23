import java.util.Scanner;
public class Athlete{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input sides of the triangle
        System.out.print("Enter the length of all 3 sides (in meters): ");
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;  //Distance in meters
        double rounds = totalDistance / perimeter;
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km",rounds);
        sc.close();
    }
}
