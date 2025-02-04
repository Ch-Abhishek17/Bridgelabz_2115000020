class Product {
    static double discount = 10.0; // Default discount percentage
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }
    void displayProductDetails() {
        if (this instanceof Product) {
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Product ID: " + this.productID);
            System.out.println("Product Name: " + this.productName);
            System.out.println("Original Price: Rs." + this.price);
            System.out.println("Discounted Price: Rs." + discountedPrice);
            System.out.println("Quantity: " + this.quantity);
        }
    }

    public static void main(String[] args) {
        Product prod1 = new Product("P001", "Laptop", 50000.00, 2);
        Product prod2 = new Product("P002", "Smartphone", 20000.00, 5);
        prod1.displayProductDetails();
        System.out.println();
        prod2.displayProductDetails();

        Product.updateDiscount(15.0);
        System.out.println();

        prod1.displayProductDetails();
        System.out.println();
        prod2.displayProductDetails();
    }
}