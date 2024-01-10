/*
* This class is a Savings Account class which inherits from the Account abstract class
* */
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance)
    {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount)
    {
        if (getBalance() >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient Funds!!");
        }
    }

    public void addInterest(){
        deposit(getBalance() * interestRate);
        System.out.println("Interest Rate added. New Balance: R" + getBalance());
    }

}
