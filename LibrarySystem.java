abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public abstract int getLoanDuration(); // Abstract method
    
    public String getItemDetails() { // Concrete method
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

// Interface for reservable items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Subclass for Book
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;
    
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // Books can be loaned for 14 days
    }
    
    @Override
    public void reserveItem() {
        isReserved = true;
        System.out.println("Book reserved successfully.");
    }
    
    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Subclass for Magazine
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be loaned for 7 days
    }
}

// Subclass for DVD
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;
    
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    
    @Override
    public int getLoanDuration() {
        return 3; // DVDs can be loaned for 3 days
    }
    
    @Override
    public void reserveItem() {
        isReserved = true;
        System.out.println("DVD reserved successfully.");
    }
    
    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Testing the Library Management System
public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "Java Programming", "John Doe");
        LibraryItem magazine = new Magazine("M001", "Tech Monthly", "Jane Smith");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");
        
        System.out.println(book.getItemDetails() + ", Loan Duration: " + book.getLoanDuration() + " days");
        System.out.println(magazine.getItemDetails() + ", Loan Duration: " + magazine.getLoanDuration() + " days");
        System.out.println(dvd.getItemDetails() + ", Loan Duration: " + dvd.getLoanDuration() + " days");
        
        Reservable reservableBook = (Reservable) book;
        reservableBook.reserveItem();
        System.out.println("Book availability: " + reservableBook.checkAvailability());
    }
}
