import java.util.*;
public class MergeMaps {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.put(entry.getKey(), mergedMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        System.out.print("Enter number of entries for Map1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter key-value pairs for Map1:");
        for (int i = 0; i < n1; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map1.put(key, value);
        }

        System.out.print("Enter number of entries for Map2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter key-value pairs for Map2:");
        for (int i = 0; i < n2; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map2.put(key, value);
        }
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println("Merged Map: " + mergedMap);
        sc.close();
    }
}
