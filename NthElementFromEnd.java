import java.util.*;
public class NthElementFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than list size");
            }
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by spaces:");
        String[] input = sc.nextLine().split("\\s+");
        System.out.println("Enter the value of N:");
        int n = sc.nextInt();
        LinkedList<String> list = new LinkedList<>(Arrays.asList(input));
        try {
            String result = findNthFromEnd(list, n);
            System.out.println("Nth element from end: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
