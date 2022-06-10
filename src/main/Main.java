/**
 * 
 */
package main;
import gamePlay.*;
/**
 * @author ruimbc
 *
 */
public class Main {
	
	public static void main(String[] args) {
	
		Game game = new Game(args);	
		
		for (int i = 0 ; i < (int) args.length; i++){
			System.out.println("args "+i+" is "+args[i]);
		}
		
		//game.run();

	}
}
