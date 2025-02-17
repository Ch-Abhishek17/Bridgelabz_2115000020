public class StringConcatenationPerformance {

    public static void testStringConcatenation(int count) {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "a";
        }
        long time = System.nanoTime() - start;
        System.out.printf("| %-15d | %-20s | %-20.2fms | %-20.2fms |\n", count,
                (time > 60_000_000_000L) ? "Unusable" : (time / 1_000_000.0 + "ms"), 0.0, 0.0);
    }

    public static void testStringBuilderConcatenation(int count) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        long time = System.nanoTime() - start;
        System.out.printf("| %-15d | %-20s | %-20.2fms | %-20.2fms |\n", count, "", time / 1_000_000.0, 0.0);
    }

    public static void testStringBufferConcatenation(int count) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        long time = System.nanoTime() - start;
        System.out.printf("| %-15d | %-20s | %-20s | %-20.2fms |\n", count, "", "", time / 1_000_000.0);
    }

    public static void main(String[] args) {
        System.out.println("| Operations Count (N) | String (O(N²))       | StringBuilder (O(N))  | StringBuffer (O(N))   |");

        int[] sizes = {1_000, 10_000, 1_000_000};

        for (int size : sizes) {
            testStringConcatenation(size);
            testStringBuilderConcatenation(size);
            testStringBufferConcatenation(size);
        }
    }
}