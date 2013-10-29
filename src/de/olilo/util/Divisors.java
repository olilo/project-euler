package de.olilo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Divisors {

    /**
     * Returns all numbers that the given number is divisible by.
     *
     * @param number the number to test
     * @return all divisors in ascending order
     */
    public static long[] of(final long number) {
        // FIXME is there an algorithm to calculate this, with filtering out duplicates?
        // use a set to filter out duplicates
        final int[] primeFactors = PrimeFactors.of(number);

        final List<Long> divisorsList = new ArrayList<Long>(getUniqueDivisorsFromPrimeFactors(primeFactors));
        Collections.sort(divisorsList);
        final long[] result = new long[divisorsList.size()];
        for (int i = 0; i < divisorsList.size(); i++) {
            result[i] = divisorsList.get(i);
        }
        return result;
    }

    static Set<Long> getUniqueDivisorsFromPrimeFactors(final int[] primeFactors) {
        final Set<Long> divisors = new HashSet<Long>();
        for (int i = 0; i < Math.pow(2, primeFactors.length); i++) {
            long divisor = 1;
            for(int j = 0; j < primeFactors.length; j++) {
                if ((i & (2 << j) / 2) > 0) {
                    divisor *= primeFactors[j];
                }
            }
            divisors.add(divisor);
        }
        return divisors;
    }

}
