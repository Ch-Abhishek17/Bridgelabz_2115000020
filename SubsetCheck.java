import java.util.*;
public class SubsetCheck {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
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
        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
        sc.close();
    }
}
