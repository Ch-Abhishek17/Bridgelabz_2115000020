import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void runTest(int size) {
        int[] dataset = new Random().ints(size, 1, size * 10).toArray();
        int target = dataset[new Random().nextInt(size)];

        long start = System.nanoTime();
        linearSearch(dataset, target);
        long linearTime = System.nanoTime() - start;

        Arrays.sort(dataset);

        start = System.nanoTime();
        binarySearch(dataset, target);
        long binaryTime = System.nanoTime() - start;

        System.out.printf("| %-12d | %-22.2fms | %-25.2fms |\n", size, linearTime / 1_000_000.0, binaryTime / 1_000_000.0);
    }

    public static void main(String[] args) {
        System.out.println("| Dataset Size  | Linear Search (O(N)) | Binary Search (O(log N)) |");
        
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        for (int size : datasetSizes) {
            runTest(size);
        }
    }
}