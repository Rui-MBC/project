package gamePlay;
import cards.*;


public class Game {
	
	private Deck deck ;
	private Player player;
	
	public Game(String[] args) {
		

		
		if(args[0].equals( "-s")) {
			System.out.println("true in sim");
			simulationMode(args);
		}
		if(args[0].equals( "-d")) {
			System.out.println("true in debug");
			debugMode(args);
		}
		
		//Player player = new Player(credit);
		
		// TODO Auto-generated constructor stub
	}
	
	private void simulationMode(String[] args) {
		
		//nos criamos o deck
		//nós lemos o credit que é suposto existir
		//nos lemos o valor das bets
		//nos lemos o n of deals
		//nos corremos a simulação esse numero de vazes sempre no modo perfeito
		
	}
	private void debugMode(String[] args) {
		int credit = Integer.parseInt(args[1]);
		String comandFile = args[2];
		String deckFile = args[3];
		Deck deck = new Deck(deckFile); 
		deck.shuffle();
		System.out.println(deck);
		
		player = new Player(credit);
		//recebe file com carts já ordenadas -> temos de ler
		//recebe um ficheiro com comandos e temos de ler
		//fazer combo
		
	}

}