import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicateCharacters(String str) {
        String result = "";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        String output = removeDuplicateCharacters(input);
        System.out.println("String after removing duplicates: " + output);
    }
}
