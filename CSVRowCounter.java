package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVRowCounter {
    public static void main(String[] args) {
        // Specify the path to your CSV file
        String filePath = "src/main/resources/data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Exclude the header row (first row) from the count
            int numberOfRecords = records.size() - 1;

            // Print the total number of records (excluding header)
            System.out.println("Total number of records (excluding header): " + numberOfRecords);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

