public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30;

        System.out.println("Calculating Fibonacci of " + n + " using Recursive approach...");
        long startTime = System.currentTimeMillis();
        int recursiveResult = fibonacciRecursive(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Recursive Result: " + recursiveResult + ", Time taken: " + (endTime - startTime) + "ms");

        System.out.println("Calculating Fibonacci of " + n + " using Iterative approach...");
        startTime = System.currentTimeMillis();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.currentTimeMillis();
        System.out.println("Iterative Result: " + iterativeResult + ", Time taken: " + (endTime - startTime) + "ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}