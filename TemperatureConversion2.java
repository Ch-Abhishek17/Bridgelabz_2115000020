import java.util.Scanner;
public class TemperatureConversion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        double celsiusResult = (fahrenheit - 32) * 5 / 9;
        System.out.printf("\nThe %.2f fahrenheit is %.2f celsius",fahrenheit, celsiusResult);
        sc.close();
    }
}
