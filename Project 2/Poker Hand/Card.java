public class Card implements Comparable<Card>{

    private int cardNum; //Stores card number
    private String suite; //Stores card suite

    /** 
     * The Constructor for the class.
     * Initializes private variables cardNum and suite using the accepted parameters
     * @param suite
     * @param cardNum
     */
    public Card(String suite, int cardNum){
        this.cardNum = cardNum;
        this.suite = suite;
    }

    @Override
    /**
     * It is used when wanting to print the value of a card
     * Cards of value 1 are "Ace"
     *       value 11 are "Jack"
     *       value 12 are "Queen"
     *       value 13 are "King"
     */
    public String toString(){
        String name = "";
        if(cardNum == 1){
            name = "Ace";
        }
        else if(cardNum == 11){
            name = "Jack";
        }else if(cardNum == 12){
            name = "Queen";
        }else if(cardNum == 13){
            name = "King";
        }else{
            name = Integer.toString(cardNum);
        }
        return name + " of " + suite;
    }

    /**
     * Returns the number of the card
     * @return Card number
     */
    public int getCardNum(){
        return cardNum;
    }
    /**
     * Returns the suite of the card i.e. 'Spades, Hearts, Diamongs, Clubs'
     * @return Card Suite
     */
    public String getSuite(){
        return suite;
    }

    @Override
    /**
     * 
     */
    public int compareTo(Card other) {
        int numCompare = Integer.compare(this.cardNum, other.cardNum);
        int suiteCompare = this.suite.compareTo(other.suite);
        System.out.println(numCompare + suiteCompare);
        return numCompare + suiteCompare;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }
    
}
