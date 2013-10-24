package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

import java.math.BigInteger;

class Problem3PrimeFactorsAddendum {

    public BigInteger findSmallestNumberWithNDistinctPrimeFactors(int numberOfPrimeFactors) {
        BigInteger result = BigInteger.valueOf(1);
        int primesMultiplied = 0;
        for (int prime : PrimesIterable.INSTANCE) {
            result = result.multiply(BigInteger.valueOf(prime));
            primesMultiplied++;
            if (primesMultiplied == numberOfPrimeFactors) {
                return result;
            }
        }
        return result;
    }

}
