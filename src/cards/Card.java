/**
 * 
 */
package cards;

/**
 * @author ruimbc
 *
 */
public class Card {

	/**
	 * 
	 */
	
	private  char suit;
	private  char value;
	private int rank;
	
	public Card(char _suit, char _value) {
		// TODO Auto-generated constructor stub
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
	
	public char value () {
		return value;
	}
	
	public char suit () {
		return suit;
	}
	public int rank() {
		return rank;
	}
	
	public String toString() {
		return ""+value+suit;
	}


}
