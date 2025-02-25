package org.example;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriterExample {
    public static void main(String[] args) {
        // Specify the file path for the CSV file.
        // This file will be created under src/main/resources.
        String filePath = "src/main/resources/employees.csv";

        // Define the CSV header and employee records.
        String[] header = {"ID", "Name", "Department", "Salary"};
        String[][] employees = {
                {"1", "John Doe", "Sales", "50000"},
                {"2", "Jane Smith", "Marketing", "60000"},
                {"3", "Alice Brown", "Engineering", "75000"},
                {"4", "Bob Johnson", "HR", "55000"},
                {"5", "Charlie Davis", "Finance", "65000"}
        };

        // Write data to the CSV file.
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header first.
            writer.writeNext(header);

            // Write each employee record.
            for (String[] employee : employees) {
                writer.writeNext(employee);
            }
            System.out.println("Employee data written to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

