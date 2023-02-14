package mru.game.model;
public class Player {
	/**
	 * This class represent each player record in the Database It is basically a
	 * model class for each record in the txt file
	 */
	
	
	// Class done by Declan
	private String name;
	private int balance;
	private int nWins;
	public Player(String name, int balance, int nWins) {
		this.name = name;
		this.balance = balance;
		this.nWins = nWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setWins(int nWins) {
		this.nWins = nWins;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public int getnWins() {
		return nWins;
	}
	public String format() {
		return name+","+balance+","+nWins;
	}
	
	public String toString() {
		return "Welcome : " + name + " your balance is " + balance + " you have " + nWins + " wins ";
	}
	public String toString1() {
		return "Welcome Back : " + name + " your balance is " + balance + " you have " + nWins + " wins ";
	}
	public String toString2() {
		return name + " your balance is " + balance + " you have " + nWins + " wins ";
	}
}


