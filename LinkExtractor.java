import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        String urlRegex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\S*)?\\b";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence containing links: ");
        String text = scanner.nextLine();

        List<String> extractedLinks = extractLinks(text);
        if (!extractedLinks.isEmpty()) {
            System.out.println("Extracted Links:");
            System.out.println(String.join(", ", extractedLinks));
        } else {
            System.out.println("No links found.");
        }

        scanner.close();
    }
}
