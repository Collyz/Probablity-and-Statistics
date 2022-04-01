import java.math.*;

public class PoissonDistribution extends BinomialDistribution{

    //The constructor of this class. It has no parameters and initializes no private variables.
    public PoissonDistribution(){

    }

    /** The method 'poissonDistribution' accepts two integers x and lambda
     * The method calculates the success in a poisson distribution problem. This method assumes that lambda IS given.
     * The variables follow:
     * @param x = y                      λ^(y) * e^(-λ)
     * @param lambda = λ          p(y) = ---------------  **POISSON DISTRIBUTION FORMULA** (assumes lambda is given)
     *                                         y!
     */
    public BigDecimal poissonDistribution(int x, int lambda){
        //Top of formula
        BigDecimal topOfFormula = BigDecimal.valueOf(Math.exp(-lambda) * Math.pow(lambda, x)) ;
        //Factorial of the bottom of the formula
        BigDecimal bottomOfFormula = new BigDecimal(factorial(x));
        //Calculates the result of the entire poisson distribution formula
        BigDecimal result = topOfFormula.divide(bottomOfFormula);
        return result;
    }

    /** The method 'poissonDistribution' accepts three integers x, events and units
     * The method calculates the success in a poisson distribution problem. This method assumes that lambda IS NOT given.
     * The variables follow:
     * @param x = y                    events
     * @param events = events     λ = -------- **HOW TO FIND LAMBDA** (assumes lambda is not given)
     * @param units = units            units
     * The rest of the calculates after this follow the method above.
     */
    public BigDecimal poissonDistribution(int x, int events, int units){
        //To find lambda calculations
        int lambda = events/units;
        //Call to method above to do poisson distribution calculations.
        return poissonDistribution(x, lambda);
    }

    /** The method 'expected' accepts one integer lambda
     * The method calculates the expected of a poisson distribution. Assuming lambda IS given
     * The variables follow:
     * @param lambda = λ      μ = E(Y) = λ  **EXPECTED FORMULA** (Assumes lambda IS given)
     */
    public double expected(int lambda){
        return lambda;
    }

    /** The method 'expected' accepts two integers, events and units
     * The method calculates the expected of a poisson distribution. Assuming lambda IS NOT given
     * The variables follow:
     * @param events = events                   events
     * @param units  = units        μ = E(Y) = --------  **EXPECTED FORMULA** (Assumes lambda IS NOT given)
     *                                          units
     */
    public double expected(int events, int units){
        int lambda = events/units;
        return lambda;
    }

    /** The method 'variance' accepts one integer, lambda
     *  The method calculates the variance of a poisson distribution problem assuming lambda IS given.
     * The variables follow:
     * @param lambda = λ      V(Y) = λ    **HOW TO FIND LAMBDA** (assumes lambda IS given)
     */
    public double variance(int lambda){
        return lambda;
    }
    /** The method 'variance' accepts two integers, events and units
     * The method calculates the variance of a poisson distribution problem assuming lambda IS NOT given.
     * The variables follow:
     * @param events = events             events
     * @param units = units       V(Y) = --------  **HOW TO FIND VARIANCE** (assumes lambda IS NOT given)
     *                                    units
     */
    public double variance(int events, int units){
        return expected(events, units);
    }


    /** The method 'standardDev' accepts one integer lambda
     * The method calculates the standard deviation of a poisson distribution assuming lambda IS given.
     * The standard deviation is the square root of the variance.
     * @param lambda =
     *
     */
    public double standardDev(int lambda){
        //The square root of the variance
        return Math.sqrt(expected(lambda));
    }

    /** The method 'standardDev' accepts two integers, events and units
     * The method calculates the standard deviation of a poisson distribution assuming lambda IS NOT given.
     * The standard deviation is the square root of the variance.
     * @param events
     * @param units
     */
    public double standardDev(int events, int units){
        return Math.sqrt(expected(events, units));
    }

    public void runAll(int x, int lambda){
        System.out.println("Poisson Distribution: " + poissonDistribution(x, lambda).multiply(new BigDecimal(100)) + "%");
        System.out.println("Expected: " + expected(lambda));
        System.out.println("Variance: " + variance(lambda));
        System.out.println("Standard Deviation: " + standardDev(lambda));
        System.out.println();
    }

}
