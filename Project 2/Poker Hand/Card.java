public class Card {

    private int cardNum; //Stores card number
    private String suite; //Stores card suite

    /** The Constructor for the class.
     * Initializes private variables cardNum and suite using the accepted parameters
     * @param suite
     * @param cardNum
     */
    public Card(String suite, int cardNum){
        this.cardNum = cardNum;
        this.suite = suite;
    }

    /** The method 'toString' accepts no parameters
     * It is used when wanting to print the value of a card
     * Cards of value 1 are "Ace"
     *          value 11 are "Jack"
     *          value 12 are "Queen"
     *          value 13 are "King"
     */
    public String toString(){
        String name = "";
        if(cardNum == 1){
            name = "Ace";
        }
        else if(cardNum == 11){
            name = "Jack";
        }
        else if(cardNum == 12){
            name = "Queen";
        }
        else if(cardNum == 13){
            name = "King";
        }
        else{
            name = Integer.toString(cardNum);
        }
        String formatted = name + " of " + suite;
        return formatted;
    }

    //This method 'getCardNum' returns the number of the card
    public int getCardNum(){
        return cardNum;
    }
    //This method 'getSuite' returns the suite of the card
    public String getSuite(){
        return suite;
    }

}
