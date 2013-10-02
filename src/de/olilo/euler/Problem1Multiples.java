package de.olilo.euler;

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

    public long solveByAlgorithm(int number) {
        long maxThreeDivisible = (number - 1 - ((number - 1) % 3));
        long maxFiveDivisible = (number - 1 - ((number - 1) % 5));
        long maxFifteenDivisible = (number - 1 - ((number - 1) % 15));
        long sumThrees = 3 * (((maxThreeDivisible / 3) * (maxThreeDivisible / 3 + 1)) / 2);
        long sumFives = 5 * (((maxFiveDivisible / 5) * (maxFiveDivisible / 5 + 1)) / 2);
        long sumFifteens = 15 * ((maxFifteenDivisible / 15) * (maxFifteenDivisible / 15 + 1) / 2);
        return sumThrees + sumFives - sumFifteens;
    }

}
