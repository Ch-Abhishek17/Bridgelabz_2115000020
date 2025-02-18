import java.util.ArrayList;
import java.util.List;

// Abstract class representing a job role
abstract class JobRole {
    private String roleName;
    
    public JobRole(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + roleName;
    }
}

// Concrete job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();
    
    public void addResume(T resume) {
        resumes.add(resume);
    }
    
    public List<T> getResumes() {
        return resumes;
    }
    
    public void displayResumes() {
        for (T resume : resumes) {
            System.out.println(resume);
        }
    }
}

// Utility class for resume processing
class ResumeUtils {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Processing resume for: " + resume.getRoleName());
        }
    }
}

// Main class to test resume screening system
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        softwareEngineerResumes.addResume(new SoftwareEngineer());
        softwareEngineerResumes.addResume(new SoftwareEngineer());

        Resume<DataScientist> dataScientistResumes = new Resume<>();
        dataScientistResumes.addResume(new DataScientist());
        dataScientistResumes.addResume(new DataScientist());
        
        Resume<ProductManager> productManagerResumes = new Resume<>();
        productManagerResumes.addResume(new ProductManager());
        productManagerResumes.addResume(new ProductManager());
        
        // Display all resumes in respective categories
        System.out.println("Software Engineer Resumes:");
        softwareEngineerResumes.displayResumes();
        
        System.out.println("\nData Scientist Resumes:");
        dataScientistResumes.displayResumes();
        
        System.out.println("\nProduct Manager Resumes:");
        productManagerResumes.displayResumes();
        
        // Using wildcard method to process all resumes
        System.out.println("\nProcessing all resumes using wildcard method:");
        ResumeUtils.processResumes(softwareEngineerResumes.getResumes());
        ResumeUtils.processResumes(dataScientistResumes.getResumes());
        ResumeUtils.processResumes(productManagerResumes.getResumes());
    }
}