import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTester {
    @LogExecutionTime
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method executed.");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed.");
    }
}

public class ExecutionTimeLogger{
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");
                System.out.println("---------------------------");
            }
        }
    }
}
