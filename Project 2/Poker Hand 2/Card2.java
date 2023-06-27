public class Card2 {
    private boolean royalFlag;
    private String suite;
    private int cardNum;

    public Card2(String suite, int cardNum){
        this.suite = suite;
        this.cardNum = cardNum;
        if(cardNum > 10){
            this.royalFlag = true;
        }else{
            this.royalFlag = false;
        }
    }
}
