import java.util.Scanner;

public class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder toggled = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggled.append(Character.toUpperCase(ch));
            } else {
                toggled.append(ch); // Keep non-alphabet characters unchanged
            }
        }
        
        return toggled.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String result = toggleCase(input);
        System.out.println("Toggled case: " + result);
        
        scanner.close();
    }
}
