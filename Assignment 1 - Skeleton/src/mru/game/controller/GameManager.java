package mru.game.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  Declan !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class GameManager {

	/**
	 * The GameManager class manages the game's data, including loading and saving the
	 * player data to a text file, searching for a player based on their choice,
	 * and finding the top players.
	 */
	
	
	private int playerWins = 0;
	private static String name;
	private int balance = 100;
	private int count = 0;
	static File f = new File("res/CasinoInfo.txt");
	private static ArrayList<Player> arrList = new ArrayList<Player>();
	
	
	 /**
     * Constructor for the GameManager class. Calls the loadFile method and the
     * display method when an instance is created.
     * 
     * @throws Exception if there is an error loading the file
     */
	

	public GameManager() throws Exception {
												// Call the load file method and the display method when an instance is created
		loadFile();
		display();		
	}
	 /**
     * Loads the text file into an ArrayList.
     * 
     * @throws Exception if there is an error loading the file
     */
	
	public static void loadFile() throws Exception {
		// Create a FileReader and BufferedReader objects to read from the text file
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		// Check if the file exists
		if (f.exists()) {
			// Read each line of the file and create a Player object for each line
			while ((line = br.readLine()) != null) {
				String[] line1 = line.split(",");
				Player p = new Player(line1[0], Integer.parseInt(line1[1]), Integer.parseInt(line1[2]));
				arrList.add(p);
			}
			fr.close();
		}
	}
	
	
	/**
     * Saves the ArrayList to the text file.
     * 
     * @throws Exception if there is an error saving the file
     */
	
	
	

	public static void SaveFile() throws Exception {
		// Create a FileWriter and PrintWriter objects to write to the text file
		FileWriter fw = new FileWriter("res/CasinoInfo.txt");
		PrintWriter pw = new PrintWriter(fw);
		// Write each Player object to the file
		for (Player p : arrList) {
			pw.println(p.format());
		}
		fw.close();
	}

	
	 /**
     * Checks if the entered name is in the ArrayList.
     * 
     * @return true if the name is found in the ArrayList, false otherwise
     */

	public static boolean booleanNamecheck() {
		// Get the name from the AppMenu class
		name = AppMenu.getName();
		boolean status = false;
		for (Player p : arrList) {
			// If the name is found, return true
			if (p.getName().equalsIgnoreCase(name)) {
				return status = true;
			}
		}
		return status;
	}

	
	/**
     * Returns the player object associated with the given name.
     * 
     * @param x the name of the player to search for
     * @return the Player object associated with the name, or null if not found
     */

	public static Player nameCheck(String x) {
		for (Player p : arrList) {
			// If the name is found, return the Player object
			if (p.getName().equalsIgnoreCase(x)) {				
				return p;
			}
		}
		return null;
	}

	/**
     * Finds the top 2 players in the ArrayList.
     * 
     * @return an ArrayList containing the top 2 players
     */

	public static ArrayList<Player> topPlayer() {  // method to search for the top 2 players 
	    for(int i = 0; i < arrList.size()-1; i++) { // loop through the array list from 0 to the second-to-last index
	        int ind = i; // initialize the current index as the smallest index in the unsorted part of the array
	        for (int j = i+1; j< arrList.size(); j++) { // loop through the unsorted part of the array
	            if (arrList.get(j).getnWins()>arrList.get(ind).getnWins()) { // compare the number of wins of two elements in the array
	                ind =j; // if the j-th element has more wins than the current smallest element, set j as the new smallest index
	            }
	        }
	        Player temp = arrList.get(ind); // swap the smallest element with the i-th element
	        arrList.set(ind, arrList.get(i));
	        arrList.set(i, temp);
	    }
	    return arrList; // return the sorted array list
	    
	}
	
	
	
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  UTSAV !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	  /**
     * Applies the game to the player.
     * 
     * @throws Exception if there is an error during the game
     */
	
	
	public void applyGame() throws Exception {
		// Create a new player object with the player's name, balance, and number of wins
		Player p = new Player(name, balance, playerWins);

		// Print a welcome message that includes the player's name and balance
		System.out.println("****************************************************************");
		System.out.println("***   Welcome " + p.getName() + "   ---   Your balance is: " + p.getBalance() + "$        ***");
		System.out.println("****************************************************************");
		System.out.println("");
    	Scanner sc = new Scanner(System.in);

    	// Call the thirdMenu method from the AppMenu class to get the player's bet amount and choice
    	String[] getAmt = AppMenu.thirdMenu();
    	String choice = getAmt[0];
    	if (!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("B") &&  !choice.equalsIgnoreCase("T") ) {
    		System.out.println("");
    		System.out.println("\t  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    		System.out.println("\t  $       Invalid input       $");
    		System.out.println("\t  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    		System.out.println("");
			display();
		}
    	int betAmt = Integer.parseInt(getAmt[1]);

    	// Check if the bet amount is valid
    	if (betAmt <= 0 || betAmt > balance) {
    	    System.out.println("Not enough money to play the game. ");
    	    display();
    	}

    	// Call the method to play the Punto Banco game and store the result
    	boolean win = PuntoBancoGame.method(PuntoBancoGame.Getpoints());

    	// Check the game result and update the player's balance and number of wins accordingly
    	if (win == true && choice.equalsIgnoreCase("P")) {
    	    count = count + 1;
    	    balance = balance + betAmt;
    	    playerWins++;
    	    PuntoBancoGame.PrintWin(); 

    	} else if (win == true && !choice.equalsIgnoreCase("P")) {
    	    balance = balance - betAmt;
    	    PuntoBancoGame.Printloose();
    	} else if (win == false && choice.equalsIgnoreCase("B") && PuntoBancoGame.getTie() == false) {
    	    balance = balance + betAmt;
    	    playerWins++;
    	    PuntoBancoGame.PrintWin(); 

    	} else if (win == false && !choice.equalsIgnoreCase("B") && PuntoBancoGame.getTie() == false) {
    	    balance = balance - betAmt;
    	    PuntoBancoGame.Printloose();
    	}

    	else if (win == false && choice.equalsIgnoreCase("T") && PuntoBancoGame.getTie() == true) {
    	    balance = balance + (betAmt * 5);
    	    playerWins++;
    	    PuntoBancoGame.PrintWin(); 
    	     
    	} else if (win == false && !choice.equalsIgnoreCase("T") && PuntoBancoGame.getTie() == true) {
    	    balance = balance - (betAmt / 5);
    	    PuntoBancoGame.Printloose();
    	}
   
    	// Create a new Player object with the updated balance and number of wins
    	p = new Player(name, balance, playerWins);

    	// Add the new Player object to the ArrayList
    	arrList.add(p);

    	// Save the ArrayList to a file
    	SaveFile();
	}
	
	
	  /**
     * Applies the game to the player.
     * 
     * @throws Exception if there is an error during the game
     */
	
	
	
	public void applyGame2() throws Exception {           // same method as above but intented for returning players
		Player plt = nameCheck(name);
		balance = plt.getBalance();
		playerWins = plt.getnWins();
		System.out.println("********************************************************************");
    	System.out.println("***   Welcome Back " + plt.getName() + "   ---   Your balance is: " + plt.getBalance() + "$        ***");
    	System.out.println("********************************************************************");
		Scanner sc = new Scanner(System.in);
		String[] getAmt = AppMenu.thirdMenu();
		String choice = getAmt[0];
		if (!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("B") &&  !choice.equalsIgnoreCase("T") ) {
			System.out.println("");
    		System.out.println("\t  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    		System.out.println("\t  $       Invalid input       $");
    		System.out.println("\t  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    		System.out.println("");
			display();
		}
		int betAmt = Integer.parseInt(getAmt[1]);
	

		if (betAmt <= 0 || betAmt > balance) {
			System.out.println("Not enough money to play the game.");
			display();
		}

		boolean win = PuntoBancoGame.method(PuntoBancoGame.Getpoints());
		if (win == true && choice.equalsIgnoreCase("P")) {
			count = count + 1;
			balance = balance + betAmt;
			playerWins++;
			PuntoBancoGame.PrintWin(); 

		} else if (win == true && !choice.equalsIgnoreCase("P")) {

			balance = balance - betAmt;
			PuntoBancoGame.Printloose();
		} else if (win == false && choice.equalsIgnoreCase("B") && PuntoBancoGame.getTie() == false) {

			balance = balance + betAmt;
			playerWins++;
			PuntoBancoGame.PrintWin(); 

		} else if (win == false && !choice.equalsIgnoreCase("B") && PuntoBancoGame.getTie() == false) {
			balance = balance - betAmt;
			PuntoBancoGame.Printloose();
		}

		else if (win == false && choice.equalsIgnoreCase("T") && PuntoBancoGame.getTie() == true) {
			balance = balance + (betAmt * 5);
			playerWins++;
			PuntoBancoGame.PrintWin(); 
		} else if (win == false && !choice.equalsIgnoreCase("T") && PuntoBancoGame.getTie() == true) {
			balance = balance - (betAmt / 5);
			PuntoBancoGame.Printloose();
		} else {
			System.out.println("Invalid input!");
			display();
		}
		plt.setName(name);
		plt.setBalance(balance);   // using set methods to change balances on existing accounts
		plt.setWins(playerWins);
		SaveFile();

	}
	
	/**

	Displays the game menu and handles user input.

	@throws Exception if an error occurs while displaying the menu or handling user input
	*/

	public void display() throws Exception {
	    
	    // Prompt user with the first menu
	    String i1 = AppMenu.firstMenu();
	    String userInput = "Y";
	    Scanner sc = new Scanner(System.in);
	    
	    // User chooses to play the game
	    if (i1.equalsIgnoreCase("P")) {
	        
	        // Continue playing game until user chooses to stop
	        while (userInput.equalsIgnoreCase("y")) {
	            
	            // Check if player database exists
	            if (booleanNamecheck() == false) {
	                // Play the game for new player
	                applyGame();
	            } else {
	                // Play the game for existing player
	                applyGame2();
	            }
	            
	            // Ask user if they want to play again
	            System.out.println("Do you want to play again?");
	            userInput = sc.nextLine();
	            
	            // If user chooses to stop playing, display the first menu again
	            if (!userInput.equalsIgnoreCase("y")) {
	                display();
	            }
	        }
	        
	    // User chooses to view statistics
	    } else if (i1.equalsIgnoreCase("S")) {
	        
	        // Prompt user with the second menu
	        String i2 = AppMenu.secondMenu();
	        System.out.println("");
	        
	        if (i2.equalsIgnoreCase("T")) {
	            // Display top players
	            System.out.println("    - TOP PLAYERS -");
	            sc = new Scanner(System.in);
	            System.out.println("+==========+==========+");
	            System.out.printf("| %-8s | %-8s |\n", topPlayer().get(0).getName(), topPlayer().get(0).getnWins());
	            System.out.println("-----------------------");
	            System.out.printf("| %-8s | %-8s |\n", topPlayer().get(1).getName(), topPlayer().get(1).getnWins());
	            System.out.println("+==========+==========+");
	            System.out.println();
	            System.out.println("Press Enter to continue");
	            
	            // If user presses enter, display the first menu again
	            String myObj = sc.nextLine();
	            if(myObj.equals("")) {
	                display();
	            } else {
	                // Otherwise, exit the game
	                System.out.println("Thanks for playing!");
	                System.exit(0);
	            }
	            
	        } else if (i2.equalsIgnoreCase("N")) {
	            // Search for player by name
	            System.out.println("Enter name to search.");
	            sc = new Scanner(System.in);
	            String input = sc.nextLine();
	            try {
	            System.out.println("**********************************");
	            System.out.println ("*** "+nameCheck(input).getName() + " --- "+ "No of wins " + nameCheck(input).getnWins()+ " ***");
	            System.out.println("**********************************");
	            
	            System.out.println("Press Enter to continue.");
	           String myObj = sc.nextLine();
	            // If user presses enter, display the first menu again
	            if(myObj.equals("")) {
	                display();
	            } else {
	                // Otherwise, exit the game
	                System.out.println("Thanks for playing!");
	                System.exit(0);
	            }
	            
	        }
	            catch (Exception e){
	            	System.out.println("Name doesnt exist!");
	            	  System.out.println("Press Enter to continue.");
	   	           String myObj = sc.nextLine();
	            	 if(myObj.equals("")) {
	 	                display();
	 	            } else {
	 	                // Otherwise, exit the game
	 	                System.out.println("Thanks for playing!");
	 	                System.exit(0);
	 	            }
	            }
	        }
	            else if (i2.equalsIgnoreCase("B")) {
	            // Display the first menu again
	            display();
	            
	        }
	        
	    // User chooses to exit the game
	    } else if (i1.equalsIgnoreCase("E")) {
	        
	        // Save player data to file and exit the game
	        System.out.println("Saving............");
	        System.out.print("Thank you for playing!");
	        SaveFile();
	        System.exit(0);
	        
	    } else {
	        // Display an error message and prompt the user with the first menu again
	        System.out.println("Invalid input entered, please try again.");
	        display();
	    }
	}

	

}


