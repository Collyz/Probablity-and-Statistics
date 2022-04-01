public class DistributionTester {
    public static void main(String[] args){
        //Binomial Distribution Test
        BinomialDistribution test1 = new BinomialDistribution();
        test1.runAll(10, 9, .3);
        //Geometric Distribution Test
        GeometricDistribution test2 = new GeometricDistribution();
        test2.runAll(.02, .98, 2);
        //Hypergeometric Distribution Test
        HypergeometricDistribution test3 = new HypergeometricDistribution();
        test3.runAll(196, 10, 101 ,7);
        //Poisson Distribution Test
        PoissonDistribution test4 = new PoissonDistribution();
        test4.runAll(4, 2);
        //Tchebysheff's Theorem Test
        TchebysheffTheorem test = new TchebysheffTheorem();
        test.tchebysheffTheorem(2, 20, 2);
    }
}
