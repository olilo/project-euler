package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;

public class Problem44PentagonNumbers implements Problem {

    @Override
    public String getMessage() {
        return "The smallest difference of two pentagonal numbers whose difference and sum are pentagonal too is: ";
    }

    @Override
    public int getProblemNumber() {
        return 44;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        // set 10_000 as maximum so we don't accidentally run infinitely long time
        for (int i = 2; i <= 10_000; i++) {
            int firstPentagonal = getPentagonalNumber(i);
            for (int j = i - 1; j >= 1; j--) {
                int secondPentagonal = getPentagonalNumber(j);

                int sum = firstPentagonal + secondPentagonal;
                int difference = Math.abs(firstPentagonal - secondPentagonal);

                // since we always start from the minimal difference between two pentagonal numbers (j = i -1)
                // the difference between the first two pentagonal numbers we encounter which satisfy the condition
                // is the minimal difference
                if (isPentagonalNumber(sum) && isPentagonalNumber(difference)) {
                    return difference;
                }
            }
        }

        return -1;
    }

    protected int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    protected boolean isPentagonalNumber(int n) {
        final double probablePentagonalNumber = (Math.sqrt(24 * n + 1) + 1) / 6.0;
        return (int) probablePentagonalNumber == probablePentagonalNumber;
    }
}
