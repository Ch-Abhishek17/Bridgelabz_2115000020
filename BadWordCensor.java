import java.util.Scanner;
public class BadWordCensor {
    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Define bad words
        String[] badWords = {"damn", "stupid"}; 

        String censoredText = censorBadWords(text, badWords);
        System.out.println("Censored Sentence: " + censoredText);

        scanner.close();
    }
}
