abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice(); // Abstract method
    public String getItemDetails() { // Concrete method
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Interface for discountable items
interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// Subclass for VegItem
class VegItem extends FoodItem implements Discountable {
    private double discount;
    
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }
    
    @Override
    public double calculateTotalPrice() {
        return (price * quantity) - (price * quantity * discount / 100);
    }
    
    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount + "%";
    }
}

// Subclass for NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double ADDITIONAL_CHARGE = 20.0;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }
    
    @Override
    public double calculateTotalPrice() {
        return ((price * quantity) + ADDITIONAL_CHARGE) - ((price * quantity) * discount / 100);
    }
    
    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount + "%";
    }
}

// Order processing system
public class FoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: " + item.calculateTotalPrice());
    }
    
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 350, 1);
        
        Discountable discountableVeg = (Discountable) vegItem;
        discountableVeg.applyDiscount(10);
        
        Discountable discountableNonVeg = (Discountable) nonVegItem;
        discountableNonVeg.applyDiscount(5);
        
        processOrder(vegItem);
        System.out.println(discountableVeg.getDiscountDetails());
        
        processOrder(nonVegItem);
        System.out.println(discountableNonVeg.getDiscountDetails());
    }
}
