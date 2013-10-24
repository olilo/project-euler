package de.olilo.euler.level1;

class Problem18MaximumPathSum {

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

    class Row {

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
