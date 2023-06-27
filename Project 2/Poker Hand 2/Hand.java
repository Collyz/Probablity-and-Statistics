import java.util.Arrays;
import java.util.HashMap;

public class Hand {
    
    private Card2[] hand;
    private Deck2 deck;

    public Hand(){
        hand = new Card2[5];
        deck = new Deck2();
        deck.fillDeck();
    }

    public void fillHand(){
        hand = deck.drawFiveCards();
    }

    public void drawSpecificCard(String suite, int cardNum, int handIndex){
        hand[handIndex] = deck.drawSingleCard(suite, cardNum);
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
        int counter = 0;
        Arrays.sort(this.hand);
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(hand[i].getCardNum() == hand[j].getCardNum()-1){
                    counter++;
                }
            }
        }
        return counter == 5;
    }

    public boolean checkFullHouse(){
        return (checkPairInt() + checkThreeOfKindInt()) == 5;
    }

    public boolean checkFlush(){
        //Stores the suites of each kind found
        int spadesCount = 0;
        int heartsCount = 0;
        int diamondsCount = 0;
        int clubsCount = 0;
        //The check done for the whole hand
        for(int i = 0; i < hand.length; i++){
            if(hand[i].getSuite().equals("Spades")){
                spadesCount++;
            }
            if(hand[i].getSuite().equals("Hearts")){
                heartsCount++;
            }
            if(hand[i].getSuite().equals("Diamonds")){
                diamondsCount++;
            }
            if(hand[i].getSuite().equals("Clubs")){
                clubsCount++;
            }
        }
        //If there is 5 of the same suite in the hand then the method returns true
        return (spadesCount == 5|| heartsCount == 5|| diamondsCount == 5 || clubsCount == 5);
    }

    public boolean checkStraightFlush(){
        return checkStraight() && checkFlush();
    }

    public boolean checkFourOfKind(){
        return checkPairInt() == 6;
    }

    public boolean checkRoyalFlush(){
        int royalCount = 0;
        int royalFlushCount = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i].isRoyalFlag()){
                royalCount++;
            }
            if(hand[i].isRoyalFlushFlag()){
                royalFlushCount++;
            }
        }
        return royalCount == 4 && royalFlushCount == 5;
    }

    public void printHand(){
        System.out.println(Arrays.toString(hand));
    }

    public void printDeck(){
        deck.printDeck();
    }

    public void run(int runs){
        //Map to hold the values
        HashMap<String, Double> hands = new HashMap<String, Double>();
        hands.put("Pair", 0.0);
        hands.put("Three of a Kind", 0.0);
        hands.put("Two Pairs", 0.0);
        hands.put("Straight", 0.0);
        hands.put("FullHouse", 0.0);
        hands.put("Flush", 0.0);
        hands.put("Four of a Kind", 0.0);
        hands.put("No Pair", 0.0);
        hands.put("Straight Flush", 0.0);
        hands.put("Royal Flush", 0.0);
        /* TODO: Reorder hands starting with: no pair (DONE), one pair, two pair, three of a kind, 
         * straight, flush, full house, four of a kind, straight flush, royal flush
         */
        for(int i = 0; i < runs; i++){
            deck.shuffle();
            hand = deck.drawFiveCards();
            if(checkNoPair()){
                hands.put("No Pair", hands.get("No Pair") + 1);
            }
            if(checkPair()){
                hands.put("Pair", hands.get("Pair") + 1 );
            }
            if(checkThreeOfKind()){
                hands.put("Three of a Kind", hands.get("Three of a Kind") + 1 );
            }
            if(checkTwoPair()){
                hands.put("Two Pairs", hands.get("Two Pairs") + 1 );
            }
            if(checkStraight()){
                hands.put("Straight", hands.get("Straight") + 1 );
            }
            if(checkFullHouse()){
                hands.put("FullHouse", hands.get("FullHouse") + 1 );
            }
            if(checkFlush()){
                hands.put("Flush", hands.get("Flush") + 1 );
            }
            if(checkStraightFlush()){
                hands.put("Straight Flush", hands.get("Straight Flush") + 1 );
            }
            if(checkFourOfKind()){
                hands.put("Four of a Kind", hands.get("Four of a Kind") + 1 );
            }
            if(checkRoyalFlush()){
                hands.put("Royal Flush", hands.get("Royal Flush") + 1 );
            }
            deck.fillDeck();
        }
        
        //Formats and displays the percents in an appropriate manner
        System.out.printf("Pair: %.2f", (hands.get("Pair")/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Three Of A Kind: %.2f", (hands.get("Three of a Kind")/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Two Pairs: %.2f", (hands.get("Two Pairs")/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Straights: %.2f", (hands.get("Straight")/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Full House: %.2f", (hands.get("FullHouse")/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Flush: %.2f", (hands.get("Flush")/ runs) * 100);
        System.out.print("%\n");
        System.out.printf("Four Of A Kind: %.3f", (hands.get("Four of a Kind")/ runs) * 100);
        System.out.print("%\n");
        System.out.printf("Straight Flush: %.6f", (hands.get("Straight Flush")));
        System.out.print("%\n");
        System.out.printf("Royal Flush: %.6f", (hands.get("Royal Flush")));
        System.out.print("%\n");
        System.out.printf("No Pair: %.2f", (hands.get("No Pair")/runs) * 100);
        System.out.print("%\n");
    }
}
