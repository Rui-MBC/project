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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String curr_line;
		String[] parts;
		int i = 0;
		int j = 0;
		int aux = 0;
		int hold_aux[] = new int[5];
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
				ArrayList<Card> hand = instance.deal(5);
			}
			
			else if (parts[i].contains("h"))
			{
				Arrays.fill(hold_aux, 0); //reset hold array
				//System.out.println("Hold");
				for (j=1; j < 6; j++)
				{
					if(i+j <parts.length && parts[i+j].matches("^[0-9]+$"))
					{
						//System.out.println(parts[i+j]);
						hold_aux[Integer.parseInt(parts[i+j])-1] = 1;
					}
					else
					{
						//System.out.println(Arrays.toString(hold_aux));
						break;
					}
				}
				
				//hold_aux[] = 1 if the player wants to hold, and = 0 if not
				//call hold method
			}
			
			else if (parts[i].contains("a"))
			{
				//call advice method
			}
			
			else if (parts[i].contains("s"))
			{
				//call statistics method
			}
		}
		sc_cmd.close();
		
	}

}