// Superclass: BankAccount
class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate; // Annual interest rate in percentage

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "% per year");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit; // Daily withdrawal limit

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Daily Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int tenure; // Tenure in months

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenure + " months");
    }
}

// Main Class to Test Hierarchical Inheritance
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 5000.0, 4.5);
        CheckingAccount checking = new CheckingAccount("CHK456", 3000.0, 1000.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 10000.0, 24);

        System.out.println("=== Savings Account Details ===");
        savings.displayBalance();
        savings.displayAccountType();
        System.out.println("------------------------");

        System.out.println("=== Checking Account Details ===");
        checking.displayBalance();
        checking.displayAccountType();
        System.out.println("------------------------");

        System.out.println("=== Fixed Deposit Account Details ===");
        fixedDeposit.displayBalance();
        fixedDeposit.displayAccountType();
    }
}
