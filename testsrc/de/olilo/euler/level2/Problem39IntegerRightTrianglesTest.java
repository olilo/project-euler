package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem39IntegerRightTrianglesTest {

    @Test
    public void testGetMaxSolutionCountUntil120() throws Exception {
        final int expected = 120;
        final int actual = new Problem39IntegerRightTriangles().getMaxSolutionCountUntil(120);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPossibleSolutionsFor() throws Exception {
        final List<GeometricTriangle> expected = new ArrayList<>();
        expected.add(new GeometricTriangle(20, 48, 52));
        expected.add(new GeometricTriangle(24, 45, 51));
        expected.add(new GeometricTriangle(30, 40, 50));
        final List<GeometricTriangle> actual = new Problem39IntegerRightTriangles().getPossibleSolutionsFor(120);
        Assert.assertEquals(expected, actual);
    }

}