package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem14CollatzSequence implements Problem {

    private final List<Integer> collatzSequenceCache = new ArrayList<>();

    @Override
    public String getMessage() {
        return "The longest Collatz sequence with a starting point of under 1 million is: ";
    }

    @Override
    public int getProblemNumber() {
        return 14;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findLongestSequenceUnder(1_000_000);
    }

    protected int findLongestSequenceUnder(int limit) {
        // make a cache of the found lengths at each int value
        collatzSequenceCache.clear();
        collatzSequenceCache.add(1);
        for (int i = 1; i < limit; i++) {
            collatzSequenceCache.add(getCollatzLength(i));
        }

        // find the index with the longest sequence from our cache
        final OptionalInt result = IntStream.range(0, collatzSequenceCache.size())
                .reduce((i, j) -> collatzSequenceCache.get(i) > collatzSequenceCache.get(j) ? i : j);
        if (result.isPresent()) {
            return result.getAsInt();
        } else {
            throw new IllegalStateException("Collatz sequence cache does not contain any values");
        }
    }

    protected int getCollatzLength(int i) {
        int length = 1;
        for (long current = i; current > 1; current = getNextCollatzNumber(current)) {
            // check whether we already have a length
            if (current < collatzSequenceCache.size() && collatzSequenceCache.get((int) current) > 0) {
                return length + collatzSequenceCache.get((int) current) - 1;
            } else {
                length++;
            }
        }
        return length;
    }

    protected long getNextCollatzNumber(long previousCollatzNumber) {
        if (previousCollatzNumber % 2 == 0) {
            return previousCollatzNumber / 2;
        } else {
            return 3 * previousCollatzNumber + 1;
        }
    }

}
