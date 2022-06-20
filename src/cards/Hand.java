package cards;

import java.util.ArrayList;
/**
 * Provides utilities to create and handle a hand
 * 
 * @author Group 46
 */
public class Hand {
	
	private ArrayList<Card> handCards ; 
	/**
	 * Hand constructor <br>
	 * Initializes an array of cards for the hand 
	 */
	public Hand() {
		handCards = new ArrayList<Card>();
	}
	
	/**
	 * Returns the hand's cards
	 * @return ArrayList with the hand's cards
	 */
	public ArrayList<Card> _getHand() {
		return handCards;
	}
	
	/**
	 * Sets the initial hand
	 * @param cards ArrayList with the initial hand's cards
	 */
	public void _setHand(ArrayList<Card> cards) {
		
		handCards.clear();

		handCards.addAll(cards);
	}
	
	/**
	 * Replaces the discarded cards by new ones
	 * @param cards ArrayList with cards to replace in hand
	 * @param hold_bool A boolean array. If true then hold that index card in hand, else put the dealt cards
	 */
	public void _setHand(ArrayList<Card> cards,boolean hold_bool[]) {
		int deal_cards_counter = 0;
		for (int i=0;i<5;i++)
		{
			if (!hold_bool[i])
			{
				handCards.set(i, cards.get(deal_cards_counter));
				deal_cards_counter++;
			}
				
		}
	}
	
	/**
	 * Returns a String with the hand
	 * @return String with the hand
	 */
	public String toString() {
		
		String hand = "";
		for(int i=0; i<handCards.size();i++ ) {
			hand += (handCards.get(i).toString()+" ");
		}
		return hand;
	} 
	
	/**
	 * Returns the indexed card from the hand
	 * @param i Index of the card
	 * @return Indexed card from the hand
	 */
	public Card get(int i)
	{
		return handCards.get(i);
	}
}
