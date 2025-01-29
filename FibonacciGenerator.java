import java.util.Scanner;
public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int terms = sc.nextInt();
        generateFibonacci(terms);
        sc.close();
    }
    private static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        System.out.print("Fibonacci Sequence: " + first);
        for (int i = 1; i < terms; i++) {
            System.out.print(", " + second);
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}