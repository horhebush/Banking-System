package Bank;
import java.util.Scanner;

public class BankAccountMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0; // Initial balance
        boolean loggedIn = true;

        while (loggedIn) {
        	System.out.println("\n\tHello, \n");
        	System.out.println(" ");
        	System.out.println("\tWelcome to Federal Reserve Bank of COM23P!");
        	System.out.println(" ");
        	System.out.println("\tBank Account Menu:");
            System.out.println("\t[A] Money Transaction");
            System.out.println("\t[B] Balance");
            System.out.println("\t[C] Account Details");
            System.out.println("\t[D] Log Out");
            System.out.print("\tEnter your choice: ");

            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    System.out.println("\n\tMoney Transaction Menu: \n");
                    System.out.println("\t[A] Deposit");
                    System.out.println("\t[B] Withdraw");
                    System.out.print("\tEnter your choice: ");
                    char transactionChoice = scanner.next().charAt(0);

                    if (transactionChoice == 'A') {
                        System.out.print("\tEnter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        balance += depositAmount;
                        System.out.println("\tDeposit successful.");
                    } else if (transactionChoice == 'B') {
                        System.out.print("\tEnter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            System.out.println("\tWithdrawal successful.");
                        } else {
                            System.out.println("\tInsufficient funds.");
                        }
                    } else {
                        System.out.println("\tInvalid choice.");
                    }
                    break;

                case 'B':
                    System.out.println("\tCurrent Balance: P " + balance);
                    break;

                case 'C':
                    System.out.println("\tAccount Details:");
                
                    break;

                case 'D':
                    System.out.println("\tYou have successfully logged out.");
                    loggedIn = false;
                    break;

                default:
                    System.out.println("\tInvalid choice. Please enter A, B, C, or D: ");
            }
        }
    }
}
