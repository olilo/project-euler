package de.olilo.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An iterable over all primes. Starts at 2 and goes to infinity.
 *
 * The algorithm that finds the next prime is not very efficient,
 * but for up to 5-digit primes it's fast enough.
 */
public enum PrimesIterable implements Iterable<Integer> {

    INSTANCE;

    private final List<Integer> primes = new ArrayList<Integer>();

    private PrimesIterable() {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }

    public int countCachedPrimes() {
        return primes.size();
    }

    void preloadNextPrime() {
        synchronized (primes) {
            int nextPrime = primes.get(primes.size() - 1) + 2;
            while (true) {
                if (isPrime(nextPrime)) {
                    primes.add(nextPrime);
                    return;
                } else {
                    nextPrime += 2;
                }
            }
        }
    }

    boolean isPrime(int probablePrime) {
        for (int prime : primes) {
            if (probablePrime == prime) {
                return true;
            }
            if (probablePrime % prime == 0) {
                return false;
            }
        }
        return true;
    }

    private class PrimesIterator implements Iterator<Integer> {

        private int primeIndex = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            if (primeIndex >= primes.size()) {
                preloadNextPrime();
            }
            return primes.get(primeIndex++);
        }

        @Override
        public void remove() {
            // cannot remove a prime
            throw new UnsupportedOperationException();
        }
    }
}
