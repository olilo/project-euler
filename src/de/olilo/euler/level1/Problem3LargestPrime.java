package de.olilo.euler.level1;

import de.olilo.util.PrimeFactors;

class Problem3LargestPrime {

    public long getLargestPrimeOf(long number) {
        // the prime factors of the number
        int[] primeFactors = PrimeFactors.of(number);
        return primeFactors[primeFactors.length - 1];
    }

}
