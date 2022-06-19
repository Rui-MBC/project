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

	private static int statTotalCount = 0;
	private static int statTotalWin = 0;
	private static int statOther = 0;

	private int initialCredit;

	public TenSevenDoubleBonus(int _initialCredit){
		initialCredit = _initialCredit;
	}
	
	public boolean[] advice(Hand hand) {
		
		System.out.println("inAdvice");
		
		boolean[] returnArray = new boolean[5];
		boolean[] result = new boolean[6];
		Arrays.fill(result, false);
		
		
		if(starightFlush_FourOfAKind_RoyalFlush(hand)[5]) 			//1
			result = starightFlush_FourOfAKind_RoyalFlush(hand); 
		
		else if(fourToRoyalFlush(hand)[5]) 							//2
			result = fourToRoyalFlush(hand); 
		
		else if(threeAces(hand)[5]) 								//3
			result = threeAces(hand); 
		
		else if(staright_Flush_FullHouse(hand)[5]) 					//4
			result = staright_Flush_FullHouse(hand); 
		
		else if(threeOfAKind(hand)[5]) 								//5
			result = threeOfAKind(hand); 
		
		else if(fourToStraightFlush(hand)[5]) 						//6
			result = fourToStraightFlush(hand); 
		
		else if(twoPair(hand)[5]) 									//7
			result = twoPair(hand); 
		
		else if(jacksOrBetter(hand)[5]) 							//8
			result = jacksOrBetter(hand); 
		
		else if(fourToFlush(hand)[5]) 								//9
			result = fourToFlush(hand); 
		
		else if(threeToRoyalFlush(hand)[5]) 						//10
			result = threeToRoyalFlush(hand); 
		
		else if(fourToOutsideStraight(hand)[5]) 					//11
			result = fourToOutsideStraight(hand); 
		
		else if(lowPair(hand)[5]) //12
			result = lowPair(hand); 
		
		else if(unsuitedAKQJ(hand)[5]) //13
			result = unsuitedAKQJ(hand); 
		
		else if(threeToStraightFlushType1(hand)[5]) //14
			result = threeToStraightFlushType1(hand); 
		
		else if(fourToInsideStraight3HighCards(hand)[5]) //15
			result = fourToInsideStraight3HighCards(hand); 
		
		else if(suitedQJ(hand)[5]) //16
			result = suitedQJ(hand); 
		
		else if(threeToFlushWithtwoHighCards(hand)[5]) //17
			result = threeToFlushWithtwoHighCards(hand); 
		
		else if(twoSuitedHighCards(hand)[5]) //18
			result = twoSuitedHighCards(hand); 
		
		else if(fourToAnInsideStraightWithTwoHighCards(hand)[5]) //19
			result = fourToAnInsideStraightWithTwoHighCards(hand); 
		
		else if(threeToStraightFlushType2(hand)[5]) //20
			result = threeToStraightFlushType2(hand); 
		
		else if(fourToAnInsideStraightWithOneHighCard(hand)[5]) //21
			result = fourToAnInsideStraightWithOneHighCard(hand); 
		
		else if(unsuitedKQJ(hand)[5]) //22
			result = unsuitedKQJ(hand); 
		
		else if(suitedJT(hand)[5]) //23
			result = suitedJT(hand); 
		
		else if(unsuitedQJ(hand)[5]) //24
			result = unsuitedQJ(hand); 
		
		else if(threeToFlushWithOneHighCard(hand)[5]) //25
			result = threeToFlushWithOneHighCard(hand); 
		
		else if(suitedQT(hand)[5]) //26
			result = suitedQT(hand); 
		
		else if(threeToStraightFlushType3(hand)[5]) //27 
			result = threeToStraightFlushType3(hand); 
		
		else if(KQorKJUnsuited(hand)[5]) //28
			result = KQorKJUnsuited(hand); 
		
		else if(Ace(hand)[5]) //29
			result = Ace(hand); 
		
		else if(KTsuited(hand)[5]) //30
			result = KTsuited(hand); 
		
		else if(JackQueenKing(hand)[5]) //31
			result = JackQueenKing(hand); 
		
		else if(fourToInsideStraightWithNoHighCards(hand)[5]) //32
			result = fourToInsideStraightWithNoHighCards(hand); 
		
		else if(threeToAFlushWithNoHighCards(hand)[5]) //33
			result = threeToAFlushWithNoHighCards(hand); 
		
		returnArray =Arrays.copyOfRange(result, 0, 5); 
		
		return returnArray;
	}
	
	

	public String[]  getHandValue(Hand hand, int bet) {
		
		String[] returnArray= new String[2];
		
		returnArray[0] = String.valueOf(0);
		returnArray[1] = null;
		statTotalCount++;
		
		if(royalFlush(hand)[5] ==true) {
			statRoyalFlush ++ ;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][0] );
			returnArray[1] = nameArray[0];
		}
		else if(straightFlush(hand)[5] ==true) {
			statStraightFlush++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][1] );
			returnArray[1] = nameArray[1];
		}
		else if(fourAces(hand)[5] ==true) {
			statFourOfAKind++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][2] );
			returnArray[1] = nameArray[2];
		}
		else if(four2to4(hand)[5] ==true) {
			statFourOfAKind++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][3] );
			returnArray[1] = nameArray[3];
		}
		else if(four5toK(hand)[5] ==true) {
			statFourOfAKind++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][4] );
			returnArray[1] = nameArray[4];
		}
		else if(fullHouse(hand)[5] ==true) {
			statFullHouse++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][5] );
			returnArray[1] = nameArray[5];
		}
		else if(flush(hand)[5] ==true) {
			statFlush++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][6] );
			returnArray[1] = nameArray[6];
		}
		else if(straight(hand)[5] ==true) {
			statStraight++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][7] );
			returnArray[1] = nameArray[7];
		}
		else if(threeOfAKind(hand)[5] ==true) {
			statThreeOfAKind++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][8] );
			returnArray[1] = nameArray[8];
		}
		else if(twoPair(hand)[5] ==true) {
			statTwoPair++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][9] );
			returnArray[1] = nameArray[9];
		}
		else if(jacksOrBetter(hand)[5] ==true) {
			statJacksOrBetter++;
			returnArray[0]= String.valueOf( creditMatrix[bet-1][10] );
			returnArray[1] = nameArray[10];
		}
		
		if(returnArray[0] == "0") 
			statOther++;
		else 
			statTotalWin++;
		return returnArray;
	}
		
	@Override
	public String getStatistics(int credit) {

		return "\nHand             "+statTotalCount+
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
		boolean[] returnArray = new boolean[6];

		if(straight(hand)[5] && flush(hand)[5]) {
			Arrays.fill(returnArray,true) ;

		}
		else Arrays.fill(returnArray,false) ;
		
		return returnArray;

		
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
		boolean[] returnArray = new boolean[6];

		ArrayList<Card> sortedHand = sortByRank(hand);
		
		if(sortedHand.get(0).rank() == sortedHand.get(1).rank()
				&& sortedHand.get(0).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(0).rank()==sortedHand.get(3).rank()) {
			if(sortedHand.get(1).rank()<5) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[4]]=false;
			}
			
		}
		else if(sortedHand.get(1).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(1).rank()==sortedHand.get(3).rank()
				&& sortedHand.get(1).rank()==sortedHand.get(4).rank()) {
			if(sortedHand.get(1).rank()<5) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[0]]=false;
			}
			
		}
		else 	Arrays.fill(returnArray,false) ;

		return returnArray;
		
	}
	
	
	private boolean[] four5toK(Hand hand) {
		boolean[] returnArray = new boolean[6];

		ArrayList<Card> sortedHand = sortByRank(hand);
		
		if(sortedHand.get(0).rank() == sortedHand.get(1).rank()
				&& sortedHand.get(0).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(0).rank()==sortedHand.get(3).rank()) {
			if(4<sortedHand.get(1).rank()&&sortedHand.get(1).rank()<14) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[4]]=false;
			}
			
		}
		else if(sortedHand.get(1).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(1).rank()==sortedHand.get(3).rank()
				&& sortedHand.get(1).rank()==sortedHand.get(4).rank()) {
			if(4<sortedHand.get(1).rank()&&sortedHand.get(1).rank()<14) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[0]]=false;
			}
			
		}
		else 	Arrays.fill(returnArray,false) ;

		return returnArray;
		
		
	}
	
	private boolean[] fullHouse(Hand hand) {
		
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortByRank(hand);
		if(sortedHand.get(0).rank() == sortedHand.get(1).rank()
				&& sortedHand.get(0).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(3).rank()==sortedHand.get(4).rank()) {
			Arrays.fill(returnArray,true) ;

			
		}else 		if(sortedHand.get(0).rank() == sortedHand.get(1).rank()
				&& sortedHand.get(3).rank()==sortedHand.get(2).rank()
				&& sortedHand.get(3).rank()==sortedHand.get(4).rank()) {
			Arrays.fill(returnArray,true) ;

			
		} else Arrays.fill(returnArray,false) ;
		
		return returnArray;

		

		
	}
	
	private boolean[] flush(Hand hand) {
		
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortBySuit(hand);
		
		if(sortedHand.get(0).suit() == sortedHand.get(4).suit()) {
			Arrays.fill(returnArray, true);
		}else
			Arrays.fill(returnArray, false);
		return returnArray;
		
	}
	
	private boolean[] straight(Hand hand) {
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortByRank(hand);
		
		if(sortedHand.get(4).rank()==14) {
			if(sortedHand.get(0).rank()==10 &&
					sortedHand.get(1).rank()==11 &&
					sortedHand.get(2).rank()==12 &&
					sortedHand.get(3).rank()==13) {
				
				Arrays.fill(returnArray, true);
	
			}else if(sortedHand.get(0).rank()==2 &&
					sortedHand.get(1).rank()==3 &&
					sortedHand.get(2).rank()==4 &&
					sortedHand.get(3).rank()==5) {
				Arrays.fill(returnArray, true);
				
			}
			
		}else {
			int testRank = sortedHand.get(0).rank()+1;
			for(int i = 1; i < 5; i++) {
				if(sortedHand.get(i).rank()!= testRank) {
					Arrays.fill(returnArray, false);
					return returnArray;
				}else testRank++;
			}
			Arrays.fill(returnArray, true);			
		}
		return returnArray;

		
	}
	
	private boolean[] threeOfAKind(Hand hand) {
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortByRank(hand);
		if(sortedHand.get(0).rank() == sortedHand.get(1).rank() &&
				sortedHand.get(1).rank() == sortedHand.get(2).rank()) {
			Arrays.fill(returnArray,true) ;
			returnArray[sortedHandIndexes[3]]=false;
			returnArray[sortedHandIndexes[4]]=false;
		}
		else if(sortedHand.get(1).rank() == sortedHand.get(2).rank() &&
				sortedHand.get(2).rank() == sortedHand.get(3).rank()) {
			Arrays.fill(returnArray,true) ;
			returnArray[sortedHandIndexes[0]]=false;
			returnArray[sortedHandIndexes[4]]=false;
		}
		else if(sortedHand.get(2).rank() == sortedHand.get(3).rank() &&
				sortedHand.get(3).rank() == sortedHand.get(4).rank()) {
			Arrays.fill(returnArray,true) ;
			returnArray[sortedHandIndexes[0]]=false;
			returnArray[sortedHandIndexes[1]]=false;
		}
		else Arrays.fill(returnArray, false);
		return returnArray;
		
	}
	
	private boolean[] twoPair(Hand hand) {
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortByRank(hand);
		
		if(sortedHand.get(0).rank() == sortedHand.get(1).rank()) {
			if(sortedHand.get(2).rank() == sortedHand.get(3).rank()) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[4]]=false;	
			}
			else if(sortedHand.get(3).rank() == sortedHand.get(4).rank()) {
				Arrays.fill(returnArray,true) ;
				returnArray[sortedHandIndexes[2]]=false;	
			}

			
		}
		else if(sortedHand.get(1).rank() == sortedHand.get(2).rank()) {
			Arrays.fill(returnArray,true) ;
			returnArray[sortedHandIndexes[0]]=false;	
		}
		else
			Arrays.fill(returnArray, false);
		
		return returnArray;

		
	}
	
	private boolean[] jacksOrBetter(Hand hand) {
		boolean[] returnArray = new boolean[6];
		ArrayList<Card> sortedHand = sortByRank(hand);
		for(int i = 0; i < 4 ; i++) {
			Arrays.fill(returnArray,false) ;
			if(sortedHand.get(i).rank() >10) {
				if(sortedHand.get(i).rank()==sortedHand.get(i+1).rank()) {
					
					returnArray[5]=true;	
					returnArray[sortedHandIndexes[i]]=true;	
					returnArray[sortedHandIndexes[i+1]]=true;
					break;
					
				}
				
			}
		}
		
		return returnArray;
	}
	
	private ArrayList<Card> sortByRank(Hand hand) {
		System.out.println("hand = "+hand);
		int auxIndex = 0;

		ArrayList<Card> aux = new ArrayList<Card>();

		
		aux = hand._getHand();
		
		System.out.println("aux = "+ aux);
		
		
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
		return aux;
	}
	
	private ArrayList<Card> sortBySuit(Hand hand){
		System.out.println("hand = "+hand);
		int auxIndex = 0;
		ArrayList<Card> aux = new ArrayList<Card>();		
		aux = hand._getHand();
		System.out.println("aux = "+ aux);
		for (int i = 0;i < 5; i++) {
			
			for (int j = i ; j<5 ; j++) {
				if(aux.get(j).suit() < aux.get(i).suit()) {
					
					auxIndex = sortedHandIndexes[i];
					sortedHandIndexes[i] = sortedHandIndexes[j];
					sortedHandIndexes[j]= auxIndex;
					Collections.swap(aux, i, j);
				}
			}
			
		}
		return aux;

	}
	
	//1
	private boolean[] starightFlush_FourOfAKind_RoyalFlush(Hand hand) {
		boolean[] returnArray = new boolean[6];
		boolean[] ret = new boolean[6];
		returnArray = straightFlush(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}
		returnArray = fourAces(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}

		returnArray = four2to4(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}
		returnArray = four5toK(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}

		returnArray = royalFlush(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}
		return ret;	
	}
	
	
	///2
	private boolean[] fourToRoyalFlush(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		if(sortedHand.get(0).suit() == sortedHand.get(3).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[4]]=false;	
			for(int i = 0 ; i < 4; i++) {	
					if(sortedHand.get(i).rank()<=9) {
						Arrays.fill(returnArray, false);
						break;
					}
				
			}
			
		}
		else if(	sortedHand.get(1).suit() == sortedHand.get(4).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[0]]=false;	
			for(int i = 1 ; i < 5; i++) {	
					if(sortedHand.get(i).rank()<=9) {
						Arrays.fill(returnArray, false);
						break;
					}
				
			}
			
		}
		return returnArray;
		
	}
	
	////3
	private boolean[] threeAces(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);

		if(sortedHand.get(2).rank()==14) {
			Arrays.fill(returnArray, true);
			returnArray[0]=false;
			returnArray[1]=false;
			
		}
		return returnArray;
		
	}
		
	///4
	private boolean[] staright_Flush_FullHouse(Hand hand) {
		boolean[] returnArray = new boolean[6];
		boolean[] ret = new boolean[6];
		Arrays.fill(ret, false);
		
		returnArray = straight(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}
		returnArray = fullHouse(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}

		returnArray = flush(hand);
		if(returnArray[5]) {
			ret = returnArray;
		}
		
	
		return ret;	
	}
	
	////5 is threeOfAKind(hand)
	
	//// 6   
	private boolean[] fourToStraightFlush(Hand hand) {
		
		boolean[] fourToFlush = fourToFlush(hand);
		boolean[] fourToOutsideStraight = fourToOutsideStraight(hand);
		boolean[] fourToAnInsideStraight = fourToAnInsideStraight(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
	
		if(fourToFlush[5]) {
			if(fourToOutsideStraight[5]) {
				if(fourToFlush == fourToOutsideStraight) {
					returnArray = fourToFlush;
				}		
			}
			else
			if(fourToAnInsideStraight[5]) {
				if(fourToFlush == fourToAnInsideStraight) {
					returnArray = fourToFlush;
				}			
			}
		}
		return returnArray;	
	}
	
	///7 is twoPair
	
	////8 is jacksOrBetter
	
	//9
	private boolean[] fourToFlush(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray,false);

		if(sortedHand.get(0).suit() == sortedHand.get(3).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[4]]=false;
		}
		else if(sortedHand.get(1).suit() == sortedHand.get(4).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[0]]=false;
		}
		
		return returnArray;
	}
	
	
	//10
	private boolean[] threeToRoyalFlush(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		if(sortedHand.get(0).suit() == sortedHand.get(2).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[3]]=false;	
			returnArray[sortedHandIndexes[4]]=false;	
			for(int i = 0 ; i < 3; i++) {	
					if(sortedHand.get(i).rank()<=9) {
						Arrays.fill(returnArray, false);
						break;
					}
				
			}
			
		}
		else if(	sortedHand.get(1).suit() == sortedHand.get(3).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[0]]=false;	
			returnArray[sortedHandIndexes[4]]=false;	
			for(int i = 1 ; i < 4; i++) {	
					if(sortedHand.get(i).rank()<=9) {
						Arrays.fill(returnArray, false);
						break;
					}
				
			}
			
		}
		else if(	sortedHand.get(2).suit() == sortedHand.get(4).suit()) {
			Arrays.fill(returnArray,true);
			returnArray[sortedHandIndexes[0]]=false;	
			returnArray[sortedHandIndexes[1]]=false;	
			for(int i = 1 ; i < 5; i++) {	
					if(sortedHand.get(i).rank()<=9) {
						Arrays.fill(returnArray, false);
						break;
					}
				
			}
			
		}
		return returnArray;
		
	}
	
	//11
	private boolean[] fourToOutsideStraight(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		int smallVal=1;

		
		int testRank = sortedHand.get(0).rank()+1;
		for(int i = 1; i < 4; i++) {
			if(sortedHand.get(i).rank()!= testRank) {
				smallVal = 0;
				break;
			}else testRank++;
		}
		if(smallVal==0) {
			testRank = sortedHand.get(1).rank()+1;
			for(int i = 2; i < 5; i++) {
				if(sortedHand.get(i).rank()!= testRank) {
					Arrays.fill(returnArray, false);
					break;
				}else testRank++;
			}
			Arrays.fill(returnArray, true);
			returnArray[sortedHandIndexes[0]]=false;
		}
		else {
			Arrays.fill(returnArray, true);
			returnArray[sortedHandIndexes[4]]=false;
		}
		return returnArray;
		
	}
	
	//12
	private boolean[] lowPair(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);

		for (int i = 0 ;i < 4; i++) {
			if (sortedHand.get(i).rank()==sortedHand.get(i+1).rank() &&
					sortedHand.get(i).rank()<11) {
				returnArray[5]=true;
				returnArray[sortedHandIndexes[i]]=true;
				returnArray[sortedHandIndexes[i+1]]=true;
				break;
			}
		}
		return returnArray;
	}
	
	//13
	private boolean[] unsuitedAKQJ(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		if(sortedHand.get(4).rank() ==14 &&
				sortedHand.get(3).rank() ==13 &&
				sortedHand.get(2).rank() ==12 &&
				sortedHand.get(1).rank() ==11 ) {
			Arrays.fill(returnArray, true);
			returnArray[sortedHandIndexes[0]]=false;
			
		}
		return returnArray;

	}
	
	//14
	private boolean[] threeToStraightFlushType1(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		
		boolean aux_array[];
		int highCounter = 0;
		
		aux_array = ThreeToStraight(hand);
		
		if (aux_array[5] == true)
		{
			for(int i = 4; i >= 0; i--) 
			 {
				if(aux_array[i] == true && hand.get(i).rank() > 10)
				{
					highCounter++;
				}
				
				if (highCounter >= 3)
				{
					return aux_array;
				}
			 }
		}
		
		else return returnArray;
		
		return returnArray;
	}
		
	//15
	private boolean[] fourToInsideStraight3HighCards(Hand hand) {
		boolean[] fourToAnInsideStraight = fourToAnInsideStraight(hand);
		boolean[] returnArray = new boolean[6];
		int highCardCounter = 0;
		Arrays.fill(returnArray, false);
		if(!fourToAnInsideStraight[5]) 
			return returnArray;
		for (int i = 0; i < 5; i++) {
			if(fourToAnInsideStraight[i]) {
				if(hand.get(i).rank()<10) highCardCounter++;
			}
		}
		
		if(highCardCounter > 2)
			returnArray = fourToAnInsideStraight;
		
		return returnArray;
	}
		
	//16
	private boolean[] suitedQJ(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		boolean flagFound = false;
		
		for (int i = 0 ; i < 4; i++) {
			if(sortedHand.get(i).rank()!=12 && 
					sortedHand.get(i).rank()!=11) continue;
			char suit = sortedHand.get(i).suit();
			for(int j = i+1 ; j<5; j++) {
				if(suit == sortedHand.get(j).suit()) {
					if(sortedHand.get(j).rank() ==12  ||
							sortedHand.get(j).rank() ==11) {
						returnArray[5]=true;
						returnArray[sortedHandIndexes[i]]=true;
						returnArray[sortedHandIndexes[j]]=true;
						flagFound = true;
						break;
					}
				}else break;
			}
			if(flagFound)break;
		}
		return returnArray;
		
	}
	
	//17
	private boolean[] threeToFlushWithtwoHighCards(Hand hand) {
		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		int counter=0;
		
		if(sortedHand.get(0).suit() == sortedHand.get(2).suit()) {
			
			if(sortedHand.get(0).rank() >10) counter++;
			if(sortedHand.get(1).rank() >10) counter++;
			if(sortedHand.get(2).rank() >10) counter++;
			if (counter >1) {
				Arrays.fill(returnArray,true);
				returnArray[sortedHandIndexes[3]]=false;	
				returnArray[sortedHandIndexes[4]]=false;	
			}	
		}
		else if(	sortedHand.get(1).suit() == sortedHand.get(3).suit()) {
			if(sortedHand.get(1).rank() >10) counter++;
			if(sortedHand.get(2).rank() >10) counter++;
			if(sortedHand.get(3).rank() >10) counter++;
			if (counter >1) {
				Arrays.fill(returnArray,true);
				returnArray[sortedHandIndexes[0]]=false;	
				returnArray[sortedHandIndexes[4]]=false;	
			}
		}
		else if(	sortedHand.get(2).suit() == sortedHand.get(4).suit()) {
			if(sortedHand.get(2).rank() >10) counter++;
			if(sortedHand.get(3).rank() >10) counter++;
			if(sortedHand.get(4).rank() >10) counter++;
			if (counter >1) {
				Arrays.fill(returnArray,true);
				returnArray[sortedHandIndexes[0]]=false;	
				returnArray[sortedHandIndexes[1]]=false;	
			}
		}
		return returnArray;	
	}
	
	//18
	private boolean[] twoSuitedHighCards(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		char suit;
		boolean flagFound = false;
		for (int i = 0; i < 4; i++) {
			if(sortedHand.get(i).rank()>10) {
				suit = sortedHand.get(i).suit();
				for (int j = i+1; j<5; j++) {
					if(sortedHand.get(j).rank()>10 &&
							sortedHand.get(j).suit()==suit) {
						returnArray[5]=true;
						returnArray[sortedHandIndexes[i]]=true;
						returnArray[sortedHandIndexes[j]]=true;
						flagFound = true;
						break;
						
					}
				}
				if(flagFound)break;
			}
		}
		return returnArray;
	}
	
	//19
	private boolean[] fourToAnInsideStraightWithTwoHighCards(Hand hand) {
		boolean[] fourToAnInsideStraight = fourToAnInsideStraight(hand);
		boolean[] returnArray = new boolean[6];
		int highCardCounter = 0;
		Arrays.fill(returnArray, false);
		if(!fourToAnInsideStraight[5]) 
			return returnArray;
		for (int i = 0; i < 5; i++) {
			if(fourToAnInsideStraight[i]) {
				if(hand.get(i).rank()<10) highCardCounter++;
			}
		}
		
		if(highCardCounter == 2)
			returnArray = fourToAnInsideStraight;
		
		return returnArray;
	}		
		
	//20
	private boolean[] threeToStraightFlushType2(Hand hand) {
	
			ArrayList<Card> sortedHand = sortBySuit(hand);
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);
			
			boolean aux_array[];
			int highCounter = 0;
			int auxCounter = 0;
			
			aux_array = ThreeToStraight(hand);
			
			if (aux_array[5] == true)
			{
				if(sortedHand.get(4).rank() > 10)
				{
					return aux_array;
				}
				
				else if (sortedHand.get(4).rank() == 14)
				{
					for(int i = 0; i < 5; i++)
					{
						if(aux_array[i] && hand.get(i).rank() <= 5)
						{
							return aux_array;
						}
					}
				}
				
				else if(sortedHand.get(0).rank() == 2 && sortedHand.get(1).rank() == 3 && sortedHand.get(2).rank() == 4)
				{
					if(sortedHand.get(0).suit() == sortedHand.get(1).suit() && sortedHand.get(1).suit() == sortedHand.get(2).suit())
					{
						return aux_array;
					}
				}
		

			}
			
			else return returnArray;
			
			return returnArray;
		}
	
	
	//21
	private boolean[] fourToAnInsideStraightWithOneHighCard(Hand hand) {
		boolean[] fourToAnInsideStraight = fourToAnInsideStraight(hand);
		boolean[] returnArray = new boolean[6];
		int highCardCounter = 0;
		Arrays.fill(returnArray, false);
		if(!fourToAnInsideStraight[5]) 
			return returnArray;
		for (int i = 0; i < 5; i++) {
			if(fourToAnInsideStraight[i]) {
				if(hand.get(i).rank()<10) highCardCounter++;
			}
		}
		
		if(highCardCounter == 1)
			returnArray = fourToAnInsideStraight;
		
		return returnArray;
	}
	
	//22
	private boolean[] unsuitedKQJ(Hand hand) {
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		if(sortedHand.get(2).rank()==11) {
			Arrays.fill(returnArray, true);
			returnArray[sortedHandIndexes[0]]=false;
			returnArray[sortedHandIndexes[1]]=false;			
		}
		return returnArray;
	}
	
	//23
	private boolean[] suitedJT(Hand hand) {
			ArrayList<Card> sortedHand = sortBySuit(hand);
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);
			boolean flagFound = false;
			
			for (int i = 0 ; i < 4; i++) {
				if(sortedHand.get(i).rank()!=11 && 
						sortedHand.get(i).rank()!=10) continue;
				char suit = sortedHand.get(i).suit();
				for(int j = i+1 ; j<5; j++) {
					if(suit == sortedHand.get(j).suit()) {
						if(sortedHand.get(j).rank() ==11  ||
								sortedHand.get(j).rank() ==10) {
							returnArray[5]=true;
							returnArray[sortedHandIndexes[i]]=true;
							returnArray[sortedHandIndexes[j]]=true;
							flagFound = true;
							break;
						}
					}else break;
				}
				if(flagFound)break;
			}
			return returnArray;
			
		}
		
	//24
	private boolean[] unsuitedQJ(Hand hand) {
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);
			ArrayList<Card> sortedHand = sortByRank(hand);
			char k_suit = ' ';
			
			for(int i = 4; i < 0; i--) 
			{
				if(sortedHand.get(i).rank() == 12)
				{
					k_suit = sortedHand.get(i).suit();
					for(int j = i; j <= 0; j--)
					{
						if(sortedHand.get(j).rank() == 11 
								&& sortedHand.get(j).suit() != k_suit)
						{
							returnArray[sortedHandIndexes[j]] = true;
							returnArray[5] = true;
							return returnArray;
						}
					}
				}
			}
			
			return returnArray;

		}	
	
	//25
	private boolean[] threeToFlushWithOneHighCard(Hand hand) {
			ArrayList<Card> sortedHand = sortBySuit(hand);
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);
			int counter=0;
			
			if(sortedHand.get(0).suit() == sortedHand.get(2).suit()) {
				
				if(sortedHand.get(0).rank() >10) counter++;
				if(sortedHand.get(1).rank() >10) counter++;
				if(sortedHand.get(2).rank() >10) counter++;
				if (counter == 1) {
					Arrays.fill(returnArray,true);
					returnArray[sortedHandIndexes[3]]=false;	
					returnArray[sortedHandIndexes[4]]=false;	
				}	
			}
			else if(	sortedHand.get(1).suit() == sortedHand.get(3).suit()) {
				if(sortedHand.get(1).rank() >10) counter++;
				if(sortedHand.get(2).rank() >10) counter++;
				if(sortedHand.get(3).rank() >10) counter++;
				if (counter ==1) {
					Arrays.fill(returnArray,true);
					returnArray[sortedHandIndexes[0]]=false;	
					returnArray[sortedHandIndexes[4]]=false;	
				}
			}
			else if(	sortedHand.get(2).suit() == sortedHand.get(4).suit()) {
				if(sortedHand.get(2).rank() >10) counter++;
				if(sortedHand.get(3).rank() >10) counter++;
				if(sortedHand.get(4).rank() >10) counter++;
				if (counter ==1) {
					Arrays.fill(returnArray,true);
					returnArray[sortedHandIndexes[0]]=false;	
					returnArray[sortedHandIndexes[1]]=false;	
				}
			}
			return returnArray;	
		}
	
	//26
	private boolean[] suitedQT(Hand hand) {
			ArrayList<Card> sortedHand = sortBySuit(hand);
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);
			boolean flagFound = false;
			
			for (int i = 0 ; i < 4; i++) {
				if(sortedHand.get(i).rank()!=12 && 
						sortedHand.get(i).rank()!=10) continue;
				char suit = sortedHand.get(i).suit();
				for(int j = i+1 ; j<5; j++) {
					if(suit == sortedHand.get(j).suit()) {
						if(sortedHand.get(j).rank() ==12  ||
								sortedHand.get(j).rank() ==10) {
							returnArray[5]=true;
							returnArray[sortedHandIndexes[i]]=true;
							returnArray[sortedHandIndexes[j]]=true;
							flagFound = true;
							break;
						}
					}else break;
				}
				if(flagFound)break;
			}
			return returnArray;
			
		}
		
	//27
	private boolean[] threeToStraightFlushType3(Hand hand) {
	
			ArrayList<Card> sortedHand = sortBySuit(hand);
			boolean[] returnArray = new boolean[6];
			Arrays.fill(returnArray, false);

			boolean aux_array[];
			
			aux_array = ThreeToStraight(hand);
			
			if (aux_array[5] == true)
			{
				for(int i = 0; i<5; i++)
				{
					if(aux_array[i])
					{
						if(hand.get(i).rank() > 10);
						{
							return returnArray;
						}
					}
				}
				
				return returnArray;
			}
			
			else return returnArray;
		}
	
	
	//28
	private boolean[] KQorKJUnsuited(Hand hand) {
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		ArrayList<Card> sortedHand = sortByRank(hand);
		char k_suit = ' ';
		
		for(int i = 4; i < 0; i--) 
		{
			if(sortedHand.get(i).rank() == 13)
			{
				k_suit = sortedHand.get(i).suit();
				for(int j = i; j <= 0; j--)
				{
					if((sortedHand.get(j).rank() == 11 || sortedHand.get(j).rank() == 12)
							&& sortedHand.get(j).suit() != k_suit)
					{
						returnArray[sortedHandIndexes[j]] = true;
						returnArray[5] = true;
						return returnArray;
					}
				}
			}
		}
		
		return returnArray;
	}
	
	//29
	private boolean[] Ace(Hand hand) {
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		
		for(int i = 4; i < 0; i--) 
		{
			if(hand.get(i).rank() == 14)
			{
				returnArray[sortedHandIndexes[i]] = true;
				returnArray[5] = true;
				return returnArray;
			}
		}
		
		return returnArray;
	}
	
	//30
	private boolean[] KTsuited(Hand hand) {

		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		ArrayList<Card> sortedHand = sortByRank(hand);
		boolean k_aux = false;
		char k_suit = ' ';
		
			
		for(int i = 4; i < 0; i--) 
		{
			if(sortedHand.get(i).rank() == 13)
			{
				k_suit = sortedHand.get(i).suit();
				for(int j = i; j <= 0; j--)
				{
					if(sortedHand.get(j).rank() == 10 && sortedHand.get(j).suit() == k_suit )
					{
						returnArray[sortedHandIndexes[j]] = true;
						returnArray[sortedHandIndexes[i]] = true;
						returnArray[5] = true;
						return returnArray;
					}
				}

			}

		}
		
		return returnArray;

	}
	
	//31
	private boolean[] JackQueenKing(Hand hand) {

		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		ArrayList<Card> sortedHand = sortByRank(hand);
		
			
		for(int i = 4; i <= 0; i--) 
		{
			if(sortedHand.get(i).rank() <= 10)
			{
				return returnArray;
			}
			
			else if (sortedHand.get(i).rank() > 10 && sortedHand.get(i).rank() < 14)
			{
				returnArray[5] = true;
				returnArray[sortedHandIndexes[i]] = true;
			}
		}
		
		return returnArray;

	}
		
	//32
	private boolean[] fourToInsideStraightWithNoHighCards(Hand hand) {
		boolean[] fourToAnInsideStraight = fourToAnInsideStraight(hand);
		boolean[] returnArray = new boolean[6];
		int highCardCounter = 0;
		Arrays.fill(returnArray, false);
		if(!fourToAnInsideStraight[5]) 
			return returnArray;
		for (int i = 0; i < 5; i++) {
			if(fourToAnInsideStraight[i]) {
				if(hand.get(i).rank()<10) highCardCounter++;
			}
		}
		
		if(highCardCounter == 0)
			returnArray = fourToAnInsideStraight;
		
		return returnArray;
	}
	
	//33
	private boolean[] threeToAFlushWithNoHighCards(Hand hand) {

		ArrayList<Card> sortedHand = sortBySuit(hand);
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		
		for(int i=0 ; i<2 ; i++) {
			if(sortedHand.get(i).suit() == sortedHand.get(i+2).suit()) {
				if(sortedHand.get(i).rank()<11 && sortedHand.get(i+1).rank()<11 && sortedHand.get(i+2).rank()<11) {
					returnArray[5] = true;
					returnArray[sortedHandIndexes[i]] = true;
					returnArray[sortedHandIndexes[i+1]] = true;
					returnArray[sortedHandIndexes[i+2]] = true;
					break;
				}
			}
		}
		
		return returnArray;

	}
	
	
	private boolean[] fourToAnInsideStraight(Hand hand) {

		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		ArrayList<Card> sortedHand = sortByRank(hand);
		int lastRank=0;
		int indexToBegin=0;
		
		if(sortedHand.get(4).rank()==14) 
		{
			if(sortedHand.get(3).rank()==13 || sortedHand.get(3).rank()==5) 
			{
				indexToBegin = 3;
				returnArray[sortedHandIndexes[4]] = true;
				returnArray[sortedHandIndexes[3]] = true;
			}
			else return returnArray;
		}
		
		else if(sortedHand.get(4).rank() - sortedHand.get(0).rank() == 4)
		{
			indexToBegin = 4;
			returnArray[sortedHandIndexes[4]] = true;
		}
		
		if (indexToBegin != 0)
		{
			lastRank = sortedHand.get(indexToBegin).rank();
			for(int i = indexToBegin-1; i >= 0; i--) 
			{
				if(sortedHand.get(i).rank() != lastRank-1) 
				{
					returnArray[i] = false;
				}
				
				else {returnArray[i] = true;
				returnArray[5]=true;}
				lastRank--;
			}

		}
			
		else return returnArray;
		
		return returnArray;

	}


	private boolean[] ThreeToStraight(Hand hand) {
		boolean[] returnArray = new boolean[6];
		Arrays.fill(returnArray, false);
		ArrayList<Card> sortedHand = sortByRank(hand);
		int counter = 0;
		
		
		 for(int i = 4; i >= 2; i--) 
		 {
			 counter = 0;
			 
			 if(sortedHand.get(i).rank() == 14)
			 {
				for(int j = 0; j < 5; j++)
				{ 
					if(5 - sortedHand.get(j).rank() <= 3)
					{
						returnArray[sortedHandIndexes[i]]=true;
						returnArray[sortedHandIndexes[j]]=true;
						counter++;
						
						if (counter == 3)
						{
							return returnArray;
						}
					}
				}
			 }
			 else for(int j = i-1; j > 0; j--)
			 {
				
				 if(sortedHand.get(i).rank()-sortedHand.get(j).rank() >= 3)
				 {
					returnArray[sortedHandIndexes[i]]=true;
					returnArray[sortedHandIndexes[j]]=true;
					counter++;
					
					if (counter == 3)
					{
						return returnArray;
					}
				}
			 }
			
			Arrays.fill(returnArray, false);
		}
		 return returnArray;
	}





}