import java.util.Scanner;
public class MaxOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = getInput("Enter first number: ", sc);
        int num2 = getInput("Enter second number: ", sc);
        int num3 = getInput("Enter third number: ", sc);
        int max = findMax(num1, num2, num3);
        System.out.println("The maximum of the three numbers is: " + max);
        sc.close();
    }
    private static int getInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextInt();
    }
    private static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}