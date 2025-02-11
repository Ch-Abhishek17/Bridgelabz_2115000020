import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;

    // Add student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Remove student by Roll Number
    public void removeByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update grade by Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    // Search student by Roll Number
    public void searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("----------------------------------------");
                System.out.println("Found: " + temp.name + " (Roll No: " + temp.rollNumber + ", Age: " + temp.age + ", Grade: " + temp.grade + ")");
                System.out.println("----------------------------------------");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void displayStudents() {
        System.out.println("----------------------------------------");
        System.out.println("Student List:");
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " - " + temp.name + " (Age: " + temp.age + ", Grade: " + temp.grade + ")");
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n----------------------------------------");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Remove Student by Roll Number");
            System.out.println("4. Update Grade by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear buffer
                continue;
            }
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    int roll, age;
                    String name, grade;
                    try {
                        roll = sc.nextInt();
                        name = sc.next();
                        age = sc.nextInt();
                        grade = sc.next();
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid values.");
                        sc.nextLine(); // Clear buffer
                        continue;
                    }
                    studentList.addAtBeginning(roll, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    try {
                        roll = sc.nextInt();
                        name = sc.next();
                        age = sc.nextInt();
                        grade = sc.next();
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid values.");
                        sc.nextLine(); // Clear buffer
                        continue;
                    }
                    studentList.addAtEnd(roll, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Roll Number to remove: ");
                    studentList.removeByRollNumber(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Roll Number and New Grade: ");
                    studentList.updateGrade(sc.nextInt(), sc.next());
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    studentList.searchStudent(sc.nextInt());
                    break;
                case 6:
                    studentList.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
