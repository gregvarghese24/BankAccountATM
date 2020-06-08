//CHECKSTYLE:OFF

import java.util.Scanner;

public class bankApplication {

    public static void main(String[] args) {
        // new BankAccount Object
       BankAccount obj1 = new BankAccount("GREG VARGHESE", "1234567890");
       obj1.showMenu();


    }
}

class BankAccount{

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //Constructor to initialize variables from main method
     BankAccount(String cname, String cid) {
         customerName = cname;
         customerId = cid;
     }


    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdrawal(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;

        }

    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Previous Transaction was a Deposit of " + previousTransaction);
        } else if (previousTransaction < 0 ) {
            System.out.println("Previous Transaction was a Withdrawal of " + Math.abs(previousTransaction));
        } else {
            System.out.println("A transaction has not been made yet.");
        }

    }

    // making interactive menu for user in the command prompt
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName );
        System.out.println("To Greg's homemade ATM");
        System.out.println("Your ID is: " + customerId);
        System.out.println("Enter the following letter to initiate an action");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do
        {
            System.out.println("--------------------------------------------------------");
            System.out.println("Enter an option");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option) {
                // check balance
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Your balance is: " + balance);
                    System.out.println("------------------------------");
                    break;
                // deposit
                case 'B':
                    System.out.println("------------------------------");
                    System.out.println("How much do you want to deposit in your account?");
                    System.out.println("------------------------------");
                    int amount1 = scanner.nextInt();
                    deposit(amount1);
                    System.out.println("\n");
                    break;
                // withdrawal
                case 'C':
                    System.out.println("------------------------------");
                    System.out.println("How much do you want to withdraw from your account?");
                    System.out.println("------------------------------");
                    int amount2 = scanner.nextInt();
                    deposit(amount2);
                    System.out.println("\n");
                    break;
                // previous transaction
                case 'D':
                    System.out.println("------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------");
                    break;
                case 'E':
                    System.out.println("***********************************");

                default:
                    System.out.println("Invalid Option! Please enter again.");
                    break;

            }
        } while (option != 'E');
        System.out.println("Thank you for using our service");
    }

}
