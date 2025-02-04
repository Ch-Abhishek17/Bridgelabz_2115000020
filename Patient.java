public class Patient {
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;
    final String patientID;
    String name;
    int age;
    String ailment;

    Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++; 
    }

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
            System.out.println("Patient ID: " + this.patientID);
        }
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("Rohan Das", 30, "Fever", "P001");
        Patient patient2 = new Patient("Anjali Singh", 25, "Migraine", "P002");

        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();

        Patient.getTotalPatients();
    }
}
 