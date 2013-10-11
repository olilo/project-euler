package de.olilo.euler;

/**
 * @author Oliver Lorenz
 * @since 0.1
 */
public class AllProblems {

    public static void main(String[] args) {
        System.out.println("Problem 1: Multiples of 3 and 5; result: " +
                new Problem1Multiples().solveIteratively(1000));
        System.out.println("Problem 2: Sum of even Fibonaccis to 4.000.000; result: " +
                new Problem2Fibonacci().solve(4000000));
        System.out.println("Problem 3: Largest prime factor of 600.851.475.143: " +
                new Problem3LargestPrime().getLargestPrimeOf(600851475143L));
    }

}
