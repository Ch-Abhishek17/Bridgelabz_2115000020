import java.util.Scanner;

public class SpaceReplacer {
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        String result = replaceMultipleSpaces(text);
        System.out.println("✅ Modified Sentence: " + result);

        scanner.close();
    }
}
