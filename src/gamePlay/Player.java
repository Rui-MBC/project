package gamePlay;
import java.util.ArrayList;
import cards.*;
public class Player {
	
	private int credit;
	private int last_bet;
	private Hand hand;


	public Player(int _credit) {
		credit = _credit;
		hand = new Hand();
		// initialize bet to 5 as a default bet value
		last_bet = 5;

	}
	public int getBet() {
		return last_bet;
	}
	public void bet() {
		credit -= last_bet;
	}
	
	public void bet(int value) {
		last_bet = value;
		credit -= value;
	}
	
	public int credit() {
		return credit;
	}
	
	public void addcredit(int creditToAdd) {
		credit += creditToAdd;
	}
	
	public ArrayList<Card> getHand() {
		return hand._getHand();
	}
	
	public Hand getHandObject() {
		return hand;
	}
	
	public void setHand(ArrayList<Card> cards) {
		hand._setHand(cards);
	}
	
	public void setHand(ArrayList<Card> cards, boolean hold_index[]) {
		hand._setHand(cards, hold_index);
	}
	
	public void printHand() {
		System.out.print("player's hand " + hand.toString());	
	}
	
	public void printBet() {
			System.out.println("player is betting "+last_bet);
	}


}
