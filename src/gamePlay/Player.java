package gamePlay;
import java.util.ArrayList;
import cards.*;
public class Player {
	
	private int credit;
	private int last_bet;
	private Hand hand;


	public Player(int _credit) {
		credit = _credit;
		
		// initialize bet to 5 as a default bet value
		last_bet = 5;

	}
	public void bet() {
		credit -= last_bet;
	}
	
	public void bet(int value) {
		credit -= value;
	}
	
	public int credit() {
		return credit;
	}
	
	public ArrayList<Card> getHand() {
		return hand._getHand();
	}
	
	public void setHand(ArrayList<Card> cards) {
		hand._setHand(cards);
	}
	
	public void setHand(ArrayList<Card> cards, Boolean hold_index[]) {
		hand._setHand(cards, hold_index);
	}


}
