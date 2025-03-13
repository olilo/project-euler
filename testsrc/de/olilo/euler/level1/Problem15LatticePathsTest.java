package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem15LatticePathsTest {

    @Test
    public void testLatticePathsThroughGridWithLength1() throws Exception {
        final long expected = 2;
        final long actual = new Problem15LatticePaths().latticePathsThroughGridWithLength(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLatticePathsThroughGridWithLength2() throws Exception {
        final long expected = 6;
        final long actual = new Problem15LatticePaths().latticePathsThroughGridWithLength(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLatticePathsThroughGridWithLength3() throws Exception {
        final long expected = 20;
        final long actual = new Problem15LatticePaths().latticePathsThroughGridWithLength(3);
        Assert.assertEquals(expected, actual);
    }

}
