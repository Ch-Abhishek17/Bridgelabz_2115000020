import java.util.Scanner;
public class DivisibleBy5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        if(n%5==0)
        System.out.printf(" Is the number %d divisible by 5? Yes",n);
        else
        System.out.printf(" Is the number %d divisible by 5? No",n);
        sc.close();
    }
}