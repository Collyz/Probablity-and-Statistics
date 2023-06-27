public class Tester {

    public static void main(String args[]) {

        //Evaluates the likely hood of poker hands given a certain number of runs
        HandEvaluator evaluator = new HandEvaluator();
        Card[] forceCards = new Card[5];
        forceCards[0] = evaluator.drawCard("Clubs", 1);
        forceCards[1] = evaluator.drawCard("Clubs", 10);
        forceCards[2] = evaluator.drawCard("Clubs", 11);
        forceCards[3] = evaluator.drawCard("Clubs", 12);
        forceCards[4] = evaluator.drawCard("Clubs", 13);
        evaluator.forceHand(forceCards);
        evaluator.runAll(1, false);
    }
}
