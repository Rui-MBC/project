package gamePlay;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cards.*;


public class Simulation implements Game {
	
	private Player player ;
	private GameInstance instance;
	int bet;
	int nbdeals;
	
	public Simulation(String[] args) {
		instance = new GameInstance("OG.deck",Integer.parseInt(args[1]));
		player = new Player(Integer.parseInt(args[1]));
		bet = Integer.parseInt(args[2]);
		nbdeals = Integer.parseInt(args[3]);
	}

	/**
	 *
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Card> deal_cards; 
		String[] results;
		boolean hold_cards[] = new boolean[5];
		int n_cards_to_deal = 0;
		
		for(int i=0 ;i<nbdeals ;i++) {
			instance.prepareRound();
			player.bet(bet);
			deal_cards = instance.deal(5);
			player.setHand(deal_cards);
			hold_cards = instance.advice(player.getHandObject());
			for(int j=0; j<5; j++) {
				if(!hold_cards[i]) {
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
			if(i==nbdeals) {
				instance.statistics(player.credit());
			}
		}
	}

}