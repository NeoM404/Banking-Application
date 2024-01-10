public class AdvancedBanking {
    public static void main(String[] args){
        Bank bank = new Bank();

        boolean isRunning = true;

        while(isRunning){
            System.out.println("\n Welcome to Martinez Banking Solutions \n");
            System.out.println("Available options: \n");
            System.out.println("1. Create New Account");
            System.out.println("2. Check balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money ");
            System.out.println("5. View Accounts ");
            System.out.println("6. Exit \n");

            System.out.println("Choose an option: ");
            int choice = bank.scanner.nextInt();

            switch (choice){
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.checkBalance();
                    break;
                case 3:
                    bank.depositMoney();
                    break;
                case 4:
                    bank.withdrawMoney();
                    break;
                case 5:
                    bank.accounts();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Exiting Bank application. GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }

        }

        bank.closeScanner();
    }
}
