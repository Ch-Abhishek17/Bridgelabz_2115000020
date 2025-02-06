import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.professor = null;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void viewCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("Professor: Not assigned yet.");
        }
        System.out.println("Students enrolled:");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        courses.add(course);
    }

    public void viewCourses() {
        System.out.println(name + " is teaching the following courses:");
        if (courses.isEmpty()) {
            System.out.println("No courses assigned.");
        } else {
            for (Course course : courses) {
                System.out.println(course.getCourseName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println(course.getCourseName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Computer Science 101");
        Course course2 = new Course("Mathematics 101");
        Course course3 = new Course("Physics 101");

        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);
        course3.assignProfessor(professor1);

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course2);
        student2.enrollCourse(course3);

        student3.enrollCourse(course1);
        student3.enrollCourse(course3);

        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();
        student3.viewEnrolledCourses();

        System.out.println("\nCourse details:");
        course1.viewCourseDetails();
        course2.viewCourseDetails();
        course3.viewCourseDetails();

        System.out.println("\nProfessor courses:");
        professor1.viewCourses();
        professor2.viewCourses();
    }
}
