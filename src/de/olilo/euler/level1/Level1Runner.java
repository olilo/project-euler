package de.olilo.euler.level1;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Level1Runner {
    
    private final List<Long> timestamps = new ArrayList<Long>();

    private final Problem1Multiples problem1 = new Problem1Multiples();
    private final Problem2Fibonacci problem2 = new Problem2Fibonacci();
    private final Problem3LargestPrime problem3 = new Problem3LargestPrime();
    private final Problem3PrimeFactorsAddendum problem3Addendum = new Problem3PrimeFactorsAddendum();
    private final Problem4Palindrome problem4 = new Problem4Palindrome();
    private final Problem5SmallestMultiple problem5 = new Problem5SmallestMultiple();
    private final Problem6SumSquareDifference problem6 = new Problem6SumSquareDifference();
    private final Problem7NthPrime problem7 = new Problem7NthPrime();
    private final Problem8GreatestProduct problem8 = new Problem8GreatestProduct();
    private final Problem9PythagoreanTriplet problem9 = new Problem9PythagoreanTriplet();
    private final Problem10SumOfPrimes problem10 = new Problem10SumOfPrimes();
    private final Problem11GridProduct problem11 = new Problem11GridProduct();
    private final Problem12TriangularNumber problem12 = new Problem12TriangularNumber();
    private final Problem13LargeSum problem13 = new Problem13LargeSum();

    public List<Long> runWith(final PrintStream out) throws IOException {
        out.println("Problem 1: Multiples of 3 and 5; result: " + problem1.solveIteratively(1000));
        problemFinished();

        out.println("Problem 2: Sum of even Fibonaccis to 4.000.000; result: " + problem2.solve(4000000));
        problemFinished();

        // problem 3 and the addendum are merged into same timestamp statistic
        out.println("Problem 3: Largest prime factor of 600.851.475.143: " + problem3.getLargestPrimeOf(600851475143L));
        out.println("Addendum Problem 3: Smallest number with 100 unique prime factors: " +
                problem3Addendum.findSmallestNumberWithNDistinctPrimeFactors(100));
        problemFinished();

        out.println("Problem 4: Biggest palindrome that is the product of two 3-digit numbers: " +
                problem4.findBiggestPalindromeFromTwoNDigitedNumbers(3));
        problemFinished();

        out.println("Problem 5: Smallest multiple up to 20: " + problem5.findSmallestMultipleUpTo(20));
        problemFinished();

        out.println("Problem 6: Difference between square of sum and sum of squares up to 100: " +
                problem6.getSumSquareDifference(100));
        problemFinished();

        out.println("Problem 7: 10001st prime number is: " + problem7.getNthPrime(10001));
        problemFinished();

        final FileReader fileWithNumber = new FileReader("problem8number.txt");
        out.println("Problem 8: Greatest product of five consecutive digits in 1000-digit number: " +
                problem8.greatestProduct(problem8.readNumberFrom(fileWithNumber), 5));
        problemFinished();

        out.println("Problem 9: Pythagorean triplet with sum of 1000: " + problem9.findPythagoreanTriplet(1000));
        out.println("Problem 9 Addendum: with sum of 100000: " + problem9.findPythagoreanTriplet(100000));
        problemFinished();

        out.println("Problem 10: Sum of all primes up to 2.000.000: " + problem10.sumOfPrimesUpTo(2000000));
        problemFinished();

        final FileReader file11Grid = new FileReader("problem11grid.txt");
        out.println("Problem 11: Greatest product in grid: " +
                problem11.findGreatestProductIn(problem11.readGrid(file11Grid), new GridFactorCount(4)));
        problemFinished();

        out.println("Problem 12: First Triangular number that has at least 500 divisors: " +
                problem12.findFirstTriangularNumberWithNDivisors(500));
        problemFinished();

        final FileReader file13Numbers = new FileReader("problem13numbers.txt");
        out.println("Problem 13: First ten digits of sum of numbers: " +
                problem13.firstTenDigitsOf(problem13.sumOf(problem13.readNumbersFrom(file13Numbers))));
        problemFinished();

        // cleanup
        fileWithNumber.close();
        file11Grid.close();
        file13Numbers.close();

        return timestamps;
    }

    int countFinishedProblems() {
        return timestamps.size();
    }

    void problemFinished() {
        timestamps.add(System.currentTimeMillis());
    }

}
