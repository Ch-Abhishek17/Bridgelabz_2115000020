import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            // Compute sum using formula
            int formulaSum = n * (n + 1) / 2;
            
            // Compute sum using while loop
            int sum = 0;
            int counter = 1;
            while (counter <= n) {
                sum += counter;
                counter++;
            }
            
            // Compare results
            System.out.println("Sum calculated using formula: " + formulaSum);
            System.out.println("Sum calculated using while loop: " + sum);
            
            if (formulaSum == sum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in the computations.");
            }
        }
        sc.close();
    }
}