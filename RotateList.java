import java.util.*;
public class RotateList {
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return;  
        k = k % n;  
        Collections.reverse(list.subList(0, k));
        Collections.reverse(list.subList(k, n));
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces:");
        String[] input = scanner.nextLine().split("\\s+");
        System.out.println("Enter rotation count:");
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (String num : input) {
            list.add(Integer.parseInt(num));
        }
        rotateList(list, k);
        System.out.println("Rotated List: " + list);
        scanner.close();
    }
}
