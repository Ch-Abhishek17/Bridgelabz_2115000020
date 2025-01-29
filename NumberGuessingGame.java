import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100;
        boolean guessedCorrectly = false;
        System.out.println("Think of a number between 1 and 100. The computer will try to guess it.");
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'h' for too high, 'l' for too low, 'c' for correct)");
            char feedback = sc.next().charAt(0);  
            if (feedback == 'c') {
              System.out.println("Great! The computer guessed your number.");
                guessedCorrectly = true;
            } else if (feedback == 'h') {
                high = guess - 1;
            } else if (feedback == 'l') {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'h', 'l', or 'c'.");
            }
        }
        sc.close();
    }
    private static int generateGuess(int low, int high, Random random) {
        return low + random.nextInt(high - low + 1);
    }
}
