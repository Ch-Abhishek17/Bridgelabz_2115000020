import java.util.Scanner;

public class FriendsInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the age of Amar: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter the height of Amar in cm: ");
        double heightAmar = scanner.nextDouble();
        
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter the height of Akbar in cm: ");
        double heightAkbar = scanner.nextDouble();
        
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter the height of Anthony in cm: ");
        double heightAnthony = scanner.nextDouble();
        
        scanner.close();
        
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        double tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        
        if (youngestAge == ageAmar) {
            System.out.println("Amar is the youngest.");
        } else if (youngestAge == ageAkbar) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }
        
        if (tallestHeight == heightAmar) {
            System.out.println("Amar is the tallest.");
        } else if (tallestHeight == heightAkbar) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
    }
}
