package Bank;
import java.util.Scanner;

public class BankAccount {
    private String storedName;
    private int storedPin;
    private String storedUsername;
    private String storedPassword;

    //User input
    public BankAccount() {
    	signUp();
    }

    private void signUp() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n \tCreate an Account!\n");
        System.out.print("\tEnter Account Name: ");
        storedName = scanner.nextLine();

        System.out.print("\tEnter PIN: ");
        storedPin = UserInput(scanner);
        scanner.nextLine(); 

        System.out.print("\tEnter Username: ");
        storedUsername = scanner.nextLine();

        System.out.print("\tEnter Password: ");
        storedPassword = scanner.nextLine();
    }

    	private int UserInput(Scanner scanner) {
		 int input = 0;
		 
		 while (true) {

	            if (scanner.hasNextInt()) {
	                input= scanner.nextInt();
	                break; 
	            } else {
	                System.out.print("\tInvalid PIN. Please enter a numeric value: ");
	                scanner.next(); 
	            }
	        }
		return input;
	
    	}
		public void displayAccountInformation() {
        System.out.println("\n\tAccount Information:\n");
        System.out.println("\tAccount Name: " + storedName);
        System.out.println("\tPIN: " + storedPin);
        System.out.println("\tUsername: " + storedUsername);
        System.out.println("\tPassword: " + storedPassword);
        System.out.println(" ");
        System.out.println("\tYou have successfuly created an account!");

   
        
    }

public static void main(String[] args) {

    BankAccount userAccount = new BankAccount();
    userAccount.displayAccountInformation();
}
}
