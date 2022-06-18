package gamePlay;
import java.util.ArrayList;

import cards.*;

public class GameInstance {
	
	Deck deck;
	Rules rules;
	
	public GameInstance(String deckfile) {
		deck = new Deck(deckfile);
		rules = new TenSeven();
		
	}
	
	public ArrayList<Card> deal(int nr_cards)
	{
		return deck.get_cards(nr_cards);
	}
	
	public Boolean[] advice(ArrayList<Card> cards_analyze)
	{
		return 	rules.advice(cards_analyze);
	}

}
