/*
 Sort a Stack Using Recursion
Problem: Given a stack, sort its elements in ascending order using recursion.
Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.
 */
import java.util.Stack;

class SortStackRecursively {
    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Remove the top element
            int top = stack.pop();
            
            // Step 2: Recursively sort the remaining stack
            sortStack(stack);
            
            // Step 3: Insert the popped element in the sorted stack
            insertInSortedOrder(stack, top);
        }
    }

    // Helper function to insert an element into the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        
        // Remove the top element
        int top = stack.pop();
        
        // Recursively insert in sorted order
        insertInSortedOrder(stack, value);
        
        // Put the removed element back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
