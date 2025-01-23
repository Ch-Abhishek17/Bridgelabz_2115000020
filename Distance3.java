import java.util.Scanner;
public class Distance3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = sc.nextDouble();
        // Conversion constants
        final double FEET_IN_YARD = 3.0;
        final double YARDS_IN_MILE = 1760.0;

        // Convert feet to yards and miles
        double distanceInYards = distanceInFeet / FEET_IN_YARD;
        double distanceInMiles = distanceInYards / YARDS_IN_MILE;
        System.out.printf("\nThe distance in yards: %.2f yards\n", distanceInYards);
        System.out.printf("The distance in miles: %.2f miles\n", distanceInMiles);
        sc.close();
    }
}
