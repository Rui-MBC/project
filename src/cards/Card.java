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
	
	public Card(char _suit, char _value) {
		// TODO Auto-generated constructor stub
	suit = _suit;
	value = _value;
	}
	
	public char value () {
		return value;
	}
	
	public char suit () {
		return suit;
	}
	
	public String toString() {
		return "suit is "+suit+" and value is "+ value+"\n";
	}


}
