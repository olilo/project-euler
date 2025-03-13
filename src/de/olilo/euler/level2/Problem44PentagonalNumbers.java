package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;

import java.io.IOException;

public class Problem44PentagonalNumbers implements Problem {

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
            for (int j = i - 1; j >= 1; j--) {
                // since we always start from the minimal difference between two pentagonal numbers (j = i -1)
                // the difference between the first two pentagonal numbers we encounter which satisfy the condition
                // is the minimal difference
                if (isDifferenceAndSumPentagonalOf(i, j)) {
                    return Math.abs(Numbers.getPentagonalNumber(i) - Numbers.getPentagonalNumber(j));
                }
            }
        }

        return -1;
    }

    /**
     * <p>
     * Returns true if the difference and sum of the nth pentagonal number as given by firstIndex and
     * the nth pentagonal number of secondIndex are pentagonal numbers too.
     * </p>
     *
     * <p>
     * E.g. isDifferenceAndSumPentagonalOf(2167, 1020) is true because the sum and difference of
     * Numbers.getPentagonalNumber(2167) and Numbers.getPentagonalNumber(1020) are pentagonal too.
     * </p>
     *
     * @param firstIndex index of first number
     * @param secondIndex index of second number
     * @return true if sum and difference of nth pentagonal numbers (as indicated by firstIndex and secondIndex)
     *              are pentagonal, false otherwise
     */
    protected boolean isDifferenceAndSumPentagonalOf(long firstIndex, long secondIndex) {
        final long firstPentagonal = Numbers.getPentagonalNumber(firstIndex);
        final long secondPentagonal = Numbers.getPentagonalNumber(secondIndex);
        final long sum = firstPentagonal + secondPentagonal;
        final long difference = Math.abs(firstPentagonal - secondPentagonal);

        return Numbers.isPentagonalNumber(sum) && Numbers.isPentagonalNumber(difference);
    }

}
