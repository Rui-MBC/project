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
		
		for (int i=0;i<5;i++)
		{
			handCards.addAll(cards);
		}
	}
	
	public void _setHand(ArrayList<Card> cards,Boolean hold_bool[]) {
		
		for (int i=0;i<5;i++)
		{
			if (!hold_bool[i])
			{
				handCards.set(i, cards.get(i));
			}
				
		}
	}

}
