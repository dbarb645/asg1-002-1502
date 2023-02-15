
package mru.game.view;


import java.util.Scanner;

public class AppMenu {

    /**
     * This class will be used to show the menus and sub menus to the user
     * It also prompts the user for the inputs and validates them
     */
	
	
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Declan !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	/**
	 * Displays the main menu and prompts the user for their choice
	 *
	 * @return The user's choice as a String
	 */
 
	public static String firstMenu() {
        System.out.println("Select One of the Options: ");
        Scanner sc = new Scanner(System.in);
        System.out.printf("%15s\n", "(P) Play game");
		System.out.printf("%12s\n", "(S) Search");
		System.out.printf("%10s\n", "(E) Exit");
		System.out.println("Enter a choice: ");
        String input1 = sc.nextLine();
        return input1;
    }
	
	/**
	 * Displays the submenu and prompts the user for their choice
	 *
	 * @return The user's choice as a String
	 */
	
	
    public static String secondMenu(){
    	Scanner sc = new Scanner(System.in);
        System.out.println("Select One of the Options: ");
        System.out.printf("%14s\n", "(T) Top Player");
        System.out.printf("%12s\n", "(N) Looking for a Name");
        System.out.printf("%10s\n", "(B) Back to the main menu");
        System.out.println("Enter a choice : ");
        String input2 = sc.nextLine();
       
        return input2;
    }
    
    /**
     * Displays the game result menu and prompts the user for their choice and bet amount
     *
     * @return The user's choice and bet amount as a String array
     */
    
    public static String[] thirdMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select One of the Options : ");
        System.out.printf("%15s\n", "(P) Player Wins");
        System.out.printf("%12s\n", "(B) Banker Wins");
        System.out.printf("%10s\n", "(T) Tie Game");
        System.out.println("Enter a choice : ");
        String input3 = sc.nextLine();
        System.out.println("How much do you want to bet this round?");
        String betAmtS = sc.nextLine();
        String [] x = {input3,betAmtS};
       
        return x;
}
    public static String getName(){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter your name: ");    // prompt users name
		String name = sc.nextLine();
		
		return name;
    	
    }

   
}
