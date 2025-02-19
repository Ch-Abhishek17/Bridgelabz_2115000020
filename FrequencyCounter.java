import java.util.*;
public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by spaces:");
        String input = scanner.nextLine();
        List<String> words = Arrays.asList(input.split("\\s+"));
        Map<String, Integer> frequency = countFrequency(words);
        System.out.println(frequency);
        scanner.close();
    }
}
