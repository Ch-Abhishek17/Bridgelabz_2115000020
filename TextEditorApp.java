/*
 8. Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
Add a new text state at the end of the list every time the user types or performs an action.
Implement the undo functionality (revert to the previous state).
Implement the redo functionality (revert back to the next state after undo).
Display the current state of the text.
Limit the undo/redo history to a fixed size (e.g., last 10 states).
Hint:
Use a doubly linked list where each node represents a state of the text.
The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
Keep track of the current state and adjust the next and prev pointers for undo/redo operations.

 */
import java.util.Scanner;

class TextState {
    String textContent;
    TextState next;
    TextState prev;

    public TextState(String textContent) {
        this.textContent = textContent;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private final int maxHistorySize = 10;
    private int historySize = 0;

    public TextEditor() {
        this.head = this.tail = this.current = null;
    }

    public void addState(String textContent) {
        TextState newState = new TextState(textContent);

        if (historySize == maxHistorySize) {
            removeOldestState();
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = tail;  // Set the current state to the new state
        }

        historySize++;
    }

    private void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            historySize--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textContent);
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textContent);
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.textContent);
        } else {
            System.out.println("No text content available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\nText Editor:");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
