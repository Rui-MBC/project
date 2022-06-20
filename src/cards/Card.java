/**
 * 
 */
package cards;

/**
 * Provides utilities to create and handle a card
 * 
 * @author Group 46
 */
public class Card {	
	private  char suit;
	private  char value;
	private int rank;
	
	/**
	 * Card constructor <br>
	 * Initialize a card with a suit, value and rank <br>
	 * (The rank goes from 2 to 14)
	 * @param _value Card value
	 * @param _suit Card suit
	 */
	public Card(char _value, char _suit) {

	suit = _suit;
	value = _value;
	if (value =='T') {
		rank = 10;
	}
	else if (value =='J') {
		rank = 11;
	}
	else if (value =='Q') {
		rank = 12;
	}
	else if (value =='K') {
		rank = 13;
	}
	else if (value =='A') {
		rank = 14;
	}
	else {
		rank  = Character.getNumericValue(value);	}
	
	}
	
	/**
	 * Returns card's value
	 * @return Card's value
	 */
	public char value () {
		return value;
	}
	
	/**
	 * Returns card's suit
	 * @return Card's suit
	 */
	public char suit () {
		return suit;
	}
	
	/**
	 * Returns card's rank
	 * @return Card's rank
	 */
	public int rank() {
		return rank;
	}
	
	/**
	 * Returns a String with the format "cardValue_cardSuit"
	 * @return String of the card
	 */
	public String toString() {
		return ""+value+suit;
	}


}
