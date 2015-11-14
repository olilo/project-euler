package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem29DistinctPowersTest {

    @Test
    public void testGetDistinctPowersOf2To5() throws Exception {
        final int expected = 15;
        final int actual = new Problem29DistinctPowers().getDistinctPowersOf2To(5, 5).size();
        Assert.assertEquals(expected, actual);
    }
}