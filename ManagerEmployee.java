class Employee {
    public int employeeID;      
    protected String department; 
    private double salary;       

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void modifySalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

// Manager class extending Employee
class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

public class ManagerEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Sales", 50000);
        employee.modifySalary(55000);
        System.out.println("Updated salary: " + employee.getSalary());
        Manager manager = new Manager(102, "HR", 75000);
        manager.displayManagerDetails();  
    }
}
