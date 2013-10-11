package de.olilo.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class Problem3LargestPrime {

    public int getLargestPrimeOf(long number) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        int primeIndex = 0;
        long limit = (long) Math.sqrt(number);
        int currentPrime = primes.get(0);
        int[] primeFactors = new int[1000];
        int primeFactorIndex = 0;
        while (currentPrime <= limit) {
            if (number % currentPrime == 0) {
                number = number / currentPrime;
                primeFactors[primeFactorIndex++] = currentPrime;
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
        return primeFactors[primeFactorIndex - 1];
    }

    int findNextPrime(int currentPrime, List<Integer> primes) {
        // TODO stackoverflow?!?
        int nextPrime = currentPrime + 2;
        for (int prime : primes) {
            if (nextPrime % prime == 0) {
                return findNextPrime(nextPrime, primes);
            }
        }
        return nextPrime;
    }

}
