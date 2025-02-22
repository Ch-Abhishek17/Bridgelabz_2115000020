import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Valid username!");
        } else {
            System.out.println("Invalid username! A valid username must:");
            System.out.println("  - Start with a letter (a-z, A-Z)");
            System.out.println("  - Contain only letters, numbers, and underscores (_)");
            System.out.println("  - Be between 5 to 15 characters long");
        }

        scanner.close();
    }
}
