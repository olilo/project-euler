package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Problem49PrimePermutations implements Problem {

    @Override
    public String getMessage() {
        return "The twelve-digit number of the (other) three four-digit increasing prime sequence is: ";
    }

    @Override
    public int getProblemNumber() {
        return 49;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final int[] primeSequence = findPrimeSequenceAfter(1487);
        final String sequence = primeSequence[0] + Integer.toString(primeSequence[1]) + primeSequence[2];
        return new BigInteger(sequence);
    }

    protected int[] findPrimeSequenceAfter(int threshold) {
        for (int i = 1_000; i < 10_000; i++) {
            for (int step = 6; step < 2 * (10_000 - i); step += 6) {
                if (isPrimeSequence(i, step) && arePermutationsOfEachOther(i, i + step, i + 2 * step) && i > threshold) {
                    return new int[] {i, i + step, i + 2 * step};
                }
            }
        }

        return new int[] {};
    }

    protected boolean isPrimeSequence(int number, int step) {
        return PrimesIterable.INSTANCE.isPrime(number) && PrimesIterable.INSTANCE.isPrime(number + step) &&
                PrimesIterable.INSTANCE.isPrime(number + 2 * step);
    }

    protected boolean arePermutationsOfEachOther (int first, int second, int third) {
        final String firstSorted = getSortedString(Integer.toString(first));
        final String secondSorted = getSortedString(Integer.toString(second));
        final String thirdSorted = getSortedString(Integer.toString(third));

        return firstSorted.equals(secondSorted) && secondSorted.equals(thirdSorted);
    }

    protected String getSortedString(String input) {
        final char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
