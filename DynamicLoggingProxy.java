import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Interface
interface Greeting {
    void sayHello(String name);
}

// Real Implementation
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Logging Proxy Handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Proxy Factory
class ProxyFactory {
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingProxyHandler(target)
        );
    }
}

// Main Class
public class DynamicLoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyGreeting = ProxyFactory.createProxy(greeting, Greeting.class);
        
        proxyGreeting.sayHello("Alice");
    }
}
