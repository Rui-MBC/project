package gamePlay;
import java.util.ArrayList;

import cards.*;

/**
 * Instance of a game with a deck and the game rules
 * @author Group 46
 */
public class GameInstance {
	
	Deck deck;
	GameRules rules;
	int inCred = 0;
	/**
	 * GameInstace constructor <br>
	 * Initialize the Deck and the game rules to play
	 * @param deckfile File containing the deck
	 * @param iniCred Initial credit
	 */
	public GameInstance(String deckfile, int iniCred) {
		deck = new Deck(deckfile);
		inCred = iniCred;
		rules = new TenSevenDoubleBonus(iniCred);
	}
	
	/**
	 * Deal cards from the Deck
	 * @param nr_cards Number of cards to deal
	 * @return Cards dealt
	 */
	public ArrayList<Card> deal(int nr_cards)
	{
		return deck.get_cards(nr_cards);
	}
	/**
	 * Gets the game advice 
	 * @param hand players hand to analyze
	 * @return A boolean array. If true then keep that index card in hand, if false is to discard 
	 */
	public boolean[] advice(Hand hand)
	{
		return 	rules.advice(hand);
	}
	/**
	 * Gets the game statistics 
	 * @param credit Current player's credit
	 * @param betSum Sum of all bets
	 * @return A string containing game statistics
	 */
	public String statistics(int credit, int betSum)
	{
		return 	rules.getStatistics(credit,betSum);
	}
	
	/**
	 * Analyse the hand value 
	 * @param _hand Players hand to analyze
	 * @param bet Current bet
	 * @return A string array : <br> 
	 * 							String[0] earned credits <br>
	 *							String[1] wining play
	 */
	
	public String[] getHandValue(Hand _hand, int bet)
	{
		
		return 	rules.getHandValue(_hand, bet);
	}
	
	/**
	 * Prepare the next round by restarting the deck (get full deck and shuffle)
	 */
	
	public void prepareRound() {
		deck.reset();
	}

}
