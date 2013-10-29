package de.olilo.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

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

}
