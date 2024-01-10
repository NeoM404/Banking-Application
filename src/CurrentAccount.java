 class CurrentAccount extends Account{

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit){
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
     public void withdraw(double amount){
        if (getBalance() + this.overdraftLimit >= amount)
        {
            super.moneyOut(amount);
            System.out.println("withdrawal successful. New balance: R" + getBalance());
        } else {
            System.out.println("Exceeds overdraft limit. Withdrawal denied");
        }
    }

}
