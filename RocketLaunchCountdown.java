// Program to count down the number from user input value to 1 using a while loop for a rocket launch

import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the countdown start value: ");
        int counter = sc.nextInt();
        while (counter > 0) {
            System.out.println(counter);
            counter--;
        }
        
        System.out.println("Blast off!");
        sc.close();
    }
}