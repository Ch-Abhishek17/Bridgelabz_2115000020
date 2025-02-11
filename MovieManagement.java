import java.util.Scanner;
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = this.next = null;
    }
}
class MovieList {
    private Movie head, tail;

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search movie by director or rating
    public void search(String key) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(key) || String.valueOf(temp.rating).equals(key)) {
                System.out.println("Found: " + temp.title + " by " + temp.director + " (" + temp.year + ") - Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Display all movies (forward)
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.director + " (" + temp.year + ") - Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies (reverse)
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.director + " (" + temp.year + ") - Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Remove Movie by Title");
            System.out.println("4. Search Movie by Director or Rating");
            System.out.println("5. Display Movies Forward");
            System.out.println("6. Display Movies Reverse");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Movie Title to remove: ");
                    list.removeByTitle(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Director name or Rating to search: ");
                    list.search(sc.nextLine());
                    break;
                case 5:
                    list.displayForward();
                    break;
                case 6:
                    list.displayReverse();
                    break;
                case 7:
                    System.out.print("Enter Movie Title and new Rating: ");
                    list.updateRating(sc.nextLine(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
