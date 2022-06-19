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
		
		Game game = null;
		if(args[0].equals( "-s")) {

		}
		if(args[0].equals( "-d")) {
			 game = new Debug(args);	
		}
		
		game.run();

	}
}
