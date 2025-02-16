/*
 * Problem:
Write a program that uses InputStreamReader to read user input from the console and write the input to a file. Each input should be written as a new line in the file.
Approach:
Create an InputStreamReader to read from System.in (the console).
Wrap the InputStreamReader in a BufferedReader for efficient reading.
Create a FileWriter to write to the file.
Read user input using readLine() and write the input to the file.
Repeat the process until the user enters "exit" to stop inputting.
Close the file after the input is finished.
 */
import java.io.*;
public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "output.txt"; // File to write user input

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Write a new line
            }

            System.out.println("User input has been saved to " + filePath);
            
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }
}
