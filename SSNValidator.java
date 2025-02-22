import java.util.Scanner;
import java.util.regex.*;
public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String ssnRegex = "^(\\d{3}-\\d{2}-\\d{4})$"; // Format: 123-45-6789
        
        Pattern pattern = Pattern.compile(ssnRegex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Social Security Number (SSN): ");
        String ssn = scanner.nextLine();

        if (isValidSSN(ssn)) {
            System.out.println("\"" + ssn + "\" is a valid SSN.");
        } else {
            System.out.println("\"" + ssn + "\" is an invalid SSN.");
        }

        scanner.close();
    }
}
