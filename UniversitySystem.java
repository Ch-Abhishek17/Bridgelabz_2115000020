import java.util.ArrayList;
import java.util.List;

// Faculty Class (Aggregation relationship with Department)
class Faculty {
    private String name;
    private int facultyId;
    public Faculty(String name, int facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }
    public void displayFacultyDetails() {
        System.out.println("Faculty ID: " + facultyId + ", Name: " + name);
    }
    public String getName() {
        return name;
    }
    public int getFacultyId() {
        return facultyId;
    }
}

// Department Class (Composition relationship with University)
class Department {
    private String departmentName;
    private List<Faculty> facultyMembers;
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    // Method to display details of faculty members in the department
    public void displayFacultyInDepartment() {
        System.out.println("Department: " + departmentName);
        if (facultyMembers.isEmpty()) {
            System.out.println("No faculty members in this department.");
        } else {
            for (Faculty faculty : facultyMembers) {
                faculty.displayFacultyDetails();
            }
        }
    }

    // Getter for department name
    public String getDepartmentName() {
        return departmentName;
    }
}
// University Class (Composition with Department, Aggregation with Faculty)
class University {
    private String universityName;
    private List<Department> departments;
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }
    public void displayDepartments() {
        System.out.println("University: " + universityName);
        if (departments.isEmpty()) {
            System.out.println("No departments in the university.");
        } else {
            for (Department department : departments) {
                department.displayFacultyInDepartment();
            }
        }
    }
    public void removeUniversity() {
        departments.clear();  // Deleting the departments when the university is deleted
        System.out.println("University and all departments have been deleted.");
    }
}
// Main Class to Demonstrate the Composition and Aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Create Faculty members
        Faculty faculty1 = new Faculty("Dr. Alice", 101);
        Faculty faculty2 = new Faculty("Dr. Bob", 102);
        Faculty faculty3 = new Faculty("Dr. Charlie", 103);
        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Mechanical Engineering");
        department1.addFaculty(faculty1);
        department1.addFaculty(faculty2);
        department2.addFaculty(faculty3);
        University university = new University("Tech University");
        university.addDepartment(department1);
        university.addDepartment(department2);
        university.displayDepartments();
        System.out.println("\nDeleting the University...\n");
        university.removeUniversity();
        university.displayDepartments();
    }
}
