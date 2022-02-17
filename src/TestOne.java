public class TestOne {
    public static void main(String[] args){

        MeanMedianModeStandDevVariance test1 = new MeanMedianModeStandDevVariance(10, 10);
        test1.runAll();
        PermutationsAndCombinations test2 = new PermutationsAndCombinations(15, 3);
        test2.runAll();
        SetOperations test3 = new SetOperations(5, 10);
        test3.runAll();
    }
}
