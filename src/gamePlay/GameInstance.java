package gamePlay;
import java.util.ArrayList;

import cards.*;


public class GameInstance {
	
	Deck deck;
	GameRules rules;
	int inCred = 0;
	
	public GameInstance(String deckfile, int iniCred) {
		deck = new Deck(deckfile);
		inCred = iniCred;
		rules = new TenSevenDoubleBonus(iniCred);
	}
	
	public ArrayList<Card> deal(int nr_cards)
	{
		return deck.get_cards(nr_cards);
	}
	
	public boolean[] advice(Hand hand)
	{
		return 	rules.advice(hand);
	}
	
	public boolean[] statistics(Hand hand)
	{
		return 	rules.statistics(cards_analyze);
	}
	
	public String[] getHandValue(Hand _hand)
	{
		
		return 	rules.getHandValue(_hand);
	}
	
	public int bet_result(ArrayList<Card> cards_analyze)
	{
		return 	rules.play_hand;
	}
	
	public void prepareRound() {
		deck.reset();
	}

}
