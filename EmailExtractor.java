import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details.";

        List<String> extractedEmails = extractEmails(text);
        if (!extractedEmails.isEmpty()) {
            System.out.println("Extracted Emails:");
            for (String email : extractedEmails) {
                System.out.println(email);
            }
        } else {
            System.out.println("No email addresses found.");
        }
    }
}
