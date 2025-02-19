import java.util.*;
public class SetOperations {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
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
        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
        sc.close();
    }
}
