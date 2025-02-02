public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0; // Fixed daily rental rate

    // Default constructor
    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate the total rental cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        // Using default constructor
        CarRental rental1 = new CarRental();
        rental1.displayRentalDetails();

        System.out.println();

        // Using parameterized constructor
        CarRental rental2 = new CarRental("Alice Johnson", "Toyota Corolla", 5);
        rental2.displayRentalDetails();
    }
}