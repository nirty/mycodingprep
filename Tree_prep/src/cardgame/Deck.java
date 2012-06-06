package cardgame;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import cardgame.Card.Suit;


public class Deck<T extends Card>{
	private ArrayList<T> cards;

    Deck(Class<T> cardtype) throws Exception
    {
    	Class<?> parTypes[] = new Class<?>[2];
        parTypes[0] = Integer.class;
        parTypes[1] = Suit.class;
        Constructor<T> ct = cardtype.getDeclaredConstructor(parTypes);
    
        cards = new ArrayList<T>();
        for (int a=1; a<=13; a++)
        {
            for (int b=1; b<=4; b++)
             {

            	 Object[] argList  = new Object[2];
                 argList[0] = a;
                 argList[1] = Suit.getSuit(b);
                 T cardObj = ct.newInstance(argList);
                 
                 
               cards.add(cardObj);
             }
        }    

       knuthshuffle();
    }

    private void knuthshuffle() {		
    	T temp;
    	int index;
    	for (int i = 0; i < cards.size(); i++){
    	index = (int) (Math.random() * (cards.size() - i)) + i;
    	temp = cards.get(i);
    	cards.set(i, cards.get(index));
    	cards.set(index, temp);
    	}
		
	}

	public T drawFromDeck()
    {       
        return cards.remove( 0 );
    }

	
	public void printCards(){
		for(T card: cards){
			System.out.println(" Type of card: "+ card.getClass().getName() + "  "+  card.getRank() + " of " + card.getSuit().name());
		}
	}
    public int getTotalCards()
    {
        return cards.size();
        //we could use this method when making 
        //a complete poker game to see if we needed a new deck
    }
}
