package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Problem29DistinctPowers implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the distinct powers of 2 to 100 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 29;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getDistinctPowersOf2To(100, 100).size();
    }

    protected Set<BigDecimal> getDistinctPowersOf2To(int a, int b) {
        final Set<BigDecimal> result = new HashSet<>();
        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= b; j++) {
                result.add(BigDecimal.valueOf(i).pow(j));
            }
        }
        return result;
    }
}
