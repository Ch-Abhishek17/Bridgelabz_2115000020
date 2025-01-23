import java.util.Scanner;
public class Sum_of_n_Natural_Numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int number=sc.nextInt();
        if(number>0){
            int sum=number*(number+1)/2;
            System.out.printf("The sum of %d natural numbers is %d",number,sum);
        }
        else{
            System.out.printf("The number %d is not a natural number",number);
        }
        sc.close();
    }
}
