import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        int vowels = 0, consonants = 0;
        String str = input.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // Check if character is a letter
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
        
        // Reverse the string without using built-in functions
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        
        System.out.println("Reversed string: " + reversed);
        
        sc.close();
    }
}