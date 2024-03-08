package Java;
import java.util.Scanner;
import java.awt.Toolkit;
import java.util.ArrayList;
public class BankingSystem {

	private static String storedName;
	private static String storedUser;
	private static String storedPass;
	private static int storedPin;
	private static int storedBalance;
	
	// New additions - LIM
   	private static Scanner scn = new Scanner(System.in); // Universal Scanner para di na gagawa ng new Scanner(System.in) sa ibang methods
    	private static double balance = 0; // Balance for deposit and withdraw
    	private static double[] balances = new double[100]; // Array para sa Transaction History
	private static int transactionCount = 0; // Counts user transactions

	public static void main(String[] args) {

	}

// added by Salazar
private static void homePage() {
		
		int option = 0;

		while (option != 3);
		System.out.println("Welcome to the Banking System!"  );
		System.out.println("1. Sign Up");
		System.out.println("2. Log In");
		System.out.println("3. Exit");
		System.out.print("Choose an option: ");
		option = scn.nextInt();
		
		switch (option) {
		case 1:
			System.out.println("Sign Up selected. ");
			break;
		case 2:
			System.out.println("Log In selected. ");
			break;
		case 3:
			System.out.println("Leaving the Banking System. Goodbye! ");
			break;
		default:
			System.out.println("Invalid option. Please try again. ");
			break;
		
		}
	}


		private static void LogIn() {  //added by Tuazon
		System.out.println("\nFederal Reserve Bank of COMP23P");
		System.out.print("Enter Your Username: ");
		String username = scn.nextLine();
		System.out.print("Enter Your Password: ");
		String pass = scn.nextLine();
			
		boolean validation1 = username.equals(storedUser);
		boolean validation2 = pass.equals(storedPass);
			
		if(validation1 == true && validation2 == true) {
			Menu(); // temporary variable lang ito, palitan na lang pag nagawa na yung method ng MENU
		}
		else {
			System.out.println("Invalid Input! Please Sign-up first or try again!");
			Home_page(); // temporary variable lang ito, palitan na lang pag nagawa na yung method ng HOME PAGE
		}
		scn.close();
			
		}
	private static void Menu() { //Added by Nofre
        {
       	System.out.println("\n\tHello, " + storedName);
       	System.out.println(" ");
       	System.out.println("\tWelcome to Federal Reserve Bank of COM23P!");
       	System.out.println(" ");
       	System.out.println("\tBank Account Menu:");
           System.out.println("\t[A] Money Transaction");
           System.out.println("\t[B] Balance");
           System.out.println("\t[C] Account Details");
           System.out.println("\t[D] Log Out");
           System.out.print("\tEnter your choice: ");
           }
	}
	
	 private static void signUp() {
	        
	        System.out.println("\n \tCreate an Account!\n");
	        System.out.print("\tEnter Account Name: ");
	        storedName = scn.nextLine();

	        System.out.print("\tEnter PIN: ");
	        storedPin = UserInput(scn);
	        scn.nextLine(); 

	        System.out.print("\tEnter Username: ");
	        storedUser = scn.nextLine();

	        System.out.print("\tEnter Password: ");
	        storedPass = scn.nextLine();
	    }

	    	private static int UserInput(Scanner scn) {
			 int input = 0;
			 while (true) {

		            if (scn.hasNextInt()) {
		                input= scn.nextInt();
		                break; 
		            } else {
		                System.out.print("\tInvalid PIN. Please enter a numeric value: ");
		                scn.next(); 
		            }
		        }
			return input;
	    	}
		
	private static boolean PinValidation(Scanner pin)
	{	
		for (int x = 0; x < 3; x++) {
		  System.out.print("\nAccount Pin: ");
		  String enteredPin = pin.nextLine();

		    if (enteredPin.equals(storedPin)) 
		 {
			  return true;
		   } 
		     else 
		        {
		            System.out.println("\n\tWrong Passcode. Please try again.\n");
		        }
		    }

		    System.out.println("You have been logged out!");
		    Open();
		    return false;
		}

		private static void MethodX() 
		{
			System.out.println("\n\tThank you for using Federal Reserve Bank of COM23P");
			System.out.println("\t\t    Have a good one. Good bye!");
		}
		
		private static char Default() 
		{
			char x;

			
			System.out.print("Select Option: ");
			x = scn.next().charAt(0);
			
			do 
			{
				if (x != 'A' && x != 'B' && x != 'C' && x != 'X') 
				{
					System.out.println("\nInvalid Input\n");
					System.out.print("Select Option: ");
					x = scn.next().charAt(0);
				}
			} 
			
			while (x != 'A' && x != 'B' && x != 'C' && x != 'X');
			
			return x;

	}
	
	
	// New Additions - LIM
	private static void deposit() { // New method for Deposit
	    double depAmount;
	    String accName;
	    int accPin;
	    	
	    System.out.print("Enter Account Name: ");
	    accName = scn.nextLine();
	    	
	    System.out.print("Enter Pin: ");
	    accPin = scn.nextInt();
	    	
	    scn.nextLine();
	    	
	    if (accName.equals(storedName) && accPin == storedPin) {
	        System.out.print("\n\tEnter amount to deposit: ");
	         depAmount = scn.nextDouble();

	         // Calculations & Storing
	        balance += depAmount;
	        balances[transactionCount++] = depAmount; // Stores the transaction in the Array

	        System.out.println("\tNew Balance: " + balance);
	    } else {
	    	System.out.print("Invalid Credentials!");
	    	return;
	    }
	}


	// New Additions - LIM    
	private static void withdraw() { // New Method for Withdraw
	    double withAmount;
			
	    String accName;
	    int accPin;
	    	
	    System.out.print("Enter Account Name: ");
	    accName = scn.nextLine();
	    	
	    System.out.print("Enter Pin: ");
	    accPin = scn.nextInt();
	    	
	    scn.nextLine();
	    	
	    if (accName.equals(storedName) && accPin == storedPin) {
	    	System.out.print("\tEnter amount to withdraw: ");
	    	withAmount = scn.nextDouble();
	    		
	    	//Conditional
	    	if (balance < withAmount) {
	    		System.out.println("\tInssuficient Funds");
	    		return;
	    	} else {
	    		// Calculations & Storing
	    		balance -= withAmount;
	    		balances[transactionCount ++] = withAmount; // Stores the transaction in the Array
	    			
	    		System.out.println("\tNew Balance: " + balance);
	    	}
	    } else {
	    	System.out.print("Invalid Credentials!");
	    	return;
	    }
	}

	
	// New Additions - LIM    
	public static void displayAccountTransaction() { // Method to display transaction history
	        String accName;
	        int accPin;
	        	
	        System.out.print("Enter Account Name: ");
	        accName = scn.nextLine();
	        	
	        System.out.print("Enter Pin: ");
	        accPin = scn.nextInt();
	        	
	        scn.nextLine();
	        if (accName.equals(storedName) && accPin == storedPin) {
	        	System.out.println("Transaction History");
	        		
	        	// Loop to iterate
	        	for (int i = 0 ; i < transactionCount ; i ++) {
	        		if (balances[i] > 0) {
	        			System.out.println("Deposited: " + balances[i]);
	        		} else {
	        			System.out.println("Whitdrawed: " + (-balances[i]));
	        		}
	        	}
	        } else {
	        	System.out.print("Invalid Credentials!");
	        	return;
	        }
	 }
}
