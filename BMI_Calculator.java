import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter your height in cm: ");
        double heightCm = scanner.nextDouble();
        
        scanner.close();
        
        double heightM = heightCm / 100; // Convert cm to meters
        double bmi = weight / (heightM * heightM);
        
        System.out.printf("Your BMI is: %.2f\n", bmi);
        
        if (bmi <= 18.4) {
            System.out.println("You are underweight.");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("You have a normal weight.");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("You are overweight.");
        } else if (bmi >= 40.0) {
            System.out.println("You are obese.");
        }
    }
}
