public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;
    public HotelBooking() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        // Using default constructor
        HotelBooking booking1 = new HotelBooking();
        booking1.displayBooking();

        System.out.println();

        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);
        booking2.displayBooking();

        System.out.println();

        // Using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        booking3.displayBooking();
    }
}
