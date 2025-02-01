class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN); // Accessing public member
        System.out.println("Title: " + title); // Accessing protected member
        System.out.println("Author: " + getAuthor()); // Accessing private member via public method
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
        Book book = new Book("978-1234567890", "Java Programming", "John Doe");
        book.displayBookDetails();

        // Modifying Author
        book.setAuthor("Jane Smith");
        System.out.println("Updated Author: " + book.getAuthor());

        // EBook
        EBook ebook = new EBook("978-0987654321", "Advanced Java", "Emily Clark", 2.5);
        ebook.displayEBookDetails();
    }
}
