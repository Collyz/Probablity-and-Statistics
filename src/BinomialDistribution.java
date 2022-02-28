import java.math.*;

public class BinomialDistribution extends FactorialSolver{

    public BinomialDistribution(){

    }

    public BigDecimal bionomialDistribution(int n, int r, double p){
        BigDecimal likely = BigDecimal.valueOf(p).pow(r);
        BigDecimal unlikely = BigDecimal.valueOf(1 - p).pow(n - r);
        BigDecimal comb = new BigDecimal(combination(n, r));
        MathContext round = new MathContext(10);
        BigDecimal distribution = comb.multiply(likely.multiply(unlikely)).round(round);
        return distribution;
    }

    public double expected(double n, double p){
        double expected = n * p;
        return expected;
    }
    public double variance(double n, double p, double q){
        double variance = n * p * q;
        return variance;
    }

    public double standardDev(double n, double p, double q){
        double standardDev = Math.sqrt(variance(n, p, q));
        return standardDev;
    }

    public BigInteger combination(int n, int r){
        BigInteger population = factorial(n);
        BigInteger group = factorial(r);
        BigInteger groupMinusPop = factorial(n - r);
        BigInteger combination = population.divide(group.multiply(groupMinusPop));
        return combination;
    }


}
