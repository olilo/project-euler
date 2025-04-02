package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Divisors;

import java.util.HashMap;
import java.util.Map;

public class Problem21AmicableNumbers implements Problem {

    private final Map<Long, Long> divisorSumCache = new HashMap<>();

    @Override
    public String getMessage() {
        return "The sum of all amicable numbers under 10,000 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 21;
    }

    @Override
    public Number runProblem(Runner runner) {
        return sumOfAmicableNumbersUntil(10_000);
    }

    public long sumOfAmicableNumbersUntil(long limit) {
        long sum = 0;
        for (long i = 1; i < limit; i++) {
            final long j = getDivisorSum(i);
            if (i < j && areAmicableNumbers(i, j)) {
                sum += i;
                sum += j;
            }
        }
        return sum;
    }

    public boolean areAmicableNumbers(long number1, long number2) {
        return number1 == getDivisorSum(number2) && getDivisorSum(number1) == number2;
    }

    protected long getDivisorSum(long number) {
        if (divisorSumCache.containsKey(number)) {
            return divisorSumCache.get(number);
        } else {
            final long[] number1Divisors = Divisors.of(number);
            final long number1DivisorsSum = sumExceptLast(number1Divisors);
            divisorSumCache.put(number, number1DivisorsSum);
            return number1DivisorsSum;
        }
    }

    protected static long sumExceptLast(long[] divisors) {
        long sum = 0;
        for (int i = 0; i < divisors.length - 1; i++) {
            sum += divisors[i];
        }
        return sum;
    }

}
