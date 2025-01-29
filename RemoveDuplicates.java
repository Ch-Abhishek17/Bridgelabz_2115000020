import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

    public static String removeDuplicates(String str) {
        // Using a HashSet to keep track of unique characters
        HashSet<Character> seen = new HashSet<>();
        StringBuilder modifiedStr = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // Add the character to the StringBuilder if it hasn't been seen before
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                modifiedStr.append(currentChar);
            }
        }
        
        return modifiedStr.toString();
    }
}
