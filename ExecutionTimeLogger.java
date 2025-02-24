import java.lang.reflect.Method;

class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName);
            
            long startTime = System.nanoTime();
            method.invoke(obj, args);
            long endTime = System.nanoTime();

            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " ns");
        } catch (Exception e) {
            throw new RuntimeException("Method execution failed", e);
        }
    }
}

class Task {
    public void compute() {
        for (int i = 0; i < 1_000_000; i++);
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) {
        Task task = new Task();
        MethodTimer.measureExecutionTime(task, "compute");
    }
}
