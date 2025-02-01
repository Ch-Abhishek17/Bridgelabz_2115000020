public class Product {
    private static int totalProducts = 0;
    private String productName;
    private double price;
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; 
    }
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 50000);
        Product product2 = new Product("Smartphone", 20000);
        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.displayTotalProducts();
    }
}
