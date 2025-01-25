import java.util.Scanner;

public class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an array to store the heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 players (in cm):");

        // Get input for the heights
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i]; // Add each height to the sum
        }

        // Calculate the mean height
        double meanHeight = sum / heights.length;

        // Display the mean height
        System.out.println("\nThe mean height of the football team is: " + meanHeight + " cm");

        sc.close();
    }
}
