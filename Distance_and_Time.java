import java.util.Scanner;
public class Distance_and_Time{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter the starting city (fromCity): ");
        String fromCity = sc.nextLine();
        System.out.print("Enter the via city (viaCity): ");
        String viaCity = sc.nextLine();
        System.out.print("Enter the final destination city (toCity): ");
        String toCity = sc.nextLine();
        // Taking user inputs for distances in miles
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double distanceFromToVia = sc.nextDouble();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double distanceViaToFinalCity = sc.nextDouble();
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (hours): ");
        int timeFromToViaHours = sc.nextInt();
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (minutes): ");
        int timeFromToViaMinutes = sc.nextInt();
        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (hours): ");
        int timeViaToFinalCityHours = sc.nextInt();
        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (minutes): ");
        int timeViaToFinalCityMinutes = sc.nextInt();
        // Compute total distance in miles
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        // Compute total time in minutes
        int totalTimeMinutes = (timeFromToViaHours * 60 + timeFromToViaMinutes) +
                               (timeViaToFinalCityHours * 60 + timeViaToFinalCityMinutes);
        System.out.println("\nTraveler: " + name);
        System.out.println("Total Distance from " + fromCity + " to " + toCity + " via " + viaCity + ": " + totalDistance + " miles, the Total Time taken is " +totalTimeMinutes+ " minutes");        
        sc.close();
    }
}
