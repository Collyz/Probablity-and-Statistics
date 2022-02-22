import java.math.*;

public class BinomialDistribution {
    private BigDecimal positiveOutcome;
    private BigDecimal negativeOutcome;
    private BigDecimal population;
    private BigDecimal grouping;
    private BigDecimal populationMinusGrouping;
    private int happeningPower;
    private int notHappeningPower;

    public BinomialDistribution(double p, double q, double n, int x){
        this.positiveOutcome = new BigDecimal(p);
        this.negativeOutcome = new BigDecimal(q);
        this.population = new BigDecimal(n);
        this.grouping = new BigDecimal(x);
        this.populationMinusGrouping = population.subtract(grouping);
        this.happeningPower = x;
        this.notHappeningPower = population.intValue() - happeningPower;
    }

    public BigDecimal distribution(){
        BigDecimal happening = getPositiveOutcome().pow(getHappeningPower());
        BigDecimal notHappening = getNegativeOutcome().pow(getNotHappeningPower());
        BigDecimal distributionNoRound = combinations().multiply(happening.multiply(notHappening));
        MathContext decimalPlaces = new MathContext(10);
        BigDecimal distributionRound = distributionNoRound.round(decimalPlaces);
        System.out.println(distributionRound);
        return combinations().multiply(happening.multiply(notHappening));

    }
    public BigDecimal combinations(){
        BigDecimal top = factorial(getPopulation());
        BigDecimal bottom = factorial(getGrouping());
        BigDecimal bottomPar = factorial(getPopulationMinusGrouping());
        BigDecimal combination = top.divide(bottom.multiply(bottomPar));
        return combination;
    }

    public BigDecimal variance(){
        BigDecimal variance = getPopulation().multiply(getPositiveOutcome().multiply(getNegativeOutcome()));
        return variance;
    }

    public BigDecimal standardDev(){

        MathContext decimalPlaces = new MathContext(10);
        BigDecimal standardDev = variance().sqrt(decimalPlaces);
        return standardDev;
    }

    private BigDecimal factorial(BigDecimal fact){
        int num = fact.intValue();
        BigDecimal factorial = BigDecimal.ONE;
        BigDecimal iterations = BigDecimal.ONE;
        for(int i = 0; i < num; i++){
            factorial = factorial.multiply(iterations);
            iterations = iterations.add(BigDecimal.ONE);
        }
        return factorial;
    }

    public BigDecimal getPositiveOutcome(){
        return positiveOutcome;
    }

    public BigDecimal getNegativeOutcome(){
        return negativeOutcome;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public BigDecimal getGrouping(){
        return grouping;
    }

    public BigDecimal getPopulationMinusGrouping(){
        return populationMinusGrouping;
    }

    public int getHappeningPower(){
        return happeningPower;
    }

    public int getNotHappeningPower(){
        return notHappeningPower;
    }
}
