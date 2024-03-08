//Calvo, Jezlyn Mae               //Nofre, Jasmine
//Fuertes, Jorge Omar		 //Salazar, Cheska Ann Lorein
//Lim, Lorenzo Matthew		//Tuazon, Jamaine Grace

package Final_Project;
import java.util.Scanner;
public class BankingSystem {

    private static String storedName;
    private static String storedUser;
    private static String storedPass;
    private static int storedPin;
    private static double balance = 0;
    
    private static double[] balances = new double[100]; 
    private static int transactionCount = 0; 
    
    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        homePage();
    }

    private static void homePage() {
        char option;

        do {
            System.out.println("\n\t\tWelcome to Federal Reserve Bank of COM23P!");
            System.out.println("\n\t\t[A] Sign Up");
            System.out.println("\t\t[B] Log In");
            System.out.println("\t\t[X] Exit");
            System.out.print("\t\tChoose an option: ");
            option = scn.next().charAt(0);
            scn.nextLine();

            switch (option) {
                case 'A', 'a':
                    System.out.println("\n\tSign Up selected. ");
                    signUp();
                    break;
                case 'B', 'b':
                    System.out.println("\n\tLog In selected. ");
                    LogIn();
                    break;
                case 'X', 'x':
                    System.out.println("\n\t\tLeaving the Banking System. Goodbye! ");
                    return;
                default:
                    System.out.println("\n\t\tInvalid option. Please try again. ");
                    break;
            }
        } while (option != 'X');
    }

    private static void signUp() {
        System.out.println("\tCreate an Account!\n");
        System.out.print("\tEnter Account Name: ");
        storedName = scn.nextLine();

        System.out.print("\tEnter PIN: ");
        storedPin = scn.nextInt();
        scn.nextLine();

        System.out.print("\tEnter Username: ");
        storedUser = scn.nextLine();

        System.out.print("\tEnter Password: ");
        storedPass = scn.nextLine();
    }

    private static void LogIn() {
        System.out.println("\tYou may now log in your account.\n");
        System.out.print("\n\tEnter Your Username: ");
        String username = scn.nextLine();
        System.out.print("\tEnter Your Password: ");
        String pass = scn.nextLine();

        boolean validation1 = username.equals(storedUser);
        boolean validation2 = pass.equals(storedPass);

        if (validation1 && validation2) {
            menu();
        } else {
            System.out.println("\tInvalid Input! Please Sign-up first or try again!");
            homePage();
        }
    }

    private static void menu() {
        char choice, choiceC;

        do {
            System.out.println("\n\tHello, " + storedName);
            System.out.println("\tWelcome to Federal Reserve Bank of COM23P!");
            System.out.println("\n\tBank Account Menu:");
            System.out.println("\t[A] Transaction Menu");
            System.out.println("\t[B] Balance");
            System.out.println("\t[C] Account Details");
            System.out.println("\t[D} Account Transaction");
            System.out.println("\t[X] Log Out");
            System.out.print("\tEnter your choice: ");
            choice = scn.next().charAt(0);
            scn.nextLine();

            switch (choice) {
                case 'A', 'a':
                	System.out.println("\n\tTransaction Menu:");
                	System.out.println("\t[A] Deposit");
                	System.out.println("\t[B] Withdraw");
                	System.out.println("\t[X] Exit");
                	System.out.print("\tEnter your choice: ");
                	choiceC = scn.next().charAt(0);
                    scn.nextLine();
                	
                    switch (choiceC) {
                		case 'A' , 'a':
                			deposit();
                			break;
                		case 'B' , 'b':
                			withdraw();
                			break;
                		case 'X' , 'x':
                			break;
                		default:
                			System.out.println("\n\tInvalid choice. Please try again.");
                            break;
                	}
                    break;
                case 'B', 'b':
                    checkBalance();
                    break;
                case 'C', 'c':
                    displayAccountDetails();
                    break;
                case 'D', 'd':
                	displayAccountTransaction();
                	break;
                case 'X', 'x':
                    System.out.println("\n\tYou have successfully logged out!");
                    return;
                default:
                    System.out.println("\n\tInvalid choice. Please try again.");
                    break;
            }
        } while (choice != 'F');
    }

    private static void deposit() {
        double depAmount;

        if (PinValidation()) {
            System.out.print("\n\tEnter amount to deposit: ");
            depAmount = scn.nextDouble();

            balance += depAmount;
            balances[transactionCount++] = depAmount;
            
            System.out.println("\tNew Balance: " + balance);
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    private static void withdraw() {
        double withAmount;

        if (PinValidation()) {
            System.out.print("\n\tEnter amount to withdraw: ");
            withAmount = scn.nextDouble();

            if (balance < withAmount) {
                System.out.println("\tInsufficient Funds");
                return;
            } else {
                balance -= withAmount;
                balances[transactionCount++] = -withAmount;

                System.out.println("\tNew Balance: " + balance);
            }
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    public static void checkBalance() {
        System.out.println("\n\tCurrent balance: " + balance);
    }

    public static void displayAccountDetails() {
        System.out.println("\n\tAccount Details:");
        System.out.println("\tAccount Name: " + storedName);
        System.out.println("\tPIN: " + storedPin);
        System.out.println("\tUsername: " + storedUser);
        System.out.println("\tPassword: " + storedPass);
        System.out.println(" ");
    }
    
    public static void displayAccountTransaction() {
        
        if (PinValidation()) { 
            System.out.println("\n\tTransaction History");

            for (int i = 0; i < transactionCount; i++) {
                if (balances[i] > 0) {
                    System.out.println("\tDeposited: " + balances[i]);
                } else {
                    System.out.println("\tWithdrawn: " + (-balances[i]));
                }
            }
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    private static boolean PinValidation() {
        for (int x = 0; x < 3; x++) {
            System.out.print("\tAccount Pin: ");
            int enteredPin = scn.nextInt();

            if (enteredPin == storedPin) {
                return true;
            } else {
                System.out.println("\n\tWrong Passcode. Please try again.\n");
            }
        }
        System.out.println("You have been logged out!");
        homePage();
        return false;
    }
	
}

