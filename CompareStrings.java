import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = sc.nextLine();
        
        System.out.println("Enter the second string: ");
        String str2 = sc.nextLine();
        compareStringsLexicographically(str1, str2);
    }
    public static void compareStringsLexicographically(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());        
        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 < char2) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
                return;
            } else if (char1 > char2) {
                System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
                return;
            }
        }
        if (str1.length() < str2.length()) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
        } else if (str1.length() > str2.length()) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}
