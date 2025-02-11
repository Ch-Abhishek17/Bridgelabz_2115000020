// 3. Circular Linked List: Task Scheduler
// Problem Statement: Create a task scheduler using a circular linked list. Each node in the list represents a task with Task ID, Task Name, Priority, and Due Date. Implement the following functionalities:
// Add a task at the beginning, end, or at a specific position in the circular list.
// Remove a task by Task ID.
// View the current task and move to the next task in the circular list.
// Display all tasks in the list starting from the head node.
// Search for a task by Priority.
// Hint:
// Use a circular linked list where the last node’s next pointer points back to the first node, creating a circular structure.
// Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
// When deleting or adding tasks, maintain the circular nature by updating the appropriate next pointers.

import java.util.Scanner;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    // Add task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain circular link
        }
    }

    // Add task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain circular link
        }
    }

    // Remove task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) return;
        Task current = head, prev = tail;
        do {
            if (current.taskId == taskId) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                prev.next = current.next;
                if (head == tail && head.taskId == taskId) head = tail = null;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // View current task and move to next
    public void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (Priority: " + head.priority + ", Due: " + head.dueDate + ")");
        head = head.next; // Move to next task
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println(temp.taskId + ". " + temp.taskName + " (Priority: " + temp.priority + ", Due: " + temp.dueDate + ")");
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: " + temp.taskName + " (Due: " + temp.dueDate + ")");
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Remove Task by ID");
            System.out.println("4. View Current Task & Move Next");
            System.out.println("5. Display All Tasks");
            System.out.println("6. Search Task by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    scheduler.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    scheduler.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeByTaskId(sc.nextInt());
                    break;
                case 4:
                    scheduler.viewAndMoveNext();
                    break;
                case 5:
                    scheduler.displayAll();
                    break;
                case 6:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
