// Base Class: Order
class Order {
    int orderId;
    String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + getOrderStatus());
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackingNumber + ")";
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// Main Class to Test Multilevel Inheritance
public class OrderManagementSystem {
    public static void main(String[] args) {
        Order order = new Order(101, "2025-02-07");
        ShippedOrder shippedOrder = new ShippedOrder(102, "2025-02-06", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2025-02-05", "TRK67890", "2025-02-07");

        System.out.println("=== Order Details ===");
        order.displayOrderDetails();
        System.out.println("------------------------");

        System.out.println("=== Shipped Order Details ===");
        shippedOrder.displayOrderDetails();
        System.out.println("------------------------");

        System.out.println("=== Delivered Order Details ===");
        deliveredOrder.displayOrderDetails();
    }
}
