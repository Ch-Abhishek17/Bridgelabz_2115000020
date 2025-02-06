import java.util.ArrayList;
import java.util.List;

// Product Class
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Display product details
    public void displayProductDetails() {
        System.out.println("Product: " + name + " | Price: $" + price);
    }
}

// Order Class
class Order {
    private int orderId;
    private List<Product> products;
    private Customer customer;

    // Constructor
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Add product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate total price of the order
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        System.out.println("Products in this order:");
        for (Product product : products) {
            product.displayProductDetails();
        }
        System.out.println("Total Price: $" + calculateTotal());
    }

    // Getter for orderId
    public int getOrderId() {
        return orderId;
    }
}

// Customer Class
class Customer {
    private String name;
    private List<Order> orders;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Place an order
    public void placeOrder(Order order) {
        orders.add(order);
    }

    // Getter for customer name
    public String getName() {
        return name;
    }

    // View all orders placed by the customer
    public void viewOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

// Main Class to Demonstrate the System
public class ECommerceSystem {
    public static void main(String[] args) {
        // Create Products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        // Create Customer
        Customer customer1 = new Customer("John Doe");

        // Create Orders and add products to the orders
        Order order1 = new Order(1, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(2, customer1);
        order2.addProduct(product3);

        // Customer places orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // View all orders placed by the customer
        customer1.viewOrders();
    }
}
