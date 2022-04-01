public class GeometricDistribution{

    //The constructor for the class
    public GeometricDistribution(){

    }
    /**The method 'geometricDistribution' accepts three doubles p, q, and x\
    * The method calculates the probability of a success given an x amount of trials
    * using the geometric distribution formula.
    * The variables follow:
    * @param p = p
    * @param q = q        p(y) = P(Y = y) = q^(y - 1) * p  **GEOMETRIC FORMULA**
    * @param x = y
     */
    public double geometricDistribution(double p, double q, double x){
        //Follows the formula exactly
        double distribution = Math.pow(q, x - 1) * p;
        return distribution;
    }

    /** The method 'expected' accepts a single double p
    * The method calculates the expected of a geometric distribution problem
    * The variables follow:
    * @param p = p        μ = E(Y) = 1 / p  **EXPECTED FORMULA**
     */
    public double expected(double p){
        //Follows the formula exactly
        double expected = 1/p;
        return expected;
    }

    /** The method 'variance' accepts a single double p
    * The method calculates the expected value of a geometric distribution problem
    * The variables follow:
    * @param p = p       V(Y) = ( 1 - p ) / p^2  **VARIANCE FORMULA**
     */
    public double variance(double p){
        //Top half of the fraction
        double topOfFraction = 1 - p;
        //Bottom half of the fraction
        double bottomOfFraction = p * p;
        //Combines both the top and bottom. This is the final result
        double variance = topOfFraction / bottomOfFraction;
        return variance;
    }

    /** The method 'standardDev accepts a single double p
    * The method calculates the standard deviation of a geometric distribution formula
    * The variables follow:
     * @param p
    * The standard deviation is the square root of the variance.
     */
    public double standardDev(double p){
        //Taking the square root of the variance.
        double standardDev = Math.sqrt(variance(p));
        return standardDev;
    }

    //Runs all of methods
    public void runAll(double p, double q, double x){
        System.out.println("Geometric Distribution: " + geometricDistribution(p, q, x) * 100 + "%");
        System.out.println("Expected: " + expected(p));
        System.out.println("Variance: " + variance(p));
        System.out.println("Standard Deviation: " + standardDev(p));
        System.out.println();
    }
}
