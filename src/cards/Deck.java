package cards;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {


	private ArrayList<Card> deck = new ArrayList<Card>(); 
	
	public Deck(String fileName) {
		
		File file = new File("/home/ruimbc/PooWorkSpace/project/Decks/"+fileName);
		char[] ch  = null;
		try (FileReader fr = new FileReader(file))
        {
            ch = new char[(int) file.length()];
            fr.read(ch);
            String fileContent = new String(ch);
            System.out.println(fileContent);
            

        }
        catch (IOException e) {
            e.printStackTrace();
        }
		for (int i = 0; i < (int) file.length(); i=i+3) {
			deck.add(new Card(ch[i], ch[i+1]));
		}

		/*
		deck.add(new Card('2', 'H'));
		deck.add(new Card('3', 'H'));
		deck.add(new Card('4', 'H'));
		deck.add(new Card('5', 'H'));
		deck.add(new Card('6', 'H'));
		deck.add(new Card('7', 'H'));
		deck.add(new Card('8', 'H'));
		deck.add(new Card('9', 'H'));
		deck.add(new Card('T', 'H'));
		deck.add(new Card('J', 'H'));
		deck.add(new Card('Q', 'H'));
		deck.add(new Card('K', 'H'));
		deck.add(new Card('A', 'H'));
	
		deck.add(new Card('2', 'D'));
		deck.add(new Card('3', 'D'));
		deck.add(new Card('4', 'D'));
		deck.add(new Card('5', 'D'));
		deck.add(new Card('6', 'D'));
		deck.add(new Card('7', 'D'));
		deck.add(new Card('8', 'D'));
		deck.add(new Card('9', 'D'));
		deck.add(new Card('T', 'D'));
		deck.add(new Card('J', 'D'));
		deck.add(new Card('Q', 'D'));
		deck.add(new Card('K', 'D'));
		deck.add(new Card('A', 'D'));
		
		deck.add(new Card('2', 'S'));
		deck.add(new Card('3', 'S'));
		deck.add(new Card('4', 'S'));
		deck.add(new Card('5', 'S'));
		deck.add(new Card('6', 'S'));
		deck.add(new Card('7', 'S'));
		deck.add(new Card('8', 'S'));
		deck.add(new Card('9', 'S'));
		deck.add(new Card('T', 'S'));
		deck.add(new Card('J', 'S'));
		deck.add(new Card('Q', 'S'));
		deck.add(new Card('K', 'S'));
		deck.add(new Card('A', 'S'));

		deck.add(new Card('2', 'C'));
		deck.add(new Card('3', 'C'));
		deck.add(new Card('4', 'C'));
		deck.add(new Card('5', 'C'));
		deck.add(new Card('6', 'C'));
		deck.add(new Card('7', 'C'));
		deck.add(new Card('8', 'C'));
		deck.add(new Card('9', 'C'));
		deck.add(new Card('T', 'C'));
		deck.add(new Card('J', 'C'));
		deck.add(new Card('Q', 'C'));
		deck.add(new Card('K', 'C'));
		deck.add(new Card('A', 'C'));
		*/		
	}
	
	public void shuffle() {
		Collections.shuffle(deck);		
	}

	@Override
	public String toString() {
		return ""+deck;
	}
	
	

}
