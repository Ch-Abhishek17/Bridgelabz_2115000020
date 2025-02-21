import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version consistency
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.dat";
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Raj", "IT", 75000));
        employees.add(new Employee(102, "Simran", "HR", 65000));
        employees.add(new Employee(103, "Amit", "Finance", 80000));

        // Serialize Employee List
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> retrievedEmployees = deserializeEmployees();
        if (retrievedEmployees != null) {
            System.out.println("\nEmployee List from File:");
            for (Employee emp : retrievedEmployees) {
                emp.display();
            }
        }
    }

    // Serialize List of Employees to a File
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
        }
    }

    // Deserialize List of Employees from File
    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found - " + e.getMessage());
        }
        return null;
    }
}
