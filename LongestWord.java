import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();        
        String longestWord = findLongestWord(sentence);
        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        
        String longestWord = "";        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }
}
