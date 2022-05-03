import java.text.DecimalFormat;

public class UniformDistribution {

    public UniformDistribution(){

    }

    public double distribution(double lowerBound, double upperBound, double problemLBound, double problemUBound){
        double top = (problemUBound - problemLBound);
        double bottom = (upperBound - lowerBound);
        double solution = top/bottom;
        DecimalFormat df = new DecimalFormat("0.00000");
        String print = top + "/" + bottom + " or " + df.format(solution);
        System.out.println("Uniform Distribution: " + print);
        return solution;
    }

    public double expected(double lowerBound, double upperBound){
        double top = lowerBound + upperBound;
        double bottom = 2;
        double mean = top/bottom;
        String print = top + "/" + bottom + " or " + mean;
        System.out.println("Uniform Expected: " +print);
        return mean;
    }

    public double variance (double lowerBound, double upperBound){
        double top = Math.pow((upperBound - lowerBound), 2);
        double bottom = 12;
        double variance = top/bottom;
        String print = top + "/" + bottom + " or " + variance;
        System.out.println("Uniform Variance: " + print);
        return variance;
    }

    public double standDev(double lowerBound, double upperBound){
        double top = Math.pow((upperBound - lowerBound), 2);
        double bottom = 12;
        double variance = top/bottom;
        double standardDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.#####");
        String print = "\u221A(" +top + "/" + bottom + ") or " + df.format(standardDev);
        System.out.println("Standard Deviation: " + print);
        return standardDev;

    }

    public void runAll(double lowerBound, double upperBound, double problemLBound, double problemUBound){
        distribution(lowerBound, upperBound, problemLBound, problemUBound);
        variance(lowerBound, upperBound);
        standDev(lowerBound, upperBound);
    }
}
