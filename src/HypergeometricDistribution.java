import java.math.*;
public class HypergeometricDistribution extends BinomialDistribution {

    //Constructor for the class, initializes no variables
    public HypergeometricDistribution(){

    }

    /** The hypergeometricDistribution method accepts 4 integers and returns the result after having calculated the hypergeometric distribution
    * The variables follow:
    * bigN = N                             ( r ) * ( N - r )
    * smallN = n                           ( y )   ( n - y )
    * r = r                   P(Y = y) = ----------------------  **HYPERGEOMETRIC FORMULA** (uses combination)
    * y = y                                    ( N )
    *                                          ( n )
    */
    public BigDecimal hypergeometricDistribution(int bigN, int smallN, int r, int y){
        //Top half of the formula
        BigDecimal rChooseY = new BigDecimal(combination(r, y));
        BigDecimal bigNChooseSmallNMinus = new BigDecimal(combination(bigN - r, smallN - y));
        //Bottom half of the formula
        BigDecimal bigNChooseSmallN = new BigDecimal(combination(bigN, smallN));
        //Multiplication that is done at the top of the formula
        BigDecimal topOfFormula = rChooseY.multiply(bigNChooseSmallNMinus);
        //The resulting calculation after dividing the top by the bottom of the formula
        BigDecimal result = topOfFormula.divide(bigNChooseSmallN, 5, RoundingMode.HALF_UP);
        return result;
    }

    /** The expected method accepts three doubles and returns the average of a hypergeometric distribution scenario
    * bigN = N                            ( n * r )
    * smallN = n              μ = E(Y) =  ---------     **EXPECTED FORMULA**
    * r = r                                ( N )
     */
    public double expected(double bigN, double smallN, double r){
        double expected = (smallN * r)/bigN;
        return expected;
    }

    /** The variance method accepts 3 doubles and returns the standard deviation for a hypergeometric distribution scenario
    * bigN = N                        ( r )   ( N - r )   ( N - n )
    * smallN = n              V(Y) =   ---  *  -------  *   -----       **VARIANCE FORMULA**
    * r = r                           ( n )     ( N )     ( N - 1 )
     */
    public double variance(double bigN, double smallN, double r){
        double variance = smallN * (r/smallN) * ((bigN - r)/bigN) * ((bigN - smallN)/(bigN - 1));
        return variance;
    }

    //The standard deviation is the square root of the variance. The code replicates this
    public double standardDev(double bigN, double smallN, double r){
        double standardDev = Math.sqrt(variance(bigN, smallN, r));
        return standardDev;
    }
}
