import java.util.Scanner;
public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = getInput(sc);
        long result = factorial(number);
        displayResult(number, result); 
        sc.close();
    }
    private static int getInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    private static void displayResult(int number, long result) {
        System.out.println("The factorial of " + number + " is: " + result);
    }
}
