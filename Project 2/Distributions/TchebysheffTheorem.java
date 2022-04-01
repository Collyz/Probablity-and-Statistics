public class TchebysheffTheorem {

    //Constructor for the class
    public TchebysheffTheorem(){

    }

    /** The method 'tchebysheffTheorem' accepts three doubles k
     * The method calculates the range in which most of the data will fall into withing a distribution of values
     * assuming k IS given
     * The variables follow:
     * @param k                                1
     * @param expected = μ               1 -  ---   →      μ - kσ       and       μ + kσ         **TCHEBYSHEFF'S THEOREM** (assumes k IS given), k > 1
     * @param standardDev = σ                 k^2       (lower bound)         (upper bound)
     */
    public String tchebysheffTheorem(double k, double expected, double standardDev){
        //Prevents k from being less than or equal to 1
        String print = "The expected is: " + expected + " ";
        if(k <= 1){
           throw new IllegalArgumentException("\"k\" must be greater than 1");
        }
        else{
            //First half of the calculations, left of arrow.
            double partOne = (1 - (1/Math.pow(k, 2))) * 100;
            //Second half of the calculations, right of arrow
            double partTwo = expected - (k * standardDev);
            double partThree = expected + (k * standardDev);
            //Combined String to return
            System.out.println("Tchebysheff's Theorem: ");
            print = print + "The range will be from " + partTwo + " to " + partThree + " with a likely hood of: " + partOne + "% of being in the range";
            System.out.println(print);
            return print;
        }
    }

    /** The method 'tchebysheffTheoremNoK' accepts two doubles, within and standardDev
     * The method calculates where range in which most of the data will fall into withing a distribution of values
     *  assuming k IS NOT given
     * The variables follow:                       within
     * @param within = withing                k = --------- **HOW TO FIND K** (assumes k IS NOT given), k > 1
     * @param standardDev = σ                        σ
     * @param expected =  μ
     */
    public String tchebysheffTheoremNoK(double within, double standardDev, double expected){
        //Calculates k
        double k = within/standardDev;
        //Further calculations are done by the method above
        return tchebysheffTheorem(k, expected, standardDev);
    }


}
