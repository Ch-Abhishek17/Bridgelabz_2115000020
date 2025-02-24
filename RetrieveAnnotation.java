import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Applying Annotation to a Class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("Book class method executed.");
    }
}

// Retrieving Annotation using Reflection
public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            Class<Book> bookClass = Book.class;
            
            // Check if @Author annotation is present
            if (bookClass.isAnnotationPresent(Author.class)) {
                Author author = bookClass.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
