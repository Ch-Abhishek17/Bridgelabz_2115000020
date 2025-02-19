import java.util.*;
public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements for the Set (space-separated):");
        String[] input = sc.nextLine().split("\\s+");
        Set<Integer> set = new HashSet<>();
        for (String num : input) {
            set.add(Integer.parseInt(num));
        }
        System.out.println("Sorted List: " + convertToSortedList(set));
        sc.close();
    }
}
