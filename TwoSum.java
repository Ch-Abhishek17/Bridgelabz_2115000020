/*
 Problem: Given an array and a target sum, find two indices such that their values add up to the target.
Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.

 */
import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in HashMap
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i}; // Return indices
            }

            // Store current number and index in HashMap
            numToIndex.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found (this should not happen as per problem constraints)
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Output: [0, 1]
    }
}
