package de.olilo.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GridReader {

    private final Reader reader;
    private boolean closeOnFinish = true;

    // should not be instantiable
    public GridReader(Reader reader) {
        this.reader = reader;
    }

    public GridReader setCloseOnFinish(boolean closeOnFinish) {
        this.closeOnFinish = closeOnFinish;
        return this;
    }

    /**
     * Reads a grid of numbers from the given Reader.
     *
     * It is not guaranteed that every row has the same number count -
     * it can easily also be a triangle that was read.
     *
     * @return a multi-dimensional int array that represents the read grid
     */
    public int[][] readGrid() throws IOException {
        // we put everything into a list first,
        // because we don't know how many rows/columns there are at start
        final List<List<Integer>> grid = readAsList();

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

    private List<List<Integer>> readAsList() throws IOException {
        final List<List<Integer>> grid = new ArrayList<List<Integer>>();

        // read lines, put each into grid
        try {
            final BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                final List<Integer> row = new ArrayList<Integer>();
                grid.add(row);

                for (String part : line.trim().split(" ")) {
                    if (part.isEmpty()) {
                        continue;
                    }
                    row.add(Integer.parseInt(part));
                }

                line = bufferedReader.readLine();
            }
        } finally {
            if (closeOnFinish) {
                reader.close();
            }
        }

        return grid;
    }

}
