import java.util.Scanner;

public class SubstringOccurrences {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // Move index forward to avoid overlapping
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.print("Enter the substring to search for: ");
        String substring = scanner.nextLine();

        int occurrences = countOccurrences(mainString, substring);
        System.out.println("Occurrences of \"" + substring + "\": " + occurrences);

        scanner.close();
    }
}
