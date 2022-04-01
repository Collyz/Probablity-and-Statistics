public class CardDeckTester {

    public static void main(String args[]) {

        //Evaluates the likely hood of poker hands given a certain number of runs
        HandEvaluator evaluator = new HandEvaluator();
        evaluator.runAll(10000);
    }
}
