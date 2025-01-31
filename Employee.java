
class Employee {
    String name;
    int empId;
    double salary;
    public Employee(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("Rahul Sharma", 101, 50000);
        Employee emp2 = new Employee("Seema Verma", 102, 60000);
        System.out.println("Employee 1 Details:");
        emp1.displayDetails();
        System.out.println("--------------------");
        System.out.println("Employee 2 Details:");
        emp2.displayDetails();
    }
}
