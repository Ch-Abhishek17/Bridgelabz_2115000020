import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();

        if (isValidLicensePlate(plate)) {
            System.out.println("Valid license plate!");
        } else {
            System.out.println("Invalid license plate! A valid license plate must:");
            System.out.println("  - Start with two uppercase letters (A-Z)");
            System.out.println("  - Be followed by four digits (0-9)");
            System.out.println("  - Example: AB1234");
        }

        scanner.close();
    }
}
