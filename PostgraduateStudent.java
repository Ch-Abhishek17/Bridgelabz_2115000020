class Student {
    public int rollNumber;
    protected String name;  // Protected Variable
    private double CGPA;    // Private Variable
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public Method to Access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public Method to Modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 10.0.");
        }
    }

    // Method to Display Student Details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass to Demonstrate the Use of Protected Member
class PostgraduateStudent extends Student {
    private String specialization;
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }
    public void displayPGDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Name: " + name); // Accessing protected member
        System.out.println("Specialization: " + specialization);
    }

    public static void main(String[] args) {
        Student student = new Student(101, "Ravi Kumar", 8.5);
        student.displayDetails();

        // Modifying CGPA
        student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student.getCGPA());

        // Postgraduate Student
        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Anjali Verma", 9.2, "Computer Science");
        pgStudent.displayPGDetails();
    }
}
