import java.util.Scanner;
public class Expressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a, b, and c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //Results
        int r1 = a + b * c;  
        int r2 = a * b + c;   
        int r3 = c + a / b;   
        int r4 = a % b + c;   
        System.out.printf("\n The results of Int Operations are %d, %d, %d, and %d \n",r1,r2,r3,r4 );
        sc.close();
    }
}
