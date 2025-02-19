import java.util.*;
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();
            System.out.print("Enter severity (higher number = higher priority): ");
            int severity = sc.nextInt();
            sc.nextLine();
            queue.add(new Patient(name, severity));
        }

        System.out.println("\nTreatment Order:");
        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }

        sc.close();
    }
}
