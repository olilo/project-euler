package de.olilo.euler.level1;

import de.olilo.util.Divisors;

public class Problem21AmicableNumbers {

    public long sumOfAmicableNumbersUntil(long limit) {
        return limit - limit;
    }

    public boolean areAmicableNumbers(long number1, long number2) {
        final long[] number1Divisors = Divisors.of(number1);
        final long[] number2Divisors = Divisors.of(number2);
        final long number1DivisorsSum = sumExceptLast(number1Divisors);
        final long number2DivisorsSum = sumExceptLast(number2Divisors);

        return number1 == number2DivisorsSum && number1DivisorsSum == number2;
    }

    static long sumExceptLast(long[] divisors) {
        long sum = 0;
        for (int i = 0; i < divisors.length - 1; i++) {
            sum += divisors[i];
        }
        return sum;
    }

}
