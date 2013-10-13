package de.olilo.euler;

import java.math.BigInteger;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class Problem3PrimeFactorsAddendum {

    BigInteger findSmallestNumberWithNDistinctPrimeFactors(int numberOfPrimeFactors) {
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
