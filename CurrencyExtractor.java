import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        String currencyRegex = "\\$?\\d+(\\.\\d{1,2})?";  // Matches "$45.99" or "10.50"

        Pattern pattern = Pattern.compile(currencyRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence with currency values: ");
        String text = scanner.nextLine();

        List<String> extractedValues = extractCurrencyValues(text);
        if (!extractedValues.isEmpty()) {
            System.out.println("Extracted Currency Values:");
            System.out.println(String.join(", ", extractedValues));
        } else {
            System.out.println("No currency values found.");
        }

        scanner.close();
    }
}
