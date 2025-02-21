import java.io.*;
public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Source file ka naam
        String destinationFile = "destination.txt";  // Destination file ka naam

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Error: Source file does not exist!");
                return;
            }

            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
