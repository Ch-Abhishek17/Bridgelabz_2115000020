import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

// Class with expensive computation
class MathOperations {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for: " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for: " + n);
        int result = (n <= 1) ? 1 : n * factorial(n - 1);
        cache.put(n, result);
        return result;
    }
}

// Cache Manager to handle method invocation
class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invoke(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = methodName + "_" + args[0]; // Unique key based on method name and argument
            if (cache.containsKey(key)) {
                System.out.println("Fetching from cache: " + key);
                return cache.get(key);
            }

            Object result = method.invoke(obj, args);
            cache.put(key, result);
            return result;
        }

        return method.invoke(obj, args);
    }
}

// Main class to test caching
public class CustomCachingSystem {
    public static void main(String[] args) throws Exception {
        MathOperations mathOps = new MathOperations();

        System.out.println("Factorial(5): " + CacheManager.invoke(mathOps, "factorial", 5));
        System.out.println("Factorial(5) Again: " + CacheManager.invoke(mathOps, "factorial", 5));
        System.out.println("Factorial(6): " + CacheManager.invoke(mathOps, "factorial", 6));
    }
}
