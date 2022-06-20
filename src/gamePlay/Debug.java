package gamePlay;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cards.*;


public class Debug implements Game {
	
	private Player player ;
	private GameInstance instance;
	private String commandFileName;
	
	public Debug(String[] args) {
		instance = new GameInstance(args[3],Integer.parseInt(args[1]));
		player = new Player(Integer.parseInt(args[1]));
		commandFileName = args[2];
	}

	/**
	 *
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
				}
				
				else
				{
					if(parts[i+1].matches("^[0-9]+$"))
					{
						aux = Integer.parseInt(parts[i+1]);
						if(0 < aux && aux <= 5) {
							player.bet(aux);
							player.printBet();
						}
						else {
							System.out.println("b: illegal amount");
						}
							
					}
					else
					{
						player.bet();
						player.printBet();
						
					}
					lastCmd = "b";
				}

			}
					
			else if (parts[i].contains("$"))
			{
				int credit =player.credit();
				System.out.println("Player's credit is " + credit);
			}
			
			else if (parts[i].contains("d"))
			{


				if (/*!lastCmd.contains("z") ||*/ !lastCmd.contains("b"))
				{
					System.out.println("d: illegal command");
				}
				else 
				{
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
					//System.out.println("Hold");
					for (j=1; j < 6; j++)
					{
						if(i+j <parts.length && parts[i+j].matches("^[0-9]+$"))
						{
							//System.out.println(parts[i+j]);
							hold_aux[Integer.parseInt(parts[i+j])-1] = false;
							hold_amount++;
						}
						else
						{
							//System.out.println(Arrays.toString(hold_aux));
							break;
						}
					}
					
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
						System.out.println("player wins with a" + result_aux[1] + " and his credit is" + player.credit());
					}
						
					lastCmd = "d";
				}
				
			}
			
			else if (parts[i].contains("a"))
			{


				//call advice method
				hold_aux = instance.advice(player.getHandObject());
				hold_flag = 0;
				for(i=0; i<5; i++)
				{
					if(hold_aux[i])
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
					for(i=0; i<5; i++)
					{
						if(hold_aux[i])
						{
							System.out.print((i+1)+" ");
						}
					}
					
					System.out.print("\n");
				}

			}
			
			else if (parts[i].contains("s"))
			{
				//call statistics method
				System.out.println(instance.statistics(player.credit(),player.getBetSum()));
			}
			
			else if (parts[i].contains(".*[a-zA-Z].*"))
			{
				System.out.println(parts[i].toString()+": invalid command");
			}


		}
		sc_cmd.close();


		
	}

}