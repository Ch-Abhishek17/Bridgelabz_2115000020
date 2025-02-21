import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "original.jpg";  // Original image file
        String destinationImage = "copy.jpg"; // Output image file

        try {
            // Step 1: Convert Image to Byte Array
            byte[] imageBytes = convertImageToByteArray(sourceImage);

            // Step 2: Write Byte Array to New Image
            writeByteArrayToImage(imageBytes, destinationImage);

            // Step 3: Verify if the files are identical
            if (verifyImages(sourceImage, destinationImage)) {
                System.out.println("Verification Successful: Images are identical!");
            } else {
                System.out.println("Verification Failed: Images are different.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Convert Image to Byte Array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Write Byte Array to New Image File
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image copied successfully to " + outputPath);
        }
    }

    // Verify if the two images are identical by comparing their sizes
    private static boolean verifyImages(String file1, String file2) throws IOException {
        File original = new File(file1);
        File copy = new File(file2);
        return Files.size(original.toPath()) == Files.size(copy.toPath());
    }
}
