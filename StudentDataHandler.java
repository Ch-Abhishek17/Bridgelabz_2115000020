import java.io.*;
class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataHandler {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Student[] students = {
            new Student(101, "Amit", 3.8),
            new Student(102, "Neha", 3.9),
            new Student(103, "Raj", 3.7)
        };

        // Writing student data to binary file
        writeStudentData(students);
        // Reading and displaying student data from binary file
        readStudentData();
    }

    public static void writeStudentData(Student[] students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Student student : students) {
                dos.writeInt(student.rollNumber);
                dos.writeUTF(student.name);
                dos.writeDouble(student.gpa);
            }
            System.out.println("Student data successfully written to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading Student Data from File:");
            while (dis.available() > 0) { // Jab tak file mein data hai
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}
