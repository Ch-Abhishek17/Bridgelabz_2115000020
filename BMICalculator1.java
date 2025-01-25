import java.util.Scanner;

public class BMICalculator1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numberOfPersons = sc.nextInt();
        double[] weight = new double[numberOfPersons];
        double[] height = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            while (true) {
                System.out.print("Enter weight (in kg): ");
                weight[i] = sc.nextDouble();
                if (weight[i] > 0) {
                    break;
                } else {
                    System.out.println("Weight must be a positive number.");
                }
            }
            while (true) {
                System.out.print("Enter height (in meters): ");
                height[i] = sc.nextDouble();
                if (height[i] > 0) {
                    break;
                } else {
                    System.out.println("Height must be a positive number.");
                }
            }
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nPerson Details:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.println("Weight: " + weight[i] + " kg");
            System.out.println("Height: " + height[i] + " meters");
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Weight Status: " + weightStatus[i]);
        }

        sc.close();
    }
}
