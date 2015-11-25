package de.olilo.euler.level2;

import de.olilo.util.PrimesIterable;

import java.util.ArrayList;
import java.util.List;

class Problem35CircularPrimes {

    public List<Integer> getCircularPrimesUntil(int limit) {
        final List<Integer> result = new ArrayList<>();
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime > limit) {
                return result;
            }
            if (isCircularPrime(prime)) {
                result.add(prime);
            }
        }
        return result;
    }

    public boolean isCircularPrime(int number) {
        final char[] digits = Integer.toString(number).toCharArray();
        for (int i = 1; i < digits.length; i++) {
            String probablePrime = "";
            for (int j = i; j < i + digits.length; j++) {
                probablePrime += digits[j % digits.length];
            }
            if (!PrimesIterable.INSTANCE.isPrime(new Integer(probablePrime))) {
                return false;
            }
        }
        return true;
    }

}
