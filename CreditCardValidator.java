import java.util.Scanner;
import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        String visaRegex = "^4\\d{15}$";      // Visa: 4 se start, total 16 digits
        String masterCardRegex = "^5\\d{15}$"; // MasterCard: 5 se start, total 16 digits
        
        return cardNumber.matches(visaRegex) || cardNumber.matches(masterCardRegex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a credit card number: ");
        String cardNumber = scanner.nextLine();

        if (isValidCreditCard(cardNumber)) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }

        scanner.close();
    }
}
