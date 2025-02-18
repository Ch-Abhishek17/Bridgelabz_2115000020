import java.util.ArrayList;
import java.util.List;

// MealPlan interface
interface MealPlan {
    String getMealName();
}

// Concrete meal types
class VegetarianMeal implements MealPlan {
    private String mealName;
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String getMealName() {
        return mealName;
    }
    @Override
    public String toString() {
        return "Vegetarian: " + mealName;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String getMealName() {
        return mealName;
    }
    @Override
    public String toString() {
        return "Vegan: " + mealName;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String getMealName() {
        return mealName;
    }
    @Override
    public String toString() {
        return "Keto: " + mealName;
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();
    
    public void addMeal(T meal) {
        meals.add(meal);
    }
    
    public List<T> getMeals() {
        return meals;
    }
    
    public void displayMeals() {
        for (T meal : meals) {
            System.out.println(meal);
        }
    }
}

// Utility class for meal plan validation
class MealUtils {
    public static <T extends MealPlan> void validateAndGenerateMealPlan(T meal) {
        System.out.println("Valid meal plan generated: " + meal.getMealName());
    }
}

// Main class to test meal plan generation
public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal("Grilled Veggie Salad"));
        vegetarianMeals.addMeal(new VegetarianMeal("Paneer Tikka"));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Tofu Stir Fry"));
        veganMeals.addMeal(new VeganMeal("Vegan Burrito"));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Grilled Chicken Salad"));
        ketoMeals.addMeal(new KetoMeal("Avocado Omelette"));
        
        // Display all meals
        System.out.println("Vegetarian Meals:");
        vegetarianMeals.displayMeals();
        
        System.out.println("\nVegan Meals:");
        veganMeals.displayMeals();
        
        System.out.println("\nKeto Meals:");
        ketoMeals.displayMeals();
        
        // Validate meal plans using generic method
        System.out.println("\nValidating Meal Plans:");
        MealUtils.validateAndGenerateMealPlan(new VegetarianMeal("Grilled Veggie Salad"));
        MealUtils.validateAndGenerateMealPlan(new VeganMeal("Tofu Stir Fry"));
        MealUtils.validateAndGenerateMealPlan(new KetoMeal("Grilled Chicken Salad"));
    }
}
