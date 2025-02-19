import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int size = scanner.nextInt();

        CircularBuffer cb = new CircularBuffer(size);

        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            cb.insert(scanner.nextInt());
            cb.display();
        }

        scanner.close();
    }
}
