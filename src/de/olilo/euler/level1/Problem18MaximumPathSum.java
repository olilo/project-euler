package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.GridReader;

import java.io.FileReader;
import java.io.IOException;

public class Problem18MaximumPathSum implements Problem {

    @Override
    public String getMessage() {
        return "The maximum total from top to bottom of the given triangle is: ";
    }

    @Override
    public int getProblemNumber() {
        return 18;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final FileReader gridReader = runner.getFileReader("18");
        return maximumPathSumOf(new GridReader(gridReader).readGrid());
    }

    public long maximumPathSumOf(int[][] triangle) {
        if (triangle.length == 0) {
            return 0;
        } else {
            Row nextRow = null;
            for (int i = triangle.length - 1; i >= 0; i--) {
                nextRow = new Row(triangle[i], nextRow);
            }
            assert nextRow != null : "nextRow is null o_O";
            return nextRow.getMaxPathSum(0);
        }
    }

    private static class Row {

        private final int[] row;
        private final int[] maxCache;
        private final Row nextRow;

        Row(final int[] row, final Row nextRow) {
            this.row = row;
            this.maxCache = new int[row.length];
            this.nextRow = nextRow;
        }

        public int getMaxPathSum(int i) {
            if (i < 0 || i >= row.length) {
                return 0;
            }
            if (maxCache[i] > 0) {
                return maxCache[i];
            }
            if (nextRow == null) {
                return row[i];
            } else {
                final int max = row[i] + Math.max(nextRow.getMaxPathSum(i), nextRow.getMaxPathSum(i + 1));
                maxCache[i] = max;
                return max;
            }
        }

    }

}
