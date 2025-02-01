public class Vehicle {
    private static double registrationFee = 5000; // Fixed registration fee for all vehicles
    private String ownerName;
    private String vehicleType;
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Amit Sharma", "Car");
        Vehicle vehicle2 = new Vehicle("Priya Singh", "Motorcycle");

        // Display vehicle details before updating registration fee
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        // Update the registration fee
        Vehicle.updateRegistrationFee(6000);

        // Display vehicle details after updating registration fee
        System.out.println("\nAfter updating registration fee:\n");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
