import java.util.Scanner;
public class Square{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = sc.nextDouble();
        double side = perimeter / 4;
        System.out.println("\nThe side length of the square is: " +side+" whose perimeter is "+perimeter);
        sc.close();
    }
}
