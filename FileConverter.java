import java.io.*;
public class FileConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt"; 
        String outputFile = "output.txt"; 

        try (
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());  
                bw.newLine();
            }
            System.out.println("File conversion completed successfully!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
