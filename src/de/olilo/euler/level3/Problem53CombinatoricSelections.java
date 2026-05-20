package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;

public class Problem53CombinatoricSelections implements Problem {

    protected static final long LIMIT = 1_000_000L;

    @Override
    public String getMessage() {
        return "The count of values of n choose r (for 1 <= n <= 100) that are greater than one-million is: ";
    }

    @Override
    public int getProblemNumber() {
        return 53;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return countBinomialsGreaterThanLimit(100, LIMIT);
    }

    protected int countBinomialsGreaterThanLimit(int maxN, long limit) {
        // We build Pascal's triangle row by row.
        // To avoid overflow for large n, we cap values that already exceed the limit.
        long[] previousRow = new long[]{1L};
        int counter = 0;

        for (int n = 1; n <= maxN; n++) {
            final long[] currentRow = new long[n + 1];
            currentRow[0] = 1L;
            currentRow[n] = 1L;
            for (int r = 1; r < n; r++) {
                final long sum = previousRow[r - 1] + previousRow[r];
                // cap to avoid overflow; we only care whether the value exceeds the limit
                currentRow[r] = Math.min(sum, limit + 1);
                if (currentRow[r] > limit) {
                    counter++;
                }
            }
            previousRow = currentRow;
        }

        return counter;
    }

}
