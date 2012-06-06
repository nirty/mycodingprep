package cardgame;

import java.util.ArrayList;

public class PokerTable {
	
	ArrayList<PokerHand> listofplayers = new ArrayList<PokerHand>();
	Deck<PokerCard> deckofcards;
	
	private ArrayList<PokerCard> tablecards = new ArrayList<PokerCard>(3);
	
	
	PokerTable(){
		try{
			deckofcards = new Deck<PokerCard>(PokerCard.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void addPokerHand(PokerHand player){
		listofplayers.add(player);
	}
	
	
	public void startinitialround(){
		
		for(PokerHand hand:listofplayers){
			
			hand.acceptCard(deckofcards.drawFromDeck());
		}
	}
	
	public void printCardsinDeck(){
		deckofcards.printCards();
	}
	
	
	
	public ArrayList<PokerCard> getTablecards() {
		return tablecards;
	}
	
	public static void main(String args[]){
		
		
		PokerTable table1 = new PokerTable();
		table1.printCardsinDeck();
		
		
	}


}
