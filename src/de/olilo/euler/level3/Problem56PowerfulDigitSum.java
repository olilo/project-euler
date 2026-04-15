package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.math.BigInteger;

public class Problem56PowerfulDigitSum implements Problem {
    @Override
    public String getMessage() {
        return "Considering natural numbers of the form, a^b, where a, b < 100, this is the maximum digital sum: ";
    }

    @Override
    public int getProblemNumber() {
        return 56;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        int maxSum = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                int sum = getPowerfulDigitSum(a, b);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    protected int getPowerfulDigitSum(int base, int power) {
        BigInteger number = BigInteger.valueOf(base).pow(power);
        return digitSumOf(number);
    }

    protected int digitSumOf(BigInteger number) {
        int sum = 0;
        for (char digit : number.toString().toCharArray()) {
            sum += digit - '0';
        }
        return sum;
    }
}
