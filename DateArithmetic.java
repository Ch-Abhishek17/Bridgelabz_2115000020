import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, formatter);
        LocalDate newDate = date.plusDays(7)
                               .plusMonths(1)
                               .plusYears(2);
        newDate = newDate.minusWeeks(3);
        System.out.println("Final date after modifications: " + newDate);
    }
}
