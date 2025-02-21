import java.io.*;
import java.nio.file.*;

public class FileReader2{
    public static void main(String[] args) {
        Path filePath = Paths.get("info.txt");

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String firstLine = br.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
