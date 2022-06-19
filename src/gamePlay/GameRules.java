package gamePlay;
import cards.*;

public interface GameRules {
	public boolean[] advice(Hand hand);
	public String[]  getHandValue(Hand hand, int bet);
	public String getStatistics(int credit);
}
