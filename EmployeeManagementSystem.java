import java.util.*;
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary for full-time employees
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // Salary based on hours worked
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Amit", 50000);
        emp1.assignDepartment("HR");
        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Neha", 500, 20);
        emp2.assignDepartment("IT");
        employees.add(emp1);
        employees.add(emp2);
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("--------------------");
        }
    }
}
