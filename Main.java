import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Double> cartOrder = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
    }

    public void displayCart() {
        TreeMap<String, Double> sortedCart = new TreeMap<>(Comparator.comparing(productPrices::get));
        sortedCart.putAll(productPrices);
        
        System.out.println("Cart in order added: " + cartOrder);
        System.out.println("Cart sorted by price: " + sortedCart);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 800);
        cart.addProduct("Phone", 500);
        cart.addProduct("Headphones", 100);
        
        cart.displayCart();
    }
}
