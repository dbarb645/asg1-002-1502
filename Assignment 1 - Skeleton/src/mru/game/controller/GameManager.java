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

	/*
	 * In this class toy'll need these methods: A constructor A method to load the
	 * text file into an arraylist (if it exists, so you check if the txt file
	 * exists first) A save method to store the arraylist into the the txt file A
	 * method to search for a player based on their choice A method to find the top
	 * players Depending on your designing technique you may need and you can add
	 * more methods here
	 */

	// Initialize instance variables
	private int playerWins = 0;
	private static String name;
	private int balance = 100;
	private int count = 0;
	static File f = new File("res/CasinoInfo.txt");
	private static ArrayList<Player> arrList = new ArrayList<Player>();

	public GameManager() throws Exception {
		// Call the load file method and the display method when an instance is created
		loadFile();
		display();		
	}

	private void display() {
		
	}

	// Method to load the text file into an ArrayList
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

	// Method to save the ArrayList to the text file
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

	// Method to check if the entered name is in the ArrayList
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

	// Method to return the player object associated with the name
	public static Player nameCheck(String x) {
		for (Player p : arrList) {
			// If the name is found, return the Player object
			if (p.getName().equalsIgnoreCase(x)) {				
				return p;
			}
		}
		return null;
	}

	// Method to find the top 2 players

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



