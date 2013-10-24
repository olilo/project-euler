package de.olilo.euler.level1;

/**
 * Simple immutable wrapper around the amount of factors taken into account in problem 11 (in the grid).
 */
class GridFactorCount {

    private final int count;

    public GridFactorCount(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
