import java.util.ArrayList;

// Employee Class (Nested inside Department)
class Employee {
    private String name;
    private int id;
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // String representation of Employee
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name;
    }
}

// Department Class
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void displayDepartmentInfo() {
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public void removeEmployees() {
        employees.clear();
    }
}

// Company Class
class Company {
    private String companyName;
    private ArrayList<Department> departments;
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Method to add a department to the company
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Method to display all departments and employees in the company
    public void displayCompanyInfo() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            department.displayDepartmentInfo();
        }
    }

    // Method to remove all departments and employees (simulating company deletion)
    public void removeCompany() {
        for (Department department : departments) {
            department.removeEmployees();  // Remove all employees from department
        }
        departments.clear();  // Remove all departments from company
        System.out.println("Company and all departments and employees have been removed.");
    }
}

// Main Class to Demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department dept1 = new Department("HR");
        Department dept2 = new Department("Engineering");

        dept1.addEmployee(new Employee("Alice", 101));
        dept1.addEmployee(new Employee("Bob", 102));

        dept2.addEmployee(new Employee("Charlie", 201));
        dept2.addEmployee(new Employee("David", 202));
        company.addDepartment(dept1);
        company.addDepartment(dept2);
        company.displayCompanyInfo();
        System.out.println();
        company.removeCompany();
        company.displayCompanyInfo();
    }
}
