import java.util.Scanner;
public class BankingSystem {
	
	private static String storedPin;
	private static String storedName;
	private static String storedUser;
	private static String storedPass;
	
	public static void main(String[] args) {
		Open();
	}
	
	private static void Open()
	{
		System.out.print("\n");
		System.out.println("\tFederal Reserve Bank of COM23P\t");
		System.out.println("\n");
		System.out.println("\t\t[A] Sign Up\t");
		System.out.println("\t\t[B] Log In\t");
		System.out.println("\t\t[X] Exit\t");
		System.out.println("\n");
		
		Scanner create = new Scanner(System.in);
		Scanner login = new Scanner(System.in);
		
		char x = Default();

		switch(x)
		{
		case 'A': SignUp(create); break;
		case 'B': Login(login); break;
		case 'X': MethodX(); break;
		}
	}
	
	private static void Menu()
	{
		System.out.print("\n");
		System.out.println("\tFederal Reserve Bank of COM23P\t");
		System.out.println("\n");
		System.out.println("\t\t[A] Money Transaction\t");
		System.out.println("\t\t[B] Check Balance\t");
		System.out.println("\t\t[C] Account Details\t");
		System.out.println("\t\t[X] Log Out\t");
		System.out.println("\n");
		
		
		Scanner account = new Scanner(System.in);
		Scanner money = new Scanner(System.in);
		Scanner balance = new Scanner (System.in);
		
		
		char x = Default();

		switch(x)
		{
		case 'A': Money(money); break;
		case 'B': Balance(balance); break;
		case 'C': Account(account); break;
		case 'X': Open(); break;
		}
	}

	private static void SignUp(Scanner create) 
	{
		System.out.println("\n\tCreate an Account!\n");
		
			System.out.print("Account Name: ");
			storedName = create.nextLine();
			System.out.print("Enter Passcode: ");
			storedPin = create.nextLine();
			System.out.print("Enter desired username: ");
			storedUser = create.nextLine();
			System.out.print("Enter desired password: ");
			storedPass = create.nextLine();
			
			
			System.out.println("\n\tYou've successfully created an account!\n");
			
			Open();
	}
	
	private static void Login(Scanner login) 
	{
		System.out.println("\n\tFederal Reserve Bank of COM23P!\n");
			
			System.out.print("Username: ");
			String enteredUser = login.nextLine();
			System.out.print("Enter Password: ");
			String enteredPass = login.nextLine();
			
			if (enteredUser.equals(storedUser) && enteredPass.equals(storedPass)) 
			{
	            System.out.println("\n\tYou've successfully logged in!\n");
	            Menu();
	        } 
			else 
			{
	            System.out.println("\n\tInvalid username or password. Please try again.\n");
	            Login(login);
	        }
	}
	
	private static void Money(Scanner money)
	{		
			/**/
	}
	
	private static void Balance(Scanner balance)
	{		
			/**/
	}
	
	private static void Account(Scanner account)
	{		
			System.out.print("\nAccount Pin: ");
			String enteredPin = account.nextLine();
			
			if (enteredPin.equals(storedPin)) 
			{
	            AccountDetails();
	        } 
			else 
			{
	            System.out.println("\n\tWrong Passcode. Please try again.\n");
	            Account(account);
	        }
	}
	
	private static void AccountDetails()
	{
		System.out.println("\n\tAccount Details!\n");
			
			System.out.print("\nAccount Name: " + storedName);
			System.out.print("\nPIN: " + storedPin);
			System.out.print("\nUsername: " + storedUser);
			System.out.print("\nPassword: " + storedPass);
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
		
		return x;
	}
}
