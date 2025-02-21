import java.io.*;
public class FileCopyPerformance {
    private static final int BUFFER_SIZE = 4096; // 4 KB buffer
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";  //File name
        String destFileBuffered = "copy_buffered.txt";  // Buffered copy
        String destFileUnbuffered = "copy_unbuffered.txt";  // Unbuffered copy

        // Buffered Streams Copy
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destFileBuffered);

        // Normal Streams Copy
        long unbufferedTime = copyUsingNormalStreams(sourceFile, destFileUnbuffered);

        // Performance Comparison
        System.out.println("\nExecution Time Comparison:");
        System.out.println("Buffered Streams Time: " + bufferedTime + " nanoseconds");
        System.out.println("Unbuffered Streams Time: " + unbufferedTime + " nanoseconds");

        System.out.println("\nBuffered Streams are " + (unbufferedTime / (double) bufferedTime) + " times faster!");
    }

    // Using Buffered Streams
    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully using Buffered Streams!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    // Using Normal Streams (Without Buffering)
    private static long copyUsingNormalStreams(String source, String destination) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully using Normal Streams!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
