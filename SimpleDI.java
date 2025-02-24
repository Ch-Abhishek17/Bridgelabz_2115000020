import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

interface Service {
    void perform();
}

class ServiceImpl implements Service {
    public void perform() {
        System.out.println("Service is performing...");
    }
}

class Client {
    @Inject
    private Service service;

    public void execute() {
        service.perform();
    }
}

class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        instances.put(clazz, instance);
    }

    public void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyType = field.getType();
                Object dependency = instances.get(dependencyType);
                if (dependency == null) {
                    throw new RuntimeException("No registered instance found for: " + dependencyType.getName());
                }
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }
}

public class SimpleDI {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        container.register(ServiceImpl.class);
        Client client = new Client();
        container.injectDependencies(client);
        client.execute();
    }
}
