import java.util.*;
public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);   
        result.removeAll(intersection);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements for Set 1 (space-separated):");
        String[] input1 = sc.nextLine().split("\\s+");
        Set<Integer> set1 = new HashSet<>();
        for (String num : input1) {
            set1.add(Integer.parseInt(num));
        }
        System.out.println("Enter elements for Set 2 (space-separated):");
        String[] input2 = sc.nextLine().split("\\s+");
        Set<Integer> set2 = new HashSet<>();
        for (String num : input2) {
            set2.add(Integer.parseInt(num));
        }
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
        sc.close();
    }
}
