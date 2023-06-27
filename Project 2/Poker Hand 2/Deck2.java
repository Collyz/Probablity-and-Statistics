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

    public Deck(){
        deck = new Arraylist<>(52);
        rand = new SplittableRandom(); 
    }

    public void fillDeck(){
        for(int i = 1; i < CARD_LIMIT; i++){
            deck.add(new Card(SPADES, i));
            deck.add(new Card(HEARTS, i));
            deck.add(new Card(DIAMONDS, i));
            deck.add(new Card(CLUBS, i));
        }
    }

    public void shuffle(){
        if(deck.size() > 5){
            for(int i = 0; i < deck.size() + 100; i++){
                int tempNum = rand.nextInt(deck.size());
                Card2 temp = deck.remove(index);
                deck.add(temp);
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
            return deck.get(0);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public Card2[] drawFiveCards(){
        Card2[] drawn = new Card2[5];
        try{
            for(int i = 0; i < 5;i++){
                drawn[i] = drawSingleCard();
            }
            return drawn;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }
}
