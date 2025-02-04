class Employee {
    static String companyName = "Tech Solutions Ltd.";
    static int totalEmployees = 0;
    final String id;
    String name;
    String designation;
    Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; 
    }
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + this.name);
            System.out.println("Employee ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Amit Sharma", "EMP1001", "Software Engineer");
        Employee emp2 = new Employee("Priya Verma", "EMP1002", "Project Manager");

        emp1.displayEmployeeDetails();
        System.out.println();
        emp2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
    }
}
