import java.util.Scanner;
public class Income {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the salary & Bonus: ");
        double salary = sc.nextDouble();
        double bonus = sc.nextDouble();
        double totalIncome = salary + bonus;
        System.out.printf("\n The salary is INR %.2f and bonus is INR %.2f. Hence Total Income is INR %.2f",salary,bonus, totalIncome);
        sc.close();
    }
}
