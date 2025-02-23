package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ListsTest {

    @Test
    public void testGeneratePermutation() {
        final List<List<Integer>> expected = List.of(
                List.of(1, 2, 3), List.of(2, 1, 3), List.of(2, 3, 1), List.of(1, 3, 2), List.of(3, 1, 2), List.of(3, 2, 1)
        );
        final List<List<Integer>> actual = Lists.generatePermutation(List.of(1, 2, 3));
        Assert.assertEquals(expected, actual);
    }

}
