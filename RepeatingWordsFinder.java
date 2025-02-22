import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> repeatingWords = new HashSet<>();
        
        // Extract words using regex
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            
            if (wordCount.get(word) > 1) {
                repeatingWords.add(word);
            }
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        Set<String> duplicates = findRepeatingWords(text);
        if (!duplicates.isEmpty()) {
            System.out.println("Repeating Words:");
            System.out.println(String.join(", ", duplicates));
        } else {
            System.out.println("No repeating words found.");
        }

        scanner.close();
    }
}
