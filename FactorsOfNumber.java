import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            return; // Exit the program
        }

        // Initialize variables
        int maxFactor = 10; // Initial size of the factors array
        int[] factors = new int[maxFactor];
        int index = 0; // To track the current position in the factors array

        // Find factors and store in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Check if the array needs to grow
                if (index == maxFactor) {
                    maxFactor *= 2; // Double the size
                    int[] temp = new int[maxFactor]; // Create a new array with increased size
                    System.arraycopy(factors, 0, temp, 0, factors.length); // Copy old elements to the new array
                    factors = temp; // Assign the new array to factors
                }

                // Store the factor in the array
                factors[index++] = i;
            }
        }

        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        sc.close();
    }
}
