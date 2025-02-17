import java.util.*;

public class DataStructureComparison {
    public static void main(String[] args) {
        int[] array = generateArray(100000);
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
            treeSet.add(array[i]);
        }

        int searchElement = array[array.length / 2];

        System.out.println("Searching in Array...");
        long startTime = System.currentTimeMillis();
        searchArray(array, searchElement);
        long endTime = System.currentTimeMillis();
        System.out.println("Array Search Time: " + (endTime - startTime) + "ms");

        System.out.println("Searching in HashSet...");
        startTime = System.currentTimeMillis();
        searchHashSet(hashSet, searchElement);
        endTime = System.currentTimeMillis();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + "ms");

        System.out.println("Searching in TreeSet...");
        startTime = System.currentTimeMillis();
        searchTreeSet(treeSet, searchElement);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + "ms");
    }

    private static int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void searchArray(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return;
            }
        }
    }

    private static void searchHashSet(HashSet<Integer> hashSet, int element) {
        hashSet.contains(element);
    }

    private static void searchTreeSet(TreeSet<Integer> treeSet, int element) {
        treeSet.contains(element);
    }
}