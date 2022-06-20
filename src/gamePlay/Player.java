package gamePlay;
import java.util.ArrayList;
import cards.*;
/**
 * Provides utilities to create and handle a player
 * @author Group 46
 */
public class Player {
	
	private int credit;
	private int last_bet;
	private Hand hand;
	private int bet_sum=0;
	/**
	 * Player constructor <br>
	 * Initialize a player with the initial credit, an empty hand and sets the default bet to 5
	 * @param _credit Initial player's credit
	 */

	public Player(int _credit) {
		credit = _credit;
		hand = new Hand();
		
		// initialize bet to 5 as a default bet value
		last_bet = 5;

	}
	
	/**
	 * Returns the last number of credits bet
	 * @return Credits bet
	 */
	public int getBet() {
		return last_bet;
	}
	
	/**
	 * Places a bet with the last bet value/default.
	 */
	public void bet() {
		credit -= last_bet;
		bet_sum += last_bet;
	}
	
	/**
	 * Places a bet with the input value
	 * @param value Number of credits to bet
	 */
	public void bet(int value) {
		last_bet = value;
		credit -= value;
		bet_sum += value;
	}
	
	/**
	 * Returns the current credit value
	 * @return Current credit value
	 */
	public int credit() {
		return credit;
	}
	
	/**
	 * Add credits to the player
	 * @param creditToAdd Number of credits to add
	 */
	public void addcredit(int creditToAdd) {
		credit += creditToAdd;
	}
	
	/**
	 * Returns the player's hand cards
	 * @return ArrayList of cards that corresponds to the player's hand
	 */
	public ArrayList<Card> getHand() {
		return hand._getHand();
	}
	
	/**
	 * Returns the player's hand 
	 * @return Player's hand
	 */
	public Hand getHandObject() {
		return hand;
	}
	
	/**
	 * Sets the player's card to be the ones given  
	 * @param cards ArrayList of cards for the hand 
	 */
	public void setHand(ArrayList<Card> cards) {
		hand._setHand(cards);
	}
	
	/**
	 * Replaces the discarded cards by new ones
	 * @param cards ArrayList of cards for the hand 
	 * @param hold_index A boolean array. If true then hold that index card in hand, else put the dealt cards
	 */
	public void setHand(ArrayList<Card> cards, boolean hold_index[]) {
		hand._setHand(cards, hold_index);
	}
	
	/**
	 * Prints the player's hand 
	 */
	public void printHand() {
		System.out.println("player's hand " + hand.toString());	
	}
	
	/**
	 * Prints the player's bet value
	 */
	public void printBet() {
			System.out.println("player is betting "+last_bet);
	}
	/**
	 * Returns the total amount of credits bet by the player
	 * @return Total amount of credits bet by the player
	 */
	public int getBetSum() {
		return bet_sum;
	}

}