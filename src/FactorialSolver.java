import java.math.BigInteger;

public class FactorialSolver {

    public FactorialSolver(){
    }

    public BigInteger factorial(int fact){
        BigInteger factorial = BigInteger.ONE;
        BigInteger iterations = BigInteger.ONE;
        for (int i = 1; i <= fact; i++) {
            factorial = factorial.multiply(iterations);
            iterations = iterations.add(BigInteger.ONE);
        }
        return factorial;
    }

    public BigInteger factorialR(int n){
        if(n == 1){
            return BigInteger.ONE;
        }
        return factorialR(n - 1).multiply(BigInteger.valueOf(n));
    }
}
