public class TchebysheffTheorem {

    //Constructor for the class
    public TchebysheffTheorem(){

    }

    public double tchebysheffTheorem(double k){
        if(k <= 1){
           throw new IllegalArgumentException("\"k\" is bigger than or equal to 1");
        }
        else{
            double result = 1 - (1/Math.pow(k, 2));
            return result;
        }
    }
    public double tchebysheffTheorem(double within, double standardDev){
        double k = within/standardDev;
        return tchebysheffTheorem(k);
    }

    public double variance(double population, double probSuccess){
        double variance = population * probSuccess * ( 1 - probSuccess);
        return variance;
    }

    public double standardDev(double population, double probSucess){
        double standardDev = variance(population, probSucess);
        return standardDev;
    }
}
