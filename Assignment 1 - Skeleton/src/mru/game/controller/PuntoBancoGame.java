package mru.game.controller;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	
	
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Utsav !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
private static boolean gameWon = false;
private static boolean gameTie = false;
private static Card playerH = null;
private static Card compH= null;
private static Card playerH1= null;
private static Card compH1= null;
private static Card playerH3= null;
private static Card compH3= null;
//private static int Balance = 100;
//public static int getBalance() {
//	return Balance;
//}
	public static CardDeck dec = new CardDeck();
	
	 /**
	   * Returns an array containing the total points of the player and the dealer.
	   * 
	   * @return the total points of the player and the dealer
	   */
	public static int[] Getpoints() {
	if (dec.getDeck().size() <= 4) {
		dec = new CardDeck();
	} // if and else conditions according to the assignment sheet
	 playerH = dec.getDeck().remove(0);
	 compH = dec.getDeck().remove(0);
	int playerP = playerH.getRank();
	if (playerP == 10 || playerP == 11 || playerP == 12 || playerP == 13) {
		playerP = 0;
	}
	int compP = compH.getRank();
	if (compP == 10 || compP == 11 || compP == 12 || compP == 13) {
		compP = 0;
		}
	 playerH1 = dec.getDeck().remove(0);
	 compH1 = dec.getDeck().remove(0);
	int playerP1 = playerH1.getRank();
	if (playerP1 == 10 || playerP1 == 11 || playerP1 == 12 || playerP1 == 13) {
		playerP1 = 0;
	}
	int compP1 = compH1.getRank();
	if (compP1 == 10 || compP1 == 11 || compP1 == 12 || compP1 == 13) {
		compP1 = 0;
	}
int totalC = (compP + compP1)%10;
if (totalC ==18) {
	totalC = 8;
}
int totalP = (playerP + playerP1)%10;
if (totalP ==18) {
	totalP = 8;
}
	
	int[] totalarr = {totalC, totalP};
	return totalarr;
	}
	
	 /**
	   * Returns an array containing the total points of the player and the dealer.
	   * 
	   * @return the total points of the player and the dealer
	   */
	
	public static boolean method( int[] x) {
	int totalC = x[0];
	int totalP = x[1];
	boolean cardDraw ;

	int compP3 = 0;
	
	int playerP3 = 0;
	
if ( totalC == 8 || totalC == 9 || totalP == 8 || totalP == 9) {
	if (totalC ==18) {
	totalC = 8;
}
	
	if (totalP ==18) {
	totalP = 8;
}
	if (totalC>totalP) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		return gameWon = false;
	}
	
	else if (totalP> totalC) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
	
		return gameWon = true;
	}
	else {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
	
		gameTie = true;
		return gameWon = false;
		
	}
}
else if (totalP >= 0 && totalP<=5) {
	playerH3 = dec.getDeck().remove(0);
	playerP3 = playerH3.getRank();
	if (playerP3 == 10 || playerP3 == 11 || playerP3 == 12 || playerP3 == 13) {
		playerP3 = 0;
	}
	totalP = (totalP + playerP3)%10;
	System.out.println(playerP3);
	if (totalP ==18) {
	totalP = 8;
}
	cardDraw = true;
	if (((playerP3 == 2 || playerP3 == 3) && (cardDraw= true)) && (totalC <=4) ) {
	
		 compH3 = dec.getDeck().remove(0);
		 compP3 = compH3.getRank();
		totalC = (totalC + compP3)%10;
		if (totalC ==18) {
	 	totalC = 8;
	 }
	}
	else if (((playerP3 == 4 || playerP3 == 5) && (cardDraw= true)) && (totalC <=5) ) {
	
		 compH3 = dec.getDeck().remove(0);
		
		 compP3 = compH3.getRank();
			if ( compP3 == 10 || compP3 == 11 || compP3 == 12 || compP3 == 13) {
				 compP3= 0;
			}
		totalC = (totalC + compP3)%10;
		if (totalC ==18) {
	 	totalC = 8;
	 }
	}
	else if (((playerP3 == 6 || playerP3 == 7) && (cardDraw= true)) && (totalC <=6) ) {
	
		 compH3 = dec.getDeck().remove(0);
		 compP3 = compH3.getRank();
		 if ( compP3 == 10 || compP3 == 11 || compP3 == 12 || compP3 == 13) {
			 compP3= 0;
		}
		totalC = (totalC + compP3)%10;
		if (totalC ==18) {
	 	totalC = 8;
	 }
	}
	else if ((playerP3 == 8) && (cardDraw= true) && (totalC <=2) ) {
		
		 compH3 = dec.getDeck().remove(0);
		 compP3 = compH3.getRank();
		 if ( compP3 == 10 || compP3 == 11 || compP3 == 12 || compP3 == 13) {
			 compP3= 0;
		}
		totalC = (totalC + compP3)%10;
		if (totalC ==18) {
	 	totalC = 8;
	 }
	}
	else if (((playerP3 == 9) || (playerP3 == 10) || (playerP3 == 11) || (playerP3 == 12) || (playerP3 == 13)) && (totalC <= 3) ) {
	
		compH3 = dec.getDeck().remove(0);
		 compP3 = compH3.getRank();
		 if ( compP3 == 10 || compP3 == 11 || compP3 == 12 || compP3 == 13) {
			 compP3= 0;
		}
		totalC = (totalC + compP3)%10;
		if (totalC ==18) {
	 	totalC = 8;
	 }
	}
	
	
	if (totalC>totalP) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		return gameWon = false;
	
	
	}
	else if (totalP> totalC) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		return gameWon = true;
		
	}
	else {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		gameTie = true;
		return gameWon= false;
		
	}
	}
	
else {
	if (totalC>totalP) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		return gameWon= false;
	}
	else if (totalP> totalC) {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		return gameWon= true;
	}
	else {
		Displayformat(playerH, compH, playerH1, compH1, playerH3, compH3, totalP, totalC );
		
		gameTie = true;
		return gameWon= false;
	}
}




}
	
	
public static boolean getTie() {
	return gameTie; // returning if game is tied or not
}


/**
 * Displays the cards and the total points for the player and the dealer.
 * 
 * @param playerH the first card of the player
 * @param compH the first card of the dealer
 * @param playerH1 the second card of the player
 * @param compH1 the second card of the dealer
 * @param playerH3 the third card of the player
 * @param compH3 the third card of the dealer
 * @param totalP the total points of the player
 * @param totalC the total points of the dealer
 */


public static void Displayformat(Card a, Card b, Card c, Card d, Card e, Card f, int x, int y) {
	System.out.println("");
	System.out.println("+======================+======================+");
	System.out.printf("| %-20s | %-20s |\n", "Player","Computer");
	System.out.println("+======================+======================+");
	System.out.printf("| %-20s | %-20s |\n", a,b);
	System.out.println("+----------------------+----------------------+");
	System.out.printf("| %-20s | %-20s |\n", c,d);
	System.out.println("+----------------------+----------------------+");
	System.out.printf("| %-20s | %-20s |\n", e,f);
	System.out.println("+----------------------+----------------------+");
	System.out.printf("| %-20s | %-20s |\n", "total points "+ x, "total points " + y);
	System.out.println("+======================+======================+");
}
public static void PrintWin() {
	System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	System.out.println("\t $ Player Won $");
	System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
}
public static void Printloose() {
	System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	System.out.println("\t $ Player Lost $");
	System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
}
}

