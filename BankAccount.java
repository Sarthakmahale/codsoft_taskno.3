import java.util.Scanner;
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance){
        balance=initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance+=amount;
            System.out.println("Deposited--> $"+amount);
        }
        else{
            System.out.println("Invalid Deposit amount...");
        }
    }

    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdraw-->$"+amount);
        }
        else{
            System.out.println("Invalid Withdrawal amount or insufficient balance");
        }
    }
}

class ATM{
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account){
        userAccount=account;
        scanner=new Scanner(System.in);
    }
    public void checkbalance(){
        System.out.println("Current Balance is-->$"+userAccount.getBalance());
    }
    public void displayOptions(){
        System.out.println("Select an option");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void run(){
        boolean isRunning=true;
        while (isRunning) {
            displayOptions();
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                checkbalance();
                break;

                case 2:
                System.out.println("Enter the Deposit amount-->$");
                double depositAmount=scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;

                case 3:
                System.out.println("Enter the Withdrawal amount-->$");
                double WithdrawalAmount=scanner.nextDouble();
                userAccount.withdraw(WithdrawalAmount);
                break;

                case 4:
                isRunning=false;
                System.out.println("Thank you for using the ATM");
                break;

                default:
                System.out.println("Invalid option. Please choose a valid option. ");
                break;
            }
        }
    }
    public static void main(String args[]){
        BankAccount useAccount=new BankAccount(100000.0);
        ATM atm=new ATM(useAccount);
        atm.run();
    }
}