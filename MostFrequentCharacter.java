import java.util.Scanner;

public class MostFrequentCharacter {
    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256];
        
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        
        int maxFreq = 0;
        char mostFrequentChar = ' ';
        
        for (char c : str.toCharArray()) {
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                mostFrequentChar = c;
            }
        }
        
        return mostFrequentChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        char result = findMostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}