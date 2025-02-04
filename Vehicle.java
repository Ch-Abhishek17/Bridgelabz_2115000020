class Vehicle {
    static double registrationFee = 5000.0; 
    final String registrationNumber;
    String ownerName;
    String vehicleType;
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: Rs." + registrationFee);
    }
    void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: Rs." + registrationFee);
        }
    }

    public static void main(String[] args) {
        // Creating vehicle objects
        Vehicle vehicle1 = new Vehicle("Rahul Mehra", "Car", "MH12AB1234");
        Vehicle vehicle2 = new Vehicle("Sneha Kapoor", "Bike", "DL8CA4567");

        // Displaying vehicle registration details
        vehicle1.displayRegistrationDetails();
        System.out.println();
        vehicle2.displayRegistrationDetails();

        // Updating registration fee
        Vehicle.updateRegistrationFee(6000.0);
        System.out.println();

        // Displaying updated details with new registration fee
        vehicle1.displayRegistrationDetails();
        System.out.println();
        vehicle2.displayRegistrationDetails();
    }
}