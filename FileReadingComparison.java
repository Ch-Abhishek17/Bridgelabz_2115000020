import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "input.txt";

        System.out.println("Reading with FileReader...");
        long startTime = System.currentTimeMillis();
        readFileWithFileReader(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with FileReader: " + (endTime - startTime) + "ms");

        System.out.println("Reading with InputStreamReader...");
        startTime = System.currentTimeMillis();
        readFileWithInputStreamReader(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with InputStreamReader: " + (endTime - startTime) + "ms");
    }

    private static void readFileWithFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            int character;
            while ((character = inputStreamReader.read()) != -1) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}