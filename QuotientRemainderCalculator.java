import java.util.Scanner;

public class QuotientRemainderCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number (dividend): ");
        int n1 = sc.nextInt();
        System.out.print("Enter the second number (divisor): ");
        int n2 = sc.nextInt();
        int quotient = n1 / n2;
        int remainder = n1 % n2;
        System.out.printf("\nThe Quotient is %d and Remainder is %d of two numbers %d and %d\n", quotient, remainder, n1, n2);

        sc.close();
    }
}
