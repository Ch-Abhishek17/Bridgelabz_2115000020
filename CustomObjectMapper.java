import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: No field found for key - " + fieldName);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }
}

class User {
    private String name;
    private int age;

    public void display() {
        System.out.println("User{name='" + name + "', age=" + age + "}");
    }
}

public class CustomObjectMapper {
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
            "name", "Alice",
            "age", 25
        );

        User user = ObjectMapper.toObject(User.class, properties);
        user.display();
    }
}
