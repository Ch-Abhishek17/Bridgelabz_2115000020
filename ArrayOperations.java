import java.util.Scanner;
public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer[] array = {10, 20, 30, 40, 50};

            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid index.");
        } finally {
            scanner.close();
        }
    }
}
