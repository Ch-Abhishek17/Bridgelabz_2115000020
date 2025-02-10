// Abstract class representing a Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public abstract double calculateFare(double distance); // Abstract method
    
    public String getVehicleDetails() { // Concrete method
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }
}

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass for Car
class Car extends Vehicle implements GPS {
    private String currentLocation;
    
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass for Bike
class Bike extends Vehicle implements GPS {
    private String currentLocation;
    
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass for Auto
class Auto extends Vehicle implements GPS {
    private String currentLocation;
    
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 10; // Additional fixed charge for auto
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Ride-Hailing System
public class RideHailingApp {
    public static void processRide(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Total Fare: " + vehicle.calculateFare(distance));
    }
    
    public static void main(String[] args) {
        Vehicle car = new Car("C001", "John Doe", 15);
        Vehicle bike = new Bike("B001", "Jane Smith", 10);
        Vehicle auto = new Auto("A001", "Robert Brown", 12);
        
        GPS carGPS = (GPS) car;
        carGPS.updateLocation("Downtown");
        
        GPS bikeGPS = (GPS) bike;
        bikeGPS.updateLocation("City Center");
        
        GPS autoGPS = (GPS) auto;
        autoGPS.updateLocation("Suburbs");
        
        processRide(car, 10);
        System.out.println("Car Location: " + carGPS.getCurrentLocation());
        
        processRide(bike, 8);
        System.out.println("Bike Location: " + bikeGPS.getCurrentLocation());
        
        processRide(auto, 12);
        System.out.println("Auto Location: " + autoGPS.getCurrentLocation());
    }
}
