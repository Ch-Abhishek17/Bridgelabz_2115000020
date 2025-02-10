import java.util.*;
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    
    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% interest rate

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2% interest rate

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for amount: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 10; // Eligibility is 10x the balance
    }
}

// Main class to demonstrate functionality
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount acc1 = new SavingsAccount("SB12345", "Rahul", 50000);
        CurrentAccount acc2 = new CurrentAccount("CA67890", "Priya", 100000);
        
        accounts.add(acc1);
        accounts.add(acc2);
        
        for (BankAccount acc : accounts) {
            acc.displayDetails();
            System.out.println("Interest Earned: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                System.out.println("Loan Eligibility: " + ((Loanable) acc).calculateLoanEligibility());
            }
            System.out.println("--------------------");
        }
    }
}
