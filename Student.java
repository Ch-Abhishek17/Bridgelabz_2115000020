class Student {
    static String universityName = "Global University";
    static int totalStudents = 0;
    final String rollNumber;
    String name;
    String grade;
    Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; 
    }
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Student Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        }
    }
    void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + this.grade);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Anita Singh", "R001", "A");
        Student student2 = new Student("Vikram Patel", "R002", "B");
        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();
        student1.updateGrade("A+");
        System.out.println();
        student1.displayStudentDetails();
        System.out.println();
        Student.displayTotalStudents();
    }
}