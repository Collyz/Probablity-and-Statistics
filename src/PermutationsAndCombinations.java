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

    public void runAll() {
        System.out.println("Permutation is: " + permutations());
        System.out.println("Combination is: " + combinations() + "\n");
    }

    public BigInteger permutations() {
        BigInteger total = factorial(totalObjects);
        BigInteger groups = factorial(totalMinusGroup);
        BigInteger perm = total.divide(groups);
        return perm;
    }

    public BigInteger combinations(){
        BigInteger total = factorial(totalObjects);
        BigInteger possibleGroups = factorial(totalMinusGroup);
        BigInteger groups = factorial(grouping);
        BigInteger combination = total.divide((groups.multiply(possibleGroups)));
        return combination;
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
