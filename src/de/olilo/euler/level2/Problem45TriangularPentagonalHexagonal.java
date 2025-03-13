package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;

public class Problem45TriangularPentagonalHexagonal implements Problem {

    @Override
    public String getMessage() {
        return "The next triangle, pentagonal and hexagonal number after 40755 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 45;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findTrianglePentagonalAndHexagonalAfter(143);
    }

    protected long findTrianglePentagonalAndHexagonalAfter(int start) {
        for (int n = start + 1; n < Integer.MAX_VALUE; n++) {
            long hexagonalNumber = Numbers.getHexagonalNumber(n);
            if (Numbers.isPentagonalNumber(hexagonalNumber)) {
                return hexagonalNumber;
            }
        }

        // FIXME throw some meaningful exception
        throw new RuntimeException("Did not find another number :(");
    }

}
