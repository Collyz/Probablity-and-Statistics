import java.math.*;

public class PoissonDistribution extends BinomialDistribution{

    public PoissonDistribution(){

    }

    public BigDecimal poissonDistribution(int x, int lambda){
        BigDecimal topOfFormula = BigDecimal.valueOf(Math.exp(-lambda) * Math.pow(lambda, x)) ;
        BigDecimal bottomOfFormula = new BigDecimal(factorial(x));
        BigDecimal result = topOfFormula.divide(bottomOfFormula);
        return result;
    }

    public BigDecimal poissonDistribution(int x, int events, int units){
        int lambda = events/units;
        return poissonDistribution(x, lambda);
    }

    public double expected(int lambda){
        return lambda;
    }

    public double expected(int events, int units){
        int lambda = events/units;
        return lambda;
    }

    public double variance(int events, int units){
        return expected(events, units);
    }

    public double standardDev(int lambda){
        return Math.sqrt(expected(lambda));
    }

    public double standardDev(int events, int units){
        return Math.sqrt(expected(events, units));
    }
}
