// https://www.decipherzone.com/blog-detail/top-programming-languages-for-desktop-apps-in-2021

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HandEvaluator {

    private Deck deck;  //Creates the deck to evaluate
    private ArrayList<Card> hand;   //Creates the hand to evaluate

    /**
     * Constructor of the class accepts no parameters.
     * It populates the deck with Card objects.
     */
    public HandEvaluator(){
        deck = new Deck();
        deck.fillDeck();
        hand = new ArrayList<>();
    }

    /**
     * Fills the ArrayList 'hand' with 5 random cards from the deck
     * @return Boolean that is determine by the success of 5 cards being drawn successfully
     */
    public boolean drawFive(){
        //If the hand ArrayList "hand" is not empty, this removes all cards in hand
        if(hand.size() != 0 ){
            hand.clear();
        }
        //Checks to see if cards can still be drawn. If true then 5 cards are drawn and displayed
        if(deck.handStatus()) {
            //String print = "";
            deck.shuffle();
            //Draws 5 Cards and puts them into the ArrayList hand
            for (int i = 0; i < 5; i++) {
                hand.add(deck.drawCard());
                //print += hand.get(i) + " | ";
            }
            //print = print.substring(0, print.length() - 2); //Allows for the 5 cards that are drawn to be displayed if needed
            //System.out.println(print);
            return true;
        }
        else{
            System.out.println("No more cards to draw");
            return false;
        }
    }

    /**
     * Checks to find a single pair in the hand
     * @return Boolean that is determine from only a single pair being in the hand
     */
    public boolean checkPair(){
        int counter = 0;
        //Double for loops check for pairs and add one to counter each time a pair is found
        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                if(hand.get(i).getCardNum() == hand.get(j).getCardNum()){
                    counter++;
                }
            }
        }
        
        // If only one pair is found 
        if(counter == 1){return true;}
        else if(counter > 1){
            // If more than one pair is found
            checkTwoPairs();
            return false;
        }
        else{return false;}
    }

    /**
     * This method is identical to checkPair however it returns the counter to indicate the number of pairs found in the hand.
     * It is exclusively used in checkFullHouse
     * @return The number of pairs in the hand
     */
    private int checkPairInt(){
        int counter = 0;
        //Double for loops check for pairs and add one to counter each time a pair is found
        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                if( hand.get(i).getCardNum() == hand.get(j).getCardNum()){
                    counter++;

                }
            }
        }
        return counter;
    }

    /**
     * Checks to find a three of a kind in the hand
     * @return Returns true if a three of a kind is found
     */
    public boolean checkThreeOfKind(){
        //Keeps track of three of a kinds found
        int counter = 0;
        //Triple for loop to evaluate for three of a kind
        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                for(int k = j + 1; k < hand.size(); k++) {
                    //Main check maid to see if three of a kind exists
                    if (hand.get(i).getCardNum() == hand.get(j).getCardNum() && hand.get(j).getCardNum() == hand.get(k).getCardNum()) {
                        counter++;
                    }
                }
            }
        }
        //If only one three of a kind is found the method returns true
        return counter == 1;
    }

    /**
     * The method is nearly identical to the method 'checkThreeOfKind' except it returns the number of three of a kind in hand.
     * Is used exclusively in checkFullHouse
     * @return Counter that holds how many three of a kind were found in the hand. 
     */
    private int checkThreeOfKindInt(){
        int counter = 0;
        //Triple for loop to evaluate for three of a kind
        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                for(int k = j + 1; k < hand.size(); k++) {
                    //Main check for three of a kind
                    if (hand.get(i).getCardNum() == hand.get(j).getCardNum() && hand.get(j).getCardNum() == hand.get(k).getCardNum()) {
                        counter++;
                    }
                }
            }
        }
        //Number of Three of a Kinds found
        return counter;
    }

    /**
     * Checks to find two pairs in the hand
     * @return The result if and only two pairs were found in the hand
     */
    public boolean checkTwoPairs(){
        //Keeps track of pairs found
        int counter = 0;

        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                if(hand.get(i).getCardNum() == hand.get(j).getCardNum()){
                    counter++;
                }
            }
        }
        //If only two pairs are found, the method returns true
        return counter == 2;

    }

    /**
     * Checks to find a straight in the hand.
     * @return The result if and only if a straight were found in the hand
     */
    public boolean checkStraight(){
        // If a card is larger than the next, check++
        int check = 0;

        /*  */
        // Sort the hand in descending order (largest -> smallest)
        sortDescending(this.hand);
        for(int i = 0; i < hand.size(); i++){
            for(int j = i+1; j < hand.size(); j++){
                if(hand.get(i).getCardNum() - 1 == hand.get(j).getCardNum()){
                    check++;
                }
            }
        }
        /* */

        //If there are five instances of a card being exactly one greater than the next returns true
        return check == 5;

    }

    /**
     * Checks to find a full house in the hand
     * @return The result if and only if a full house is found in the hand
     */
    public boolean checkFullHouse(){
        int counterOne = checkPairInt();   //Stores the number of pairs found
        int counterTwo = checkThreeOfKindInt();   //Stores the number of three of a kind found
        int total = counterOne + counterTwo;    //Sums up the total checks found

        //If the total = 5 then the hand holds a full house and the method returns true
        if(total == 5){
            return true;
        }
        //If total is not exactly 5 then the method returns false
        else {return false;}
    }

    /**
     * The method 'checkFlush' accepts no parameters and return true if there is a flush in the hand
     * @return The result if and only if a flush is found in the hand
     */
    public boolean checkFlush(){
        //Stores the suites of each kind found
        int spadesCount = 0;
        int heartsCount = 0;
        int diamondsCount = 0;
        int clubsCount = 0;
        //The check done for the whole hand
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getSuite().equals("Spades")){
                spadesCount++;
            }
            if(hand.get(i).getSuite().equals("Hearts")){
                heartsCount++;
            }
            if(hand.get(i).getSuite().equals("Diamonds")){
                diamondsCount++;
            }
            if(hand.get(i).getSuite().equals("Clubs")){
                clubsCount++;
            }
        }
        //If there is 5 of the same suite in the hand then the method returns true
        return spadesCount == 5|| heartsCount == 5|| diamondsCount == 5 || clubsCount == 5;

    }

    /**
     * Checks if there are 4 of a kind in the hand
     * @return The result if and only if a 4 of a kind is found in the hand
     */
    public boolean checkFourOfKind(){
        //Keeps track of pairs found
        int check = 0;
        //Creates an array 'numbers' and stores the hand's Card number values in the array
        int[] numbers = new int[hand.size()];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = hand.get(i).getCardNum();
        }
        //Sorts the numbers from largest to smallest
        numbers = sortDescending(numbers);
        for(int j = 0; j < numbers.length;j++){
            for(int k = j + 1; k < numbers.length; k++){
                //Checks for cards with the same number
                if(numbers[j] == numbers[k]){
                    check++;
                }
            }
        }
        //If six matches are found then the method return true
        if(check == 6){
            return true;
        }
        //If six matches are not found then the method returns false
        else{return false;}
    }

    /** The method 'runAll' accepts one integer runs
     * The method runs all the hand checks given a number of runs and presents it as a percentage
     * @param runs  The number of times to iterate the loop in the method
     */
    public void runAll(int runs) {
        HashMap<String, Integer> hands = new HashMap<String, Integer>();
        hands.put("Pair", 0);
        hands.put("Three of a Kind", 0);
        hands.put("Two Pairs", 0);
        hands.put("Straight", 0);
        hands.put("FullHouse", 0);
        hands.put("Flush", 0);
        hands.put("Four of a Kind", 0);
        hands.put("No Pair", 0);
        hands.put("Straight Flush", 0);
        hands.put("Royal Flush", 0);
        /* TODO: Reorder hands starting with: no pair, one pair, two pair, three of a kind, 
         * straight, flush, full house, four of a kind, straight flush, royal flush
          */

        //Creates an array 'counts' to store each time one of the checks returns true
        double[] counts = new double[7];
        for(int i = 0; i < runs; i++){
            drawFive();
            if(checkPair()){
                counts[0] = counts[0] + 1;
                hands.put("Pair", hands.get("Pair") + 1 );
            }
            if(checkThreeOfKind()){
                counts[1] = counts[1] + 1;
                hands.put("Three of a Kind", hands.get("Three of a Kind") + 1 );
            }
            if(checkTwoPairs()){
                counts[2] = counts[2] + 1;
                hands.put("Two Pairs", hands.get("Two Pairs") + 1 );
            }
            if(checkStraight()){
                counts[3] = counts[3] + 1;
                hands.put("Straight", hands.get("Straight") + 1 );
            }
            if(checkFullHouse()){
                counts[4] = counts[4] + 1;
                hands.put("FullHouse", hands.get("FullHouse") + 1 );
            }
            if(checkFlush()){
                counts[5] = counts[5] + 1;
                hands.put("Flush", hands.get("Flush") + 1 );
            }
            if(checkFourOfKind()){
                counts[6] = counts[6] + 1;
                hands.put("Four of a Kind", hands.get("Four of a Kind") + 1 );
            }
            deck.reset();
        }
        //Formats and displays the percents in an appropriate manner
        System.out.printf("Pair: %.2f", (counts[0]/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Three Of A Kind: %.2f", (counts[1]/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Two Pairs: %.2f", (counts[2]/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Straights: %.2f", (counts[3]/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Full House: %.2f", (counts[4]/runs) * 100);
        System.out.print("%\n");
        System.out.printf("Flush: %.2f", (counts[5] / runs) * 100);
        System.out.print("%\n");
        System.out.printf("Four Of A Kind: %.3f", (counts[6] / runs) * 100);
        System.out.print("%\n");
                //TODO: add Royal Flush, Straight Flush, No Pair/High Card
        System.out.println("Pair from map: " + (hands.get("Pair")));
    }

    /**
     * Selection sort to arrange integers in descending order (largest to smallest)
     * @param array The array of ints to sort
     * @return A sorted array
     */
    private int[] sortDescending(int[] array){
        int[] temp = array;
        for(int i = 0; i < temp.length - 1; i++){
            //Stores the largest number found in the array in int maxPos
            int maxPos = maxPosition(temp, i);
            //Swapping the larger number with the smaller number in the array
            swap(temp, maxPos, i);
        }
        return temp;
    }

    /**
     * Selection sort to arrange the cards in the hand in descending order (largest to smallest)
     * @param hand The hand of cards to sort
     */
    private void sortDescending(ArrayList<Card> hand){
        for(int i = 0; i < hand.size(); i++){
            //Stores the largest number found in the array in int maxPos
            int maxPos = maxPosition(hand, i);
            //Swapping the larger number with the smaller number in the array
            swap(hand, maxPos, i);
        }
    }

    /**
     * Helper method for sortDescending, aids in selection sort. Finds the next largest position
     * @param a The array to use
     * @param from The index to begin checking from
     * @return The next largest position
     */
   private int maxPosition(int[] a, int from) {
        int maxPos = from;
        for (int i = from + 1; i < a.length; i ++)
        {
            if (a[i] > a[maxPos])
            {
                maxPos = i;
            }
        }
        return maxPos;
    }

    /**
     * Helper method for sortDescending, aids in selection sort. Finds the next largest position
     * @param a The ArrayList to use
     * @param from The index to begin checking from
     * @return The next largest position
     */
    private int maxPosition(ArrayList<Card> a, int from){
        int maxPos = from;
        for(int i = from + 1; i < a.size(); i++){
            if(a.get(i).getCardNum() > a.get(maxPos).getCardNum()){
                maxPos = i;
            }
        }
        return maxPos;
    }

    //The method 'swap' is a helper class for the method 'sort'. It aids in the selection sort
    //The method accepts an int[] array 'a', int 'i' and int 'j'
    //The method swaps the values stored at the index values of a[i] and a[j]
    /**
     * Is a helper method for 'sortDescending'. It swaps two indexes in an array
     * @param a The array to be used
     * @param i Index swapped with j
     * @param j Index swapped with i
     */
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Is a helper method 'sortDescending'. It swaps two indexes in an ArrayList 
     * @param a The ArrayList to use
     * @param i Index swapped with j
     * @param j Index swapped with i
     */
    private void swap(ArrayList<Card> a, int i, int j){
        Collections.swap(a, i, j);
    }
}