// Superclass: Vehicle
class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable (For Petrol Vehicles)
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle (Inherits from Vehicle)
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging electric vehicle...");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: PetrolVehicle (Inherits from Vehicle & Implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, double fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle...");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Main Class to Test Hybrid Inheritance
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        System.out.println("=== Electric Vehicle Details ===");
        ev.displayInfo();
        ev.charge();
        System.out.println("------------------------");

        System.out.println("=== Petrol Vehicle Details ===");
        pv.displayInfo();
        pv.refuel();
    }
}
