package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Divisors;

public class Problem12TriangularNumber implements Problem {

    @Override
    public String getMessage() {
        return "The first triangular number that has at least 500 divisors is: ";
    }

    @Override
    public int getProblemNumber() {
        return 12;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findFirstTriangularNumberWithNDivisors(500);
    }

    protected long findFirstTriangularNumberWithNDivisors(int minimumDivisors) {
        // FIXME either find a minimum to go off from or find a purely algorithmic approach
        int index = 1;
        long number = 1;
        int numDivisors = 1;

        while (numDivisors < minimumDivisors) {
            index++;
            number += index;
            numDivisors = Divisors.of(number).length;
        }

        return number;
    }

}
