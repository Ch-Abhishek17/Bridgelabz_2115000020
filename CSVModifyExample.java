package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVModifyExample {
    public static void main(String[] args) {
        // Define the input and output file paths
        String inputFilePath = "src/main/resources/employees.csv";
        String outputFilePath = "src/main/resources/updated_employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Create a CSVWriter to write the updated records to a new CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
                // Write the header row first
                writer.writeNext(records.get(0));

                // Process and update each record (skipping the header)
                for (int i = 1; i < records.size(); i++) {
                    String[] row = records.get(i);
                    // Assuming the CSV columns are: ID, Name, Department, Salary
                    String department = row[2];
                    if ("IT".equalsIgnoreCase(department)) {
                        try {
                            double salary = Double.parseDouble(row[3]);
                            // Increase the salary by 10%
                            salary = salary * 1.10;
                            // Update the salary in the record
                            row[3] = String.valueOf(salary);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid salary for employee ID " + row[0] + ": " + row[3]);
                        }
                    }
                    // Write the (updated) record to the new file
                    writer.writeNext(row);
                }
                System.out.println("CSV file updated successfully. Check: " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

