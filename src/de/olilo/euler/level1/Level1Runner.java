package de.olilo.euler.level1;

import de.olilo.euler.AbstractRunner;
import de.olilo.util.GridReader;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Level1Runner extends AbstractRunner {

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
    private final Problem14CollatzSequence problem14 = new Problem14CollatzSequence();
    private final Problem15LatticePaths problem15 = new Problem15LatticePaths();
    private final Problem16PowerDigitSum problem16 = new Problem16PowerDigitSum();
    private final Problem17NumberLetterCounts problem17 = new Problem17NumberLetterCounts();
    private final Problem18MaximumPathSum problem18 = new Problem18MaximumPathSum();
    private final Problem19CountingSundays problem19 = new Problem19CountingSundays();
    private final Problem20FactorialDigitSum problem20 = new Problem20FactorialDigitSum();
    private final Problem21AmicableNumbers problem21 = new Problem21AmicableNumbers();
    private final Problem22Names problem22 = new Problem22Names();
    private final Problem23NonAbundantSums problem23 = new Problem23NonAbundantSums();
    private final Problem24LexicographicPermutations problem24 = new Problem24LexicographicPermutations();
    private final Problem25FibonacciNumber problem25 = new Problem25FibonacciNumber();

    @Override
    public void initFileReaders() throws IOException {
        addFileReader("8", "problemfiles/problem8number.txt");
        addFileReader("11", "problemfiles/problem11grid.txt");
        addFileReader("13", "problemfiles/problem13numbers.txt");
        addFileReader("18", "problemfiles/problem18triangle.txt");
        addFileReader("22", "problemfiles/problem22Names.txt");
    }

    @Override
    public void runProblems(final PrintStream out) throws IOException {
        runProblems1To5(out);
        runProblems6To10(out);
        runProblems11To15(out);
        runProblems16To20(out);
        runProblems21To25(out);
    }

    private void runProblems1To5(final PrintStream out) {
        out.println("Problem 1: Multiples of 3 and 5; result: " + problem1.solveByAlgorithm(1000));
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
    }

    private void runProblems6To10(final PrintStream out) throws IOException {
        out.println("Problem 6: Difference between square of sum and sum of squares up to 100: " +
                problem6.getSumSquareDifference(100));
        problemFinished();

        out.println("Problem 7: 10001st prime number is: " + problem7.getNthPrime(10001));
        problemFinished();

        out.println("Problem 8: Greatest product of five consecutive digits in 1000-digit number: " +
                problem8.greatestProduct(problem8.readNumberFrom(getFileReader("8")), 5));
        problemFinished();

        out.println("Problem 9: Pythagorean triplet with sum of 1000: " + problem9.findPythagoreanTriplet(1000));
        out.println("Problem 9 Addendum: with sum of 100000: " + problem9.findPythagoreanTriplet(100000));
        problemFinished();

        out.println("Problem 10: Sum of all primes up to 2.000.000: " + problem10.sumOfPrimesUpTo(2000000));
        problemFinished();
    }

    private void runProblems11To15(final PrintStream out) throws IOException {
        out.println("Problem 11: Greatest product in grid: " +
                problem11.findGreatestProductIn(new GridReader(getFileReader("11")).readGrid(), new Problem11GridProduct.GridFactorCount(4)));
        problemFinished();

        out.println("Problem 12: First Triangular number that has at least 500 divisors: " +
                problem12.findFirstTriangularNumberWithNDivisors(500));
        problemFinished();

        out.println("Problem 13: First ten digits of sum of numbers: " +
                problem13.firstTenDigitsOf(problem13.sumOf(problem13.readNumbersFrom(getFileReader("13")))));
        problemFinished();

        out.println("Problem 14: Longest Collatz sequence under 1 million: " +
                problem14.findLongestSequenceUnder(1000000));
        problemFinished();

        out.println("Problem 15: Number of lattice Paths through a 20x20 grid: " +
                problem15.latticePathsThroughGridWithLength(20));
        problemFinished();
    }

    private void runProblems16To20(final PrintStream out) throws IOException {
        out.println("Problem 16: Power digit sum - sum of digits of 2^1000: " +
                problem16.digitSumOfTwoToThePowerOf(1000));
        problemFinished();

        out.println("Problem 17: Number letter counts; letters in numbers from 1 to 1000: " +
                problem17.countLettersInNumberWordsFrom1To(1000));
        problemFinished();

        out.println("Problem 18: Maximum path sum in triangle: " +
                problem18.maximumPathSumOf(new GridReader(getFileReader("18")).readGrid()));
        problemFinished();

        final Calendar calendar = Calendar.getInstance();
        calendar.set(1901, Calendar.JANUARY, 1);
        final Date start = calendar.getTime();
        calendar.set(2000, Calendar.DECEMBER, 31);
        final Date finish = calendar.getTime();
        out.println("Problem 19: Counting sundays on first of month in twentieth century: " +
                problem19.countFirstOfMonthIsSundayBetween(start, finish));
        problemFinished();

        out.println("Problem 20: Digit sum of 100!: " +
                problem20.getFactorialDigitSum(100));
        problemFinished();
    }

    private void runProblems21To25(final PrintStream out) throws IOException {
        out.println("Problem 21: Sum of amicable numbers until 10.000: " +
                problem21.sumOfAmicableNumbersUntil(10000));
        problemFinished();

        out.println("Problem 22: Name score sum: " +
                problem22.sumOfNameScores(getFileReader("22")));
        problemFinished();

        out.println("Problem 23: sum of all the positive integers which cannot be written " +
                "as the sum of two abundant numbers: " + problem23.sumOfNonAbundantSumsUntil(28123));
        problemFinished();

        out.println("Problem 24: millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9: " +
                Arrays.toString(problem24.nthPermutationOf(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1000000)));
        problemFinished();

        out.println("Problem 25: index of the first term in the Fibonacci sequence to contain 1000 digits: " +
                problem25.fibonacciIndexWithDigitCount(1000));
        problemFinished();
    }

}
