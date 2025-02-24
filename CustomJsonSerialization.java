import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with @JsonField annotations
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// JSON Serializer class
class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }

        if (json.length() > 1) {
            json.setLength(json.length() - 2); // Remove last comma and space
        }
        json.append("}");

        return json.toString();
    }
}

// Main class to test serialization
public class CustomJsonSerialization {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("JohnDoe", 25);
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}
