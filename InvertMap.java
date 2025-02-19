import java.util.*;
public class InvertMap {
    public static <K, V> Map<V, List<K>> invert(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter key-value pairs (format: key value):");
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            originalMap.put(key, value);
        }
        Map<Integer, List<String>> invertedMap = invert(originalMap);
        System.out.println("Inverted Map: " + invertedMap);
        sc.close();
    }
}
