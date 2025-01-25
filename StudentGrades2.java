import java.util.Scanner;

public class StudentGrades2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        int numSubjects = 3;  
        int[][] marks = new int[numStudents][numSubjects];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();
        }
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = (totalMarks / 300.0) * 100;
            String grade = "";
            if (percentage >= 90) {
                grade = "A";
            } else if (percentage >= 75) {
                grade = "B";
            } else if (percentage >= 60) {
                grade = "C";
            } else if (percentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Total Marks: " + totalMarks + " out of 300");
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Grade: " + grade + "\n");
        }

        sc.close();
    }
}
