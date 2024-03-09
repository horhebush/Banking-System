package Laboratory;
import java.awt.Toolkit;
import java.util.Scanner;
public class FinalProject {

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

    	System.out.println("\n\tFederal Reserve Bank of COM23P\t\n");
		System.out.println("\t\t[A] Sign Up\t");
		System.out.println("\t\t[B] Log In\t");
		System.out.println("\t\t[X] Exit\t");
		
		char x = Default();

		switch(x)
		{
		case 'A', 'a': signUp(); break;
		case 'B', 'b': LogIn(); break;
		case 'C', 'c': homePage(); break;
		case 'X', 'x': MethodX(); break;
		}
    }

    private static void signUp() {
        System.out.println("\n\tCreate an Account!\n");
        System.out.print("\tEnter Account Name: ");
        storedName = scn.nextLine();
        scn.nextLine();

        System.out.print("\tEnter PIN: ");
        storedPin = scn.nextInt();
        scn.nextLine();

        System.out.print("\tEnter Username: ");
        storedUser = scn.nextLine();

        System.out.print("\tEnter Password: ");
        storedPass = scn.nextLine();
        
        homePage();
    }

    private static void LogIn() {
        System.out.println("\n\tYou may now log in your account.\n");
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

    private static void menu() 
    {
    	System.out.println("\n\t\tHello, " + storedName + "!");
        System.out.println("\tWelcome to Federal Reserve Bank of COM23P!");
        System.out.println("\n\tBank Account Menu:\n");
        System.out.println("\t[A] Money Transaction");
        System.out.println("\t[B] Balance");
        System.out.println("\t[C] Account Details");
        System.out.println("\t[D} Account Transaction");
        System.out.println("\t[X] Log Out");

        char x = Default();

        switch(x)
    	{
    		case 'A', 'a': Money(); break;
    		case 'B', 'b': checkBalance(); break;
    		case 'C', 'c': displayAccountDetails(); break;
    		case 'D', 'd': displayAccountTransaction(); break;
    		case 'X', 'x': homePage(); break;
    	}
    }
    private static void Money()
	{	
        System.out.println("\n\tFederal Reserve Bank of COM23P!");
		System.out.println("\n\t\t[A] Deposit\t");
		System.out.println("\t\t[B] Withdraw\t");
		System.out.println("\t\t[X] Menu\t\n");
	
		char x = Default();

		switch(x)
		{
		case 'A', 'a': deposit(); break;
		case 'B', 'b': withdraw(); break;
		case 'C', 'c': Money(); break;
		case 'X', 'x': menu(); break;
		}
	}

    private static void deposit() 
    {
        double depAmount;

        PinValidation();
        System.out.print("\n\tEnter amount to deposit: ");
        depAmount = scn.nextDouble();

        balance += depAmount;
        balances[transactionCount++] = depAmount;
            
        System.out.println("\n\tNew Balance: " + balance);
        Money();
    }

    private static void withdraw() {
        double withAmount;

        PinValidation();
        System.out.print("\n\tEnter amount to withdraw: ");
        withAmount = scn.nextDouble();

        if (balance < withAmount) 
        {
            System.out.println("\n\tInsufficient funds. Check your balance.");
            menu();
            return;
        } 
        else
        {
        	balance -= withAmount;
        	balances[transactionCount++] = -withAmount;
            System.out.println("\n\tNew Balance: " + balance);
        }
        Money();
     }
 

    public static void checkBalance() {
    	PinValidation();
        System.out.println("\n\tCurrent balance: " + balance);
        menu();
    }

    public static void displayAccountDetails() {
    	PinValidation();
        System.out.println("\n\tAccount Details: \n");
        System.out.println("\tAccount Name: " + storedName);
        System.out.println("\tPIN: " + storedPin);
        System.out.println("\tUsername: " + storedUser);
        System.out.println("\tPassword: " + storedPass);
        System.out.println(" ");
        
        menu();
    }
    
    public static void displayAccountTransaction() 
    {
        
        PinValidation();
        System.out.println("\n\tTransaction History\n");

        for (int i = 0; i < transactionCount; i++) 
        {
        	if (balances[i] > 0) 
        	{
        		System.out.println("\tDeposited: " + balances[i]);
        	} 
        	else 
        	{
        		System.out.println("\tWithdrawn: " + (-balances[i]));
                
        	}
        }
        menu();
    } 

    private static boolean PinValidation() {
        for (int x = 0; x < 3; x++) {
            System.out.print("\n\tAccount Pin: ");
            int enteredPin = scn.nextInt();

            if (enteredPin == storedPin) {
                return true;
            } else {
                System.out.println("\n\tWrong Passcode. Please try again.\n");
            }
        }
        System.out.println("You have been logged out!");
        Toolkit.getDefaultToolkit().beep();
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

		Scanner select = new Scanner(System.in);
		System.out.print("\nSelect Option: ");
		x = select.next().charAt(0);
		
		do 
		{
			if (x != 'A' && x != 'B' && x != 'C' && x != 'D' && x != 'X' && x != 'a' && x != 'b' && x != 'c' && x != 'd' && x != 'x') 
			{
				System.out.println("\nInvalid Input\n");
				System.out.print("Select Option: ");
				x = select.next().charAt(0);
			}
		} 
		
		while (x != 'A' && x != 'B' && x != 'C' && x != 'D' && x != 'X' && x != 'a' && x != 'b' && x != 'c' && x != 'd' && x != 'x');
		
		return x;
	}
	
}
