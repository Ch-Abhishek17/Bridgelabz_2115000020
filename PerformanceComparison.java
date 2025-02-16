/*
 * Problem:
Write a program that:
Uses StringBuilder and StringBuffer to concatenate a list of strings 1,000,000 times.
Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and print the number of words in the file.
Approach:
StringBuilder and StringBuffer:
Create a list of strings (e.g., "hello").
Concatenate the strings 1,000,000 times using both StringBuilder and StringBuffer.
Measure and compare the time taken for each.
FileReader and InputStreamReader:
Read a large text file (100MB) using FileReader and InputStreamReader.
Count the number of words by splitting the text on whitespace characters.
Print the word count and compare the time taken for reading the file.
 */
import java.io.*;
public class PerformanceComparison {
    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        compareStringBuilders();

        // Compare FileReader and InputStreamReader
        String filePath = "large_text_file.txt"; // Replace with the actual file path
        compareFileReaders(filePath);
    }

    private static void compareStringBuilders() {
        int iterations = 1000000;
        String text = "hello";

        // Using StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        // Using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");
    }

    private static void compareFileReaders(String filePath) {
        System.out.println("\nComparing FileReader vs. InputStreamReader for file reading...");
        long fileReaderTime = countWordsUsingFileReader(filePath);
        long inputStreamReaderTime = countWordsUsingInputStreamReader(filePath);

        System.out.println("FileReader time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader time: " + inputStreamReaderTime + " ms");
    }

    private static long countWordsUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file using FileReader: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Words counted using FileReader: " + wordCount);
        return endTime - startTime;
    }

    private static long countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file using InputStreamReader: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Words counted using InputStreamReader: " + wordCount);
        return endTime - startTime;
    }
}
