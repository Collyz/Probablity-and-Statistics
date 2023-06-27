import java.util.Arrays;

public class Hand {
    
    private Card2[] hand;
    private Deck2 deck;

    public Hand(){
        hand = new Card2[5];
        deck = new Deck2();
        deck.fillDeck();
        deck.shuffle();
    }

    public void run(int runs){
        for(int i = 0; i < runs; i++){
            deck.shuffle();
            for(int j = 0; j < 10; i++){

            }
        }
    }

    public void fillHand(){
        hand = deck.drawFiveCards();
    }

    /**
     * Helper method to check for the number of pairs
     * @return Number of pairs found
     */
    private int checkPairInt(){
        int counter = 0;
        //Double for loops check for pairs and add one to counter each time a pair is found
        for(int i = 0; i < hand.length; i++){
            for(int j = i + 1; j < hand.length; j++){
                if(hand[i].getCardNum() == hand[j].getCardNum()){
                    counter++;
                }
            }
        }
        return counter;
    }

    private int checkThreeOfKindInt(){
        int counter = 0;
        //Triple for loop to evaluate for three of a kind
        for(int i = 0; i < hand.length; i++){
            for(int j = i + 1; j < hand.length; j++){
                for(int k = j + 1; k < hand.length; k++) {
                    //Main check for three of a kind
                    if (hand[i].getCardNum() == hand[j].getCardNum() && hand[j].getCardNum() == hand[k].getCardNum()) {
                        counter++;
                    }
                }
            }
        }
        //Number of Three of a Kinds found
        return counter;
    }

    public boolean checkNoPair(){
        return checkPairInt() == 0;
    }

    public boolean checkPair(){
        return checkPairInt() == 1;
    }

    public boolean checkTwoPair(){
        return checkPairInt() == 2;
    }

    public boolean checkThreeOfKind(){
        return checkThreeOfKindInt() == 1;
    }
    
    public boolean checkStraight(){
        Arrays.sort(this.hand);
        System.out.println(Arrays.toString(this.hand));
        return false;
    }

    public void printHand(){
        System.out.println(Arrays.toString(hand));
    }

    public void printDeck(){
        deck.printDeck();
    }


}
