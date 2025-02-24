import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class SoftwareModule {
    @BugReport(description = "Null pointer exception occurs on invalid input")
    @BugReport(description = "Performance issue when handling large data")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("processData");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugs = method.getAnnotationsByType(BugReport.class);
            for (BugReport bug : bugs) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}
