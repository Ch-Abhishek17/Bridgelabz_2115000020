import java.util.*;
public class ReverseList {
    // Reverse an ArrayList using Two-pointer approach
    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Reverse a LinkedList using Deque (Efficient way)
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        Deque<T> deque = new ArrayDeque<>(list);
        list.clear(); 
        while (!deque.isEmpty()) {
            list.add(deque.pollLast()); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces:");
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (String num : input) {
            int value = Integer.parseInt(num);
            arrayList.add(value);
            linkedList.add(value);
        }
        reverseArrayList(arrayList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
        scanner.close();
    }
}
