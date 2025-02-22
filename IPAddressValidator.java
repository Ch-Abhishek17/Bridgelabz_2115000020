import java.util.Scanner;
import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIPAddress(String ip) {
        String ipRegex = 
            "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}" +
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        
        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();

        if (isValidIPAddress(ipAddress)) {
            System.out.println("Valid IPv4 Address");
        } else {
            System.out.println("Invalid IPv4 Address");
        }

        scanner.close();
    }
}
