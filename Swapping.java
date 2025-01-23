import java.util.Scanner;
public class Swapping{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        num1 = num1 + num2; 
        num2 = num1 - num2; 
        num1 = num1 - num2;
        System.out.printf("\nThe swapped numbers are %d and %d",num1,num2);
        sc.close();
    }
}
