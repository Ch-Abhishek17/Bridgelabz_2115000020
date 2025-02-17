import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void runTest(int size) {
        Random rand = new Random();
        int[] dataset = rand.ints(size, 1, size * 10).toArray();

        int[] arr1 = Arrays.copyOf(dataset, dataset.length);
        long start = System.nanoTime();
        bubbleSort(arr1);
        long bubbleTime = System.nanoTime() - start;

        int[] arr2 = Arrays.copyOf(dataset, dataset.length);
        start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long mergeTime = System.nanoTime() - start;

        int[] arr3 = Arrays.copyOf(dataset, dataset.length);
        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        long quickTime = System.nanoTime() - start;

        System.out.printf("| %-12d | %-20s | %-20.2fms | %-20.2fms |\n", size,
                (bubbleTime > 60_000_000_000L) ? "Unfeasible" : (bubbleTime / 1_000_000.0 + "ms"),
                mergeTime / 1_000_000.0, quickTime / 1_000_000.0);
    }

    public static void main(String[] args) {
        System.out.println("| Dataset Size  | Bubble Sort (O(N²)) | Merge Sort (O(N log N)) | Quick Sort (O(N log N)) |");

        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        for (int size : datasetSizes) {
            runTest(size);
        }
    }
}