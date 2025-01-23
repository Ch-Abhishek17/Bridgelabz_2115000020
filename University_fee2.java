import java.util.Scanner;
public class University_fee2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total fees and discount percent");
        int fee=sc.nextInt();
        int dp=sc.nextInt(); //dp-discount percent
        int discount=(fee*dp)/100;
        int due=fee-discount; //fee to be paid
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+due);
    }    
}