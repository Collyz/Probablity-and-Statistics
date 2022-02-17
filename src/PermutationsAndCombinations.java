import java.math.BigInteger;

public class PermutationsAndCombinations {
    private BigInteger totalObjects; //All items that can be grouped in different permutations/combinations
    private BigInteger grouping;  //The grouping for permutations/combinations
    private BigInteger totalMinusGroup;

    //Sets the number of items and the number of items in a group
    public PermutationsAndCombinations(int allObjects, int groupOfObjects) {
        this.totalObjects = BigInteger.valueOf(allObjects);
        this.grouping = BigInteger.valueOf(groupOfObjects);
        this.totalMinusGroup = totalObjects.subtract(BigInteger.valueOf(groupOfObjects));
    }

    //Runs all of the methods below runAll and prints out their return value
    public void runAll() {
        System.out.println("Permutation is: " + permutations());
        System.out.println("Combination is: " + combinations() + "\n");
    }

    //Returns the permutation for a given number of items grouped in a specific order
    public BigInteger permutations() {
        BigInteger total = factorial(totalObjects);
        BigInteger groups = factorial(totalMinusGroup);
        BigInteger perm = total.divide(groups);
        return perm;
    }

    //Returns the combination for a given number of items grouped in a non specific order
    public BigInteger combinations(){
        BigInteger total = factorial(totalObjects);
        BigInteger possibleGroups = factorial(totalMinusGroup);
        BigInteger groups = factorial(grouping);
        BigInteger combination = total.divide((groups.multiply(possibleGroups)));
        return combination;
    }

    //Factorial calculation for a number taken as a paramter
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
