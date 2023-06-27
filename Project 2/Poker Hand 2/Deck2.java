import java.util.ArrayList;
import java.util.SplittableRandom;

public class Deck2 {
    private final int CARD_LIMIT = 14; //Determines how many cards will be in each suite
    private ArrayList<Card2> deck;     //Stores the Card objects     
    private SplittableRandom rand;    //Used to create a random shuffle
    private final String SPADES = "Spades";
    private final String HEARTS = "Hearts";
    private final String DIAMONDS = "Diamonds";
    private final String CLUBS = "Clubs";

    public Deck2(){
        deck = new ArrayList<>(52);
        rand = new SplittableRandom(); 
    }

    public void fillDeck(){
        for(int i = 1; i < CARD_LIMIT; i++){
            deck.add(new Card2(SPADES, i));
            deck.add(new Card2(HEARTS, i));
            deck.add(new Card2(DIAMONDS, i));
            deck.add(new Card2(CLUBS, i));
        }
    }

    public void shuffle(){
        if(deck.size() > 5){
            for(int i = 0; i < deck.size() + 100; i++){
                int index1 = rand.nextInt(deck.size());
                int index2 = rand.nextInt(deck.size());
                Card2 temp = deck.get(index2);
                deck.set(index2, deck.get(index1));
                deck.set(index1, temp);
            }
        }else{
            System.out.println("Only 5 or fewer cards remain, no need to shuffle");
        }
    }

    public Card2 drawSingleCard(String suite, int cardNum){
        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).compare(suite, cardNum)){
                return deck.remove(i);
            }
        }
        System.out.println("No card match: RETURNING NULL");
        return null;
    }

    public Card2 drawSingleCard(){
        try{
            return deck.remove(0);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public Card2[] drawFiveCards(){
        Card2[] drawn = new Card2[5];
        try{
            for(int i = 0; i < 5; i++){
                drawn[i] = drawSingleCard();
            }
            return drawn;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public void printDeck(){
        for(Card2 cards: deck){
            System.out.println(cards.toString());
        }
    }
    
}
