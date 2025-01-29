import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();
        System.out.print("Convert to (C/F): ");
        char choice = sc.next().toUpperCase().charAt(0);
        if (choice == 'C') {
            System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temperature));
        } else if (choice == 'F') {
            System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temperature));
        } else {
            System.out.println("Invalid choice. Please enter 'C' or 'F'.");
        }
        
        sc.close();
    }static
    private  double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}