import java.util.ArrayList;
// Bank Account Class
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}
// Customer Class
class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    public String getName() {
        return name;
    }
}
// Bank Class
class Bank {
    private String bankName;
    private ArrayList<Customer> customers;
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Method to open a new account for a customer
    public void openAccount(Customer customer, BankAccount account) {
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer); // Add customer if not already in the bank
        }
    }
    public void displayCustomers() {
        System.out.println("Bank: " + bankName);
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
        }
    }
}
// Main Class to Demonstrate the Association
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        BankAccount account1 = new BankAccount("123456", 1000.00);
        BankAccount account2 = new BankAccount("789101", 500.00);
        BankAccount account3 = new BankAccount("112233", 300.00);
        bank.openAccount(customer1, account1);
        bank.openAccount(customer1, account2);
        bank.openAccount(customer2, account3);

        customer1.viewBalance();
        System.out.println();
        customer2.viewBalance();

        System.out.println();
        bank.displayCustomers();
    }
}
