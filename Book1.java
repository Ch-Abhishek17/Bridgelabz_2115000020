public class Book1 {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Book is available by default
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
            return true;
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently unavailable.");
            return false;
        }
    }

    // Method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Book1 book1 = new Book1("1984", "George Orwell", 199.99);
        book1.displayInfo();

        System.out.println();

        book1.borrowBook(); // Borrow the book
        book1.displayInfo();

        System.out.println();

        book1.borrowBook(); // Try to borrow again
    }
}
