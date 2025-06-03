package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimeFactors;

public class Problem47DistinctPrimeFactors implements Problem {

    @Override
    public String getMessage() {
        return "The first number of four consecutive integers with four distinct prime factors each is: ";
    }

    @Override
    public int getProblemNumber() {
        return 47;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findFirstOfConsecutiveIntegersWithNDistinctPrimeFactors(4);
    }

    /**
     * Returns the first integer of n consecutive integers which have n distinct prime factors,
     * where n is given as a method parameter.
     *
     * @param n the count of consecutive numbers and count of distinct prime factors
     * @return the first integer of n consecutive integers with n distinct prime factors
     */
    protected int findFirstOfConsecutiveIntegersWithNDistinctPrimeFactors(int n) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int primeFactorCount = PrimeFactors.countDistinct(i);

            // break if we go to far
            if (primeFactorCount > 10 * n) {
                break;
            }

            // current number does not have the required distinct prime factor count
            if (primeFactorCount != n) {
                continue;
            }

            boolean isConsecutivePrimeNumberCount = true;
            for (int j = 1; j < n; j++) {
                if (primeFactorCount != PrimeFactors.countDistinct(i + j)) {
                    isConsecutivePrimeNumberCount = false;
                    break;
                }
            }

            if (isConsecutivePrimeNumberCount) {
                return i;
            }
        }

        throw new RuntimeException("Could not find smallest number with " + n + " distinct prime factors");
    }

}
