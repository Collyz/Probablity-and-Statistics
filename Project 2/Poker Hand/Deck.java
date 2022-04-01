import java.util.*;

public class Deck {
    private final int cardLimit = 14; //Determines how many cards will be in each suite
    private Card card; //Card objects to be created in a deck
    private ArrayList<Card> hand; //Stores the Card objects
    private Random rand;  //Used to create a random shuffle

    //Constructor of the class. Accepts no parameters and initializes
    //two private variables, hand ArrayList and rand Random
    public Deck(){
        hand = new ArrayList<>();
        rand = new Random();
    }

    //This method fills in the ArrayList with the Card objects of each suite number 1-13
    public void fillDeck(){
        for(int i = 1; i < cardLimit; i++){
            hand.add(card = new Card("Spades", i));
            hand.add(card = new Card("Hearts", i));
            hand.add(card = new Card("Diamonds", i));
            hand.add(card = new Card("Clubs", i));
        }
    }

    //This method shuffle's the deck and stops if there are only 5 cards left. This is because there are only ever 5 in a hand
    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<Card>(52);
        try {
            for (int i = 0; i < 52; i++) {
                if (hand.size() == 5) {
                    break;
                }
                int tempNum = rand.nextInt(hand.size());
                temp.add(hand.remove(tempNum));
            }
            hand = temp;
        }catch (IndexOutOfBoundsException | IllegalArgumentException exception){
            System.out.println("There are no more cards to shuffle");
        }
    }

    //Draws a single card and returns it. Removes that card from the ArrayList hand to remove it from the deck
    public Card drawCard() {
        try{
            //removes the card from the deck
            return hand.remove(0);
        }catch (IndexOutOfBoundsException exception){
            System.out.println("No more cards to draw"); //If there are no more cards in hand this will be displayed
            return null;
        }
    }

    //Boolean return to check if there are still cards in the deck.
    public boolean handStatus(){
        if(hand.size() >= 1){
            return true; //True if there are cards in ArrayList hand
        }
        else {return false;}
    }

    //Returns the card number of the card object in the deck
    public int getCardNum(){
        return hand.get(0).getCardNum();
    }

    //Returns the suite of the card object in the deck
    public String getSuite(){
        return hand.get(0).getSuite();
    }

    public void reset(){
        hand.clear();
        fillDeck();
    }

}
