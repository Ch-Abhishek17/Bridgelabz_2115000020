/*
 * Problem Statement: Design an inventory management system using a singly linked list where each node stores information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
Add an item at the beginning, end, or at a specific position.
Remove an item based on Item ID.
Update the quantity of an item by Item ID.
Search for an item based on Item ID or Item Name.
Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
Sort the inventory based on Item Name or Price in ascending or descending order.
Hint:
Use a singly linked list where each node represents an item in the inventory.
Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
For total value calculation, traverse through the list and sum up Quantity * Price for each item.

 */
import java.util.Scanner;
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search item by ID or Name
    public void searchItem(String key) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(key) || Integer.toString(temp.itemId).equals(key)) {
                System.out.println("----------------------------------------");
                System.out.println("Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                System.out.println("----------------------------------------");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
        System.out.println("Total Inventory Value: " + totalValue);
        System.out.println("----------------------------------------");
    }

    // Display all items
    public void displayInventory() {
        System.out.println("----------------------------------------");
        System.out.println("Inventory List:");
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " - " + temp.itemName + " (Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n----------------------------------------");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Remove Item by ID");
            System.out.println("4. Update Quantity by ID");
            System.out.println("5. Search Item by ID or Name");
            System.out.println("6. Display Inventory");
            System.out.println("7. Calculate Total Inventory Value");
            System.out.println("8. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear buffer
                continue;
            }
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name, ID, Quantity, Price: ");
                    String name = sc.next();
                    int id, qty;
                    double price;
                    try {
                        id = sc.nextInt();
                        qty = sc.nextInt();
                        price = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                        sc.nextLine(); // Clear buffer
                        continue;
                    }
                    inventory.addAtBeginning(name, id, qty, price);
                    break;
                case 2:
                    System.out.print("Enter Item Name, ID, Quantity, Price: ");
                    name = sc.next();
                    try {
                        id = sc.nextInt();
                        qty = sc.nextInt();
                        price = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                        sc.nextLine(); // Clear buffer
                        continue;
                    }
                    inventory.addAtEnd(name, id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeByItemId(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Item ID and New Quantity: ");
                    inventory.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID or Name to search: ");
                    inventory.searchItem(sc.next());
                    break;
                case 6:
                    inventory.displayInventory();
                    break;
                case 7:
                    inventory.calculateTotalValue();
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
