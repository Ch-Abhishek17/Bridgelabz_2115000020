/*
 
5. Doubly Linked List: Library Management System
Problem Statement: Design a library management system using a doubly linked list. Each node represents a book and contains the following attributes: Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
Add a new book at the beginning, end, or at a specific position.
Remove a book by Book ID.
Search for a book by Book Title or Author.
Update a book’s Availability Status.
Display all books in forward and reverse order.
Count the total number of books in the library.
Hint:
Use a doubly linked list with two pointers (next and prev) in each node to facilitate traversal in both directions.
Ensure that when removing a book, both the next and prev pointers are correctly updated.
Displaying in reverse order will require traversal from the last node using prev pointers.
 */
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;
    private int totalBooks = 0;
    Scanner sc = new Scanner(System.in);

    // Add a new book at the beginning, end, or a specific position
    public void addBook(String title, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);

        if (position == 1) { // Add at beginning
            if (head == null) {
                head = tail = newBook;
            } else {
                newBook.next = head;
                head.prev = newBook;
                head = newBook;
            }
        } else if (position == 2) { // Add at end
            if (head == null) {
                head = tail = newBook;
            } else {
                tail.next = newBook;
                newBook.prev = tail;
                tail = newBook;
            }
        } else { // Add at specific position
            Book temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newBook.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = newBook;
                }
                temp.next = newBook;
                newBook.prev = temp;
            }
        }
        totalBooks++;
    }

    // Remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("No books to remove.");
            return;
        }

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            System.out.println("Book removed.");
            totalBooks--;
            return;
        }

        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp == tail) {
                    tail = temp.prev;
                }
                System.out.println("Book removed.");
                totalBooks--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Search for a book by Book Title or Author
    public void searchBook(String searchTerm) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(searchTerm) || temp.author.equalsIgnoreCase(searchTerm)) {
                System.out.println("Book Found: ");
                System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre +
                        ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean availabilityStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availabilityStatus = availabilityStatus;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books to display.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books to display.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public void countBooks() {
        System.out.println("Total number of books in the library: " + totalBooks);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Update Availability Status");
            System.out.println("5. Display Books Forward");
            System.out.println("6. Display Books Reverse");
            System.out.println("7. Count Total Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline character

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability Status (true for available, false for not): ");
                    boolean availabilityStatus = sc.nextBoolean();
                    System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Specific Position");
                    int position = sc.nextInt();
                    library.addBook(title, author, genre, bookId, availabilityStatus, position);
                    break;

                case 2: // Remove Book
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    break;

                case 3: // Search Book
                    System.out.print("Enter Book Title or Author to search: ");
                    sc.nextLine(); // Consume newline character
                    String searchTerm = sc.nextLine();
                    library.searchBook(searchTerm);
                    break;

                case 4: // Update Availability Status
                    System.out.print("Enter Book ID to update status: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new Availability Status (true for available, false for not): ");
                    boolean newStatus = sc.nextBoolean();
                    library.updateAvailabilityStatus(updateId, newStatus);
                    break;

                case 5: // Display Books Forward
                    library.displayBooksForward();
                    break;

                case 6: // Display Books Reverse
                    library.displayBooksReverse();
                    break;

                case 7: // Count Total Books
                    library.countBooks();
                    break;

                case 8: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}