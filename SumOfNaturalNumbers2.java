import java.util.Scanner;
public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            // Compute sum using formula
            int formulaSum = n * (n + 1) / 2;
            // Compute sum using for loop
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            
            // Compare results
            System.out.println("Sum calculated using formula: " + formulaSum);
            System.out.println("Sum calculated using for loop: " + sum);
            
            if (formulaSum == sum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in the computations.");
            }
        }
        sc.close();
    }
}
