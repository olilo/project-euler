package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

public class Problem6SumSquareDifference implements Problem {

    @Override
    public String getMessage() {
        return "The difference between the sum of the squares of the first one hundred natural numbers " +
                "and the square of the sum is: ";
    }

    @Override
    public int getProblemNumber() {
        return 6;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getSumSquareDifference(100);
    }

    protected long getSumSquareDifference(int limit) {
        long sumOfSquares = 0;
        long squareOfSum = 0;
        for (int i = 1; i <= limit; i++) {
            sumOfSquares += (long) i * i;
            squareOfSum += i;
        }
        squareOfSum = squareOfSum * squareOfSum;
        return squareOfSum - sumOfSquares;
    }

}
