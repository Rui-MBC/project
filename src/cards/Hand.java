package cards;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> handCards ; 
	
	public Hand() {
		handCards = new ArrayList<Card>();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Card> _getHand() {
		return handCards;
	}
	
	public void _setHand(ArrayList<Card> cards) {
		
		handCards.clear();

		handCards.addAll(cards);
	}
	
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
	
	public String toString() {
		
		String hand = "";
		for(int i=0; i<handCards.size();i++ ) {
			hand += (handCards.get(i).toString()+" ");
		}
		return hand;
	} 
	
	public Card get(int i)
	{
		return handCards.get(i);
	}
}
