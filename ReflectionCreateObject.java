import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class ReflectionCreateObject {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student"); // Load Student class dynamically

            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class); // Get constructor
            Object studentObj = constructor.newInstance("Alice", 22); // Create instance dynamically

            Method displayMethod = studentClass.getMethod("display");
            displayMethod.invoke(studentObj); // Invoke method dynamically

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
