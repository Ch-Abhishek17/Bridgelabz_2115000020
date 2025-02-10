import java.util.*;
abstract class Product {
    private int productId;
    private String name;
    private double price;
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
    
    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 18%";
    }
}

// Clothing class
class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }
}

// Groceries class
class Groceries extends Product implements Taxable {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 5%";
    }
}
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Electronics product1 = new Electronics(201, "Laptop", 60000);
        Clothing product2 = new Clothing(202, "T-Shirt", 1000);
        Groceries product3 = new Groceries(203, "Rice", 500);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        for (Product product : products) {
            product.displayDetails();
            double finalPrice = product.getPrice() - product.calculateDiscount();
            if (product instanceof Taxable) {
                finalPrice += ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------");
        }
    }
}