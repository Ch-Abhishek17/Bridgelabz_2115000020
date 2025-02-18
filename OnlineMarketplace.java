import java.util.ArrayList;
import java.util.List;
interface Category {}
class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

// Generic Product class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public T getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return name + " (" + category.getClass().getSimpleName() + ") - $" + price;
    }
}

// Generic method to apply discount
class ProductUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied to " + product.getName() + ". New Price: $" + product.getPrice());
    }
}

// Main class to test the catalog
public class OnlineMarketplace {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();
        
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 25.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());
        
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        
        System.out.println("Product Catalog:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
        
        // Apply discount
        System.out.println("\nApplying Discounts:");
        ProductUtils.applyDiscount(book, 10);
        ProductUtils.applyDiscount(shirt, 15);
        ProductUtils.applyDiscount(phone, 5);
    }
}
