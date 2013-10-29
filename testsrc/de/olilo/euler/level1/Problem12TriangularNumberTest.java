package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem12TriangularNumberTest {
    @Test
    public void testFindFirstTriangularNumberWithNDivisors() throws Exception {
        final long expected = 28;
        final long actual = new Problem12TriangularNumber().findFirstTriangularNumberWithNDivisors(5);
        Assert.assertEquals(expected, actual);
    }
}
