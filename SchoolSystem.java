import java.util.ArrayList;
import java.util.List;
// Course Class
class Course {
    private String courseName;
    private List<Student> enrolledStudents;
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this);  
    }
    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println(student.getName());
            }
        }
    }
    // Getter for course name
    public String getCourseName() {
        return courseName;
    }
}
// Student Class
class Student {
    private String name;
    private List<Course> enrolledCourses;
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);  // Add this student to the course
    }
    public void viewCourses() {
        System.out.println("Student: " + name);
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println(course.getCourseName());
            }
        }
    }

    // Getter for student name
    public String getName() {
        return name;
    }
    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }
}

// School Class
class School {
    private String schoolName;
    private List<Student> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void displayStudents() {
        System.out.println("School: " + schoolName);
        if (students.isEmpty()) {
            System.out.println("No students in the school.");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
}

// Main Class to Demonstrate the Association and Aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        school.addStudent(student1);
        school.addStudent(student2);
        Course mathCourse = new Course("Mathematics");
        Course scienceCourse = new Course("Science");
        student1.enrollInCourse(mathCourse);
        student1.enrollInCourse(scienceCourse);
        student2.enrollInCourse(scienceCourse);
        school.displayStudents();
        System.out.println();
        student1.viewCourses();
        student2.viewCourses();
        System.out.println();
        mathCourse.displayEnrolledStudents();
        scienceCourse.displayEnrolledStudents();
    }
}
