package gamePlay;
import java.util.ArrayList;
import cards.Card;
import cards.Hand;
import java.util.Arrays;
import java.util.Collections;




public class TenSevenDoubleBonus implements GameRules {
	
	private int[] sortedHandIndexes = {0,1,2,3,4}; ///originalIndex
	
	
	private static int[][] creditMatrix = {
			{250, 500, 750, 1000, 4000}, //Royal Flush
			{ 50, 100, 150,  200,  250}, //Straight Flush
			{160, 320, 480,  640,  800}, //Four Aces
			{ 80, 160, 240,  320,  400}, //Four 2-4  
			{ 50, 100, 150,  200,  250}, //Four 5-K
			{ 10,  20,  30,   40,   50}, //Full House
			{  7,  14,  21,   28,   35}, //Flush
			{  5,  10,  15,   20,   25}, //Straight
			{  3,   6,  12,   18,   24}, //Three of a Kind
			{  1,   2,   3,    4,    5}, //Two Pair
			{  1,   2,   3,    4,    5}  //Jacks or Better
			
	};
	
	
	private String[] nameArray= {"Royal Flush", "Straight Flush", 
			"Four Aces", "Four 2 to 4", "Four 5 to K", "Full House", "Flush", "Straight", 
			"Three of a Kind", "Two Pair", "Jacks or Better"};
	private static int statJacksOrBetter = 0;
	private static int statTwoPair = 0;
	private static int statThreeOfAKind = 0;
	private static int statStraight = 0;
	private static int statFlush = 0;
	private static int statFullHouse = 0;
	private static int statFourOfAKind = 0;
	private static int statStraightFlush = 0;
	private static int statRoyalFlush = 0;

	private static int statHandCount = 0;
	private static int statTotalWin = 0;
	private static int statOther = 0;

	private int initialCredit;

	public TenSevenDoubleBonus(int _initialCredit){
		initialCredit = _initialCredit;
	}
	
	
	
	
	

	public boolean[] advice(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[]  getHandvalue(Hand hand, int bet) {
		
		String[] returnArray= new String[2];
		
		returnArray[0] = String.valueOf(0);
		returnArray[1] = null;
		
		
		if(royalFlush(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][0] );
			returnArray[1] = nameArray[0];
		}
		else if(straightFlush(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][1] );
			returnArray[1] = nameArray[1];
		}
		else if(fourAces(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][2] );
			returnArray[1] = nameArray[2];
		}
		else if(four2to4(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][3] );
			returnArray[1] = nameArray[3];
		}
		else if(four5toK(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][4] );
			returnArray[1] = nameArray[4];
		}
		else if(fullHouse(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][5] );
			returnArray[1] = nameArray[5];
		}
		else if(flush(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][6] );
			returnArray[1] = nameArray[6];
		}
		else if(straight(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][7] );
			returnArray[1] = nameArray[7];
		}
		else if(threeOfAKind(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][8] );
			returnArray[1] = nameArray[8];
		}
		else if(twoPair(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][9] );
			returnArray[1] = nameArray[9];
		}
		else if(jacksOrBetter(hand)[5] ==true) {
			returnArray[0]= String.valueOf( creditMatrix[bet-1][10] );
			returnArray[1] = nameArray[10];
		}
		return returnArray;
	}
	
	
	@Override
	public String getStatistics(int credit) {

		return "\nHand             "+statHandCount+
		       "\n______________________"+
		       "\nJacks or Better  "+statJacksOrBetter+
		       "\nTwo Pair         "+statTwoPair+
		       "\nThree Of A Kind  "+statThreeOfAKind+
		       "\nStraight         "+statStraight+
		       "\nFlush            "+statFlush+
		       "\nFull House       "+statFullHouse+
		       "\nFour Of A Kind   "+statFourOfAKind+
		       "\nStraight Flush   "+statStraightFlush+
		       "\nRoyal Flush      "+statRoyalFlush+
		       "\nOther            "+statOther+
		       "\n______________________"+
		       "\nTotal            "+statTotalWin+
		       "\n______________________"+
		       "\nCredit           "+credit+"   "+(credit / initialCredit);
	}
	
	private boolean[] royalFlush(Hand hand) {
		char[] valueArray = new char[] {'T','J','Q','K','A'};
		boolean[] returnArray = new boolean[6];
		
		if(hand.get(0).suit() == hand.get(1).suit()
				&& hand.get(0).suit()==hand.get(2).suit()
				&& hand.get(0).suit()==hand.get(3).suit()
				&& hand.get(0).suit()==hand.get(4).suit()) {
			for(char s : valueArray) {
				if(s == hand.get(0).value() || 
						s == hand.get(1).value() ||
						s == hand.get(2).value() ||
						s == hand.get(3).value() ||
						s == hand.get(4).value()) {
					
				}
				else {
					Arrays.fill(returnArray,false) ;
					
				}
			}
			Arrays.fill(returnArray,true) ;

			
		}
		else {
			Arrays.fill(returnArray,false) ;
		}
		
		return returnArray;
		
	}
	
	private boolean[] straightFlush(Hand hand) {
		
	}
	
	private boolean[] fourAces(Hand hand) {
		int aceCounter = 0;
		boolean[] returnArray = new boolean[6];
	
		for (int i = 0 ; i < 5 ; i++) {
			if(hand.get(i).value() == 'A') {
			 aceCounter ++;	
			}
		}
		if (aceCounter >3) {
			Arrays.fill(returnArray,true) ;			
		}
		else {
			Arrays.fill(returnArray,false) ;
		}
		return returnArray;
		
	}
	private boolean[] four2to4(Hand hand) {
		
		
	}
	private boolean[] four5toK(Hand hand) {
		
	}
	private boolean[] fullHouse(Hand hand) {
		
	}
	private boolean[] flush(Hand hand) {
		
	}
	private boolean[] straight(Hand hand) {
		
	}
	private boolean[] threeOfAKind(Hand hand) {
		
	}
	private boolean[] twoPair(Hand hand) {
		
	}
	private boolean[] jacksOrBetter(Hand hand) {
		
	}
	
	
	
	private ArrayList<Card> sortByRank(Hand hand) {
		int auxIndex = 0;

		ArrayList<Card> aux = new ArrayList<Card>();

		
		aux = hand._getHand();
		
		
		
		for (int i = 0;i < 5; i++) {
			
			for (int j = i ; j<5 ; j++) {
				if(aux.get(j).rank() <aux.get(i).rank()) {
					
					auxIndex = sortedHandIndexes[i];
					sortedHandIndexes[i] = sortedHandIndexes[j];
					sortedHandIndexes[j]= auxIndex;
					Collections.swap(aux, i, j);
				}
			}
			
		}
		
	}
	
	








}