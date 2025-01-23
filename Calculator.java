import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers");
        float a=sc.nextFloat();
        float b=sc.nextFloat();
        float add=a+b;
        float sub=a-b;
        float mult=a*b;
        float div=a/b;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+a+" and "+b+ "is "+add+", "+sub+", " +mult+", and "+div);
    }
    
}
