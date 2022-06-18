package gamePlay;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cards.*;


public class Debug implements Game {
	
	private Player player ;
	private GameInstance instance;
	
	public Debug(String[] args) {
		instance = new GameInstance(args[3]);
		player = new Player(Integer.parseInt(args[1]));
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
		
		boolean hold_aux[] = new boolean[5];
		int hold_amount = 0;
		int hold_flag = -1;
		
		String result_aux;
		
		File file_cmd = new File("/Users/cemar/Main/IST/POO/Proj/DebugMode/cmd-file.txt");
		Scanner sc_cmd = new Scanner(file_cmd);

		//Cmd file
		curr_line = sc_cmd.nextLine();
		parts = curr_line.split(" ");
		
		
		for ( i = 0; i < parts.length; i++)
		{
			if (parts[i].contains("b"))
			{
				
				if(parts[i+1].matches("^[0-9]+$"))
				{
					aux = Integer.parseInt(parts[i+1]);
					player.bet(aux);
				}
				else
				{
					player.bet();
				}
			}
					
			else if (parts[i].contains("$"))
			{
				int credit =player.credit();
				System.out.println("Player's credit is " + credit);
			}
			
			else if (parts[i].contains("d"))
			{
				ArrayList<Card> rcvd_cards = instance.deal(5);
				player.setHand(rcvd_cards);
			}
			
			else if (parts[i].contains("h"))
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
				result_aux = instance.hand_result(player.getHand());
				
				if (result_aux == NULL)
				{
					System.out.println("player loses and his credit is "+player.credit());
				}
					
				else
				{
					System.out.println("player ties");
				}
					
					
				
				//hold_aux[] = 1 if the player wants to hold, and = 0 if not
				//call hold method
			}
			
			else if (parts[i].contains("a"))
			{
				//call advice method
				hold_aux = instance.advice(player.getHand());
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
				instance.statistics();
			}
		}
		sc_cmd.close();
		
	}

}