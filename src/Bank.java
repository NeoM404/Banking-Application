import java.util.*;

/*
* This class manages accounts in a Bank
 */
public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    public final Scanner scanner = new Scanner(System.in);

    public void createAccount(){
        Random rand = new Random();
        int accountNumber = 0;
        Account account;


        //Creating account number Randomly
        do{
            accountNumber = 1435706 + rand.nextInt(9999999);

            if (accounts.containsKey(accountNumber)){
                System.out.println("Account already Exists");
            }
        }while(accounts.containsKey(accountNumber));

        String accountNum = Integer.toString(accountNumber);
        // Exception handling required!
        System.out.println("Enter your initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        System.out.println("Enter account type (1. Savings, 2. Current): ");
        int accountType = scanner.nextInt();

        // Creating account for User.
        if (accountType == 1){
            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();

            account = new SavingsAccount(accountNum, initialDeposit, interestRate);

        }else if (accountType == 2)
        {
            System.out.println("Enter Overdraft Limit: ");
            double overdraftLimit = scanner.nextDouble();
            account =  new CurrentAccount(accountNum, initialDeposit, overdraftLimit);
        }else {
            System.out.println("Invalid account type");
            return;
        }

        //Adding created account to the hash map
        accounts.put(accountNum, account);
        System.out.println("Account created successfully");

    }

    public void depositMoney(){
        System.out.println("Enter account number to deposit to: ");
        String accountNumber = scanner.next();

        if (accounts.containsKey(accountNumber)){
            System.out.println("Enter deposit amount: R");
            double depositAmount = scanner.nextDouble();

            accounts.get(accountNumber).deposit(depositAmount);

            System.out.println("deposit successful. New Balance: R" + accounts.get(accountNumber).getBalance());
        }else {
            System.out.println("Account not found. Please create an account first");
        }
    }

    public void withdrawMoney(){

        System.out.println("Enter an account number to withdraw from: ");
        String accountNumber = scanner.next();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Enter an amount to withdraw");
            double amount = scanner.nextDouble();

            accounts.get(accountNumber).withdraw(amount);

            System.out.println("Take your cash. Remaining balance is: R" + accounts.get(accountNumber).getBalance());
        }else {
            System.out.println("Account not found. Please create an account first");
        }
    }

    public void checkBalance()
    {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.next();

        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).displayBalance();
        }else {
            System.out.println("Account not found. Please create an Account");
        }
    }

    public void accounts()
    {
        String adminPass = scanner.next();

        if (Objects.equals(adminPass, "admin#Martinez450#")){
            System.out.println("Available Accounts: " + accounts);
        }else {
            System.out.println("No enough Access right");
            return;
        }
    }

    public void closeScanner()
    {
        scanner.close();
    }

}
