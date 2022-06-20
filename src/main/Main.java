/**
 * 
 */
package main;
import gamePlay.*;
/**
 * Main Class to run the application
 * 
 * @author Group 46
 */
public class Main {
	/**
	 * Main function
	 * @param args Input arguments of application
	 *
	 */
	public static void main(String[] args) {
		
		Game game = null;
		if(args[0].equals( "-s")) {
			game = new Simulation(args);
		}
		if(args[0].equals( "-d")) {
			 game = new Debug(args);	
		}
		
		game.run();

	}
}
