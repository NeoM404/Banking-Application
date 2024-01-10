import java.util.HashMap;

abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public abstract void withdraw(double amount);

    public void displayBalance()
    {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: R" + this.balance);
    }
}
