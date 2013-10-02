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
        long maxThreeDivisible = (number - (number % 3));
        long maxFiveDivisible = (number - (number % 5));
        long maxFifteenDivisible = (number - (number % 15));
        return 3 * ((maxThreeDivisible / 3) * (maxThreeDivisible / 3 - 1) / 2)
                + 5 * ((maxFiveDivisible / 5) * (maxFiveDivisible / 5 - 1) / 2)
                - 15 * ((maxFifteenDivisible / 15) * (maxFifteenDivisible / 15 - 1) / 2);
    }

}
