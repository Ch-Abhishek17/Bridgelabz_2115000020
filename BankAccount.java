class BankAccount {
    static String bankName = "Global Bank";
    static int totalAccounts = 0;

    final String accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++; 
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Balance: " + this.balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rajesh Kumar", "ACC12345", 15000.75);
        BankAccount acc2 = new BankAccount("Suman Sharma", "ACC67890", 25000.50);

        acc1.displayAccountDetails();
        System.out.println();
        acc2.displayAccountDetails();
        BankAccount.getTotalAccounts();
    }
}