package de.olilo.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    /**
     * Returns an array of all prime factors of the given number, sorted by prime factor ascending.
     * Multiple occurrences of a prime factor appear multiple times in the returned array.
     *
     * @param number the number to get the prime factors of
     * @return all prime factors of the given number
     */
    public static int[] of (long number) {
        final List<Integer> primeFactors = new ArrayList<Integer>();
        for (int prime : PrimesIterable.INSTANCE) {
            if (number == 1) {
                break;
            }
            while (number % prime == 0) {
                number /= prime;
                primeFactors.add(prime);
            }
        }

        // copy list to int array
        final int[] result = new int[primeFactors.size()];
        for (int i = 0; i < primeFactors.size(); i++) {
            result[i] = primeFactors.get(i);
        }
        return result;
    }

    /**
     * Counts the number of distinct prime factors of a number, e.g. countDistinct(14) results in 2
     * (because it has 2 and 7 as prime factors) or countDistinct(644) results in 3 because it has 3
     * distinct prime factors (2 twice, 7 and 23).
     *
     * @param number the number to get the distinct prime factor count of
     * @return the number of distinct prime factors of the given number
     */
    public static int countDistinct(long number) {
        if (number <= 0) {
            return 0;
        }

        int counter = 0;

        for (int prime : PrimesIterable.INSTANCE) {
            boolean isPrimeFactor = false;
            if (number == 1) {
                return counter;
            }
            while (number % prime == 0) {
                number /= prime;
                isPrimeFactor = true;
            }
            if (isPrimeFactor) {
                counter++;
            }
        }

        return 0;
    }

}
