import java.util.Scanner;

public class StudentGrades1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create arrays to store marks, percentages, and grades for the students
        int[] physicsMarks = new int[numStudents];
        int[] chemistryMarks = new int[numStudents];
        int[] mathsMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        // Take input for the marks of students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            // Get physics marks
            while (true) {
                System.out.print("Physics: ");
                physicsMarks[i] = scanner.nextInt();
                if (physicsMarks[i] >= 0 && physicsMarks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            }

            // Get chemistry marks
            while (true) {
                System.out.print("Chemistry: ");
                chemistryMarks[i] = scanner.nextInt();
                if (chemistryMarks[i] >= 0 && chemistryMarks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            }

            // Get maths marks
            while (true) {
                System.out.print("Maths: ");
                mathsMarks[i] = scanner.nextInt();
                if (mathsMarks[i] >= 0 && mathsMarks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            }

            // Calculate the percentage
            double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
            percentages[i] = (totalMarks / 300) * 100;

            // Assign grades based on the percentage
            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 75) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        // Display the results for each student
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("Physics Marks: " + physicsMarks[i]);
            System.out.println("Chemistry Marks: " + chemistryMarks[i]);
            System.out.println("Maths Marks: " + mathsMarks[i]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
        }

        scanner.close();
    }
}
