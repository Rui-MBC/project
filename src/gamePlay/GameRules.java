package gamePlay;
import cards.*;

public interface GameRules {
	public boolean[] advice(Hand hand);
	public String[]  getHandvalue(Hand hand, int bet);
	public String getStatistics(int credit);
}
