import java.util.*;
public class SetEqualityCheck {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
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
        System.out.println("Are both sets equal? " + areSetsEqual(set1, set2));
        sc.close();
    }
}
