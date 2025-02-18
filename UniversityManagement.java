import java.util.ArrayList;
import java.util.List;

// Abstract class representing a course type
abstract class CourseType {
    private String courseName;
    
    public CourseType(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + courseName;
    }
}

// Concrete course types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    
    public void addCourse(T course) {
        courses.add(course);
    }
    
    public List<T> getCourses() {
        return courses;
    }
    
    public void displayCourses() {
        for (T course : courses) {
            System.out.println(course);
        }
    }
}

// Utility method to display any type of course
class CourseUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}
// Main class to test the course management system
public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics"));
        examCourses.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History"));
        assignmentCourses.addCourse(new AssignmentCourse("Literature"));
        
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));
        researchCourses.addCourse(new ResearchCourse("Quantum Computing"));
        
        // Display all courses in respective categories
        System.out.println("Exam Courses:");
        examCourses.displayCourses();
        
        System.out.println("\nAssignment Courses:");
        assignmentCourses.displayCourses();
        System.out.println("\nResearch Courses:");
        researchCourses.displayCourses();
        // Using wildcard method to display all courses
        System.out.println("\nDisplaying all courses using wildcard method:");
        CourseUtils.displayAllCourses(examCourses.getCourses());
        CourseUtils.displayAllCourses(assignmentCourses.getCourses());
        CourseUtils.displayAllCourses(researchCourses.getCourses());
    }
}