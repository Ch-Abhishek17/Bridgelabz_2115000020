import java.io.*;
public class UserInfoToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "user_info.txt"; // Output file
        try (FileWriter writer = new FileWriter(fileName, true)) { // Append mode
            // User input 
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            // writing to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("-----------------------------\n");

            System.out.println("User information saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a number.");
        }
    }
}
