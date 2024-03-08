package Java;
import java.util.Scanner;
import java.awt.Toolkit;
import java.util.ArrayList;
public class BankingSystem {

	private static String storedPin;
	private static String storedName;
	private static String storedUser;
	private static String storedPass;

	public static void main(String[] args) {

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
}
