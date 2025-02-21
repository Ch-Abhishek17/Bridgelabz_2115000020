import java.io.*;

public class ErrorLogFilter {
    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Large file ka path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Line-by-line read karega
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
