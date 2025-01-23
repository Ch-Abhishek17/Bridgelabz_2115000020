import java.util.Scanner;
public class Largest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        int number1=sc.nextInt();
        int number2=sc.nextInt();
        int number3=sc.nextInt();
        if((number1>number2) && (number1>number3)){
            System.out.println("Is the first number the Largest? Yes");

        }
        else if(number2>number3){
            System.out.println("Is the Second number the Largest? Yes");
        }
        else{
            System.out.println("Is the third number the Largest? Yes");
        }
        sc.close();
    }
}
