package cards;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Provides utilities to create and handle a deck
 * 
 * @author Group 46
 */
public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	int deck_pointer = 0;
	/**
	 * Deck constructor <br>
	 * Creates a deck based on a deck file <br>
	 * @param fileName Deck file's name
	 */
	public Deck(String fileName) {
		System.out.println("\n"+fileName);
		String curr_line;
		String[] parts;
		File file_cmd = new File( "../Decks/" + fileName);
		Scanner deck_list = null;
		try {
			deck_list = new Scanner(file_cmd);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Cmd file
		curr_line = deck_list.nextLine();
		parts = curr_line.split(" ");
		
		for ( int i = 0; i < parts.length; i++)
		{
			deck.add(new Card(parts[i].charAt(0), parts[i].charAt(1)));
			System.out.print(parts[i].charAt(0));
			System.out.print(parts[i].charAt(1));
			System.out.print(" ");
		}
		
		System.out.print("\n");
		
	}
	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);		
	}
	/**
	 * Returns a String with the deck
	 * @return String with the deck
	 */
	@Override
	public String toString() {
		return ""+deck;
	}
	
	/**
	 * Draws cards from the deck
	 * @param nr_cards Number of cards to draw
	 * @return ArrayList of the cards drawn
	 */
	public ArrayList<Card> get_cards(int nr_cards)
	{
		ArrayList<Card> get_aux = new ArrayList<Card>();
		for (int i = 0; i < nr_cards; i++ )
		{
			get_aux.add(deck.get(deck_pointer+i));//set(i, deck.get(deck_pointer+i));
		}
		
		deck_pointer += nr_cards;
		
		return get_aux;
	}
	/**
	 * Restarts the original deck and shuffles it
	 */
	public void reset() {
		deck_pointer = 0;
		shuffle();
	}

}
