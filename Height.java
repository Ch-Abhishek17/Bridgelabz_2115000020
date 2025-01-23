/*
 * Write a program that takes your height in centimeters and converts it into feet and inches
Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
I/P => height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
 */
import java.util.Scanner;
public class Height {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        float height=sc.nextFloat();
        double inch=height/2.54;
        System.out.println("Your Height in cm is "+height+" while in feet is "+(inch/12)+" and inches is "+inch);
    }
    
}
