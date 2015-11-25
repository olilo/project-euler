package de.olilo.euler.level2;

import de.olilo.euler.AbstractLevelRunner;

import java.io.IOException;
import java.io.PrintStream;

public class Level2Runner extends AbstractLevelRunner {

    private Problem26ReciprocalCycles problem26 = new Problem26ReciprocalCycles();
    private Problem27QuadraticPrimes problem27 = new Problem27QuadraticPrimes();
    private Problem28NumberSpiralDiagonals problem28 = new Problem28NumberSpiralDiagonals();
    private Problem29DistinctPowers problem29 = new Problem29DistinctPowers();
    private Problem30DigitFifthPowers problem30 = new Problem30DigitFifthPowers();
    private Problem31CoinSums problem31 = new Problem31CoinSums();
    private Problem32PandigitalProducts problem32 = new Problem32PandigitalProducts();
    private Problem33DigitCancellingFractions problem33 = new Problem33DigitCancellingFractions();
    private Problem34DigitFactorials problem34 = new Problem34DigitFactorials();
    private Problem35CircularPrimes problem35 = new Problem35CircularPrimes();
    private Problem36DoubleBasePalindromes problem36 = new Problem36DoubleBasePalindromes();

    @Override
    protected void initFileReaders() throws IOException {
    }

    @Override
    protected void runProblems(PrintStream out) throws IOException {
        runProblems26To30(out);
        runProblems31To35(out);
        runProblems36To40(out);
    }

    private void runProblems26To30(final PrintStream out) throws IOException {
        out.println("Problem 26: Longest recurring cycle for unit fractions until 1 / 1000: " +
                problem26.getUnitFractionWithLongestRecurringCycle(1000));
        problemFinished();

        out.println("Problem 27: a * b of longest chain of quadratic primes (n² + an + b): " +
                problem27.getLongestChainOfQuadraticPrimes(1000, 1000));
        problemFinished();

        out.println("Problem 28: number spiral diagonals sum of 1001x1001 spiral: " +
                problem28.getNumberSpiralDiagonalsFor(1001));
        problemFinished();

        out.println("Problem 29: number of distinct terms of a^b, 2 <= a <= 100, 2 <= b <= 100: " +
                problem29.getDistinctPowersOf2To(100, 100).size());
        problemFinished();

        out.println("Problem 30:  sum of all the numbers that can be written as the sum of fifth powers of their digits: " +
                problem30.sumOf(problem30.getNumbersEqualTheirDigitFifthPowers(1000000)));
        problemFinished();
    }

    private void runProblems31To35(final PrintStream out) throws IOException {
        out.println("Problem 31: How many different ways can 2 pounds be made using any number of coins " +
                "(1p, 2p, 5p, 10p, 20p, 50p, 1 pound, 2 pounds): " +
                problem31.getPossibleSolutionsFor(200).size());
        problemFinished();

        out.println("Problem 32: sum of all products whose multiplicand/multiplier/product identity " +
                "can be written as a 1 through 9 pandigital: " + problem32.pandigitalProductSum(10000));
        problemFinished();

        out.println("Problem 33: denominator of product of digit-cancelling fractions: " +
                problem33.getProductOf(problem33.getDigitCancellingFractionsBetween(10, 99)).getValue());
        problemFinished();

        out.println("Problem 34: sum of all numbers which are equal to the sum of the factorial of their digits: " +
                problem34.sumOfDigitFactorialsUntil(1_000_000));
        problemFinished();

        out.println("Problem 35: amount of circular primes below one million: " +
                problem35.getCircularPrimesUntil(1_000_000).size());
        problemFinished();
    }

    private void runProblems36To40(final PrintStream out) throws IOException {
        out.println("Problem 36: sum of all numbers, less than one million, which are palindromic in base 10 and base 2: " +
                problem36.sumOf(problem36.findPalindromesInBaseTenAndTwoUntil(1_000_000)));
        problemFinished();
    }
}
