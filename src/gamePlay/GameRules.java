package gamePlay;
import cards.*;

/**
 * GameRules Interface
 * @author Group 46
 */
public interface GameRules {
	/**
	 * Based on the hand advises the best cards to hold when playing the 10/7 Double Bonus
	 * @param hand Player's hand
	 * @return A boolean array. If true then hold that index card in hand, else discard 
	 */
	public boolean[] advice(Hand hand);
	
	/**
	 * Analyse the hand value
	 * @param hand Players hand to analyze
	 * @param bet Current bet
	 * @return A string array : <br> 
	 * 							String[0] earned credits <br>
	 *							String[1] wining play
	 */
	public String[]  getHandValue(Hand hand, int bet);
	
	/**
	 * Gets the game statistics 
	 * @param credit Current player's credit
	 * @param betSum Sum of all bets
	 * @return A string containing game statistics
	 */
	public String getStatistics(int credit, int betSum);
}
