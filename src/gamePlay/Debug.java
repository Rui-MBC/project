package gamePlay;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cards.*;
/**
 * Debug game mode
 * 
 * @author Group 46
 */

public class Debug implements Game {
	
	private Player player ;
	private GameInstance instance;
	private String commandFileName;
	/**
	 * Debug constructor
	 * Initialize the Player, GameInstance and get the command's file name
	 * @param args Input arguments of application
	 */
	public Debug(String[] args) {
		instance = new GameInstance(args[3],Integer.parseInt(args[1]));
		player = new Player(Integer.parseInt(args[1]));
		commandFileName = args[2];
	}

	/**
	 * Plays the game in Debug Mode
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String curr_line;
		String[] parts;
		int i = 0;
		int j = 0;
		int aux = 0;
		String lastCmd = "z";
		
		boolean hold_aux[] = new boolean[5];
		int hold_amount = 0;
		int hold_flag = -1;
		
		String[] result_aux;
		
		File file_cmd = new File( "../Commands/" + commandFileName);
		Scanner sc_cmd = null;
		try {
			sc_cmd = new Scanner(file_cmd);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Cmd file
		curr_line = sc_cmd.nextLine();
		parts = curr_line.split(" ");
		
		for ( i = 0; i < parts.length; i++)
		{
			if (parts[i].contains("b"))
			{			
				if ( lastCmd.contains("d"))
				{
					System.out.println("b: illegal command");
					continue;
				}
				
				else
				{
					if(parts[i+1].matches("^[0-9]+$"))
					{
						aux = Integer.parseInt(parts[i+1]);
						if(0 < aux && aux <= 5) {
							/*player.bet(aux);
							player.printBet();*/
						}
						else {
							System.out.println("b: illegal amount");
						}
							
					}
					else
					{
						aux = 0;
						/*player.bet();
						player.printBet();*/
						
					}
					System.out.print("\n-cmd b");
					if (aux != 0)
					{
						System.out.print(" "+aux+"\n");
						player.bet(aux);
						player.printBet();
						
					}
					else 
					{
						System.out.print("\n");
						player.bet();
						player.printBet();		
					}
					lastCmd = "b";
				}

			}
					
			else if (parts[i].contains("$"))
			{
				System.out.println("\n-cmd $");
				int credit =player.credit();
				System.out.println("Player's credit is " + credit);
			}
			
			else if (parts[i].contains("d"))
			{


				if (!lastCmd.contains("b"))
				{
					System.out.println("d: illegal command");
					continue;
				}
				else 
				{
					System.out.println("\n-cmd d");
					ArrayList<Card> rcvd_cards = instance.deal(5);
					player.setHand(rcvd_cards);
					player.printHand();

					lastCmd = "d";
				}

			}
			
			else if (parts[i].contains("h"))
			{
				if (!lastCmd.contains("d"))
				{
					System.out.println("h: illegal command");
				}
				
				else
				{
					Arrays.fill(hold_aux, false); //reset hold array
					hold_amount = 0;
					//System.out.println("Hold");
					for (j=1; j < 6; j++)
					{
						if(i+j <parts.length)
						{
							if (parts[i+j].matches("^[0-9]+$"))
							{
								//System.out.println(parts[i+j]);
								hold_aux[Integer.parseInt(parts[i+j])-1] = true;
								hold_amount++;
							}
							
							else break;

						}
						else
						{
							//System.out.println(Arrays.toString(hold_aux));
							break;
						}
					}
					
					System.out.print("\n-cmd h");
					for(j=0;j< 5; j++)
					{
						if(hold_aux[j])
						{
							System.out.print(" "+(j+1));
						}
						
					}
					System.out.print("\n");
					lastCmd = "h";
					
					ArrayList<Card> rcvd_cards = instance.deal(5-hold_amount);
					player.setHand(rcvd_cards,hold_aux);
					player.printHand();
					result_aux = instance.getHandValue(player.getHandObject(), player.getBet());
					
					if (result_aux[1] == null)
					{
						System.out.println("player loses and his credit is "+player.credit());
					}
						
					else
					{
						player.addcredit(Integer.parseInt(result_aux[0]));
						System.out.println("player wins with a " + result_aux[1] + " and his credit is " + player.credit());
					}
					
				}
				
			}
			
			else if (parts[i].contains("a"))
			{


				System.out.println("\n-cmd a");
				hold_aux = instance.advice(player.getHandObject());
				hold_flag = 0;
				for(j=0; j<5; j++)
				{
					if(hold_aux[j])
					{
						hold_flag = 1;
						break;
					}
				}
				
				if(hold_flag == 0)
				{
					System.out.println("Discard all cards");
				}
				else
				{
					System.out.print("player should hold cards ");
					for(j=0; j<5; j++)
					{
						if(hold_aux[j])
						{
							System.out.print((j+1)+" ");
						}
					}
					
					System.out.print("\n");
				}

			}
			
			else if (parts[i].contains("s"))
			{
				//call statistics method
				System.out.print("\n-cmd s");
				System.out.println(instance.statistics(player.credit(),player.getBetSum()));
			}
			
			else if (parts[i].contains(".[a-zA-Z]."))
			{
				System.out.println(parts[i].toString()+": invalid command");
			}


		}
		sc_cmd.close();


		
	}

}