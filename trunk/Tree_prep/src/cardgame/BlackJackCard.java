package cardgame;

public class BlackJackCard extends Card {

	public BlackJackCard(int r, Suit s) {
		super(r, s);
	}

	@Override
	public int getRank() {
		int r = super.getRank();
		if (r == 1)
			return 11; // aces are 11
		if (r < 10)
			return r;
		return 10;
	}

	boolean isAce() {
		return super.getRank() == 1;
	}

}
