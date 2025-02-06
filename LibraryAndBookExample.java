import java.util.ArrayList;

// Book Class
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // String representation of the Book object
    @Override
    public String toString() {
        return "Book Title: " + title + ", Author: " + author;
    }
}

// Library Class
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Display information about the library and its books
    public void displayLibraryInfo() {
        System.out.println("Library: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Main Class to Demonstrate Aggregation
public class LibraryAndBookExample {
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Creating Library objects
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Adding books to the libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);

        // Display information about both libraries and their books
        library1.displayLibraryInfo();
        System.out.println();
        library2.displayLibraryInfo();
    }
}
