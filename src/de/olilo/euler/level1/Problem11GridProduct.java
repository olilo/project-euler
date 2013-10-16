package de.olilo.euler.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Problem11GridProduct {

    public int[][] readGrid(Reader reader) throws IOException {
        // we put everything into a list first,
        // because we don't know how many rows/columns there are at start
        final List<List<Integer>> grid = new ArrayList<List<Integer>>();

        // read lines, put each into grid
        try {
            final BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                final List<Integer> row = new ArrayList<Integer>();
                grid.add(row);
                String[] parts = line.split(" ");
                for (String part : parts) {
                    row.add(Integer.parseInt(part));
                }
                line = bufferedReader.readLine();
            }
        } finally {
            reader.close();
        }

        // now copy the values from the list into a multi-dimensional array
        final int[][] result = new int[grid.size()][];
        for (int i = 0; i < grid.size(); i++) {
            List<Integer> row = grid.get(i);
            result[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }
        return result;
    }

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
