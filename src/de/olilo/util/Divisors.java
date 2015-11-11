package de.olilo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {

    /**
     * Returns the sum of all divisors of that number, excluding the number itself.
     *
     * @param number the number to get the divisor-sum of
     * @return the sum of all divisors of that number (excluding the number itself)
     */
    public static long sum(final long number) {
        final double limit = Math.sqrt(number);
        long sum = 1L;

        for(long i = 2; i <= limit; i++) {
            if (i == limit) {
                sum += i;
            } else if (number % i == 0) {
                sum += i;
                sum += number / i;
            }
        }

        return sum;
    }

    /**
     * Returns all numbers that the given number is divisible by.
     *
     * @param number the number to test
     * @return all divisors in ascending order
     */
    public static long[] of(final long number) {
        final double limit = Math.sqrt(number);
        final List<Long> divisorsList = new ArrayList<>();

        divisorsList.add(1L);
        divisorsList.add(number);

        for(long i = 2; i <= limit; i++) {
            if (i == limit) {
                divisorsList.add(i);
            } else if (number % i == 0) {
                divisorsList.add(i);
                divisorsList.add(number / i);
            }
        }

        Collections.sort(divisorsList);
        final long[] result = new long[divisorsList.size()];
        for (int i = 0; i < divisorsList.size(); i++) {
            result[i] = divisorsList.get(i);
        }
        return result;
    }

}
