public class Card2 {
    private boolean royalFlag;
    private String suite;
    private int cardNum;

    /**
     * Constructor for the class
     * @param suite The suite of the card (Spades, Hearts, Diamonds, Clubs)
     * @param cardNum The number of the card (1-13)
     */
    public Card2(String suite, int cardNum){
        this.suite = suite;
        this.cardNum = cardNum;
        if(cardNum > 10){
            this.royalFlag = true;
        }else{
            this.royalFlag = false;
        }
    }

    public boolean isRoyalFlag() {
        return royalFlag;
    }

    public void setRoyalFlag(boolean royalFlag) {
        this.royalFlag = royalFlag;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        String name = "";

        if(cardNum == 1){
            name += "Ace";
        }else if(cardNum == 11){
            name += "Jack";
        }else if(cardNum == 12){
            name += "Queen";
        }else if(cardNum == 13){
            name += "King";
        }else{
            name += Integer.toString(cardNum);
        }
        return name + " of " + suite;
    }

    public boolean compare(Card other){
        if(this.suite == other.getSuite() && this.cardNum == other.getCardNum()){
            return true;
        }
        return false;
    }
    
    public boolean compare(String suite, int cardNum){
        if(this.suite == suite && this.cardNum == cardNum){
            return true;
        }
        return false;
    }

    

}
