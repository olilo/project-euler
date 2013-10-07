package de.olilo.euler;

import java.math.BigInteger;

/**
 * @author Oliver Lorenz
 * @since 0.1
 */
public class Problem1Multiples {

    public long solveIteratively(int number) {
        long result = 0;
        for (int i = 0; i < number; ++i) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }

    public BigInteger solveByAlgorithm(long number) {
        long maxThreeDivisible = (number - 1 - ((number - 1) % 3));
        long maxFiveDivisible = (number - 1 - ((number - 1) % 5));
        long maxFifteenDivisible = (number - 1 - ((number - 1) % 15));
        final BigInteger two = BigInteger.valueOf(2);
        BigInteger sumThrees = BigInteger.valueOf(maxThreeDivisible / 3);
        sumThrees = sumThrees.multiply(BigInteger.valueOf(maxThreeDivisible / 3 + 1));
        sumThrees = sumThrees.divide(two);
        sumThrees = sumThrees.multiply(BigInteger.valueOf(3));
        BigInteger sumFives = BigInteger.valueOf(maxFiveDivisible / 5);
        sumFives = sumFives.multiply(BigInteger.valueOf(maxFiveDivisible / 5 + 1));
        sumFives = sumFives.divide(two);
        sumFives = sumFives.multiply(BigInteger.valueOf(5));
        BigInteger sumFifteens = BigInteger.valueOf(maxFifteenDivisible / 15);
        sumFifteens = sumFifteens.multiply(BigInteger.valueOf(maxFifteenDivisible / 15 + 1));
        sumFifteens = sumFifteens.divide(two);
        sumFifteens = sumFifteens.multiply(BigInteger.valueOf(15));
        return sumThrees.add(sumFives).subtract(sumFifteens);
    }

}
