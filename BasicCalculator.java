import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char operation = sc.next().charAt(0);
        double result;
        switch (operation) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                if (num2 != 0) {
                    result = divide(num1, num2);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                sc.close();
                return;
        }
        
        System.out.println("Result: " + result);
        sc.close();
    }
    private static double add(double a, double b) {
        return a + b;
    }
    private static double subtract(double a, double b) {
        return a - b;
    }
    private static double multiply(double a, double b) {
        return a * b;
    }
    private static double divide(double a, double b) {
        return a / b;
    }
}