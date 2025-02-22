import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        String dateRegex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        List<String> extractedDates = extractDates(text);
        if (!extractedDates.isEmpty()) {
            System.out.println("Extracted Dates:");
            System.out.println(String.join(", ", extractedDates));
        } else {
            System.out.println("No valid dates found.");
        }

        scanner.close();
    }
}
