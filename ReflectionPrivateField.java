import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            person.displayAge();

            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);  // Allow access to private field

            System.out.println("\nModifying private field using Reflection...");
            ageField.set(person, 30); // Modify private field

            person.displayAge(); // Verify change

            int modifiedAge = (int) ageField.get(person); // Retrieve modified value
            System.out.println("Retrieved Age using Reflection: " + modifiedAge);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
