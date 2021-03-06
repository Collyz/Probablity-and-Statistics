import java.util.ArrayList;

public class HandEvaluator {

    private Deck deck;  //Creates the deck to evaluate
    private ArrayList<Card> hand;   //Creates the hand to evaluate

    //Constructor of the class accepts no parameters. It initializes all private variables and populates the deck with Card objects
    public HandEvaluator(){
        deck = new Deck();
        deck.fillDeck();
        hand = new ArrayList<>();
    }

    //Method 'drawFive' accepts no parameters.
    //It fills the ArrayList hand with 5 random cards from the deck
    public boolean drawFive(){
        //If the hand ArrayList "hand" is not empty, this removes all cards in hand
        if(hand.size() > 0 ){
            hand.clear();
        }
        //Checks to see if cards can still be drawn. If true then 5 cards are drawn and displayed
        if(deck.handStatus()) {
            String print = "";
            deck.shuffle();
            //Draws 5 Cards and puts them into the ArrayList hand
            for (int i = 0; i < 5; i++) {
                hand.add(deck.drawCard());
                print = print + hand.get(i) + " | ";
            }
            print = print.substring(0, print.length() - 2); //Allows for the 5 cards that are drawn to be displayed if needed
            //System.out.println(print);
            return true;
        }
        else{
            System.out.println("No more cards to draw");
            return false;
        }
    }
    //The method 'checkPair' accepts no parameters and returns true if there is only a single pair in the hand.
    public boolean checkPair(){
        int counter = 0;
        //Double for loops check for pairs and add one to counter each time a pair is found
        for(int i = 0; i < hand.size(); i++){
            for(int j = i + 1; j < hand.size(); j++){
                if( hand.get(i).getCardNum() == hand.get(j).getCardNum()){
                    counter++;
                }
            }
        }
        //If only one pair is found then the method returns true
        if(counter == 1){
            return true;
        }
        //If more than one pair is found then the method return false
        else if(counter > 1){
            checkTwoPairs();
            return false;
        }
        else{return false;}
    }

    //This method is nearly identical to checkPair however it returns the counter to indicate the number of pairs found in the hand
    //It is exclusively used in checkFullHouse
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

    //The method 'checkThreeOfKind' accepts no parameters and checks for three of a kind in the hand
    //Returns true if a three of a kind is found
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
        //If one three of a kind is found the method returns true
        if(counter == 1){
            return true;
        }
        //If no three of a kind is found the method return false
        else{return false;}

    }

    //The method 'checkThreeOfKindInt() is nearly identical to the method checkThreeOfKind except this method
    //returns the counter that holds how many three of a kind were found in the hand. This method is used exclusively in checkFullHouse
    private int checkThreeOfKindInt(){
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
        //returns the number of Three of a Kinds found
        return counter;
    }

    //The method 'checkTwoPairs' accepts no parameters and returns true if two pairs are found in the hand
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
        //If there are exactly two pairs then the method returns true
        if(counter == 2){
            return true;
        }
        //If there aren't two pairs then the method returns false
        else{return false;}

    }

    //The method 'checkStraight' accepts no parameters and returns true of there is a straight in the hand
    public boolean checkStraight(){
        //Keeps track of instances where the card on top is exactly one number greater than the card below it
        int check = 0;
        //Creates an array 'numbers' and stores the hand's Card number values in the array
        int[] numbers = new int[hand.size()];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = hand.get(i).getCardNum();
        }
        //Sorts the numbers from largest to smallest
        numbers = sort(numbers);
        for(int j = 0; j < numbers.length;j++){
            for(int k = j + 1; k < numbers.length; k++){
                //Check to see if there is a straight
                if(numbers[j] - 1 == numbers[k]){
                    check++;
                }
            }
        }
        //If there are five instances of a Card above another card being exactly one greater than the one below it then the method returns true
        if(check == 5){
            return true;
        }
        //If there aren't five instances then the method return false
        else{return false;}

    }

    //The method 'checkFullHouse' accepts no parameters and returns true if there is a full house in the hand
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

    //The method 'checkFlush' accepts no parameters and return true if there is a flush in the hand
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
        if(spadesCount == 5|| heartsCount == 5|| diamondsCount == 5 || clubsCount == 5){
            return true;
        }
        //If the cards aren't 5 of the same suite then the method returns false
        else{return false;}

    }

    //The method 'checkFourOfKind' accepts no parameters and checks if there are 4 of a kind in the hand
    public boolean checkFourOfKind(){
        //Keeps track of pairs found
        int check = 0;
        //Creates an array 'numbers' and stores the hand's Card number values in the array
        int[] numbers = new int[hand.size()];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = hand.get(i).getCardNum();
        }
        //Sorts the numbers from largest to smallest
        numbers = sort(numbers);
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
        //Creates an array 'counts' to store each time one of the checks returns true
        double[] counts = new double[7];
        for(int i = 0; i < runs; i++){
            drawFive();
            if(checkPair()){
                counts[0] = counts[0] + 1;
            }
            if(checkThreeOfKind()){
                counts[1] = counts[1] + 1;
            }
            if(checkTwoPairs()){
                counts[2] = counts[2] + 1;
            }
            if(checkStraight()){
                counts[3] = counts[3] + 1;
            }
            if(checkFullHouse()){
                counts[4] = counts[4] + 1;
            }
            if(checkFlush()){
                counts[5] = counts[5] + 1;
            }
            if(checkFourOfKind()){
                counts[6] = counts[6] + 1;
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
        System.out.print("%");
    }

    //The method 'sort' is a helper method that is a selection to arrange integers from largest to smallest
    //It accepts a parameter of int[] array and returns an int[] array
    private int[] sort(int[] array){
        int[] temp = array;
        for(int i = 0; i < temp.length - 1; i++){
            //Stores the largest number found in the array in int maxPos
            int maxPos = maxPosition(temp, i);
            //Swapping the larger number with the smaller number in the array
            swap(temp, maxPos, i);
        }
        return temp;
    }

   //The method 'maxPosition' is a helper class for the method 'sort'. It aids in the selection sort
   //The method accepts an int[] array 'a' and an integer 'from' which it then returns an int
   //The int returned is the largest number from the array
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

    //The method 'swap' is a helper class for the method 'sort'. It aids in the selection sort
    //The method accepts an int[] array 'a', int 'i' and int 'j'
    //The method swaps the values stored at the index values of a[i] and a[j]
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}