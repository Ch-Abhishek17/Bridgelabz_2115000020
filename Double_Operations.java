import java.util.Scanner;

public class Double_Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a, b, and c ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        // Perform double operations 
        double r1 = a + b * c; 
        double r2 = a * b + c;   
        double r3 = c + a / b;   
        double r4 = a % b + c;   
        System.out.printf("The results of Double Operations are %.2f, %.2f, %.2f, and %.2f ",r1,r2,r3,r4 );
        sc.close();
    }
}
