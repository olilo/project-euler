package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.util.ArrayList;
import java.util.List;

public class Problem30DigitFifthPowers implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the all numbers that can be written as the sum of fifth powers of their digits is: ";
    }

    @Override
    public int getProblemNumber() {
        return 30;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getNumbersEqualTheirDigitFifthPowers().stream().reduce(0, Integer::sum);
    }

    protected int getDigitFifthPowers(int number) {
        final String numberString = Integer.toString(number);
        int sum = 0;
        for (char digit : numberString.toCharArray()) {
            sum += (int) Math.pow(Character.getNumericValue(digit), 5);
        }
        return sum;
    }

    protected List<Integer> getNumbersEqualTheirDigitFifthPowers() {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < 1000000; i++) {
            if (getDigitFifthPowers(i) == i) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
