import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();  
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (seen.add(item)) { 
                result.add(item);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces:");
        String[] input = sc.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String num : input) {
            list.add(Integer.parseInt(num));
        }
        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("List after removing duplicates: " + uniqueList);
        sc.close();
    }
}
