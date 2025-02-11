/*
 6. Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
Add a new process at the end of the circular list.
Remove a process by Process ID after its execution.
Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
Display the list of processes in the circular queue after each round.
Calculate and display the average waiting time and turn-around time for all processes.
Hint:
Use a circular linked list to represent a queue of processes.
Each process executes for a fixed time quantum, and then control moves to the next process in the circular list.
Maintain the current node as the process being executed, and after each round, update the list to simulate execution.

 */
import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int remainingBurstTime;
    int waitingTime;
    int turnAroundTime;
    Process next;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int totalProcesses = 0;
    private int totalBurstTime = 0;

    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);

        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        totalProcesses++;
        totalBurstTime += burstTime;
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        if (head.processId == processId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            totalProcesses--;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.processId == processId) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                totalProcesses--;
                return;
            }
        } while (temp != head);
    }

    public void roundRobinScheduling(int quantum) {
        if (head == null) return;

        Process temp = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        while (totalProcesses > 0) {
            if (temp.remainingBurstTime > quantum) {
                temp.remainingBurstTime -= quantum;
                totalWaitingTime += temp.waitingTime;
            } else {
                totalWaitingTime += temp.waitingTime + temp.remainingBurstTime;
                totalTurnaroundTime += temp.turnAroundTime + temp.remainingBurstTime;
                temp.turnAroundTime = temp.waitingTime + temp.remainingBurstTime;
                temp.remainingBurstTime = 0;
                removeProcess(temp.processId);
            }

            temp = temp.next;
        }

        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }

    public void displayProcesses() {
        if (head == null) return;

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Remaining Burst Time: " + temp.remainingBurstTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\nRound Robin Scheduling:");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Simulate Round Robin Scheduling");
            System.out.println("4. Display Processes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processId = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = sc.nextInt();
                    scheduler.addProcess(processId, burstTime);
                    break;

                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    int removeId = sc.nextInt();
                    scheduler.removeProcess(removeId);
                    break;

                case 3:
                    System.out.print("Enter time quantum: ");
                    int quantum = sc.nextInt();
                    scheduler.roundRobinScheduling(quantum);
                    break;

                case 4:
                    scheduler.displayProcesses();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
