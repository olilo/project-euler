package de.olilo.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class Problem3LargestPrime {

    public long getLargestPrimeOf(long number) {
        // we have a cache of primes up to the point needed and
        // use prime factorization of the given number
        // to find the highest prime factor
        int primeIndex = 0;
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        int currentPrime = primes.get(0);

        // optimization: highest prime factor must be at most the square root of the number itself
        long limit = (long) Math.sqrt(number);

        // the prime factors of the number
        int[] primeFactors = new int[1000];
        int primeFactorIndex = 0;

        // work with a copy of the number to compare it later (check to see if number itself is prime)
        long numberCopy = number;

        // main loop
        while (currentPrime <= limit && numberCopy != 1) {
            if (numberCopy % currentPrime == 0) {
                numberCopy = numberCopy / currentPrime;

                // minor space optimization: only register distinct prime factors
                if (primeFactors[primeFactorIndex] != currentPrime) {
                    primeFactors[primeFactorIndex++] = currentPrime;
                }
            } else {
                primeIndex++;
                if (primeIndex < primes.size()) {
                    currentPrime = primes.get(primeIndex);
                } else {
                    currentPrime = findNextPrime(currentPrime, primes);
                    primes.add(currentPrime);
                }
            }
        }

        // if number is still the same as we started with, it must be prime, so it is the biggest prime factor itself
        if (number == numberCopy) {
            return number;
        } else {
            return primeFactors[primeFactorIndex - 1];
        }
    }

    BigInteger findSmallestNumberWithNDistinctPrimeFactors(int numberOfPrimeFactors) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int currentPrime = primes.get(0);

        BigInteger result = BigInteger.valueOf(2);
        for (int i = 0; i < numberOfPrimeFactors - 1; i++) {
            currentPrime = findNextPrime(currentPrime, primes);
            primes.add(currentPrime);
            result = result.multiply(BigInteger.valueOf(currentPrime));
        }

        return result;
    }

    int findNextPrime(int currentPrime, List<Integer> primes) {
        // special case: 2
        if (currentPrime == 2) {
            return 3;
        }

        // FIXME: stackoverflow?!?
        int nextPrime = currentPrime + 2;
        for (int prime : primes) {
            if (nextPrime % prime == 0) {
                return findNextPrime(nextPrime, primes);
            }
        }
        return nextPrime;
    }

}
