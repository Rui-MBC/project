import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {

	public static void main(String[] args) throws FileNotFoundException
	{
		String curr_line;
		String[] parts;
		int i = 0;
		int j = 0;
		int aux = 0;
		int hold_aux[] = new int[5];
		File file_crd = new File("/Users/cemar/Main/IST/POO/Proj/DebugMode/card-file.txt");
		Scanner sc_crd = new Scanner(file_crd);
		File file_cmd = new File("/Users/cemar/Main/IST/POO/Proj/DebugMode/cmd-file.txt");
		Scanner sc_cmd = new Scanner(file_cmd);
		
		
		//Card file
		curr_line = sc_crd.nextLine();
		for(i = 0; i+2 <= curr_line.length();i = i+3)
		{
			//parses all cards
			//System.out.println("Card:"+curr_line.substring(i,i+2));
		}
		
		sc_crd.close();
		

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
				}
				else
				{
					aux = -1;
				}
				
				//call bet method
				//if aux = -1, bet previous/default amount, else bet aux amount
			}
					
			else if (parts[i].contains("$"))
			{
				//call credit method
			}
			
			else if (parts[i].contains("d"))
			{
				//call deal method
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

