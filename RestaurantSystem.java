// Superclass: Person
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface: Worker (Simulating Multiple Inheritance)
interface Worker {
    void performDuties();
}

// Subclass: Chef (Inherits from Person & Implements Worker)
class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking and preparing dishes.");
    }
}

// Subclass: Waiter (Inherits from Person & Implements Worker)
class Waiter extends Person implements Worker {
    int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Taking orders and serving food.");
    }
}

// Main Class to Test Hybrid Inheritance
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 201, 5);

        System.out.println("=== Chef Details ===");
        chef.displayInfo();
        chef.performDuties();
        System.out.println("------------------------");

        System.out.println("=== Waiter Details ===");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
