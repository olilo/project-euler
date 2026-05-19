package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;

public class Problem34DigitFactorials implements Problem {

    @Override
    public String getMessage() {
        return "The sum of all numbers which are equal to the sum of the factorial of their digits is: ";
    }

    @Override
    public int getProblemNumber() {
        return 34;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return sumOfDigitFactorialsUntil(1_000_000);
    }

    public long sumOfDigitFactorialsUntil(int limit) {
        int sum = 0;
        for (int i = 10; i < limit; i++) {
            if (isDigitFactorial(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public long factorialOf(int number) {
        long result = 1;
        while (number > 1) {
            result *= number--;
        }
        return result;
    }

    public boolean isDigitFactorial(int number) {
        long result = 0;
        for (char digit : Integer.toString(number).toCharArray()) {
            result += factorialOf(Character.getNumericValue(digit));
        }
        return result == number;
    }

}
