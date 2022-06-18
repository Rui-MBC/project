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
	
	public boolean[] advice(ArrayList<Card> cards_analyze)
	{
		return 	rules.advice(cards_analyze);
	}
	
	public boolean[] statistics(ArrayList<Card> cards_analyze)
	{
		return 	rules.statistics(cards_analyze);
	}
	
	public string hand_result(ArrayList<Card> cards_analyze)
	{
		return 	rules.play_hand;
	}
	
	public int bet_result(ArrayList<Card> cards_analyze)
	{
		return 	rules.play_hand;
	}

}
