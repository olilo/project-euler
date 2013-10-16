package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

import java.util.Iterator;

public class Problem3LargestPrime {

    public long getLargestPrimeOf(long number) {
        // we have a cache of primes up to the point needed and
        // use prime factorization of the given number
        // to find the highest prime factor
        final Iterator<Integer> primes = PrimesIterable.INSTANCE.iterator();
        int currentPrime = primes.next();

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
                currentPrime = primes.next();
            }
        }

        // if number is still the same as we started with, it must be prime, so it is the biggest prime factor itself
        if (number == numberCopy) {
            return number;
        } else {
            return primeFactors[primeFactorIndex - 1];
        }
    }

}
