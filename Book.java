class Book {
    static String libraryName = "City Central Library";
    final String isbn;
    String title;
    String author;
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library Name: " + libraryName);
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "ISBN00123");
        Book book2 = new Book("1984", "George Orwell", "ISBN00456");

        Book.displayLibraryName();
        System.out.println();

        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
    }
}
