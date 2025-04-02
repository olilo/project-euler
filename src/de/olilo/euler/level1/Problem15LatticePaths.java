package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

public class Problem15LatticePaths implements Problem {

    @Override
    public String getMessage() {
        return "The number of lattice Paths through a 20x20 grid is: ";
    }

    @Override
    public int getProblemNumber() {
        return 15;
    }

    @Override
    public Number runProblem(Runner runner) {
        return latticePathsThroughGridWithLength(20);
    }

    public long latticePathsThroughGridWithLength(int length) {
        final Grid grid = new Grid(length);
        return grid.countPathsFrom(0, 0);
    }

    protected static class Grid {

        private final long[][] cells;
        private final int length;

        public Grid(int length) {
            this.cells = new long[length + 1][length + 1];
            this.length = length;
        }

        public long countPathsFrom(int x, int y) {
            // finished going through grid
            if (x >= length && y >= length) {
                return 1;
            }

            // check if we already were at this position before
            if (cells[x][y] > 0) {
                return cells[x][y];
            }

            // count all possible ways
            long pathsToFinish = 0;
            if (x < length) {
                pathsToFinish += countPathsFrom(x + 1, y);
            }
            if (y < length) {
                pathsToFinish += countPathsFrom(x, y + 1);
            }
            cells[x][y] = pathsToFinish;
            return pathsToFinish;
        }

    }

}
