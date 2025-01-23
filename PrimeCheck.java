import java.util.Scanner;
public class PrimeCheck{
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break; 
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();        
        if (isPrime(userInput)) {
            System.out.println(userInput + " is a prime number.");
        } else {
            System.out.println(userInput + " is not a prime number.");
        }        
        scanner.close();
    }
}
