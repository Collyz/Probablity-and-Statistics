import java.math.BigInteger;

public class FactorialSolver {

    //The constructor for the class. It accepts no parameters and initializes no private variables
    public FactorialSolver(){
    }

    //The method 'factorial' accepts an int fact and returns the factorial of that number
    public BigInteger factorial(int fact){
        BigInteger factorial = BigInteger.ONE;
        BigInteger iterations = BigInteger.ONE;
        //factorial calculation
        for (int i = 1; i <= fact; i++) {
            factorial = factorial.multiply(iterations);
            iterations = iterations.add(BigInteger.ONE);
        }
        return factorial;
    }

    //The method 'factorialR' is a recursive form of the method above, it also calculates the factorial
    //of the given parameter int n
    public BigInteger factorialR(int n){
        if(n == 1){
            return BigInteger.ONE;
        }
        //Recursive factorial calculation
        return factorialR(n - 1).multiply(BigInteger.valueOf(n));
    }
}
