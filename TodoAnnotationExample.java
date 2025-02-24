import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectModule {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Improve UI design", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("Improving UI...");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        Method[] methods = ProjectModule.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("---------------------------");
            }
        }
    }
}
