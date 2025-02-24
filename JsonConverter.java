import java.lang.reflect.Field;
import java.util.StringJoiner;

class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            StringJoiner json = new StringJoiner(", ", "{", "}");

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);

                String jsonValue = (value instanceof String) ? "\"" + value + "\"" : value.toString();
                json.add("\"" + name + "\": " + jsonValue);
            }

            return json.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize object to JSON", e);
        }
    }
}

class User {
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}

public class JsonConverter {
    public static void main(String[] args) {
        User user = new User("Alice", 25, true);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
