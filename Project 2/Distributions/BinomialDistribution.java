import java.math.*;

public class BinomialDistribution extends FactorialSolver{

    //Constructor for the class, does not initialize any private variables or have any parameters
    public BinomialDistribution(){

    }

    /** Method 'binomialDistribution' accepts two ints and a double.
    * The method calculates the binomial distribution of a problem given the correct values
    * The variables follow:
    * @param n = n                         ( n )
    * @param r = y       p(y) = P(Y = y) = ( y ) * p ^ (y) * (1 - p)^(n-y) **BINOMIAL FORMULA** (uses combination)
    * @param p = p
    */
    public BigDecimal binomialDistribution(int n, int r, double p){
        //Right side of the formula where p ^ (y) * (1 - p)^(n-y)
        BigDecimal likely = BigDecimal.valueOf(p).pow(r);
        BigDecimal unlikely = BigDecimal.valueOf(1 - p).pow(n - r);
        //Combination part of the formula
        BigDecimal comb = new BigDecimal(combination(n, r));
        //Rounded to ten decimal places
        MathContext round = new MathContext(10);
        //Multiplying the following the formula (n choose y) * ( p raised to y) * ((1 - p) raised to (n - y))
        BigDecimal distribution = comb.multiply(likely.multiply(unlikely)).round(round);
        return distribution;
    }

    /** The method 'expected' accepts two doubles, n and p
    * The method calculates the expected value of a binomial distribution problem.
    * The variables follow:
    * @param n = n
    * @param p = p     μ = E(Y) = n * p  **EXPECTED FORMULA**
     */
    public double expected(double n, double p){
        //Follows the formula exactly multiplying n with p
        double expected = n * p;
        return expected;
    }

    /** The method 'variance' accepts two doubles, n and p
     * The method calculates the variance of a binomial distribution problem.
     * The variables follow:
     * @param n = n
     * @param p = p     V(Y) = n * p * ( 1 - p)  **VARIANCE FORMULA**
     */
    public double variance(double n, double p){
        //Finding q which is the probability of not occurring
        double q = 1 - p;
        //Following the formula of variance exactly
        double variance = n * (p * q);
        return variance;
    }

    /** The method 'standardDev' accepts two doubles, n and p
     * The method calculates the standard deviation of a binomial distribution problem.
     * The variables follow:
     * @param n
     * @param p
     * The standard deviation is the square root of the variance. The code follows this
     */
    public double standardDev(double n, double p){
        //Square root of the variance
        double standardDev = Math.sqrt(variance(n, p));
        return standardDev;
    }

    /**The method 'combination' accepts two integers n and r
    * The method calculates the combinations possible given the total n and the group r
    * The variables follow:
    * @param n = n             n!
    * @param r = r   nCr = ----------     **COMBINATION FORMULA**
    *                   r!(n - r)!
     */
    public BigInteger combination(int n, int r){
        //The factorial calculations of n!, r! and (n - r)!
        BigInteger population = factorial(n);
        BigInteger group = factorial(r);
        BigInteger groupMinusPop = factorial(n - r);
        //The final calculation of the three factorial calculations above
        BigInteger combination = population.divide(group.multiply(groupMinusPop));
        return combination;
    }

    //Runs all of methods
    public void runAll(int n, int r, double p){
        System.out.println("Binomial Distribution: " + binomialDistribution(n, r, p).multiply(new BigDecimal(100)) + "%");
        System.out.println("Expected: " + expected(n, p));
        System.out.println("Variance: " + variance(n, p));
        System.out.println("Standard Deviation: " + standardDev(n, p));
        System.out.println();
    }

}
