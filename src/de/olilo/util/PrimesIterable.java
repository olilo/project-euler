package de.olilo.util;

import java.util.Iterator;

/**
 * An iterable over all primes. Starts at 2 and goes to Integer.MAX_VALUE.
 *
 * This class is threadsafe for all use cases.
 *
 * Pay attention when you go to very high numbers, as this Iterable does not clean up (yet).
 */
public enum PrimesIterable implements Iterable<Integer> {

    INSTANCE;

    private int[] primes = new int[128];
    private int primeCount;

    PrimesIterable() {
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primeCount = 4;
    }

    public boolean isPrime(int number) {
        int limit = (int) Math.sqrt(number);
        while (limit > primes[primeCount - 1]) {
            preloadNextPrimes();
        }
        return isPrimeInternal(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }

    public int countCachedPrimes() {
        return primeCount;
    }

    synchronized void preloadNextPrimes() {
        // extend primes
        if (primeCount + 4 >= primes.length) {
            int[] newprimes = new int[(int) (primes.length * 1.5)];
            System.arraycopy(primes, 0, newprimes, 0, primeCount);
            primes = newprimes;
        }

        int nextPrime = primes[primeCount - 1] + 2;
        int primesFound = 0;
        while (primesFound < 4) {
            if (isPrimeInternal(nextPrime)) {
                primes[primeCount] = nextPrime;
                primeCount++;
                primesFound++;
            }

            nextPrime += 2;
        }
    }

    boolean isPrimeInternal(int probablePrime) {
        int limit = (int) Math.sqrt(probablePrime);
        for (int i = 0; i < primeCount; i++) {
            final int prime = primes[i];
            if (probablePrime == prime || prime > limit) {
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
            if (primeIndex >= primeCount) {
                preloadNextPrimes();
            }
            return primes[primeIndex++];
        }

        @Override
        public void remove() {
            // cannot remove a prime
            throw new UnsupportedOperationException();
        }
    }
}
