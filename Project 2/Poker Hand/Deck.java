import java.util.ArrayList;
import java.util.SplittableRandom;

/**
 * Purpose is to behave as a deck of cards that can be drawn from at random. There are 
 */
public class Deck {
    private final int CARD_LIMIT = 14; //Determines how many cards will be in each suite
    private ArrayList<Card> deck;     //Stores the Card objects     
    private SplittableRandom rand;    //Used to create a random shuffle

    /**
    * Constructor of the class. Accepts no parameters and initializes
    * two private variables, hand ArrayList and rand Random
    */
    public Deck(){
        deck = new ArrayList<>(52);
        rand = new SplittableRandom();
    }

    /**
     * This method fills in the ArrayList with the Card objects of each suite number 1-13
     */
    public void fillDeck(){
        for(int i = 1; i < CARD_LIMIT; i++){
            deck.add(new Card("Spades", i));
            deck.add(new Card("Hearts", i));
            deck.add(new Card("Diamonds", i));
            deck.add(new Card("Clubs", i));
        }
    }

    /**
     * This method shuffle's the deck and stops if there are only 5 cards left. This is because there are only ever 5 in a hand
     */
    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<Card>(52);
        try {
            if(deck.size() != 5){
                    for (int i = 0; i < 52; i++) {
                    int tempNum = rand.nextInt(deck.size());
                    temp.add(deck.remove(tempNum));
                    }
                deck = temp;
                }
        }catch (IndexOutOfBoundsException | IllegalArgumentException exception){
            System.out.println("There are no more cards to shuffle");
        }
    }

    /**
     * Draws a single card and returns it. 
     * Removes that card from the ArrayList 'deck' to remove it from the deck
     * @return The card object that is removed from the deck;
     */
    public Card drawCard() {
        try{
            return deck.remove(0);     //removes the card from the deck
        }catch (IndexOutOfBoundsException exception){
            //If there are no more cards in hand this will be displayed
            System.out.println("No more cards to draw");     
            return null;
        }
    }

    /**
     * Check to see if there are still cards in the deck.
     * @return Boolean card status for the deck
     */
    public boolean handStatus(){
        if(deck.size() >= 1){
            return true;    //True if there are cards in ArrayList hand
        }
        else {return false;}
    }

    /**
     * Returns the card number of the card object in the deck
     * @return Number of the card 'on top' of the deck (index zero)
     */
    public int getCardNum(){
        return deck.get(0).getCardNum();
    }

    /**
     * Returns the suite of the card object in the deck
     * @return Suite of the card 'on top' of the deck (index zero)
    */
        public String getSuite(){
        return deck.get(0).getSuite();
    }

    /**
     * Empties all of the cards in the deck and then refills the deck with 52 cards.
     */
    public void reset(){
        deck.clear();
        fillDeck();
    }

}