import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        String[] knownLanguages = {"Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Ruby", "Swift", "PHP", "Kotlin", "Rust", "Perl", "TypeScript", "R", "Dart", "Scala"};
        
        for (String lang : knownLanguages) {
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                languages.add(lang);
            }
        }
        return languages;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        List<String> extractedLanguages = extractLanguages(text);
        if (!extractedLanguages.isEmpty()) {
            System.out.println("Extracted Programming Languages:");
            System.out.println(String.join(", ", extractedLanguages));
        } else {
            System.out.println("No programming languages found.");
        }

        scanner.close();
    }
}
