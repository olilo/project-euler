package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;

import java.io.IOException;

public class Problem55LychrelNumbers implements Problem {

    @Override
    public String getMessage() {
        return "There are this many lychrel numbers below ten-thousand: ";
    }

    @Override
    public int getProblemNumber() {
        return 55;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return countLychrelNumbersBelow(10_000);
    }

    public int countLychrelNumbersBelow(int limit) {
        int counter = 0;
        for (int i = 0; i < limit; i++) {
            if (Numbers.isLychrelNumberBelowTenThousand(i)) {
                counter++;
            }
        }
        return counter;
    }

}
