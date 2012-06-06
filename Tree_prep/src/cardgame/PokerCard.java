package cardgame;

public class PokerCard extends Card {

	public PokerCard(Integer r, Suit s) {
		super(r, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRank() {
		int r = super.getRank();
		if (r == 1)
			return 14; // aces are 14
		return r;
	}

	boolean isAce() {
		return super.getRank() == 1;
	}
}
