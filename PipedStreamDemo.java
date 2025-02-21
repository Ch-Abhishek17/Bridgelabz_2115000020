import java.io.*;
class WriterThread extends Thread {
    private PipedOutputStream pos;
    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }
    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); 
            System.out.println("Writer: Data written successfully!");
            pos.close(); 
        } catch (IOException e) {
            System.err.println("Writer Error: " + e.getMessage());
        }
    }
}
class ReaderThread extends Thread {
    private PipedInputStream pis;
    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }
    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader: Received - " + receivedMessage);
            pis.close(); 
        } catch (IOException e) {
            System.err.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connecting streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join(); // Ensure writer finishes first
            reader.join(); // Ensure reader finishes

        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
