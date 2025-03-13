package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem45TriangularPentagonalHexagonalTest {

    @Test
    public void testFindTrianglePentagonalAndHexagonalAfter() {
        final long expected = 1533776805L;
        final long actual = new Problem45TriangularPentagonalHexagonal().findTrianglePentagonalAndHexagonalAfter(143);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTrianglePentagonalAndHexagonalAfterHigh() {
        final long expected = 40755;
        final long actual = new Problem45TriangularPentagonalHexagonal().findTrianglePentagonalAndHexagonalAfter(1);
        Assert.assertEquals(expected, actual);
    }

}
