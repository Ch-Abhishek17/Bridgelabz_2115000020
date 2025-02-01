public class Course {
    private static String instituteName = "Default Institute";
    private String courseName;
    private int duration; // Duration in weeks or months
    private double fee;

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 12, 15000);
        Course course2 = new Course("Web Development", 10, 12000);

        // Display course details before updating institute name
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Update the institute name
        Course.updateInstituteName("Tech Academy");

        // Display course details after updating institute name
        System.out.println("\nAfter updating institute name:\n");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}