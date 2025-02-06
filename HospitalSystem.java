import java.util.ArrayList;
import java.util.List;

// Doctor Class
class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patients;
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    // Method to consult a patient
    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " (" + specialty + ") is consulting with patient " + patient.getName());
        patient.addDoctor(this);  // Add this doctor to the patient's list of doctors
    }
    public void viewPatients() {
        System.out.println("Doctor " + name + " is seeing the following patients:");
        if (patients.isEmpty()) {
            System.out.println("No patients.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Getter for doctor name
    public String getName() {
        return name;
    }
}

// Patient Class
class Patient {
    private String name;
    private List<Doctor> doctors;

    // Constructor
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Method to add a doctor to the patient's list of doctors
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to view all doctors the patient has consulted
    public void viewDoctors() {
        System.out.println("Patient " + name + " has consulted the following doctors:");
        if (doctors.isEmpty()) {
            System.out.println("No doctors.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName());
            }
        }
    }

    // Getter for patient name
    public String getName() {
        return name;
    }
}

// Hospital Class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    // Constructor
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Method to add a doctor to the hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to add a patient to the hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to view all doctors in the hospital
    public void viewDoctors() {
        System.out.println("Doctors in " + hospitalName + ":");
        if (doctors.isEmpty()) {
            System.out.println("No doctors.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName() + " - " + doctor.specialty);
            }
        }
    }

    // Method to view all patients in the hospital
    public void viewPatients() {
        System.out.println("Patients in " + hospitalName + ":");
        if (patients.isEmpty()) {
            System.out.println("No patients.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }
}

// Main Class to Demonstrate the Association and Communication
public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiologist");
        Doctor doctor2 = new Doctor("Dr. Johnson", "Pediatrician");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        doctor1.consult(patient1);  // Dr. Smith consults Alice
        doctor1.consult(patient2);  // Dr. Smith consults Bob
        doctor2.consult(patient1);  // Dr. Johnson consults Alice
        System.out.println("\nDoctors in the hospital:");
        hospital.viewDoctors();
        System.out.println("\nPatients in the hospital:");
        hospital.viewPatients();
        System.out.println("\nPatient consultations:");
        patient1.viewDoctors();
        patient2.viewDoctors();
        System.out.println("\nDoctor consultations:");
        doctor1.viewPatients();
        doctor2.viewPatients();
    }
}
