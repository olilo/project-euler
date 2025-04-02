package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.math.BigInteger;

public class Problem25FibonacciNumber implements Problem {

    @Override
    public String getMessage() {
        return "The index of the first term in the fibonacci sequence to contain 1000 digits is: ";
    }

    @Override
    public int getProblemNumber() {
        return 25;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return fibonacciIndexWithDigitCount(1000);
    }

    public int fibonacciIndexWithDigitCount(int digitCount) {
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        int index = 1;
        while (current.toString().length() < digitCount) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
            index++;
        }
        return index;
    }

}
