package cardgame;

public class Card {
	
	public enum Suit {
		CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
		int value;

		private Suit(int v) {
			value = v;
		}
		
		public static Suit getSuit(int value){			
			switch(value){
			case 1:
				return CLUBS;
			case 2:
				return SPADES;
			case 3:
				return HEARTS;
			case 4:
				return DIAMONDS;
			}			
			return null;				
		}
	};

	private int rank;
	private Suit suit;

	public Card(int r, Suit s) {
		rank = r;
		suit = s;
	}

	public int getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}