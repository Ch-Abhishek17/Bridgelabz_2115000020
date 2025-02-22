import java.util.Scanner;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#([A-Fa-f0-9]{6})$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex color code: ");
        String color = scanner.nextLine();

        if (isValidHexColor(color)) {
            System.out.println("Valid hex color code!");
        } else {
            System.out.println("Invalid hex color! A valid hex color must:");
            System.out.println("  - Start with '#' ");
            System.out.println("  - Be followed by exactly 6 hexadecimal characters (0-9, A-F, a-f)");
            System.out.println("  - Example: #FFA500, #ff4500");
        }

        scanner.close();
    }
}
