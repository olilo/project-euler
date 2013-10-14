package de.olilo.euler;

import de.olilo.euler.level1.Problem1Multiples;
import de.olilo.euler.level1.Problem2Fibonacci;
import de.olilo.euler.level1.Problem3LargestPrime;
import de.olilo.euler.level1.Problem3PrimeFactorsAddendum;
import de.olilo.euler.level1.Problem4Palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.1
 */
public class AllProblems {

    private AllProblems() {
        // static-only class
    }

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final List<Long> timestamps = new ArrayList<Long>();
        System.out.println("Problem 1: Multiples of 3 and 5; result: " +
                new Problem1Multiples().solveIteratively(1000));
        timestamps.add(System.currentTimeMillis());
        System.out.println("Problem 2: Sum of even Fibonaccis to 4.000.000; result: " +
                new Problem2Fibonacci().solve(4000000));
        timestamps.add(System.currentTimeMillis());
        System.out.println("Problem 3: Largest prime factor of 600.851.475.143: " +
                new Problem3LargestPrime().getLargestPrimeOf(600851475143L));
        timestamps.add(System.currentTimeMillis());
        System.out.println("Addendum Problem 3: Smallest number with 100 unique prime factors: " +
                new Problem3PrimeFactorsAddendum().findSmallestNumberWithNDistinctPrimeFactors(100));
        timestamps.add(System.currentTimeMillis());
        System.out.println("Problem 4: Biggest palindrome that is the product of two 3-digit numbers: " +
                new Problem4Palindrome().findBiggestPalindromeFromTwoNDigitedNumbers(3));
        timestamps.add(System.currentTimeMillis());

        System.out.println();
        System.out.println("Solved all " + timestamps.size() + " problems");
        System.out.println("Average time needed: " + averageOf(timestamps, startTime) + "ms; " +
                "longest time: " + (Collections.max(timestamps) - startTime) + "ms; " +
                "total time: " + sum(timestamps, startTime) + "ms");
    }

    static double averageOf(List<Long> timestamps, long start) {
        return ((double) sum(timestamps, start)) / timestamps.size();
    }

    static long sum(List<Long> timestamps, long start) {
        long sum = 0;
        for (Long timestamp : timestamps) {
            sum += timestamp - start;
        }
        return sum;
    }

}
