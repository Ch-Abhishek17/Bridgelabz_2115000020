/*
 *Find All Subarrays with Zero Sum
Problem: Given an array, find all subarrays whose elements sum up to zero.
Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.
 */
import java.util.*;

class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        int prefixSum = 0;

        // Initialize with prefix sum 0 at index -1 (to handle cases where sum = 0 from start)
        prefixSumMap.put(0, new ArrayList<>());
        prefixSumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefix sum was seen before, subarrays exist
            if (prefixSumMap.containsKey(prefixSum)) {
                for (int start : prefixSumMap.get(prefixSum)) {
                    result.add(new int[]{start + 1, i}); // (start+1, i) forms a zero-sum subarray
                }
            }

            // Store current prefix sum in the map
            prefixSumMap.putIfAbsent(prefixSum, new ArrayList<>());
            prefixSumMap.get(prefixSum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-Sum Subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}
