import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    public void generalTask() {
        System.out.println("General task executed.");
    }
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) throws Exception {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        executeMethod(service, "adminTask", adminUser);  // Allowed
        executeMethod(service, "adminTask", normalUser); // Access Denied
        executeMethod(service, "generalTask", normalUser); // Allowed
    }

    public static void executeMethod(SecureService service, String methodName, User user) throws Exception {
        Method method = SecureService.class.getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (!roleAllowed.value().equals(user.getRole())) {
                System.out.println("Access Denied! User role: " + user.getRole());
                return;
            }
        }

        method.invoke(service);
    }
}
