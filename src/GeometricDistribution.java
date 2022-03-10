public class GeometricDistribution{

    public GeometricDistribution(){

    }

    public double geometricDistribution(double p, double q, double x){
        double distribution = Math.pow(q, x - 1) * p;
        return distribution;
    }

    public double expected(double p){
        double expected = 1/p;
        return expected;
    }

    public double variance(double p){
        double variance = (1 - p)/(p * p);
        return variance;
    }

    public double standardDev(double p){
        double standardDev = Math.sqrt(variance(p));
        return standardDev;
    }
}
