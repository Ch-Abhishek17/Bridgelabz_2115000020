// Abstract class representing a warehouse item
import java.util.*;
abstract class WarehouseItem {
    private String name;
    
    public WarehouseItem(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + name;
    }
}

// Concrete item types
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public List<T> getItems() {
        return items;
    }
    
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Utility method to display items from any storage type
class WarehouseUtils {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test functionality
public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Milk"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chair"));
        
        // Display all items in respective storage
        System.out.println("Electronics Storage:");
        electronicsStorage.displayItems();
        
        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayItems();
        
        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayItems();
        
        // Using wildcard method to display all items
        System.out.println("\nDisplaying all items using wildcard method:");
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}
