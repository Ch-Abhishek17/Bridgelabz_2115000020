import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class CapitalizedWordExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        String capitalizedWordRegex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(capitalizedWordRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        List<String> extractedWords = extractCapitalizedWords(text);
        if (!extractedWords.isEmpty()) {
            System.out.println("Extracted Capitalized Words:");
            System.out.println(String.join(", ", extractedWords));
        } else {
            System.out.println("No capitalized words found.");
        }

        scanner.close();
    }
}
