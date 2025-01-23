import java.util.Scanner;
public class Handshakes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int maxHandshakes = (n * (n - 1)) / 2;
        System.out.println("\nThe maximum number of possible handshakes is: " + maxHandshakes);
        sc.close();
    }
}
