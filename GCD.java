import java.util.Scanner;

public class GCD{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = getInput("Enter first number: ", sc);
        int num2 = getInput("Enter second number: ", sc);
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        
        displayResults(num1, num2, gcd, lcm);
        
        sc.close();
    }
    private static int getInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextInt();
    }  
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
    private static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    private static void displayResults(int num1, int num2, int gcd, int lcm) {
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}