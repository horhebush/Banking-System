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
		homePage();
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

		private static void LogIn() {  //added by Tuazon
		System.out.println("\nFederal Reserve Bank of COMP23P");
		System.out.print("Enter Your Username: ");
		String username = scn.nextLine();
		System.out.print("Enter Your Password: ");
		String pass = scn.nextLine();
			
		boolean validation1 = username.equals(storedUser);
		boolean validation2 = pass.equals(storedPass);
			
		if(validation1 == true && validation2 == true) {
			Menu(); // 
		} else {
			System.out.println("Invalid Input! Please Sign-up first or try again!");
			homePage();
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
			Toolkit.getDefaultToolkit().beep();
		    System.out.println("You have been logged out!");
		    homePage();
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
	private static void deposit() {
   	 double depAmount;
   	 String accName;
   	 int accPin;

    	System.out.print("Enter Account Name: ");
    	accName = scn.nextLine();

    	if (PinValidation(scn)) { // Call PIN validation method
    	    System.out.print("\n\tEnter amount to deposit: ");
   	     depAmount = scn.nextDouble();

   	     // Calculations & Storing
    	    balance += depAmount;
    	    balances[transactionCount++] = depAmount; // Stores the transaction in the Array

    	    System.out.println("\tNew Balance: " + balance);
   	 } else {
   	     System.out.println("Invalid Credentials!");
    	}
	}

	// New Additions - LIM    
	private static void withdraw() {
   	 double withAmount;
    	 String accName;

    	 System.out.print("Enter Account Name: ");
    	 accName = scn.nextLine();

    	 if (PinValidation(scn)) { // Call PIN validation method
       	 	 System.out.print("\tEnter amount to withdraw: ");
         	 withAmount = scn.nextDouble();

        	 // Conditional
        	 if (balance < withAmount) {
            	 System.out.println("\tInsufficient Funds");
            	 return;
        	 } else {
            	 // Calculations & Storing
            	 balance -= withAmount;
            	 balances[transactionCount++] = -withAmount; // Stores the transaction in the Array

            	 System.out.println("\tNew Balance: " + balance);
        	}
    	 } else {
         System.out.println("Invalid Credentials!");
    }
}

	
	// New Additions - LIM    
public static void displayAccountTransaction() {
    String accName;

    System.out.print("Enter Account Name: ");
    accName = scn.nextLine();

    if (PinValidation(scn)) { // Call PIN validation method
        System.out.println("Transaction History");

        // Loop to iterate
        for (int i = 0; i < transactionCount; i++) {
            if (balances[i] > 0) {
                System.out.println("Deposited: " + balances[i]);
            } else {
                System.out.println("Withdrawn: " + (-balances[i]));
            }
        }
    } else {
        System.out.println("Invalid Credentials!");
    }
}

	//added by jez
	public static void checkBalance() {
	System.out.println("Current balance: " + storedBalance);
	}
	
	public static void displayAccountDetails() {
		System.out.println("\n\tAccount Details:\n");
		System.out.println("\tAccount Name: " + storedName);
		System.out.println("\tPIN: " + storedPin);
		System.out.println("\tUsername: " + storedUser);
		System.out.println("\tPassword: " + storedPass);
		System.out.println(" ");
	}
	public static void main(String [] args){
		char choiceC;
	do {
		int choice;
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. Account Details");
		System.out.println("5. Account Transaction");
		System.out.println("6. Log Out");
		System.out.println("Enter your Choice: ");
		choice = scn.nextInt();

	switch (choice){
	case 1:
		deposit();
		break;
	case 2:
		withdraw();
		break;
	case 3:
		checkBalance();
		break;
	case 4:
		displayAccountDetails();
		break;
	case 5:
		displayAccountTransaction();
		break;
	case 6:
		System.out.println("Exiting Program...");
		System.exit(0);
		break;
	default:
		System.out.println("Invalid Choice... ");
}
	 System.out.print("Do you want to make another transaction? [y/n]: ");
		choiceC = scn.next()charAt(0);

		if choiceC == 'n' && choiceC == 'N')
		break;
	} while (true)
}		

}
