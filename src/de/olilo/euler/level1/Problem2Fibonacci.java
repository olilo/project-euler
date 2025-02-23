package de.olilo.euler.level1;

import de.olilo.euler.Runner;
import de.olilo.euler.Problem;

public class Problem2Fibonacci implements Problem {

    @Override
    public String getMessage() {
        return "The sum of all even-valued terms in the Fibonacci sequence below four million are: ";
    }

    @Override
    public int getProblemNumber() {
        return 2;
    }

    @Override
    public Number runProblem(Runner runner) {
        return solve(4_000_000);
    }

    protected long solve(int max) {
        long sum = 0;
        long first = 1;
        long second = 1;
        while (second < max) {
            long next = first + second;
            first = second;
            second = next;
            if (next % 2 == 0) {
                sum += next;
            }
        }
        return sum;
    }

}
