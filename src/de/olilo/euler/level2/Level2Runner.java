package de.olilo.euler.level2;

import de.olilo.euler.AbstractRunner;
import de.olilo.euler.Problem;

import java.io.IOException;
import java.io.PrintStream;

public class Level2Runner extends AbstractRunner {

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
    private Problem37TruncatablePrimes problem37 = new Problem37TruncatablePrimes();
    private Problem38PandigitalMultiples problem38 = new Problem38PandigitalMultiples();
    private Problem39IntegerRightTriangles problem39 = new Problem39IntegerRightTriangles();
    private Problem40ChampernownesConstant problem40 = new Problem40ChampernownesConstant();
    private final Problem41PandigitalPrime problem41 = new Problem41PandigitalPrime();
    private Problem42CodedTriangleNumbers problem42 = new Problem42CodedTriangleNumbers();
    private Problem43SubStringDivisibility problem43 = new Problem43SubStringDivisibility();
    private final Problem problem44 = new Problem44PentagonalNumbers();
    private final Problem problem45 = new Problem45TriangularPentagonalHexagonal();

    @Override
    protected void initFileReaders() throws IOException {
        problem42.initialize(this);
    }

    @Override
    public void runProblems(PrintStream out) throws IOException {
        this.currentProblemNumber = 26;
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

        out.println("Problem 37: sum of the only eleven primes that are both truncatable from left to right and right to left: " +
                problem37.sumOf(problem37.findAllTruncatablePrimes()));
        problemFinished();

        out.println("Problem 38: largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product" +
                " of an integer with (1,2, ... , n): " + problem38.getBiggestPandigitalProduct());
        problemFinished();

        out.println("Problem 39: Maximum number of right-angle triangles for perimeter p, p <= 1000: " +
                problem39.getMaxSolutionCountUntil(1000));
        problemFinished();

        out.println("Problem 40: Champernownes constant - find digit product: " +
                problem40.getDigitProduct(10, 6));
        problemFinished();

        out.println("Problem 41: Largest 9-digit pandigital prime is: " +
                problem41.findLargestPandigitalPrime());
        problemFinished();

        out.println("Problem 42: " + problem42.getMessage() + problem42.runProblem(this));
        problemFinished();

        out.println("Problem 43: " + problem43.getMessage() + problem43.runProblem(this));
        problemFinished();

        out.println("Problem 44: " + problem44.getMessage() + problem44.runProblem(this));
        problemFinished();

        out.println("Problem 45: " + problem45.getMessage() + problem45.runProblem(this));
        problemFinished();
    }
}
