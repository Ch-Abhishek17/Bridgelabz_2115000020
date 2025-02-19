import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        accounts.put(accNo, balance);
        sortedAccounts.put(balance, accNo);
        System.out.println("Account Added Successfully!\n");
    }

    public void requestWithdrawal() {
        System.out.print("Enter Account Number for Withdrawal: ");
        int accNo = scanner.nextInt();
        if (accounts.containsKey(accNo)) {
            withdrawalQueue.add(accNo);
            System.out.println("Withdrawal request added for account: " + accNo + "\n");
        } else {
            System.out.println("Account not found!\n");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accNo);
        }
        System.out.println("All withdrawals processed.\n");
    }

    public void displayAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedAccounts + "\n");
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. Request Withdrawal");
            System.out.println("3. Process Withdrawals");
            System.out.println("4. Display Accounts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1 -> addAccount();
                case 2 -> requestWithdrawal();
                case 3 -> processWithdrawals();
                case 4 -> displayAccounts();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again!\n");
            }
        }
    }
}

public class Banking_System {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.menu();
    }
}
