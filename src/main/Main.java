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
		
		if(args[0].equals( "-s")) {

		}
		if(args[0].equals( "-d")) {
			Debug game = new Debug(args);	
		}
		
		//game.run();

	}
}
