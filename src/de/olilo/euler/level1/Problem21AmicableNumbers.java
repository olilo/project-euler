package de.olilo.euler.level1;

import de.olilo.util.Divisors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem21AmicableNumbers {

    private final Map<Long, Long> divisorSumCache = new HashMap<Long, Long>();

    public long sumOfAmicableNumbersUntil(long limit) {
        final Set<Long> amicableNumber = new HashSet<Long>();
        for (long i = 1; i < limit; i++) {
            for (long j = i + 1; j < i * 3; j++) {
                if (areAmicableNumbers(i, j)) {
                    amicableNumber.add(i);
                    amicableNumber.add(j);
                }
            }
        }
        System.out.println(amicableNumber);
        int sum = 0;
        for (long number : amicableNumber) {
            sum += number;
        }
        return sum;
    }

    public boolean areAmicableNumbers(long number1, long number2) {
        return number1 == getDivisorSum(number2) && getDivisorSum(number1) == number2;
    }

    long getDivisorSum(long number1) {
        if (divisorSumCache.containsKey(number1)) {
            return divisorSumCache.get(number1);
        } else {
            final long[] number1Divisors = Divisors.of(number1);
            final long number1DivisorsSum = sumExceptLast(number1Divisors);
            divisorSumCache.put(number1, number1DivisorsSum);
            return number1DivisorsSum;
        }
    }

    static long sumExceptLast(long[] divisors) {
        long sum = 0;
        for (int i = 0; i < divisors.length - 1; i++) {
            sum += divisors[i];
        }
        return sum;
    }

}
