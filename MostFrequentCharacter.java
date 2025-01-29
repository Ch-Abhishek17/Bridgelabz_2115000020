import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "success"; // Example input string
        char result = findMostFrequentCharacter(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
    public static char findMostFrequentCharacter(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();        
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        char mostFrequentChar = str.charAt(0);
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequentChar;
    }
}
