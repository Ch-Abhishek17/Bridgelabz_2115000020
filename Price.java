import java.util.Scanner;
public class Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the unit price: ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.printf("\nThe total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f\n", totalPrice, quantity, unitPrice);
        sc.close();
    }
}
