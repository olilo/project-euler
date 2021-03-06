package de.olilo.euler.level1;

class Problem11GridProduct {

    public long findGreatestProductIn(int[][] grid, GridFactorCount factorCount) {
        // brute force approach
        long maxProduct = findGreatestProductInRows(grid, factorCount);
        maxProduct = Math.max(maxProduct, findGreatestProductInColumns(grid, factorCount));
        maxProduct = Math.max(maxProduct, findGreatestProductDiagonally(grid, factorCount));
        return maxProduct;
    }

    private long findGreatestProductInRows(final int[][] grid, GridFactorCount factorCount) {
        long maxProduct = 0;
        for (final int[] row : grid) {
            for (int j = 0; j <= row.length - factorCount.getCount(); j++) {
                long product = 1;
                for (int k = j; k < j + factorCount.getCount(); k++) {
                    product *= row[k];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    private long findGreatestProductInColumns(final int[][] grid, GridFactorCount factorCount) {
        long maxProduct = 0;
        for (int i = 0; i <= grid.length - factorCount.getCount(); i++) {
            for (int j = 0; j < grid[i].length; j++) {
                long product = 1;
                for (int k = i; k < i + factorCount.getCount(); k++) {
                    product *= grid[k][j];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    private long findGreatestProductDiagonally(final int[][] grid, final GridFactorCount factorCount) {
        long maxProduct = 0;
        for (int i = 0; i < grid.length - factorCount.getCount(); i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j <= grid[i].length - factorCount.getCount()) {
                    long product = 1;
                    for (int k = 0; k < factorCount.getCount(); k++) {
                        product *= grid[i + k][j + k];
                    }
                    maxProduct = Math.max(maxProduct, product);
                }
                if (j >= factorCount.getCount() - 1) {
                    long product = 1;
                    for (int k = 0; k < factorCount.getCount(); k++) {
                        product *= grid[i + k][j - k];
                    }
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }

}
