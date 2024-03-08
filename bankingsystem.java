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

	private static void LogIn() {
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

			Scanner select = new Scanner(System.in);
			System.out.print("Select Option: ");
			x = select.next().charAt(0);
			
			do 
			{
				if (x != 'A' && x != 'B' && x != 'C' && x != 'X') 
				{
					System.out.println("\nInvalid Input\n");
					System.out.print("Select Option: ");
					x = select.next().charAt(0);
				}
			} 
			
			while (x != 'A' && x != 'B' && x != 'C' && x != 'X');
			
			return x;

	}

}
