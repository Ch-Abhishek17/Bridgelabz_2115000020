import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
    public abstract double calculateRentalCost(int days);
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: " + rentalRate);
    }
}
// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
// Car class
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% insurance cost
    }
    @Override
    public String getInsuranceDetails() {
        return "Insurance: 5% of rental rate";
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate() * 1.2; // Extra 20% cost for heavy vehicles
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% insurance cost
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance: 10% of rental rate";
    }
}
// Main class to demonstrate functionality
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Car car1 = new Car("KA01AB1234", 1000);
        Bike bike1 = new Bike("KA02BC5678", 500);
        Truck truck1 = new Truck("KA03CD9101", 2000);
        
        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(truck1);
        
        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println("--------------------");
        }
    }
}