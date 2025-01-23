import java.util.Scanner;
public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter the age of the Voter:");
        int age=sc.nextInt();
        if(age>=18){
            System.out.printf("The person's age is %d and can vote.",age);
        }
        else{
            System.out.printf("The person's age is %d and can not vote.",age);
        }
        sc.close();
    }
}
