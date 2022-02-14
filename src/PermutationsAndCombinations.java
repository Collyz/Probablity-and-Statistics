import java.math.BigInteger;

public class PermutationsAndCombinations {
    private BigInteger totalObjects;
    private BigInteger grouping;
    private BigInteger totalMinusGroup;


    public PermutationsAndCombinations(int allObjects, int groupOfObjects) {
        this.totalObjects = BigInteger.valueOf(allObjects);
        this.grouping = BigInteger.valueOf(groupOfObjects);
        this.totalMinusGroup = totalObjects.subtract(BigInteger.valueOf(groupOfObjects));
    }

    public void permutations() {
        BigInteger total = factorial(totalObjects);
        BigInteger groups = factorial(totalMinusGroup);
        BigInteger perm = total.divide(groups);
        System.out.println("Permutation is: " + perm);
    }

    public void combinations(){
        BigInteger total = factorial(totalObjects);
        BigInteger groups = factorial(totalMinusGroup);
        BigInteger combination = total.divide((grouping.multiply(groups)));
        System.out.println("Combination is: " + combination);
    }

    private BigInteger factorial(BigInteger num) {
        BigInteger factorial = BigInteger.ONE;
        int number = num.intValue();
        BigInteger iterations = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(iterations);
            iterations = iterations.add(BigInteger.ONE);
        }
        return factorial;
    }
}
