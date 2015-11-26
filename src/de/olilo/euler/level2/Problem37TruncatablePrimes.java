package de.olilo.euler.level2;

import de.olilo.util.PrimesIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem37TruncatablePrimes {

    public int sumOf(List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public List<Integer> findAllTruncatablePrimes() {
        final List<Integer> truncatablePrimes = new ArrayList<>();
        final Iterator<Integer> primes = PrimesIterable.INSTANCE.iterator();
        while (truncatablePrimes.size() < 11) {
            final int prime = primes.next();
            if (prime < 10) {
                continue;
            }
            if (isTruncatablePrime(prime)) {
                truncatablePrimes.add(prime);
            }
        }
        return truncatablePrimes;
    }

    public boolean isTruncatablePrime(int prime) {
        final String primeString = Integer.toString(prime);
        for (int i = 1; i < primeString.length(); i++) {
            if (!PrimesIterable.INSTANCE.isPrime(new Integer(primeString.substring(i)))) {
                return false;
            }
        }
        for (int i = primeString.length(); i >= 1; i--) {
            if (!PrimesIterable.INSTANCE.isPrime(new Integer(primeString.substring(0, i)))) {
                return false;
            }
        }
        return true;
    }

}
