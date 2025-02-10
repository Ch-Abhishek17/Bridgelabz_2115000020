// Abstract class representing a Patient
abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public abstract double calculateBill(); // Abstract method
    
    public String getPatientDetails() { // Concrete method
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// Subclass for InPatient
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private String medicalHistory;
    
    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }
    
    @Override
    public String viewRecords() {
        return "Medical History: \n" + medicalHistory;
    }
}

// Subclass for OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory;
    
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }
    
    @Override
    public String viewRecords() {
        return "Medical History: \n" + medicalHistory;
    }
}

// Hospital Management System
public class HospitalManagementSystem {
    public static void processPatient(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: " + patient.calculateBill());
    }
    
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 45, 1500, 5);
        Patient outPatient = new OutPatient("P002", "Jane Smith", 30, 500);
        
        MedicalRecord inPatientRecord = (MedicalRecord) inPatient;
        inPatientRecord.addRecord("Admitted for surgery.");
        
        MedicalRecord outPatientRecord = (MedicalRecord) outPatient;
        outPatientRecord.addRecord("Routine check-up.");
        
        processPatient(inPatient);
        System.out.println(inPatientRecord.viewRecords());
        
        processPatient(outPatient);
        System.out.println(outPatientRecord.viewRecords());
    }
}