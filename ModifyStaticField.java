import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<Configuration> configClass = Configuration.class;
            
            Field apiKeyField = configClass.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true); // Allow access to private field

            System.out.println("Before Modification: " + Configuration.getApiKey());

            apiKeyField.set(null, "NEW_SECRET_KEY"); // Modify static field

            System.out.println("After Modification: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
