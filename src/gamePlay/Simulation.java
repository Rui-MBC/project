package gamePlay;
import java.util.ArrayList;


import cards.*;
/**
 * Simulation game mode
 * 
 * @author Group 46
 */

public class Simulation implements Game {
	
	private Player player ;
	private GameInstance instance;
	int bet;
	int nbdeals;
	/**
	 * Simulation constructor
	 * Initialize the Player, GameInstance, sets the bet value and the number of deals
	 * @param args Input arguments of application
	 */
	public Simulation(String[] args) {
		instance = new GameInstance("OG.deck",Integer.parseInt(args[1]));
		player = new Player(Integer.parseInt(args[1]));
		bet = Integer.parseInt(args[2]);
		nbdeals = Integer.parseInt(args[3]);
	}

	/**
	 * Plays the game in Simulation Mode
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Card> deal_cards; 
		String[] results;
		boolean hold_cards[] = new boolean[5];
		int n_cards_to_deal = 0;
		
		for(int i=0 ;i<nbdeals ;i++) {
			n_cards_to_deal = 0;
			instance.prepareRound();
			player.bet(bet);
			deal_cards = instance.deal(5);
			player.setHand(deal_cards);
			hold_cards = instance.advice(player.getHandObject());
			for(int j=0; j<5; j++) {
				if(!hold_cards[j]) {
					n_cards_to_deal++;					
				}
			}
			if(n_cards_to_deal != 0) {
				ArrayList<Card> rcvd_cards = instance.deal(n_cards_to_deal);
				player.setHand(rcvd_cards,hold_cards);
			}
			
			results = instance.getHandValue(player.getHandObject(),player.getBet());
			
			if (results[1] != null)
			{
				player.addcredit(Integer.parseInt(results[0]));
			}
			if(i==nbdeals-1) {
				System.out.print(instance.statistics(player.credit(),player.getBetSum()));
			}
		}
	}

}