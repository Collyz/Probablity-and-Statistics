public class PermutationsAndCombinations {
    private int totalObjects;
    private int grouping;


    public PermutationsAndCombinations(int t, int g) {
        this.totalObjects = t;
        this.grouping = totalObjects - g;
    }

    private int factorial(int fact) {
        int total = 1;
        int number = fact;
        for (int i = 1; i <= number; i++) {
            total = total * i;
        }
        return total;
    }

    public void permuations() {
        int total = factorial(totalObjects);
        int groups = factorial(grouping);
        int perm = total/groups;
        System.out.println(perm);
    }
}
